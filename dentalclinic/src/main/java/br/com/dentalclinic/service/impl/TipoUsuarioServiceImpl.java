package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.repository.ITipoUsuarioRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements IService<TipoUsuario> {
    /** Attribute **/
    @Autowired
    private ITipoUsuarioRepository ITipoUsuarioRepository;

    /** Constructor **/
    //public TipoUsuarioServiceImpl(TipoUsuarioRepository tipoUsuarioRepository) {
    //    this.tipoUsuarioRepository = tipoUsuarioRepository;
    //}

    /** Methods **/
    @Override
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        if (!tipoUsuario.equals(null)) {
            ITipoUsuarioRepository.save(tipoUsuario);
        }
        return tipoUsuario;
    }

    public List<TipoUsuario> buscarTodos(){
        return ITipoUsuarioRepository.findAll();
    }

    public Optional<TipoUsuario> buscarById(Integer id) {
        return ITipoUsuarioRepository.findById(id);
    }

    public TipoUsuario buscarByNome(String nome){return ITipoUsuarioRepository.findByNome(nome);}

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        return ITipoUsuarioRepository.saveAndFlush(tipoUsuario);
    }

    public void deletar(Integer id) {
        ITipoUsuarioRepository.deleteById(id);
    }
}
