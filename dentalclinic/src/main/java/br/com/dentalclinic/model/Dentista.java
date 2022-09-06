package br.com.dentalclinic.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_dentista")
public class Dentista implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome,sobrenome,cro;

    @OneToOne
    private Usuario usuario;

    @ManyToOne
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

    public void setId(int id) {
        this.id = id;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
