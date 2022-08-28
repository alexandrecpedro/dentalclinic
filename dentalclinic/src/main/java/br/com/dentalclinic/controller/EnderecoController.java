package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.EnderecoDaoImpl;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    /** Attribute **/
    private EnderecoService enderecoService = new EnderecoService(
            new EnderecoDaoImpl(new ConfiguracaoJDBC())
    );

    /** Methods **/
    @PostMapping("/salvar")
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvar(endereco);
    }

    @GetMapping("/{id}")
    public Endereco buscarById(@PathVariable Integer id) {
        return enderecoService.buscarById(id);
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
