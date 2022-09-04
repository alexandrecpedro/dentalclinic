package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Dentista;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

public class DentistaDTO {
    private String nome, cro;
    @OneToOne(cascade = CascadeType.ALL)
    private int fk_idUsuario;

    public DentistaDTO() {
    }

    public DentistaDTO(Dentista dentista) {
        this.nome = dentista.getNome();
        this.cro = dentista.getCro();
        this.fk_idUsuario = dentista.getFk_idUsuario();
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
}
