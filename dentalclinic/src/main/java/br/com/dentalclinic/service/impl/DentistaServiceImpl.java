package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.DentistaDTO;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.repository.DentistaRepository;
import br.com.dentalclinic.repository.UsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaServiceImpl implements IService<Dentista> {
    /** Attributes **/
    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /** Methods **/
    @Override
    public Dentista salvar(Dentista dentista) {
        if (!dentista.equals(null)) {
            dentistaRepository.save(dentista);
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscarById(Integer id) {
        return dentistaRepository.findById(id);
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return dentistaRepository.saveAndFlush(dentista);
    }

    @Override
    public void deletar(Integer id) {
        dentistaRepository.deleteById(id);
    }

//    public Dentista mapperDTOToEntity(DentistaDTO dentistaDTO) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Dentista dentista = objectMapper.convertValue(dentistaDTO, Dentista.class);
//        return dentista;
//    }
//
//    public DentistaDTO mapperEntityToDTO(Dentista dentista) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        DentistaDTO dentistaDTO = objectMapper.convertValue(dentista, DentistaDTO.class);
//        return dentistaDTO;
//    }
}
