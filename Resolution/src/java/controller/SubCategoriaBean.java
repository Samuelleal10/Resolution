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
import model.SubCategoria;
import model.SubCategoriaRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class SubCategoriaBean implements Serializable {

    private SubCategoria subCategoria = new SubCategoria();
    private List<SubCategoria> subCategorias;

    public void adicionaSubCategoria() {
        EntityManager manager = this.getEntityManager();
        SubCategoriaRepository repository = new SubCategoriaRepository(manager);
        repository.adiciona(this.getSubCategoria());
        this.setSubCategoria(new SubCategoria());
        this.subCategorias = null;
    }

    public List<SubCategoria> getSubCategorias() {
        if (this.subCategorias == null) {
            EntityManager manager = this.getEntityManager();
            SubCategoriaRepository repository = new SubCategoriaRepository(manager);
            this.subCategorias = repository.buscaTodos();
        }
        return this.subCategorias;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the subCategoria
     */
    public SubCategoria getSubCategoria() {
        return subCategoria;
    }

    /**
     * @param subCategoria the subCategoria to set
     */
    public void setSubCategoria(SubCategoria subCategoria) {
        this.subCategoria = subCategoria;
    }
}
