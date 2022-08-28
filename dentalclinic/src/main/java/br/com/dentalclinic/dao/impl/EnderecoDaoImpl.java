package br.com.dentalclinic.dao.impl;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Endereco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDaoImpl implements IDao<Endereco> {
    /** Attributes **/
    private ConfiguracaoJDBC configuracaoJDBC;

    /** Constructor **/
    public EnderecoDaoImpl(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    /** Methods **/
    @Override
    public Endereco salvar(Endereco endereco) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("INSERT INTO tb_endereco (logradouro, numero, complemento, " +
                        "bairro, localidade, uf, cep) " +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(),
                endereco.getBairro(), endereco.getLocalidade(), endereco.getUf(),
                endereco.getCep());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next())
                endereco.setId(resultSet.getInt(1));

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    @Override
    public Endereco buscarById(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("SELECT * FROM tb_endereco WHERE id = '%S'", id);
        Endereco endereco = new Endereco();

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                endereco.setId(resultSet.getInt(1));
                endereco.setLogradouro(resultSet.getString(2));
                endereco.setNumero(resultSet.getString(3));
                endereco.setComplemento(resultSet.getString(4));
                endereco.setBairro(resultSet.getString(5));
                endereco.setLocalidade(resultSet.getString(6));
                endereco.setUf(resultSet.getString(7));
                endereco.setCep(resultSet.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("UPDATE tb_endereco SET logradouro='%s', numero='%s' " +
                        "complemento='%s', bairro='%s', localidade='%s', uf='%s', cep='%s' " +
                        "WHERE id='%s'",
                endereco.getLogradouro(), endereco.getNumero(), endereco.getComplemento(),
                endereco.getBairro(), endereco.getLocalidade(), endereco.getUf(),
                endereco.getCep(), endereco.getId());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }

    @Override
    public void deletar(int id) {
        Connection connection = configuracaoJDBC.connectWithDatabase();
        Statement statement = null;
        String query = String.format("DELETE FROM tb_endereco WHERE id='%s'", id);

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
