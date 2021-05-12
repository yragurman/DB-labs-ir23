package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.coupon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class couponDao implements AbstractGenericDao<coupon>{

    public static final String TABLE = "gurman_db.coupon";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (customer_id, entry_date, exit_date, parking_slot_id) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET customer_id = ?, entry_date = ?, exit_date = ?, parking_slot_id = ? WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<coupon> findAll() {
        List<coupon> coupons = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                coupon coupon = new coupon(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("entry_date"),
                        resultSet.getString("exit_date"),
                        resultSet.getInt("parking_slot_id")
                );
                coupons.add(coupon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coupons;
    }
    @Override
    public coupon find(Integer id) {
        coupon coupon = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                coupon = new coupon(
                        resultSet.getInt("id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("entry_date"),
                        resultSet.getString("exit_date"),
                        resultSet.getInt("parking_slot_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return coupon;
    }

    @Override
    public void create(coupon coupon) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, coupon.getCustomerId());
            statement.setString(2, coupon.getEntryDate());
            statement.setString(3, coupon.getExitDate());
            statement.setInt(4, coupon.getParkingSlotId());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, coupon coupon) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, coupon.getCustomerId());
            statement.setString(2, coupon.getEntryDate());
            statement.setString(3, coupon.getExitDate());
            statement.setInt(4, coupon.getParkingSlotId());
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
