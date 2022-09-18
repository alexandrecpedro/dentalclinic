package br.com.dentalclinic.model;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_tipo_usuario")
public class TipoUsuario implements Serializable {
    /** Attributes **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    /** Constructor **/
    public TipoUsuario(String nome) {
        this.nome = nome;
    }

    public TipoUsuario(TipoUsuarioDTO tipoUsuarioDTO) {
        this.nome = tipoUsuarioDTO.getNome();
    }
}
