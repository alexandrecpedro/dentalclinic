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
    private Endereco endereco;

    public ClinicaDTO(String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    public ClinicaDTO(Clinica clinica) {
        this.nomeFantasia = clinica.getNomeFantasia();
        this.razaoSocial = clinica.getRazaoSocial();
        this.endereco = clinica.getEndereco();
    }

    public ClinicaDTO(String nomeFantasia, String razaoSocial, EnderecoDTO enderecoDTO) {
    }

    @Override
    public String toString() {
        return "ClinicaDTO{" +
                "nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
