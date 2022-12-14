package br.com.dentalclinic.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    /** Methods **/
    T salvar(T t);
    Optional<T> buscarById(Integer id);
    List<T> buscarTodos();
    T atualizar(T t);
    void deletar(Integer id);
}
