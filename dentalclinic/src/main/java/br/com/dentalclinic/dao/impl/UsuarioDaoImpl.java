package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDaoImpl implements IDao<Usuario> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public UsuarioDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Usuario salvar(Usuario usuario) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_usuario (email, senha, fk_idTipoUsuario) " +
                        "VALUES ('%s', '%s', '%s')",
                usuario.getEmail(), usuario.getSenha(), usuario.getFk_idTipoUsuario());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                usuario.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Usuario buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_usuario WHERE id = '%S'", id);
        Usuario usuario = new Usuario();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                usuario.setId(resultSet.getInt(1));
                usuario.setEmail(resultSet.getString(2));
                usuario.setSenha(resultSet.getString(3));
                usuario.setFk_idTipoUsuario(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_usuario SET email='%s', senha='%s' " +
                        "fk_idTipoUsuario='%s' WHERE id='%s'",
                usuario.getEmail(), usuario.getSenha(), usuario.getFk_idTipoUsuario(), 
                usuario.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_usuario WHERE id='%s'", id);

        try {
            statement = connection.createStatement();
            statement.execute(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
