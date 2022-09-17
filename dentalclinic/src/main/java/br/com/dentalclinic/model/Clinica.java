package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ClinicaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
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
    private String nomeFantasia;
    private String razaoSocial;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Endereco.class)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    /** Constructor **/
    public Clinica(ClinicaDTO clinicaDTO) {
        this.nomeFantasia = clinicaDTO.getNomeFantasia();
        this.razaoSocial = clinicaDTO.getRazaoSocial();
    }

    public Clinica(String nomeFantasia, String razaoSocial, Endereco endereco) {
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Clinica{" +
                "id=" + id +
                ", nomeFantasia='" + nomeFantasia + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", endereco='" + endereco.toString() + '\''+
                '}';
    }
}
