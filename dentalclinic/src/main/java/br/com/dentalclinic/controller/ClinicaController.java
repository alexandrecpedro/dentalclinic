package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ClinicaDaoImpl;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.service.ClinicaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {
    /** Attribute **/
    private ClinicaService clinicaService = new ClinicaService(
            new ClinicaDaoImpl(new ConfiguracaoJDBC())
    );

    /** Methods **/
    @PostMapping("/salvar")
    public Clinica salvar(@RequestBody Clinica clinica) {
        return clinicaService.salvar(clinica);
    }

    @GetMapping("/{id}")
    public Clinica buscarById(@PathVariable Integer id) {
        return clinicaService.buscarById(id);
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
