package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}