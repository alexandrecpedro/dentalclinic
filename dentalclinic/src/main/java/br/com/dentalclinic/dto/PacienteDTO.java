package br.com.dentalclinic.dto;

public class PacienteDTO {
    private String nomel;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private int fk_idUsuario;
    private int fk_idEndereco;

    public PacienteDTO() {
    }

    public PacienteDTO(String nomel, String sobrenome, String cpf, String telefone, int fk_idUsuario, int fk_idEndereco) {
        this.nomel = nomel;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.fk_idUsuario = fk_idUsuario;
        this.fk_idEndereco = fk_idEndereco;
    }

    public String getNomel() {
        return nomel;
    }

    public void setNomel(String nomel) {
        this.nomel = nomel;
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