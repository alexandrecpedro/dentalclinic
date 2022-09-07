package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public TipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        this.nome = tipoUsuarioDTO.getNome();
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

    /** Methods **/
    @Override
    public String toString() {
        return "TipoUsuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
