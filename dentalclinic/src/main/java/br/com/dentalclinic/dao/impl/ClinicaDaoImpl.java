package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Clinica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClinicaDaoImpl implements IDao<Clinica> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public ClinicaDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Clinica salvar(Clinica clinica) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_clinica (nomeFantasia, razaoSocial, fk_idEndereco) " +
                        "VALUES ('%s', '%s', '%s')",
                clinica.getNomeFantasia(), clinica.getRazaoSocial(), clinica.getFk_idEndereco());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                clinica.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return clinica;
    }

    @Override
    public Clinica buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_clinica WHERE id = '%S'", id);
        Clinica clinica = new Clinica();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                clinica.setId(resultSet.getInt(1));
                clinica.setNomeFantasia(resultSet.getString(2));
                clinica.setRazaoSocial(resultSet.getString(3));
                clinica.setFk_idEndereco(resultSet.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clinica;
    }

    @Override
    public Clinica atualizar(Clinica clinica) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_clinica SET nomeFantasia='%s', razaoSocial='%s' " +
                        "fk_idEndereco='%s' WHERE id='%s'",
                clinica.getNomeFantasia(), clinica.getRazaoSocial(), clinica.getFk_idEndereco(),
                clinica.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clinica;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_clinica WHERE id='%s'", id);

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
