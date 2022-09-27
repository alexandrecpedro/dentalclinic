package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.repository.IClinicaRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClinicaServiceImpl implements IService<ClinicaDTO> {
    /** Attributes **/
    @Autowired
    private IClinicaRepository clinicaRepository;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    /** Methods **/
    @Override
    public ClinicaDTO salvar(ClinicaDTO clinicaDTO) {
        Clinica clinica = new Clinica(clinicaDTO);
        int idEndereco = clinica.getEndereco().getId();

        if (enderecoService.ifEnderecoExists(idEndereco)) {
            EnderecoDTO enderecoDTO = enderecoService.buscarById(idEndereco).orElseThrow(() -> {
                throw new ResourceNotFoundException("Endereço não encontrado!");
            });
            Endereco endereco = new Endereco(enderecoDTO);
            //clinica.setEndereco(endereco);
            clinica = clinicaRepository.save(clinica);
        }
        clinicaDTO = new ClinicaDTO(clinica);
        return clinicaDTO;
    }

    @Override
    public Optional<ClinicaDTO> buscarById(Integer id) {
        Clinica clinica = clinicaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Clínica não encontrada!");
        });
        ClinicaDTO clinicaDTO = new ClinicaDTO(clinica);
        return Optional.ofNullable(clinicaDTO);
    }

    @Override
    public List<ClinicaDTO> buscarTodos() {
        List<Clinica> clinicas = clinicaRepository.findAll();
        List<ClinicaDTO> clinicaDTOS = new ArrayList<>();

        for (Clinica clinica : clinicas) {
            ClinicaDTO clinicaDTO = new ClinicaDTO(clinica);
            clinicaDTOS.add(clinicaDTO);
        }
        return clinicaDTOS;
    }

    @Override
    public ClinicaDTO atualizar(ClinicaDTO clinicaDTO) {
        Clinica clinica = new Clinica(clinicaDTO);
        clinica = clinicaRepository.saveAndFlush(clinica);
        clinicaDTO = new ClinicaDTO(clinica);
        return clinicaDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (clinicaRepository.existsById(id)) {
            clinicaRepository.deleteById(id);
        } else {
            throw new BadRequestException("Clínica inexistente!");
        }
    }

    public Optional<ClinicaDTO> buscarByNomeFantasia(String nomeFantasia) {
        Clinica clinica = clinicaRepository.findByNomeFantasia(nomeFantasia).orElseThrow(()-> new BadRequestException("Clínica inexistente!"));
        ClinicaDTO clinicaDTO = new ClinicaDTO(clinica);
        return Optional.ofNullable(clinicaDTO);
    }

    public boolean ifClinicaExists(int id){
        return clinicaRepository.existsById(id);
    }

    public Clinica mapperDTOToEntity(ClinicaDTO clinicaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Clinica clinica = objectMapper.convertValue(clinicaDTO, Clinica.class);
        return clinica;
    }

    public ClinicaDTO mapperEntityToDTO(Clinica clinica) {
        ObjectMapper objectMapper = new ObjectMapper();
        ClinicaDTO clinicaDTO = objectMapper.convertValue(clinica, ClinicaDTO.class);
        return clinicaDTO;
    }


}
