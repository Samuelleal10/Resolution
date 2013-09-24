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
import model.Chamado;
import model.ChamadoRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class ChamadoBean implements Serializable {
    
    private Chamado chamado = new Chamado();
    private List<Chamado> chamados;

    public void adicionaChamado() {
        EntityManager manager = this.getEntityManager();
        ChamadoRepository repository = new ChamadoRepository(manager);
        
        repository.adiciona(this.getChamado());
        this.setChamado(new Chamado());
        this.chamados = null;
    }

    public List<Chamado> getChamados() {
         if(this.chamados == null){
            EntityManager manager = this.getEntityManager();
            ChamadoRepository repository = new ChamadoRepository(manager);
            this.setChamados(repository.buscaTodos());
        }
        return this.chamados;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the chamado
     */
    public Chamado getChamado() {
        return chamado;
    }

    /**
     * @param chamado the chamado to set
     */
    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    /**
     * @param chamados the chamados to set
     */
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
