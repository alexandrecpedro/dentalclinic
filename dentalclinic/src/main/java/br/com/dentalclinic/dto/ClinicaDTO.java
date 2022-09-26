package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaDTO {

    private int id;
    private String nomeFantasia;
    private String razaoSocial;
    private EnderecoDTO enderecoDTO;

    public ClinicaDTO(String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.enderecoDTO = new EnderecoDTO(endereco);
    }

    public ClinicaDTO(Clinica clinica) {
        this.nomeFantasia = clinica.getNomeFantasia();
        this.razaoSocial = clinica.getRazaoSocial();
        this.enderecoDTO = new EnderecoDTO(clinica.getEndereco());
    }

    public ClinicaDTO(String nomeFantasia, String razaoSocial, EnderecoDTO enderecoDTO) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.enderecoDTO = enderecoDTO;
    }
}
