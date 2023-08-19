package me.xflyiwnl.restapi.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import me.xflyiwnl.restapi.database.dao.CitizenDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Connector {

    private HikariConfig config = new HikariConfig();
    private HikariDataSource dataSource;

    private Connection connection;

    private CitizenDAO citizenDAO;

    public Connector() {
    }

    public void connect(String host, String user, String password, int port) {
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl( "jdbc:mysql://" + host + ":" + port);
        config.setUsername(user);
        config.setPassword(password);

        dataSource = new HikariDataSource( config );

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        connectDAO();
    }

    public void connectDAO() {
        citizenDAO = new CitizenDAO(connection);
    }

    public CitizenDAO getCitizenDAO() {
        return citizenDAO;
    }
}
