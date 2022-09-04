package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Paciente;

public class PacienteDTO {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private int fk_idUsuario;
    private int fk_idEndereco;

    public PacienteDTO() {
    }

    public PacienteDTO(Paciente paciente) {
        this.nome = paciente.getNome();
        this.sobrenome = paciente.getSobrenome();
        this.cpf = paciente.getCpf();
        this.telefone = paciente.getTelefone();
        this.fk_idUsuario = paciente.getFk_idUsuario();
        this.fk_idEndereco = paciente.getFk_idEndereco();
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

    public int getFk_idUsuario() {
        return fk_idUsuario;
    }

    public void setFk_idUsuario(int fk_idUsuario) {
        this.fk_idUsuario = fk_idUsuario;
    }

    public int getFk_idEndereco() {
        return fk_idEndereco;
    }

    public void setFk_idEndereco(int fk_idEndereco) {
        this.fk_idEndereco = fk_idEndereco;
    }
}