package br.com.dentalclinic.dto;

public class UsuarioDTO {

    private String email;
    private String senha;
    private int fk_tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String email, String senha, int fk_tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.fk_tipoUsuario = fk_tipoUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFk_tipoUsuario() {
        return fk_tipoUsuario;
    }

    public void setFk_tipoUsuario(int fk_tipoUsuario) {
        this.fk_tipoUsuario = fk_tipoUsuario;
    }
}
