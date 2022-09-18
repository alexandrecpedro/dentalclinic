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
}
