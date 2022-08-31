package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaService {
    /** Attribute **/
    @Autowired
    private ConsultaRepository consultaRepository;

    /** Constructor **/
    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    /** Methods **/
    public Consulta salvar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public Optional<Consulta> buscarById(Integer id) {
        return consultaRepository.findById(id);
    }

    public Consulta atualizar(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    public void deletar(Integer id) {
        consultaRepository.deleteById(id);
    }
}
