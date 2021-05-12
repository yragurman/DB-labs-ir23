package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.parkingSlot;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class parkingSlotDao implements AbstractGenericDao<parkingSlot>{

    public static final String TABLE = "gurman_db.parking_slot";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (slot_number, is_invalid_place, parking_price_id, is_reserved, time_count_in_minutes) VALUES (?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET slot_number = ?, is_invalid_place = ?, parking_price_id = ?, is_reserved = ?, time_count_in_minutes = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<parkingSlot> findAll() {
        List<parkingSlot> parkingSlots = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                parkingSlot parkingSlot = new parkingSlot(
                        resultSet.getInt("id"),
                        resultSet.getInt("slot_number"),
                        resultSet.getString("is_invalid_place"),
                        resultSet.getInt("parking_price_id"),
                        resultSet.getString("is_reserved"),
                        resultSet.getInt("time_count_in_minutes")
                );
                parkingSlots.add(parkingSlot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingSlots;
    }
    @Override
    public parkingSlot find(Integer id) {
        parkingSlot parkingSlot = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSlot = new parkingSlot(
                        resultSet.getInt("id"),
                        resultSet.getInt("slot_number"),
                        resultSet.getString("is_invalid_place"),
                        resultSet.getInt("parking_price_id"),
                        resultSet.getString("is_reserved"),
                        resultSet.getInt("time_count_in_minutes")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingSlot;
    }

    @Override
    public void create(parkingSlot parkingSlot) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, parkingSlot.getSlotNumber());
            statement.setString(2, String.valueOf(parkingSlot.getIsInvalidPlace()));
            statement.setInt(3, parkingSlot.getParkingPriceId());
            statement.setString(4, String.valueOf(parkingSlot.getIsReserved()));
            statement.setInt(5, parkingSlot.getTimeCountInMinutes());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, parkingSlot parkingSlot) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, parkingSlot.getSlotNumber());
            statement.setString(2, String.valueOf(parkingSlot.getIsInvalidPlace()));
            statement.setInt(3, parkingSlot.getParkingPriceId());
            statement.setString(4, String.valueOf(parkingSlot.getIsReserved()));
            statement.setInt(5, parkingSlot.getTimeCountInMinutes());
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
