package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.DentistaDTO;
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
@Table(name = "tb_dentista")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Dentista implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome,sobrenome,cro;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Usuario.class)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Clinica.class)
    private Clinica clinica;

    /** Constructor **/
    public Dentista(DentistaDTO dentistaDTO) {
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.cro = dentistaDTO.getCro();
        this.usuario = dentistaDTO.getUsuario();
        this.clinica = dentistaDTO.getClinica();
    }

    public Dentista(int id, String nome, String sobrenome, String cro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cro='" + cro + '\'' +
                ", usuario=" + usuario.toString() +
                ", clinica=" + clinica.toString() +
                '}';
    }

}
