package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;

public class ClinicaDTO {

    private String nomeFantasia, razaoSocial;
    private int fk_idEndereco;

    public ClinicaDTO() {
    }

    public ClinicaDTO(Clinica clinica) {
        this.nomeFantasia = clinica.getNomeFantasia();
        this.razaoSocial = clinica.getRazaoSocial();
        this.fk_idEndereco = clinica.getFk_idEndereco();
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
}
