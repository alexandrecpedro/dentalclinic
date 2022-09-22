package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.model.Usuario;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DentistaDTO {
    /** Attributes **/
    private int id;
    private String nome;

    private String sobrenome;
    private String cro;
    private  Usuario usuario;

    private Clinica clinica;
    /** Construtores **/
    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
        this.usuario = dentista.getUsuario();
        this.clinica = dentista.getClinica();
    }

    public DentistaDTO(String nome, String sobrenome, String cro, Usuario usuario, Clinica clinica) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
    }

}
