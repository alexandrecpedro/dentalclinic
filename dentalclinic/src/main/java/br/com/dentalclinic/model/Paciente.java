package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.PacienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String telefone;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Usuario.class)
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    /** Constructor **/
    public Paciente(String nome, String sobrenome, String cpf, String telefone, Usuario usuario, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public Paciente(PacienteDTO pacienteDTO) {
        this.nome = pacienteDTO.getNome();
        this.sobrenome = pacienteDTO.getSobrenome();
        this.cpf = pacienteDTO.getCpf();
        this.telefone = pacienteDTO.getTelefone();
        this.usuario = pacienteDTO.getUsuario();
        this.endereco = pacienteDTO.getEndereco();
    }
}
