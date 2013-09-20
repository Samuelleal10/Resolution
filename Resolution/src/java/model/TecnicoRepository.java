/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Labin05
 */
public class TecnicoRepository {
    
     private EntityManager manager;

    public TecnicoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Tecnico tecnico) {
        this.getManager().persist(tecnico);
    }

    public List<Tecnico> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Tecnico x");
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
