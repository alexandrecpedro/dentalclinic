package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.DentistaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tb_dentista")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dentista implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
    private String nome, cro;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idUsuario;

    /** Constructor **/
    public Dentista() {
    }

    public Dentista(DentistaDTO dentistaDTO) {
        this.nome = dentistaDTO.getNome();
        this.cro = dentistaDTO.getCro();
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
