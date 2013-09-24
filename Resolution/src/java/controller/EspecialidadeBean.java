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
import repository.GenericRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
public class EspecialidadeBean {
        private Especialidade especialidade = new Especialidade();
        private List<Class> especialidades;

    public void adicionaEspecialidade() {
        EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        repository.adiciona(this.especialidade);
        this.setEspecialidade(new Especialidade());
        this.especialidades = null;
    }

    public List<Class> getEspecialidades() {
        if(this.especialidades == null){
             EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        this.especialidades = repository.buscaTodos("Especialidade");
        }
       
        return this.especialidades;
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
