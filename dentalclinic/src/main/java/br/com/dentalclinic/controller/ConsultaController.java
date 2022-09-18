package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.ConsultaDTO;
import br.com.dentalclinic.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    /** Attribute **/
    @Autowired
    private ConsultaServiceImpl consultaService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<ConsultaDTO> salvar(@RequestBody @Validated ConsultaDTO consultaDTO) {
        return ResponseEntity.ok(consultaService.salvar(consultaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ConsultaDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(consultaService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<ConsultaDTO> atualizar(@RequestBody @Validated ConsultaDTO consultaDTO) {
        return (consultaService.buscarById(consultaDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(consultaService.atualizar(consultaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (consultaService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            consultaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
