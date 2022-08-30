package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.PacienteDaoImpl;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    /** Attribute **/
    @Autowired
    private PacienteService pacienteService = new PacienteService(
            new PacienteDaoImpl(new ConfiguracaoJDBC())
    );

    /** Methods **/
    @PostMapping("/salvar")
    public Paciente salvar(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente buscarById(@PathVariable Integer id) {
        return pacienteService.buscarById(id);
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
