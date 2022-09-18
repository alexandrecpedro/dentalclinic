package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    /** Attribute **/
    @Autowired
    private UsuarioServiceImpl usuarioService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody @Validated UsuarioDTO usuarioDTO) {
        return (usuarioService.buscarById(usuarioDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(usuarioService.atualizar(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (usuarioService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            usuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
