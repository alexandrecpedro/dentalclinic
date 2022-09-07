package br.com.dentalclinic.controller;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    /** Attribute **/
    @Autowired
    private EnderecoServiceImpl enderecoService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<Endereco> salvar(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(enderecoService.salvar(endereco));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Endereco>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco) {
        return (enderecoService.buscarById(endereco.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(enderecoService.atualizar(endereco));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (enderecoService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            enderecoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
