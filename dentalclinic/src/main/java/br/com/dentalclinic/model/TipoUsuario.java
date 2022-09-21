package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.enums.UserRoles;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    /** Constructor **/
    public TipoUsuario(String nome) {
        this.nome = nome;
    }

    public TipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        this.nome = tipoUsuarioDTO.getNome();
    }
}
