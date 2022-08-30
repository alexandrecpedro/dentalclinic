package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.TipoUsuarioDaoImpl;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {
    /** Attribute **/
    @Autowired
    private TipoUsuarioService tipoUsuarioService = new TipoUsuarioService(
            new TipoUsuarioDaoImpl(new ConfiguracaoJDBC())
    );

    /** Methods **/
    @PostMapping("/salvar")
    public TipoUsuario salvar(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.salvar(tipoUsuario);
    }

    @GetMapping("/{id}")
    public TipoUsuario buscarById(@PathVariable Integer id) {
        return tipoUsuarioService.buscarById(id);
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
