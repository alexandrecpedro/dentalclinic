package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoUsuarioService {
    /** Attribute **/
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /** Constructor **/
    public TipoUsuarioService(TipoUsuarioRepository tipoUsuarioRepository) {
        this.tipoUsuarioRepository = tipoUsuarioRepository;
    }

    /** Methods **/
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public Optional<TipoUsuario> buscarById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    public void deletar(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
