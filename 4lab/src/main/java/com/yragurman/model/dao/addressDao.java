package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.address;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class addressDao implements AbstractGenericDao<address>{

    public static final String TABLE = "gurman_db.address";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (country, city, adress_name, post_index) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET country = ?, city = ?, adress_name = ?, post_index = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<address> findAll() {
        List<address> addresses = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                address address = new address(
                    resultSet.getInt("id"),
                    resultSet.getString("country"),
                    resultSet.getString("city"),
                    resultSet.getString("adress_name"),
                    resultSet.getInt("post_index")
                );
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }
    @Override
    public address find(Integer id) {
        address address = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                address = new address(
                        resultSet.getInt("id"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("adress_name"),
                        resultSet.getInt("post_index")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void create(address address) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getAddressName());
            statement.setInt(4, address.getPostIndex());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, address address) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getAddressName());
            statement.setInt(4, address.getPostIndex());
            statement.setInt(5, id);
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
