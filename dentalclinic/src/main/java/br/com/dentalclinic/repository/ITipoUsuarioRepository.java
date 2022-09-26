package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
    List<TipoUsuario> findByNome(String nome);
}
