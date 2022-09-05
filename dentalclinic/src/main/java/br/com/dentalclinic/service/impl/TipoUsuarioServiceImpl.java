package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.repository.TipoUsuarioRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements IService<TipoUsuario> {
    /** Attribute **/
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /** Constructor **/
    //public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
    //    this.tipoUsuarioRepository = tipoUsuarioRepository;
    //}

    /** Methods **/
    @Override
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        if (!tipoUsuario.equals(null)) {
            tipoUsuarioRepository.save(tipoUsuario);
        }
        return tipoUsuario;
    }

    public List<TipoUsuario> buscarTodos(){
        return tipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuario> buscarById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuario buscarByNome(String nome){return tipoUsuarioRepository.findByNome(nome);}

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.saveAndFlush(tipoUsuario);
    }

    public void deletar(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
