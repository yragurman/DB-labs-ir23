package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.regularCustomer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class regularCustomerDao implements AbstractGenericDao<regularCustomer>{

    public static final String TABLE = "gurman_db.regular_customer";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (customer_id, purchase_date, start_date, duration_in_day, cost) VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET customer_id = ?, purchase_date = ?, start_date = ?, duration_in_day = ?, cost = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<regularCustomer> findAll() {
        List<regularCustomer> regularCustomers = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                regularCustomer regularCustomer = new regularCustomer(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("purchase_date"),
                        resultSet.getString("start_date"),
                        resultSet.getInt("duration_in_day"),
                        resultSet.getInt("cost")
                );
                regularCustomers.add(regularCustomer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regularCustomers;
    }
    @Override
    public regularCustomer find(Integer id) {
        regularCustomer regularCustomer = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                regularCustomer = new regularCustomer(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("purchase_date"),
                        resultSet.getString("start_date"),
                        resultSet.getInt("duration_in_day"),
                        resultSet.getInt("cost")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regularCustomer;
    }

    @Override
    public void create(regularCustomer regularCustomer) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, regularCustomer.getCustomerId());
            statement.setString(2, regularCustomer.getPurchaseDate());
            statement.setString(3, regularCustomer.getStartDate());
            statement.setInt(4, regularCustomer.getDurationInDay());
            statement.setInt(5, regularCustomer.getCost());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, regularCustomer regularCustomer) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, regularCustomer.getCustomerId());
            statement.setString(2, regularCustomer.getPurchaseDate());
            statement.setString(3, regularCustomer.getStartDate());
            statement.setInt(4, regularCustomer.getDurationInDay());
            statement.setInt(5, regularCustomer.getCost());
            statement.setInt(6, id);
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
