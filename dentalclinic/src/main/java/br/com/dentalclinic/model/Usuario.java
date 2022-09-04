package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_usuario")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String email, senha;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idTipoUsuario;

    /** Constructor **/
    public Usuario() {
    }

    public Usuario(UsuarioDTO usuarioDTO) {
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.fk_idTipoUsuario = usuarioDTO.getFk_tipoUsuario();
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
