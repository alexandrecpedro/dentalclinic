package br.com.dentalclinic.controller;

import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> buscarById(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioService.buscarById(id));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        return (usuarioService.buscarById(usuario.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(usuarioService.atualizar(usuario));
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
