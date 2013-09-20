/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Labin05
 */
public class DepartamentoRepository {

    private EntityManager manager;

    public DepartamentoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Departamento departamento) {
        this.manager.persist(departamento);
    }

    public List<Departamento> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Departamento x");
        return query.getResultList();
    }

    /**
     * @return the manager
     */
    public EntityManager getManager() {
        return manager;
    }

    /**
     * @param manager the manager to set
     */
    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}