/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import util.BaseEntity;

/**
 *
 * @author Labin05
 */
@Entity
public class CategoriaChamado implements Serializable, BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String descricao;
    private Equipe equipe;
    
    @OneToMany(mappedBy = "categoriaChamado")
    private List<SubCategoria> subCategorias = new ArrayList<SubCategoria>();
    
     @OneToMany(mappedBy="categoriaChamado")
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
        if (!(object instanceof CategoriaChamado)) {
            return false;
        }
        CategoriaChamado other = (CategoriaChamado) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CategoriaChamado[ id=" + getId() + " ]";
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
     * @return the equipe
     */
    public Equipe getEquipe() {
        return equipe;
    }

    /**
     * @param equipe the equipe to set
     */
    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    /**
     * @return the subCategorias
     */
    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    /**
     * @param subCategorias the subCategorias to set
     */
    public void setSubCategorias(List<SubCategoria> subCategorias) {
        this.subCategorias = subCategorias;
    }
}
