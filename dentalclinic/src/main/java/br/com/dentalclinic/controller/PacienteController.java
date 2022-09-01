package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.PacienteDaoImpl;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.service.PacienteService;
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
    private PacienteService pacienteService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(pacienteService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente) {
        return (pacienteService.buscarById(paciente.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(pacienteService.atualizar(paciente));
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
