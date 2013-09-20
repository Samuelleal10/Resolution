/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author Labin05
 */
@Entity
public class Chamado implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String TipoChamado;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date dataInicio;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date dataFim;
//    private Date horaInicio;
//    private Date horaFim;
    private String descricaoChamado;
    private String descricaoSolucao;

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
        if (!(object instanceof Chamado)) {
            return false;
        }
        Chamado other = (Chamado) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Chamado[ id=" + getId() + " ]";
    }

    /**
     * @return the TipoChamado
     */
    public String getTipoChamado() {
        return TipoChamado;
    }

    /**
     * @param TipoChamado the TipoChamado to set
     */
    public void setTipoChamado(String TipoChamado) {
        this.TipoChamado = TipoChamado;
    }

    /**
     * @return the descricaoChamado
     */
    public String getDescricaoChamado() {
        return descricaoChamado;
    }

    /**
     * @param descricaoChamado the descricaoChamado to set
     */
    public void setDescricaoChamado(String descricaoChamado) {
        this.descricaoChamado = descricaoChamado;
    }

    /**
     * @return the descricaoSolucao
     */
    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    /**
     * @param descricaoSolucao the descricaoSolucao to set
     */
    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }
    
}
