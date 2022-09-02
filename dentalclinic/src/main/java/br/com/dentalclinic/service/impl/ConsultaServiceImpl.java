package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.repository.ConsultaRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IService<Consulta> {
    /** Attribute **/
    @Autowired
    private ConsultaRepository consultaRepository;

    /** Constructor **/
    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    /** Methods **/
    @Override
    public Consulta salvar(Consulta consulta) {
        if (!consulta.equals(null)) {
            consultaRepository.save(consulta);
        }
        return consulta;
    }

    @Override
    public Optional<Consulta> buscarById(Integer id) {
        return consultaRepository.findById(id);
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        return consultaRepository.saveAndFlush(consulta);
    }

    @Override
    public void deletar(Integer id) {
        consultaRepository.deleteById(id);
    }
}
