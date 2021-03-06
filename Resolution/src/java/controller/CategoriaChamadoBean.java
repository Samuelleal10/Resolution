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
import model.CategoriaChamado;
import repository.GenericRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class CategoriaChamadoBean implements Serializable {
     
    private CategoriaChamado categoriaChamado = new CategoriaChamado();
    private List<Class> categoriaChamados;

    public void adicionaCategoriaChamado() {
        EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        repository.adiciona(this.getCategoriaChamado());
        this.setCategoriaChamado(new CategoriaChamado());
        this.categoriaChamados = null;
    }

    public List<Class> getCategoriaChamados() {
        if(this.categoriaChamados == null){
            EntityManager manager = this.getEntityManager();
            GenericRepository repository = new GenericRepository(manager);
            this.categoriaChamados = repository.buscaTodos("CategoriaChamado");
        }
       return this.categoriaChamados;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the categoriaChamado
     */
    public CategoriaChamado getCategoriaChamado() {
        return categoriaChamado;
    }

    /**
     * @param categoriaChamado the categoriaChamado to set
     */
    public void setCategoriaChamado(CategoriaChamado categoriaChamado) {
        this.categoriaChamado = categoriaChamado;
    }

}
