package me.xflyiwnl.restapi.database.dao;

import me.xflyiwnl.restapi.entity.Citizen;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CitizenDAO implements RestDAO<Citizen> {

    private Connection connection;

    public CitizenDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Citizen get(Object key) {

        Citizen citizen = null;

        try {

            Statement statement = connection.createStatement();
            statement.execute("USE cities;");
            statement.execute("SELECT * from `citizens` WHERE uuid = '" + key.toString() + "';");

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                citizen = new Citizen();
                citizen.setUniqueId(UUID.fromString(resultSet.getString("uuid")));
                citizen.setName(resultSet.getString("name"));
                citizen.setCity(UUID.fromString(resultSet.getString("city")));
                citizen.setRegistered(resultSet.getString("registered"));
                citizen.setJoinedCity(resultSet.getString("joinedCity"));
            }

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return citizen;
    }

    @Override
    public Citizen get(Citizen entity) {
        return get(entity.getUniqueId().toString());
    }

    @Override
    public void save(Citizen entity) {

    }

    @Override
    public void delete(Citizen entity) {

    }

    @Override
    public List<Citizen> all() {
        List<Citizen> citizens = new ArrayList<Citizen>();

        try {
            Statement statement = connection.createStatement();
            statement.execute("USE `cities`;");
            statement.execute("SELECT * from `citizens`;");

            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                citizens.add(get(resultSet.getString("uuid")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return citizens;
    }

}
