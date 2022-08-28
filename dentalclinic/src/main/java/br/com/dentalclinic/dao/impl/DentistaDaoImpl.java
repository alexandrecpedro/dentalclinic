package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Dentista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DentistaDaoImpl implements IDao<Dentista> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public DentistaDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Dentista salvar(Dentista dentista) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_dentista (nome, cro, fk_idUsuario) " +
                        "VALUES ('%s', '%s', '%s')",
                dentista.getNome(), dentista.getCro(), dentista.getFk_idUsuario());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                dentista.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }

    @Override
    public Dentista buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_dentista WHERE id = '%S'", id);
        Dentista dentista = new Dentista();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                dentista.setId(resultSet.getInt("id"));
                dentista.setNome(resultSet.getString("nome"));
                dentista.setCro(resultSet.getString("cro"));
                dentista.setFk_idUsuario(resultSet.getInt("fk_idUsuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_dentista SET nome='%s', cro='%s', " +
                        "fk_idUsuario='%s' WHERE id='%d'",
                dentista.getNome(), dentista.getCro(), dentista.getFk_idUsuario(),
                dentista.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentista;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_dentista WHERE id='%s'", id);

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
