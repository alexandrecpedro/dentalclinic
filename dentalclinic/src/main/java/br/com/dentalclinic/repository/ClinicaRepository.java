package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {
    Optional<Clinica> findByNomeFantasia(String nomeFantasia);
}