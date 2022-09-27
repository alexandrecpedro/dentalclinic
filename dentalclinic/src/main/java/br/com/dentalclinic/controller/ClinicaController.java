package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.service.impl.ClinicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {
    /** Attribute **/
    @Autowired
    private ClinicaServiceImpl clinicaService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<ClinicaDTO> salvar(@RequestBody @Validated ClinicaDTO clinicaDTO) {
        return ResponseEntity.ok(clinicaService.salvar(clinicaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClinicaDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(clinicaService.buscarById(id));
    }
    @GetMapping("/buscarTodos")
    public List<ClinicaDTO> buscarTodos() {
        return ResponseEntity.ok(clinicaService.buscarTodos()).getBody();
    }
    @PutMapping("/atualizar")
    public ResponseEntity<ClinicaDTO> atualizar(@RequestBody @Validated ClinicaDTO clinicaDTO) {
        return (clinicaService.buscarById(clinicaDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(clinicaService.atualizar(clinicaDTO));
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
