package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.PacienteDTO;
import br.com.dentalclinic.service.impl.PacienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    /** Attribute **/
    @Autowired
    private PacienteServiceImpl pacienteService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<PacienteDTO> salvar(@RequestBody PacienteDTO pacienteDTO) {
        return ResponseEntity.ok(pacienteService.salvar(pacienteDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PacienteDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<PacienteDTO> atualizar(@RequestBody PacienteDTO pacienteDTO) {
        return (pacienteService.buscarById(pacienteDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(pacienteService.atualizar(pacienteDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (pacienteService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            pacienteService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
