package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Paciente;

import java.util.Date;

public class ConsultaDTO {

    private int id;
    private Date dataConsulta;
    private String descricao, status;
    private Paciente paciente;
    private Dentista dentista;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Date dataConsulta, String descricao, String status, Paciente paciente, Dentista dentista) {
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.status = status;
        this.paciente = paciente;
        this.dentista = dentista;
    }

    public ConsultaDTO(Consulta consulta) {
        this.dataConsulta = consulta.getDataConsulta();
        this.descricao = consulta.getDescricao();
        this.status = consulta.getStatus();
        this.paciente = consulta.getPaciente();
        this.dentista = consulta.getDentista();
    }

    public int getId() {
        return id;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
}
