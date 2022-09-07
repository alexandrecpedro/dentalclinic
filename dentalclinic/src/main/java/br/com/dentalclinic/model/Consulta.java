package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "tb_consulta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dataConsulta;
    private String descricao;
    private String status;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Paciente.class)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Dentista.class)
    private Dentista dentista;

    /** Constructor **/
    public Consulta() {
    }

    public Consulta(ConsultaDTO consultaDTO) {
        this.dataConsulta = consultaDTO.getDataConsulta();
        this.descricao = consultaDTO.getDescricao();
        this.status = consultaDTO.getStatus();
        this.paciente = consultaDTO.getPaciente();
        this.dentista = consultaDTO.getDentista();
    }

    public Consulta(Date dataConsulta, String descricao, String status, Paciente paciente, Dentista dentista) {
        this.dataConsulta = dataConsulta;
        this.descricao = descricao;
        this.status = status;
        this.paciente = paciente;
        this.dentista = dentista;
    }

    /** Getters/Setters **/
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
