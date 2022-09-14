package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
    /** Attribute **/
    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    /** Methods **/
    @PostMapping("/salvar")
    public ResponseEntity<TipoUsuarioDTO> salvar(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return ResponseEntity.ok(tipoUsuarioService.salvar(tipoUsuarioDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TipoUsuarioDTO>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(tipoUsuarioService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TipoUsuarioDTO> atualizar(@RequestBody TipoUsuarioDTO tipoUsuarioDTO) {
        return (tipoUsuarioService.buscarById(tipoUsuarioDTO.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(tipoUsuarioService.atualizar(tipoUsuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (tipoUsuarioService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            tipoUsuarioService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
