package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_consulta")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Consulta implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String status;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Paciente.class)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, targetEntity = Dentista.class)
    private Dentista dentista;
    
    private LocalDate data;
    private LocalTime hora;

    /** Constructor **/
    public Consulta(ConsultaDTO consultaDTO) {
        this.descricao = consultaDTO.getDescricao();
        this.status = consultaDTO.getStatus();
        this.paciente = consultaDTO.getPaciente();
        this.dentista = consultaDTO.getDentista();
        this.data = consultaDTO.getData();
        this.hora = consultaDTO.getHora();
    }

    public Consulta(String descricao, String status, Paciente paciente, Dentista dentista, LocalDate data, LocalTime hora) {
        this.descricao = descricao;
        this.status = status;
        this.paciente = paciente;
        this.dentista = dentista;
        this.data = data;
        this.hora = hora;
    }

    /** Methods **/
    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", dataConsulta=" + data +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
