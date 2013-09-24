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
import model.Status;
import model.StatusRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class StatusBean implements Serializable {
    
    private Status status = new Status();
    private List<Status> statusall;

    public void adicionaStatus() {
        EntityManager manager = this.getEntityManager();
        StatusRepository repository = new StatusRepository(manager);
        
        repository.adiciona(this.getStatus());
        this.setStatus(new Status());
        this.statusall = null;
    }

    public List<Status> getStatusall() {
         if(this.statusall == null){
            EntityManager manager = this.getEntityManager();
            StatusRepository repository = new StatusRepository(manager);
            this.setStatusall(repository.buscaTodos());
        }
        return this.statusall;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @param statusall the statusall to set
     */
    public void setStatusall(List<Status> statusall) {
        this.statusall = statusall;
    }
}
