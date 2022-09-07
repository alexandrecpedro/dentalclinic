package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.TipoUsuario;

public class TipoUsuarioDTO {

    private int id;
    private String nome;

    public TipoUsuarioDTO() {
    }

    public TipoUsuarioDTO(TipoUsuario tipoUsuario) {
        this.nome = tipoUsuario.getNome();
    }

    public TipoUsuarioDTO(String nome) {
        this.nome = nome;
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
}
