package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {

    private int id;
    private String email;
    private String senha;
    private TipoUsuarioDTO tipoUsuarioDTO;

    public UsuarioDTO(String email, String senha, TipoUsuarioDTO tipoUsuarioDTO) {
        this.email = email;
        this.senha = senha;
        this.tipoUsuarioDTO = tipoUsuarioDTO;
    }

    public UsuarioDTO(Usuario usuario){
        if(usuario.getId()!=0){
            this.id=usuario.getId();
        }else{
            this.id=0;
        }
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.tipoUsuarioDTO = new TipoUsuarioDTO(usuario.getTipoUsuario());
    }
}
