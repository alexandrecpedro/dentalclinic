package br.com.dentalclinic.controller;

import br.com.dentalclinic.model.TipoUsuario;
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
    public ResponseEntity<TipoUsuario> salvar(@RequestBody TipoUsuario tipoUsuario) {
        return ResponseEntity.ok(tipoUsuarioService.salvar(tipoUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<TipoUsuario>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(tipoUsuarioService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<TipoUsuario> atualizar(@RequestBody TipoUsuario tipoUsuario) {
        return (tipoUsuarioService.buscarById(tipoUsuario.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(tipoUsuarioService.atualizar(tipoUsuario));
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
