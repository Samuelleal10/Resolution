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
public class CategoriaChamadoRepository {
      private EntityManager manager;

    public CategoriaChamadoRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(CategoriaChamado categoriaChamado) {
        this.getManager().persist(categoriaChamado);
    }

    public List<CategoriaChamado> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from CategoriaChamado x");
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
