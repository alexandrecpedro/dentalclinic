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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Consulta implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private Date dataConsulta;
    private String descricao, status;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idPaciente;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idDentista;

    /** Constructor **/
    public Consulta() {
    }

    public Consulta(ConsultaDTO consultaDTO) {
        this.dataConsulta = consultaDTO.getDataConsulta();
        this.descricao = consultaDTO.getDescricao();
        this.status = consultaDTO.getStatus();
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
