package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_clinica")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Clinica implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique=true)
    private String nomeFantasia;
    @Column(nullable = false, unique=true)
    private String razaoSocial;
    @OneToOne(cascade = CascadeType.REMOVE, targetEntity = Endereco.class)
    @PrimaryKeyJoinColumn
    private Endereco endereco;


    /** Constructor **/
    public Clinica(ClinicaDTO clinicaDTO) {
        if(clinicaDTO.getId()!=0){
            this.id=clinicaDTO.getId();
        }
        this.nomeFantasia = clinicaDTO.getNomeFantasia();
        this.razaoSocial = clinicaDTO.getRazaoSocial();
        this.endereco = new Endereco(clinicaDTO.getEnderecoDTO());
    }

    public Clinica(String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco=" + endereco.toString() +
                '}';
    }
}
