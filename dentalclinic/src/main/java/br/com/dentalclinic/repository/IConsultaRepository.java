package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaRepository extends JpaRepository<Consulta, Integer> {
}
