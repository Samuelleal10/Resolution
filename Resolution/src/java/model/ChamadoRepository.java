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
public class ChamadoRepository {
      private EntityManager manager;

    public ChamadoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Chamado chamado) {
        this.getManager().persist(chamado);
    }

    public List<Chamado> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Chamado x");
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
