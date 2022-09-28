package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
public class EnderecoDTO {

    private int id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;

    public EnderecoDTO(Endereco endereco) {
        if(endereco.getId()!=0){
            this.id= endereco.getId();
        }
        this.logradouro = endereco.getLogradouro();
        this.numero = endereco.getNumero();
        this.complemento = endereco.getComplemento();
        this.bairro = endereco.getBairro();
        this.localidade = endereco.getLocalidade();
        this.uf = endereco.getUf();
        this.cep = endereco.getCep();
    }

    public EnderecoDTO(String logradouro, String numero, String complemento, String bairro, String localidade, String uf, String cep) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.cep = cep;
    }

    public EnderecoDTO(JSONObject jsonEndereco) {
        this.logradouro = jsonEndereco.getString("logradouro");
        this.numero = jsonEndereco.getString("numero");
        this.complemento = jsonEndereco.getString("complemento");
        this.bairro = jsonEndereco.getString("bairro");
        this.localidade = jsonEndereco.getString("localidade");
        this.uf = jsonEndereco.getString("uf");
        this.cep = jsonEndereco.getString("cep");
    }

    @Override
    public String toString() {
        return "EnderecoDTO{" +
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