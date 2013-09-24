/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import model.Prioridade;
import repository.GenericRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class PrioridadeBean implements Serializable {
    
    private Prioridade prioridade = new Prioridade();
    private List<Class> prioridades;

    public void adicionaPrioridade() {
        EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        
        repository.adiciona(this.getPrioridade());
        this.setPrioridade(new Prioridade());
        this.prioridades = null;
    }

    public List<Class> getPrioridades() {
         if(this.prioridades == null){
            EntityManager manager = this.getEntityManager();
            GenericRepository repository = new GenericRepository(manager);
            this.prioridades =  repository.buscaTodos("Prioridade");
        }
        return this.prioridades;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the prioridade
     */
    public Prioridade getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }
}
