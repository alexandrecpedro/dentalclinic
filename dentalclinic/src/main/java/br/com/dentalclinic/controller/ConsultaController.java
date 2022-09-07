package br.com.dentalclinic.controller;

import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Consulta> salvar(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.salvar(consulta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Consulta>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(consultaService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta) {
        return (consultaService.buscarById(consulta.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(consultaService.atualizar(consulta));
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
