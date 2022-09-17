package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email, senha;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = TipoUsuario.class)
    @PrimaryKeyJoinColumn
    private TipoUsuario tipoUsuario;

    /** Constructor **/
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
