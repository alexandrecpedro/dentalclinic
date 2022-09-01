package br.com.dentalclinic.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_tipo_usuario")

public class TipoUsuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    /** Constructor **/
    public TipoUsuario() {
    }

    public TipoUsuario(String nome) {
        this.nome = nome;
    }

    public TipoUsuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    /** Methods **/
    @Override
    public String toString() {
        return "TipoUsuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
