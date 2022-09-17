package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private int id;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;

    public UsuarioDTO(String email, String senha, TipoUsuario tipoUsuario) {
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public UsuarioDTO(Usuario usuario){
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.tipoUsuario = usuario.getTipoUsuario();
    }
}
