package br.com.dentalclinic.repository;

import br.com.dentalclinic.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEnderecoRepository extends JpaRepository<Endereco, Integer> {
}
