package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.UsuarioDTO;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email, senha;
    @OneToOne
    @PrimaryKeyJoinColumn
    private TipoUsuario tipoUsuario;

    /** Constructor **/
    public Usuario() {
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.tipoUsuario = usuarioDTO.getTipoUsuario();
    }

    public Usuario(String email, String senha, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    /** Getters/Setters **/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
