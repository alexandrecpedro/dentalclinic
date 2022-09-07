package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Integer> {
}
