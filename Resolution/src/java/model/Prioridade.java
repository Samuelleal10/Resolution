/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import util.BaseEntity;

/**
 *
 * @author Labin05
 */
@Entity
public class Prioridade implements Serializable, BaseEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
      
    @OneToMany(mappedBy="prioridade")
    private List<Chamado> chamados = new ArrayList<Chamado>();

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
        if (!(object instanceof Prioridade)) {
            return false;
        }
        Prioridade other = (Prioridade) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Prioridade[ id=" + getId() + " ]";
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the chamados
     */
    public List<Chamado> getChamados() {
        return chamados;
    }

    /**
     * @param chamados the chamados to set
     */
    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
    
}
