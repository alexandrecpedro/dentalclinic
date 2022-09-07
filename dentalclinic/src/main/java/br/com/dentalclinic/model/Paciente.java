package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.PacienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_paciente")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Usuario.class)
    private Usuario usuario;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    /** Constructor **/
    public Paciente() {
    }

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


    /** Getters/Setters **/
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", usuario=" + usuario.toString() +
                ", endereco=" + endereco.toString() +
                '}';
    }
}
