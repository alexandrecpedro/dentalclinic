package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
}