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
    private String nome, cro;
    private int fk_idUsuario;

    /** Constructor **/
    public Dentista() {
    }

    public Dentista(String nome, String cro) {
        this.nome = nome;
        this.cro = cro;
    }

    public Dentista(int id, String nome, String cro) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
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

    public int getFk_idUsuario() {
        return fk_idUsuario;
    }

    public void setFk_idUsuario(int fk_idUsuario) {
        this.fk_idUsuario = fk_idUsuario;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cro='" + cro + '\'' +
                '}';
    }
}
