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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_idEndereco")
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    /** Constructor **/
    public Clinica() {
    }

    public Clinica(ClinicaDTO clinicaDTO) {
        this.nomeFantasia = clinicaDTO.getNomeFantasia();
        this.razaoSocial = clinicaDTO.getRazaoSocial();
    }

    public Clinica(String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
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

    public Endereco getFk_idEndereco() {
        return endereco;
    }

    public void setFk_idEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco='" + endereco.toString() + '\''+
                '}';
    }
}
