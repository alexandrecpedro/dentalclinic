package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.repository.IClinicaRepository;
import br.com.dentalclinic.repository.clinicaRepository;
import br.com.dentalclinic.repository.IEnderecoRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaServiceImpl implements IService<ClinicaDTO> {
    /** Attribute **/
    @Autowired
    private IClinicaRepository clinicaRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    /** Methods **/
    @Override
    public ClinicaDTO salvar(ClinicaDTO clinicaDTO) {
        Clinica clinica = mapperDTOToEntity(clinicaDTO);
        int idEndereco = clinica.getEndereco().getId();

        if (enderecoService.ifEnderecoExists(idEndereco)) {
            EnderecoDTO enderecoDTO = enderecoService.buscarById(idEndereco);
            clinicaRepository.save(clinicaDTO);
        }
        return clinicaDTO;
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

    public List<Clinica> buscarTodos() {
        return clinicaRepository.findAll();
    }

    public Optional<Clinica> buscarByNomeFantasia(String nomeFantasia){return clinicaRepository.findByNomeFantasia(nomeFantasia);}

    public Clinica mapperDTOToEntity(ClinicaDTO clinicaDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        Clinica clinica = objectMapper.convertValue(clinicaDTO, Clinica.class);
        return clinica;
    }

    public ClinicaDTO mapperEntityToDTO(Clinica clinica){
        ObjectMapper objectMapper = new ObjectMapper();
        ClinicaDTO clinicaDTO = objectMapper.convertValue(clinica, ClinicaDTO.class);
        return clinicaDTO;
    }

}
