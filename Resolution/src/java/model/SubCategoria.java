/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import util.BaseEntity;

/**
 *
 * @author Labin05
 */
@Entity
public class SubCategoria implements Serializable, BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private CategoriaChamado categoriaChamado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubCategoria)) {
            return false;
        }
        SubCategoria other = (SubCategoria) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SubCategoria[ id=" + getId() + " ]";
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the categoriaChamado
     */
    public CategoriaChamado getCategoriaChamado() {
        return categoriaChamado;
    }

    /**
     * @param categoriaChamado the categoriaChamado to set
     */
    public void setCategoriaChamado(CategoriaChamado categoriaChamado) {
        this.categoriaChamado = categoriaChamado;
    }
    
}
