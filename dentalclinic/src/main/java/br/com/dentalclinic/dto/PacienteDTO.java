package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {

    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Usuario usuario;
    private Endereco endereco;

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