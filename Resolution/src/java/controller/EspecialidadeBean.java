/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import model.Especialidade;
import model.EspecialidadeRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
public class EspecialidadeBean {
        private Especialidade especialidade = new Especialidade();

    public void adicionaEspecialidade() {
        EntityManager manager = this.getEntityManager();
        EspecialidadeRepository repository = new EspecialidadeRepository(manager);
        repository.adiciona(this.especialidade);
        this.setEspecialidade(new Especialidade());
    }

    public List<Especialidade> getEspecialidades() {
        EntityManager manager = this.getEntityManager();
        EspecialidadeRepository repository = new EspecialidadeRepository(manager);
        return repository.buscaTodos();
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the especialidade
     */
    public Especialidade getEspecialidade() {
        return especialidade;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
