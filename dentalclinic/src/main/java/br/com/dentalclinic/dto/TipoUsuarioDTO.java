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
        if(tipoUsuario.getId()!=0){
            this.id=tipoUsuario.getId();
        }else{
            this.id=0;
        }
        this.nome = tipoUsuario.getNome();
    }

    public TipoUsuarioDTO(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "TipoUsuarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
