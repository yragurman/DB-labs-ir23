package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class customerDao implements AbstractGenericDao<customer> {

    public static final String TABLE = "gurman_db.customer";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (vehicle_number, is_regular_customer, contact_number) VALUES (?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET vehicle_number = ?, is_regular_customer = ?, contact_number = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<customer> findAll() {
        List<customer> customers = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                customer customer = new customer(
                        resultSet.getInt("id"),
                        resultSet.getString("vehicle_number"),
                        resultSet.getString("is_regular_customer"),
                        resultSet.getString("contact_number")
                );
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
    @Override
    public customer find(Integer id) {
        customer customer = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new customer(
                        resultSet.getInt("id"),
                        resultSet.getString("vehicle_number"),
                        resultSet.getString("is_regular_customer"),
                        resultSet.getString("contact_number")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(customer customer) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, customer.getVehicleNumber());
            statement.setString(2, String.valueOf(customer.getIsRegularCustomer()));
            statement.setString(3, customer.getContactNumber());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, customer customer) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, customer.getVehicleNumber());
            statement.setString(2, String.valueOf(customer.getIsRegularCustomer()));
            statement.setString(3, customer.getContactNumber());
            statement.setInt(4, id);
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
