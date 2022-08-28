package br.com.dentalclinic.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfiguracaoJDBC {
    /** Attributes **/
    private String jdbcDriver, dbUrl, userName, userPassword;

    /** Constructor **/
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String userName, String userPassword) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.userName = "sa";
        this.userPassword = "";
    }

    /** Method **/
    public Connection connectWithDatabase() {
        Connection connection = null;

        try {
            Class.forName(jdbcDriver).newInstance();
            connection = DriverManager.getConnection(dbUrl, userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
