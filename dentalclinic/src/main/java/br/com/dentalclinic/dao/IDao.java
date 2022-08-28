package br.com.dentalclinic.dao;

public interface IDao<T> {
    T salvar(T t);
    T buscarById(int id);
    T atualizar(T t);
    void deletar(int id);
}
