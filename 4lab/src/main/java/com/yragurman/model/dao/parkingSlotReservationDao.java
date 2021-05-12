package com.yragurman.model.dao;

import com.yragurman.model.entity.parkingSlotReservation;
import com.yragurman.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class parkingSlotReservationDao implements AbstractGenericDao<parkingSlotReservation>{

    public static final String TABLE = "gurman_db.parking_slot_reservation";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (booking_date, customer_id, parking_slot_id, is_paid, entry_date, exit_date) VALUES (?, ?, ?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET booking_date = ?, customer_id = ?, parking_slot_id = ?, is_paid = ?, entry_date = ?, exit_date = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<parkingSlotReservation> findAll() {
        List<parkingSlotReservation> parkingSlotReservations = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                parkingSlotReservation parkingSlotReservation = new parkingSlotReservation(
                        resultSet.getInt("id"),
                        resultSet.getString("booking_date"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("parking_slot_id"),
                        resultSet.getString("is_paid"),
                        resultSet.getString("entry_date"),
                        resultSet.getString("exit_date")
                );
                parkingSlotReservations.add(parkingSlotReservation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingSlotReservations;
    }
    @Override
    public parkingSlotReservation find(Integer id) {
        parkingSlotReservation parkingSlotReservation = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingSlotReservation = new parkingSlotReservation(
                        resultSet.getInt("id"),
                        resultSet.getString("booking_date"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("parking_slot_id"),
                        resultSet.getString("is_paid"),
                        resultSet.getString("entry_date"),
                        resultSet.getString("exit_date")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingSlotReservation;
    }

    @Override
    public void create(parkingSlotReservation parkingSlotReservation) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, parkingSlotReservation.getBookingDate());
            statement.setInt(2, parkingSlotReservation.getCustomerId());
            statement.setInt(3, parkingSlotReservation.getParkingSlotId());
            statement.setString(4, String.valueOf(parkingSlotReservation.getIsPaid()));
            statement.setString(5, parkingSlotReservation.getEntryDate());
            statement.setString(6,parkingSlotReservation.getExitDate());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, parkingSlotReservation parkingSlotReservation) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, parkingSlotReservation.getBookingDate());
            statement.setInt(2, parkingSlotReservation.getCustomerId());
            statement.setInt(3, parkingSlotReservation.getParkingSlotId());
            statement.setString(4, String.valueOf(parkingSlotReservation.getIsPaid()));
            statement.setString(5, parkingSlotReservation.getEntryDate());
            statement.setString(6,parkingSlotReservation.getExitDate());
            statement.setInt(7, id);
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
