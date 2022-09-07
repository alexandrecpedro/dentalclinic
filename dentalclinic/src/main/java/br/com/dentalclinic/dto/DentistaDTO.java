package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Usuario;

public class DentistaDTO {

    private int id;
    private String nome;
    private String cro;
    private Usuario usuario;

    public DentistaDTO() {
    }

    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.cro = dentista.getCro();
        this.usuario = dentista.getUsuario();
    }

    public DentistaDTO(String nome, String cro, Usuario usuario) {
        this.nome = nome;
        this.cro = cro;
        this.usuario = usuario;
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
}
