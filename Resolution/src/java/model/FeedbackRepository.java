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
public class FeedbackRepository {
      private EntityManager manager;

    public FeedbackRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Feedback feedback) {
        this.getManager().persist(feedback);
    }

    public List<Feedback> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Feedback x");
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
