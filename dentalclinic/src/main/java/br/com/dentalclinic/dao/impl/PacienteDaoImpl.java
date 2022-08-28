package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Paciente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PacienteDaoImpl implements IDao<Paciente> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public PacienteDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Paciente salvar(Paciente paciente) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_paciente (nome, sobrenome, cpf, telefone, " +
                        "fk_idUsuario, fk_idEndereco) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                paciente.getNome(), paciente.getSobrenome(), paciente.getCpf(),
                paciente.getTelefone(), paciente.getFk_idUsuario(),
                paciente.getFk_idEndereco());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                paciente.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Paciente buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_paciente WHERE id = '%S'", id);
        Paciente paciente = new Paciente();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                paciente.setId(resultSet.getInt("id"));
                paciente.setNome(resultSet.getString("nome"));
                paciente.setSobrenome(resultSet.getString("sobrenome"));
                paciente.setCpf(resultSet.getString("cpf"));
                paciente.setTelefone(resultSet.getString("telefone"));
                paciente.setFk_idUsuario(resultSet.getInt("fk_idUsuario"));
                paciente.setFk_idEndereco(resultSet.getInt("fk_idEndereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_paciente SET nome='%s', sobrenome='%s' " +
                        "cpf='%s', telefone='%s', fk_idUsuario='%s', fk_idEndereco='%s' " +
                        "WHERE id='%s'",
                paciente.getNome(), paciente.getSobrenome(), paciente.getCpf(),
                paciente.getTelefone(), paciente.getFk_idUsuario(), paciente.getFk_idEndereco(),
                paciente.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_paciente WHERE id='%s'", id);

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
