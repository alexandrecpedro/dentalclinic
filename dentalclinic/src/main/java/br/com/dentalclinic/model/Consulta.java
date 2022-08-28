package br.com.dentalclinic.model;

import java.io.Serializable;
import java.util.Date;

public class Consulta implements Serializable {
    /** Attributes **/
    private int id;
    private Date dataConsulta;
    private String descricao, status;
    private int fk_idPaciente, fk_idDentista;

    /** Constructor **/
    public Consulta() {
    }

    public Consulta(Date dataConsulta, String descricao, String status) {
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.status = status;
    }

    public Consulta(int id, Date dataConsulta, String descricao, String status) {
        this.id = id;
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.status = status;
    }

    /** Getters/Setters **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(Date dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFk_idPaciente() {
        return fk_idPaciente;
    }

    public void setFk_idPaciente(int fk_idPaciente) {
        this.fk_idPaciente = fk_idPaciente;
    }

    public int getFk_idDentista() {
        return fk_idDentista;
    }

    public void setFk_idDentista(int fk_idDentista) {
        this.fk_idDentista = fk_idDentista;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataConsulta=" + dataConsulta +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
