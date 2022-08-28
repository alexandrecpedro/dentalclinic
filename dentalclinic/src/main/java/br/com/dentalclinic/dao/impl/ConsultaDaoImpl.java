package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Consulta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaDaoImpl implements IDao<Consulta> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public ConsultaDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Consulta salvar(Consulta consulta) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_consulta (dataConsulta, descricao, status, " +
                        "fk_idPaciente, fk_idDentista) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s')",
                consulta.getDataConsulta(), consulta.getDescricao(), consulta.getStatus(),
                consulta.getFk_idPaciente(), consulta.getFk_idDentista());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                consulta.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta;
    }

    @Override
    public Consulta buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_consulta WHERE id = '%S'", id);
        Consulta consulta = new Consulta();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                consulta.setId(resultSet.getInt(1));
                consulta.setDataConsulta(resultSet.getDate(2));
                consulta.setDescricao(resultSet.getString(3));
                consulta.setStatus(resultSet.getString(4));
                consulta.setFk_idPaciente(resultSet.getInt(5));
                consulta.setFk_idDentista(resultSet.getInt(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta;
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_consulta SET dataConsulta='%s', descricao='%s' " +
                        "status='%s', fk_idPaciente='%s', fk_idDentista='%s' WHERE id='%s'",
                consulta.getDataConsulta(), consulta.getDescricao(), consulta.getStatus(),
                consulta.getFk_idPaciente(), consulta.getFk_idDentista(), consulta.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return consulta;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_consulta WHERE id='%s'", id);

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
