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
import model.Departamento;
import model.DepartamentoRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
public class DepartamentoBean {

    private Departamento dep = new Departamento();

    public void adicionaDepartamento() {
        EntityManager manager = this.getEntityManager();
        DepartamentoRepository repository = new DepartamentoRepository(manager);
        System.out.println("entrou");
        repository.adiciona(this.getDep());
        this.setDep(new Departamento());
    }

    public List<Departamento> getDepartamentos() {
        EntityManager manager = this.getEntityManager();
        DepartamentoRepository repository = new DepartamentoRepository(manager);
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
     * @return the dep
     */
    public Departamento getDep() {
        return dep;
    }

    /**
     * @param dep the dep to set
     */
    public void setDep(Departamento dep) {
        this.dep = dep;
    }
}