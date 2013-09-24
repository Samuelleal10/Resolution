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
import repository.GenericRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
public class DepartamentoBean {

    private Departamento dep = new Departamento();
     private List<Class> departamentos;

    public void adicionaDepartamento() {
        EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        System.out.println("entrou");
        repository.adiciona(this.getDep());
        this.setDep(new Departamento());
        this.departamentos = null;
    }

    public List<Class> getDepartamentos() {
        if(this.departamentos == null){
            EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        this.departamentos = repository.buscaTodos("Departamento");
        }
        return this.departamentos;
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