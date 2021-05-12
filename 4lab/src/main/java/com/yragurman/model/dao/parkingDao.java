package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.parking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class parkingDao implements AbstractGenericDao<parking>{

    public static final String TABLE = "gurman_db.parking";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (trade_network, address_id, customer_id, parking_slot_id) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET trade_network = ?, address_id = ?, customer_id = ?, parking_slot_id = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<parking> findAll() {
        List<parking> parkings = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                parking parking = new parking(
                        resultSet.getInt("id"),
                        resultSet.getString("trade_network"),
                        resultSet.getInt("address_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("parking_slot_id")
                );
                parkings.add(parking);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkings;
    }
    @Override
    public parking find(Integer id) {
        parking parking = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parking = new parking(
                        resultSet.getInt("id"),
                        resultSet.getString("trade_network"),
                        resultSet.getInt("address_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("parking_slot_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parking;
    }

    @Override
    public void create(parking parking) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, parking.getTradeNetwork());
            statement.setInt(2, parking.getAddressId());
            statement.setInt(3, parking.getCustomerId());
            statement.setInt(4, parking.getParkingSlotId());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, parking parking) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, parking.getTradeNetwork());
            statement.setInt(2, parking.getAddressId());
            statement.setInt(3, parking.getCustomerId());
            statement.setInt(4, parking.getParkingSlotId());
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
