package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
    TipoUsuario findByNome(String nome);
}
