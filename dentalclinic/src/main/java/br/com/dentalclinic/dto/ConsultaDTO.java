package br.com.dentalclinic.dto;

import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Paciente;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaDTO {

    private int id;
    private String descricao;
    private String status;
    private Paciente paciente;
    private Dentista dentista;
    private LocalDate data;
    private LocalTime hora;

    public ConsultaDTO(String descricao, String status, Paciente paciente, Dentista dentista, LocalDate data, LocalTime hora) {
        this.descricao = descricao;
        this.status = status;
        this.paciente = paciente;
        this.dentista = dentista;
        this.data = data;
        this.hora = hora;
    }

    public ConsultaDTO(Consulta consulta) {
        this.descricao = consulta.getDescricao();
        this.status = consulta.getStatus();
        this.paciente = consulta.getPaciente();
        this.dentista = consulta.getDentista();
        this.data = consulta.getData();
        this.hora = consulta.getHora();
    }
}
