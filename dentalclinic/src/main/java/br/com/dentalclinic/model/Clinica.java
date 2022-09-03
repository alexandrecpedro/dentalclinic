package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ClinicaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_clinica")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Clinica implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String nomeFantasia, razaoSocial;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idEndereco;

    /** Constructor **/
    public Clinica() {
    }

    public Clinica(ClinicaDTO clinicaDTO) {
        this.nomeFantasia = clinicaDTO.getNomeFantasia();
        this.razaoSocial = clinicaDTO.getRazaoSocial();
    }

    /** Getters/Setters **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getFk_idEndereco() {
        return fk_idEndereco;
    }

    public void setFk_idEndereco(int fk_idEndereco) {
        this.fk_idEndereco = fk_idEndereco;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
