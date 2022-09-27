package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.UsuarioDTO;
//import br.com.dentalclinic.security.AuthenticationResponse;
//import br.com.dentalclinic.security.utils.JwtUtil;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    /** Attributes **/
//    @Autowired
//    private UsuarioServiceImpl usuarioService;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;


    /** Methods **/
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody UsuarioDTO usuarioDTO)
//            throws Exception {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                    usuarioDTO.getEmail(), usuarioDTO.getSenha()));
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect", e);
//        }
//        final UserDetails userDetails = usuarioService.loadUserByUsername(usuarioDTO.getEmail());
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new AuthenticationResponse((jwt)));
//    }
//
//    @PostMapping("/salvar")
//    public ResponseEntity<UsuarioDTO> salvar(@RequestBody @Validated UsuarioDTO usuarioDTO) {
//        return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<UsuarioDTO>> buscarById(@PathVariable Integer id) {
//        return ResponseEntity.ok(usuarioService.buscarById(id));
//    }
//
//    @PutMapping("/atualizar")
//    public ResponseEntity<UsuarioDTO> atualizar(@RequestBody @Validated UsuarioDTO usuarioDTO) {
//        return (usuarioService.buscarById(usuarioDTO.getId()).equals(null)) ?
//                new ResponseEntity(HttpStatus.NOT_FOUND)
//                : ResponseEntity.ok(usuarioService.atualizar(usuarioDTO));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deletar(@PathVariable Integer id) {
//        if (usuarioService.buscarById(id).equals(null)) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        } else {
//            usuarioService.deletar(id);
//            return ResponseEntity.noContent().build();
//        }
//    }
}
