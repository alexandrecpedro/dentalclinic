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

    public ConsultaDTO(String descricao, String status, PacienteDTO pacienteDTO, DentistaDTO dentistaDTO, LocalDate data, LocalTime hora) {
        this.descricao = descricao;
        this.status = status;
        this.paciente = new Paciente(pacienteDTO);
        this.dentista = new Dentista(dentistaDTO);
        this.data = data;
        this.hora = hora;
    }

    public ConsultaDTO(Consulta consulta) {
        if(consulta.getId()!=0){
            this.id=consulta.getId();
        }
        this.descricao = consulta.getDescricao();
        this.status = consulta.getStatus();
        this.paciente = consulta.getPaciente();
        this.dentista = consulta.getDentista();
        this.data = consulta.getData();
        this.hora = consulta.getHora();
    }

    public ConsultaDTO(String descricao, String status, PacienteDTO pacienteDTO, DentistaDTO dentistaDTO, String data, String hora) {
        this.descricao = descricao;
        this.status = status;
        this.paciente = new Paciente(pacienteDTO);
        this.dentista = new Dentista(dentistaDTO);
        String[] dataArr;
        dataArr = data.split("/");
        String[] horaArr;
        horaArr = hora.split(":");
        this.data = LocalDate.of(Integer.parseInt(dataArr[2]),Integer.parseInt(dataArr[1]),Integer.parseInt(dataArr[0]));
        this.hora = LocalTime.of(Integer.parseInt(horaArr[0]),Integer.parseInt(horaArr[1]));
    }


    @Override
    public String toString() {
        return "ConsultaDTO{" +
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
