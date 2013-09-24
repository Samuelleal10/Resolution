/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Chamado;

/**
 *
 * @author Labin05
 */
public class GenericRepository {
      private EntityManager manager;

    public GenericRepository(EntityManager manager) {
        this.manager = manager;
    }

    public void adiciona(Object obj) {
        this.manager.persist(obj);
    }

    public List<Class> buscaTodos(String table) {
        Query query = this.manager.createQuery(" select x from "+table+" x");
        List<Class> listResult = query.getResultList();
        return listResult;
    }

    public List<Chamado> buscaTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void update(Class classe) {
        this.manager.merge(classe);
        this.manager.flush();
    }

}
