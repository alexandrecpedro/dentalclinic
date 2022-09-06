package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistaRepository extends JpaRepository<Dentista, Integer> {
}
