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
public class SubCategoriaRepository {
      private EntityManager manager;

    public SubCategoriaRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(SubCategoria subCategoria) {
        this.getManager().persist(subCategoria);
    }

    public List<SubCategoria> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from SubCategoria x");
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
