package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ClinicaDaoImpl;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {
    /** Attribute **/
    @Autowired
    private ClinicaService clinicaService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<Clinica> salvar(@RequestBody Clinica clinica) {
        return ResponseEntity.ok(clinicaService.salvar(clinica));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Clinica>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(clinicaService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Clinica> atualizar(@RequestBody Clinica clinica) {
        return (clinicaService.buscarById(clinica.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(clinicaService.atualizar(clinica));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (clinicaService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            clinicaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
