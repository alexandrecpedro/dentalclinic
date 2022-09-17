package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.repository.IEnderecoRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IService<EnderecoDTO> {
    /** Attribute **/
    @Autowired
    private IEnderecoRepository enderecoRepository;

    /** Methods **/
    @Override
    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        Endereco endereco = mapperDTOToEntity(enderecoDTO);
        if (!enderecoDTO.equals(null)) {
            endereco = enderecoRepository.save(endereco);
        } else {
            throw new BadRequestException("Endereço já cadastrado!");
        }
        enderecoDTO = mapperEntityToDTO(endereco);
        return enderecoDTO;
    }

    @Override
    public Optional<EnderecoDTO> buscarById(Integer id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Endereço não encontrado");
        });
        EnderecoDTO enderecoDTO = mapperEntityToDTO(endereco);
        return Optional.ofNullable(enderecoDTO);
    }

    @Override
    public List<EnderecoDTO> buscarTodos() {
        List<Endereco> enderecos = enderecoRepository.findAll();
        List<EnderecoDTO> enderecoDTOS = new ArrayList<>();

        for (Endereco endereco: enderecos) {
            EnderecoDTO enderecoDTO = mapperEntityToDTO(endereco);
            enderecoDTOS.add(enderecoDTO);
        }
        return enderecoDTOS;
    }

    @Override
    public EnderecoDTO atualizar(EnderecoDTO enderecoDTO) {
        Endereco endereco = mapperDTOToEntity(enderecoDTO);
        endereco = enderecoRepository.saveAndFlush(endereco);
        enderecoDTO = mapperEntityToDTO(endereco);
        return enderecoDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
        } else {
            throw new BadRequestException("Endereço inexistente!");
        }
    }

    public Boolean ifEnderecoExists(int id) {
        return enderecoRepository.existsById(id);
    }

    public Endereco mapperDTOToEntity(EnderecoDTO enderecoDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Endereco endereco = objectMapper.convertValue(enderecoDTO, Endereco.class);
        return endereco;
    }

    public EnderecoDTO mapperEntityToDTO(Endereco endereco) {
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoDTO enderecoDTO = objectMapper.convertValue(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }

}
