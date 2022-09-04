package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.repository.ClinicaRepository;
import br.com.dentalclinic.repository.EnderecoRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicaServiceImpl implements IService<Clinica> {
    /** Attributes **/
    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    /** Methods **/
    @Override
    public Clinica salvar(Clinica clinica) {
        if (!clinica.equals(null)) {
            clinicaRepository.save(clinica);
        }
        return clinica;
    }
    @Override
    public Optional<Clinica> buscarById(Integer id) {
        return clinicaRepository.findById(id);
    }
    @Override
    public Clinica atualizar(Clinica clinica) {
        return clinicaRepository.saveAndFlush(clinica);
    }

    @Override
    public void deletar(Integer id) {
        clinicaRepository.deleteById(id);
    }

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
