package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IClinicaRepository extends JpaRepository<Clinica, Integer> {
    Optional<Clinica> findByNomeFantasia(String nomeFantasia);
}