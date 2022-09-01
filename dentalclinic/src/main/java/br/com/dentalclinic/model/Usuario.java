package br.com.dentalclinic.model;

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
    private int fk_idTipoUsuario;

    /** Constructor **/
    public Usuario() {
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
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

    public int getFk_idTipoUsuario() {
        return fk_idTipoUsuario;
    }

    public void setFk_idTipoUsuario(int fk_idTipoUsuario) {
        this.fk_idTipoUsuario = fk_idTipoUsuario;
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
