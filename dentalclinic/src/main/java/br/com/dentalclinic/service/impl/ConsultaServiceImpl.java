package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.repository.IConsultaRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IService<Consulta> {
    /** Attribute **/
    @Autowired
    private IConsultaRepository IConsultaRepository;

    /** Constructor **/
    public ConsultaServiceImpl(IConsultaRepository IConsultaRepository) {
        this.IConsultaRepository = IConsultaRepository;
    }

    /** Methods **/
    @Override
    public Consulta salvar(Consulta consulta) {
        if (!consulta.equals(null)) {
            IConsultaRepository.save(consulta);
        }
        return consulta;
    }

    @Override
    public Optional<Consulta> buscarById(Integer id) {
        return IConsultaRepository.findById(id);
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        return IConsultaRepository.saveAndFlush(consulta);
    }

    @Override
    public void deletar(Integer id) {
        IConsultaRepository.deleteById(id);
    }
}
