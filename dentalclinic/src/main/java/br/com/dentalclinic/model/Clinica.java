package br.com.dentalclinic.model;

import java.io.Serializable;

public class Clinica implements Serializable {
    /** Attributes **/
    private int id;
    private String nomeFantasia, razaoSocial;
    private int fk_idEndereco;

    /** Constructor **/
    public Clinica() {
    }

    public Clinica(String nomeFantasia, String razaoSocial) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }

    public Clinica(int id, String nomeFantasia, String razaoSocial) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
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
