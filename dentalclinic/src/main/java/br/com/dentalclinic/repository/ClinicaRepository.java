package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<Clinica, Integer> {
}