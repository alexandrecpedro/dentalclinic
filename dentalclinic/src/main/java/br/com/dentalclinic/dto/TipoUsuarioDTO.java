package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.TipoUsuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoUsuarioDTO {

    private int id;
    private String nome;

    public TipoUsuarioDTO(TipoUsuario tipoUsuario) {
        this.nome = tipoUsuario.getNome();
    }

    public TipoUsuarioDTO(String nome) {
        this.nome = nome;
    }
}
