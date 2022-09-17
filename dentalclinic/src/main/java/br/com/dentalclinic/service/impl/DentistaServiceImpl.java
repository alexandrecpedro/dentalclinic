package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.DentistaDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IDentistaRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaServiceImpl implements IService<DentistaDTO> {
    /** Attribute **/
    @Autowired
    private IDentistaRepository dentistaRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private ClinicaServiceImpl clinicaService;

    /** Methods **/
    @Override
    public DentistaDTO salvar(DentistaDTO dentistaDTO) {
        Dentista dentista = mapperDTOToEntity(dentistaDTO);
        int idUsuario = dentista.getUsuario().getId();
        int idClinica = dentista.getClinica().getId();

        if (clinicaService.ifClinicaExists(idClinica) && usuarioService.ifUsuarioExists(idUsuario)) {
            ClinicaDTO clinicaDTO = clinicaService.buscarById(idClinica).orElseThrow(() -> {
                throw new ResourceNotFoundException("Clínica não encontrada");
            });
            Clinica clinica = new Clinica(clinicaDTO);
            UsuarioDTO usuarioDTO = usuarioService.buscarById(idUsuario).orElseThrow(() -> {
                throw new ResourceNotFoundException("Usuário não encontrado");
            });
            Usuario usuario = new Usuario(usuarioDTO);

            dentista.setClinica(clinica);
            dentista.setUsuario(usuario);

            dentista = dentistaRepository.save(dentista);
        }

        dentistaDTO = mapperEntityToDTO(dentista);
        return dentistaDTO;

    }

    @Override
    public Optional<DentistaDTO> buscarById(Integer id) {
        Dentista dentista = dentistaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Dentista não encontrado");
        });
        DentistaDTO dentistaDTO = mapperEntityToDTO(dentista);
        return Optional.ofNullable(dentistaDTO);
    }

    @Override
    public List<DentistaDTO> buscarTodos(){
        List<Dentista> dentistas = dentistaRepository.findAll();
        List<DentistaDTO> dentistaDTOS = new ArrayList<>();

        for (Dentista dentista : dentistas){
            DentistaDTO dentistaDTO = mapperEntityToDTO(dentista);
            dentistaDTOS.add(dentistaDTO);
        }
        return dentistaDTOS;
    }

    @Override
    public DentistaDTO atualizar(DentistaDTO dentistaDTO) {
        Dentista dentista = mapperDTOToEntity(dentistaDTO);
        dentista = dentistaRepository.saveAndFlush(dentista);
        dentistaDTO = mapperEntityToDTO(dentista);
        return dentistaDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (dentistaRepository.existsById(id)) {
            dentistaRepository.deleteById(id);
        } else {
            throw new BadRequestException("Dentista inexistente!");
        }
    }

    public boolean ifDentistaExists(int id){
        return dentistaRepository.existsById(id);
    }

    public Dentista mapperDTOToEntity(DentistaDTO dentistaDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Dentista dentista = objectMapper.convertValue(dentistaDTO, Dentista.class);
        return dentista;
    }

    public DentistaDTO mapperEntityToDTO(Dentista dentista) {
        ObjectMapper objectMapper = new ObjectMapper();
        DentistaDTO dentistaDTO = objectMapper.convertValue(dentista, DentistaDTO.class);
        return dentistaDTO;
    }
}
