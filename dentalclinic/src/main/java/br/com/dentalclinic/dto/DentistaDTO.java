package br.com.dentalclinic.dto;

public class DentistaDTO {
    private String nome;
    private String cro;
    private int fk_idUsuario;

    public DentistaDTO() {
    }

    public DentistaDTO(String nome, String cro, int fk_idUsuario) {
        this.nome = nome;
        this.cro = cro;
        this.fk_idUsuario = fk_idUsuario;
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

    public int getFk_idUsuario() {
        return fk_idUsuario;
    }

    public void setFk_idUsuario(int fk_idUsuario) {
        this.fk_idUsuario = fk_idUsuario;
    }
}
