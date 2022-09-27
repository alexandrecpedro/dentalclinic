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
        if(dentista.getId()!=0){
            this.id=dentista.getId();
        }
        this.nome = dentista.getNome();
        this.sobrenome = dentista.getSobrenome();
        this.cro = dentista.getCro();
        this.usuario = dentista.getUsuario();
        this.clinica = dentista.getClinica();
    }

    public DentistaDTO(String nome, String sobrenome, String cro, UsuarioDTO usuarioDTO, ClinicaDTO clinicaDTO) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = new Usuario(usuarioDTO);
        this.clinica = new Clinica(clinicaDTO);
    }

    @Override
    public String toString() {
        return "DentistaDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cro='" + cro + '\'' +
                ", usuario=" + usuario.toString() +
                ", clinica=" + clinica.toString() +
                '}';
    }
}
