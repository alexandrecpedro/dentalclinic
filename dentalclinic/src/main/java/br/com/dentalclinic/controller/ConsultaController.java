package br.com.dentalclinic.controller;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ConsultaDaoImpl;
import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {
    /** Attribute **/
    @Autowired
    private ConsultaService consultaService = new ConsultaService(
            new ConsultaDaoImpl(new ConfiguracaoJDBC())
    );

    /** Methods **/
    @PostMapping("/salvar")
    public Consulta salvar(@RequestBody Consulta consulta) {
        return consultaService.salvar(consulta);
    }

    @GetMapping("/{id}")
    public Consulta buscarById(@PathVariable Integer id) {
        return consultaService.buscarById(id);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta) {
        return (consultaService.buscarById(consulta.getId()).equals(null)) ?
                new ResponseEntity(HttpStatus.NOT_FOUND)
                : ResponseEntity.ok(consultaService.atualizar(consulta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Integer id) {
        if (consultaService.buscarById(id).equals(null)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            consultaService.deletar(id);
            return ResponseEntity.noContent().build();
        }
    }
}
