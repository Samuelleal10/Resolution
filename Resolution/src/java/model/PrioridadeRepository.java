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
public class PrioridadeRepository {
      private EntityManager manager;

    public PrioridadeRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Prioridade prioridade) {
        this.manager.persist(prioridade);
    }

    public List<Prioridade> buscaTodos() {
        Query query = this.manager.createQuery(" select x from Prioridade x");
        return query.getResultList();
    }

}
