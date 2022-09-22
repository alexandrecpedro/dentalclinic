package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class  Usuario implements UserDetails {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = TipoUsuario.class)
    @PrimaryKeyJoinColumn
    private TipoUsuario tipoUsuario;

    /** Constructor **/
    public Usuario(UsuarioDTO usuarioDTO) {
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
        this.tipoUsuario = new TipoUsuario(usuarioDTO.getTipoUsuarioDTO());
    }

    public Usuario(String email, String senha, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tipoUsuario.getNome());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
