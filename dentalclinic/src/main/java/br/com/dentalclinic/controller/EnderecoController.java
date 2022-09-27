package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<EnderecoDTO> salvar(@RequestBody @Validated EnderecoDTO enderecoDTO) {
        System.out.println(enderecoDTO.toString());
        return ResponseEntity.ok(enderecoService.salvar(enderecoDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<EnderecoDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(enderecoService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<EnderecoDTO> atualizar(@RequestBody @Validated EnderecoDTO enderecoDTO) {
        return (enderecoService.buscarById(enderecoDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(enderecoService.atualizar(enderecoDTO));
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
