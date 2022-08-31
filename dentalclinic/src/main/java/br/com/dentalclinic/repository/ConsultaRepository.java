package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
}
