package br.com.dentalclinic.dto;

public class TipoUsuarioDTO {

    private String nome;

    public TipoUsuarioDTO() {
    }

    public TipoUsuarioDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
