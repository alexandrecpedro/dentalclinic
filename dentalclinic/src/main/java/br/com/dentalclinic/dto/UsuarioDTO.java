package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Usuario;

public class UsuarioDTO {

    private String email, senha;
    private int fk_tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.fk_tipoUsuario = usuario.getFk_idTipoUsuario();
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
