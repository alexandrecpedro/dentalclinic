package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.DentistaDTO;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.repository.IDentistaRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (clinicaService.ifClinicaExists(idClinica) && usuarioService.) {
            IDentistaRepository.save(dentista);
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscarById(Integer id) {
        return IDentistaRepository.findById(id);
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return IDentistaRepository.saveAndFlush(dentista);
    }

    @Override
    public void deletar(Integer id) {
        IDentistaRepository.deleteById(id);
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
