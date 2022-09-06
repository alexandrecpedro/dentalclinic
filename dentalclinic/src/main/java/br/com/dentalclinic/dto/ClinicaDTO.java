package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Endereco;

public class ClinicaDTO {

    private String nomeFantasia, razaoSocial;
    private Endereco endereco;

    public ClinicaDTO() {
    }

    public ClinicaDTO(Clinica clinica) {
        this.nomeFantasia = clinica.getNomeFantasia();
        this.razaoSocial = clinica.getRazaoSocial();
        this.endereco = clinica.getEndereco();
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
}
