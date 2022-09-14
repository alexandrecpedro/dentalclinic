package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Usuario;

public class DentistaDTO {

    private int id;
    private String nome;

    private String sobrenome;
    private String cro;
    private Usuario usuario;

    private Clinica clinica;
    public DentistaDTO() {
    }


    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
        this.usuario = dentista.getUsuario();
        this.clinica = dentista.getClinica();
    }

    public DentistaDTO(int id, String nome, String sobrenome, String cro, Usuario usuario, Clinica clinica) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }
}
