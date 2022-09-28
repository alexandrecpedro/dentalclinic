package br.com.dentalclinic;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IUsuarioRepository;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UsuarioServiceImpl iUsuarioRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        //String password2 = passwordEncoder.encode("user");
        String password = passwordEncoder.encode("admin");
        String password2 = passwordEncoder.encode("user");

        UsuarioDTO usuario1 = iUsuarioRepository.salvar(new UsuarioDTO("admin@dh.com",password,new TipoUsuarioDTO("ROLE_ADMIN")));
        UsuarioDTO usuario2 = iUsuarioRepository.salvar(new UsuarioDTO("user@dh.com",password2,new TipoUsuarioDTO("ROLE_USER")));

    }
}