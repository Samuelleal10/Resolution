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
public class ClienteRepository {
      private EntityManager manager;

    public ClienteRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Cliente cliente) {
        this.manager.persist(cliente);
    }

    public List<Cliente> buscaTodos() {
        Query query = this.manager.createQuery(" select x from Cliente x");
        return query.getResultList();
    }

}
