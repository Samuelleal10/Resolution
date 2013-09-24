/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import util.BaseEntity;

/**
 *
 * @author Labin05
 */
@Entity
public class Chamado implements Serializable, BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String tipoChamado;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date dataInicio;
//    @Temporal(javax.persistence.TemporalType.DATE)
//    private Date dataFim;
//    private Date horaInicio;
//    private Date horaFim;
    private String descricaoChamado;
    private String descricaoSolucao;
    private Status status;
    private Prioridade prioridade;
    private CategoriaChamado categoriaChamado;
    //Vou deixa-lo comentado até o ponto que eu venha a usá-lo. Este e os campos relacionados à data e hora
    //dos chamados serão tratados mais à frente. O que importa agora é INSERIR e ATUALIZAR (tarefas referntes a entrega).
    //private List<Feedback> feedbacks = new ArrayList<Feedback>(); //Todos os feedbacks

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

    /**
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * @return the prioridade
     */
    public Prioridade getPrioridade() {
        return prioridade;
    }

    /**
     * @param prioridade the prioridade to set
     */
    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
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

    /**
     * @return the tipoChamado
     */
    public String getTipoChamado() {
        return tipoChamado;
    }

    /**
     * @param tipoChamado the tipoChamado to set
     */
    public void setTipoChamado(String tipoChamado) {
        this.tipoChamado = tipoChamado;
    }
    /**
     * @return the feedbacks
     */
//    public List<Feedback> getFeedbacks() {
//        return feedbacks;
//    }
//
//    /**
//     * @param feedbacks the feedbacks to set
//     */
//    public void setFeedbacks(List<Feedback> feedbacks) {
//        this.feedbacks = feedbacks;
//    }
}
