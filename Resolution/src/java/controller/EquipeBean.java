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
import model.Equipe;
import model.EquipeRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class EquipeBean implements Serializable {
    
    private Equipe equipe = new Equipe();
    private List<Equipe> equipes;

    public void adicionaEquipe() {
        EntityManager manager = this.getEntityManager();
        EquipeRepository repository = new EquipeRepository(manager);
        
        repository.adiciona(this.getEquipe());
        this.setEquipe(new Equipe());
        this.equipes = null;
    }

    public List<Equipe> getEquipes() {
         if(this.equipes == null){
            EntityManager manager = this.getEntityManager();
            EquipeRepository repository = new EquipeRepository(manager);
            this.equipes =  repository.buscaTodos();
        }
        return this.equipes;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * @param equipe the equipe to set
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
