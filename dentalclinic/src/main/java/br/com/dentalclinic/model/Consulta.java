package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.ConsultaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
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

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String status;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = Paciente.class)
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.MERGE, targetEntity = Dentista.class)
    private Dentista dentista;

    @Column(nullable = false)
    private LocalDate data;
    @Column(nullable = false)
    private LocalTime hora;

    /** Constructor **/
    public Consulta(ConsultaDTO consultaDTO) {
        if(consultaDTO.getId()!=0){
            this.id=consultaDTO.getId();
        }
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

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", paciente=" + paciente.toString() +
                ", dentista=" + dentista.toString() +
                ", data=" + data +
                ", hora=" + hora +
                '}';
    }
}
