package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
    TipoUsuario findByNome(String nome);
}
