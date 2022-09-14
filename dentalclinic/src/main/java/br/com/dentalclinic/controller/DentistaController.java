package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.DentistaDTO;
import br.com.dentalclinic.service.impl.DentistaServiceImpl;
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
    private DentistaServiceImpl dentistaService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<DentistaDTO> salvar(@RequestBody DentistaDTO dentistaDTO) {
        return ResponseEntity.ok(dentistaService.salvar(dentistaDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DentistaDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(dentistaService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<DentistaDTO> atualizar(@RequestBody DentistaDTO dentistaDTO) {
        return (dentistaService.buscarById(dentistaDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(dentistaService.atualizar(dentistaDTO));
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
