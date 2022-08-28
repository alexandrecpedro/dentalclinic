package br.com.dentalclinic.model;

import java.io.Serializable;

public class TipoUsuario implements Serializable {
    /** Attributes **/
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
