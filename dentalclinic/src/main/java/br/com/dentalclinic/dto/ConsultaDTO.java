package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Consulta;

import java.util.Date;

public class ConsultaDTO {
    private Date dataConsulta;
    private String descricao, status;
    private int fk_idPaciente, fk_idDentista;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Consulta consulta) {
        this.dataConsulta = consulta.getDataConsulta();
        this.descricao = consulta.getDescricao();
        this.status = consulta.getStatus();
        this.fk_idPaciente = consulta.getFk_idPaciente();
        this.fk_idDentista = consulta.getFk_idDentista();
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
}
