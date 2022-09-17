package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.EnderecoDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String logradouro, numero, complemento,
            bairro, localidade, uf, cep;

    /** Constructor **/
    public Endereco(EnderecoDTO enderecoDTO) {
        this.logradouro = enderecoDTO.getLogradouro();
        this.numero = enderecoDTO.getNumero();
        this.complemento = enderecoDTO.getComplemento();
        this.bairro = enderecoDTO.getBairro();
        this.localidade = enderecoDTO.getLocalidade();
        this.uf = enderecoDTO.getUf();
        this.cep = enderecoDTO.getCep();
    }

    public Endereco(String logradouro, String numero, String complemento, String bairro, String localidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", localidade='" + localidade + '\'' +
                ", uf='" + uf + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
