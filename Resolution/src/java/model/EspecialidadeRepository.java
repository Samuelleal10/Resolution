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
public class EspecialidadeRepository {
      private EntityManager manager;

    public EspecialidadeRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Especialidade especialidade) {
        this.getManager().persist(especialidade);
    }

    public List<Especialidade> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Especialidade x");
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
