/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.context.*;
import javax.persistence.*;
import javax.servlet.http.HttpServletRequest;
import model.Tecnico;
import model.TecnicoRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
public class TecnicoBean {

    private Tecnico tecnico = new Tecnico();

    public void adicionaTecnico() {
        EntityManager manager = this.getEntityManager();
        TecnicoRepository repository = new TecnicoRepository(manager);
        System.out.println("entrou");
        repository.adiciona(this.getDep());
        this.setDep(new Tecnico());
    }

    public List<Tecnico> getTecnicos() {
        EntityManager manager = this.getEntityManager();
        TecnicoRepository repository = new TecnicoRepository(manager);
        return repository.buscaTodos();
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }
    // GETTERS E SETTERS

    /**
     * @return the tecnico
     */
    public Tecnico getDep() {
        return tecnico;
    }

    /**
     * @param tecnico the tecnico to set
     */
    public void setDep(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}