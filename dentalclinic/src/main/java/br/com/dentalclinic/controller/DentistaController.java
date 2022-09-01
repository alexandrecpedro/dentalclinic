package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.DentistaDaoImpl;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/dentista")
public class DentistaController {
    /** Attribute **/
    @Autowired
    private DentistaService dentistaService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<Dentista> salvar(@RequestBody Dentista dentista) {
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Dentista>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistaService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Dentista> atualizar(@RequestBody Dentista dentista) {
        return (dentistaService.buscarById(dentista.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(dentistaService.atualizar(dentista));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (dentistaService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            dentistaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
