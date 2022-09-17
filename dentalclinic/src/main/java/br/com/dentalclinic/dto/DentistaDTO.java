package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DentistaDTO {

    private int id;
    private String nome;

    private String sobrenome;
    private String cro;
    private Usuario usuario;

    private Clinica clinica;

    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
        this.usuario = dentista.getUsuario();
        this.clinica = dentista.getClinica();
    }
}
