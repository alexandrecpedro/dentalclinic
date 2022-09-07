package br.com.dentalclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
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
    public Dentista() {
    }

    public Dentista(String nome, String sobrenome, String cro, Usuario usuario, Clinica clinica) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
    }

    public Dentista(int id, String nome, String sobrenome, String cro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cro = cro;
        this.usuario = usuario;
        this.clinica = clinica;
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

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
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
