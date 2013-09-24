/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import model.Cliente;
import repository.GenericRepository;

/**
 *
 * @author Labin05
 */
@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable {
    
    private Cliente cliente = new Cliente();
    private List<Class> clientes;

    public void adicionaCliente() {
        EntityManager manager = this.getEntityManager();
        GenericRepository repository = new GenericRepository(manager);
        
        repository.adiciona(this.getCliente());
        this.setCliente(new Cliente());
        this.clientes = null;
    }

    public List<Class> getClientes() {
         if(this.clientes == null){
            EntityManager manager = this.getEntityManager();
            GenericRepository repository = new GenericRepository(manager);
            this.setClientes(repository.buscaTodos("Cliente"));
        }
        return this.clientes;
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(List<Class> clientes) {
        this.clientes = clientes;
    }
}
