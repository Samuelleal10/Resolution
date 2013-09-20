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
public class FuncionarioRepository {
      private EntityManager manager;

    public FuncionarioRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Funcionario funcionario) {
        this.getManager().persist(funcionario);
    }

    public List<Funcionario> buscaTodos() {
        Query query = this.getManager().createQuery(" select x from Funcionario x");
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
