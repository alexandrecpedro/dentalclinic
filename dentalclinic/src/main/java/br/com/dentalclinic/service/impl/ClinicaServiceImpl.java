package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.repository.IClinicaRepository;
import br.com.dentalclinic.repository.IEnderecoRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaServiceImpl implements IService<Clinica> {
    /** Attribute **/
    @Autowired
    private IClinicaRepository IClinicaRepository;

    @Autowired
    private IEnderecoRepository IEnderecoRepository;

    /** Constructor **/
    public ClinicaServiceImpl(IClinicaRepository IClinicaRepository) {
        this.IClinicaRepository = IClinicaRepository;
    }

    /** Methods **/
    @Override
    public Clinica salvar(Clinica clinica) {
        if (!clinica.equals(null)) {
            IClinicaRepository.save(clinica);
        }
        return clinica;
    }
    @Override
    public Optional<Clinica> buscarById(Integer id) {
        return IClinicaRepository.findById(id);
    }
    @Override
    public Clinica atualizar(Clinica clinica) {
        return IClinicaRepository.saveAndFlush(clinica);
    }

    @Override
    public void deletar(Integer id) {
        IClinicaRepository.deleteById(id);
    }

    public List<Clinica> buscarTodos() {
        return IClinicaRepository.findAll();
    }

    public Optional<Clinica> buscarByNomeFantasia(String nomeFantasia){return IClinicaRepository.findByNomeFantasia(nomeFantasia);}
//
//    public Clinica mapperDTOToEntity(ClinicaDTO clinicaDTO){
//        ObjectMapper objectMapper = new ObjectMapper();
//        Clinica clinica = objectMapper.convertValue(clinicaDTO, Clinica.class);
//        return clinica;
//    }
//
//    public ClinicaDTO mapperEntityToDTO(Clinica clinica){
//        ObjectMapper objectMapper = new ObjectMapper();
//        ClinicaDTO clinicaDTO = objectMapper.convertValue(clinica, ClinicaDTO.class);
//        return clinicaDTO;
//    }

}
