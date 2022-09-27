package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.DentistaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false)
    private String cro;

    @OneToOne(cascade = CascadeType.REMOVE, targetEntity = Usuario.class)
    private Usuario usuario;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Clinica.class)
    private Clinica clinica;

    /** Constructor **/
    public Dentista(DentistaDTO dentistaDTO) {
        if(dentistaDTO.getId()!=0){
            this.id= dentistaDTO.getId();
        }
        this.nome = dentistaDTO.getNome();
        this.sobrenome = dentistaDTO.getSobrenome();
        this.cro = dentistaDTO.getCro();
        this.usuario = dentistaDTO.getUsuario();
        this.clinica = dentistaDTO.getClinica();
    }

    public Dentista(String nome, String sobrenome, String cro, Usuario usuario, Clinica clinica) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
    }

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
