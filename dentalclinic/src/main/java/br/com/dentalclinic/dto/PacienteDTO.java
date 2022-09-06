package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.model.Usuario;

public class PacienteDTO {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Usuario usuario;
    private Endereco endereco;

    public PacienteDTO() {
    }

    public PacienteDTO(String nome, String sobrenome, String cpf, String telefone, Usuario usuario, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.usuario = usuario;
        this.endereco = endereco;
    }

    public PacienteDTO(Paciente paciente) {
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.cpf = paciente.getCpf();
        this.telefone = paciente.getTelefone();
        this.usuario = paciente.getUsuario();
        this.endereco = paciente.getEndereco();
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "PacienteDTO{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", usuario=" + usuario.toString() +
                ", endereco=" + endereco.toString() +
                '}';
    }
}