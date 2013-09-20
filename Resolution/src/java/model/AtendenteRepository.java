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
public class AtendenteRepository {
      private EntityManager manager;

    public AtendenteRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Atendente atendente) {
        this.manager.persist(atendente);
    }

    public List<Atendente> buscaTodos() {
        Query query = this.manager.createQuery(" select x from Atendente x");
        return query.getResultList();
    }

}
