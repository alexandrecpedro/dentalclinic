package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
