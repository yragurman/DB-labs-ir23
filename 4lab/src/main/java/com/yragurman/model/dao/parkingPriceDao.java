package com.yragurman.model.dao;

import com.yragurman.DatabaseConnector;
import com.yragurman.model.entity.parkingPrice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class parkingPriceDao implements AbstractGenericDao<parkingPrice>{

    public static final String TABLE = "gurman_db.parking_price";

    private static final String GET_ALL_QUERY = "SELECT * FROM " + TABLE + ";";

    private static final String GET_ONE_QUERY = "SELECT * FROM " + TABLE + " WHERE id = ?;";

    private static final String CREATE_QUERY = "INSERT INTO " + TABLE + " (morning_price, midday_price, evening_price, all_day_price) VALUES (?, ?, ?, ?);";

    private static final String UPDATE_QUERY = "UPDATE " + TABLE + " SET morning_price = ?, midday_price = ?, evening_price = ?, all_day_price = ?, WHERE id = ?;";

    private static final String DELETE_QUERY = "DELETE FROM " + TABLE + " WHERE id = ?;";

    @Override
    public List<parkingPrice> findAll() {
        List<parkingPrice> parkingPrices = new ArrayList<>();

        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ALL_QUERY)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                parkingPrice parkingPrice = new parkingPrice(
                        resultSet.getInt("id"),
                        resultSet.getBigDecimal("morning_price"),
                        resultSet.getBigDecimal("midday_price"),
                        resultSet.getBigDecimal("evening_price"),
                        resultSet.getBigDecimal("all_day_price")
                );
                parkingPrices.add(parkingPrice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingPrices;
    }
    @Override
    public parkingPrice find(Integer id) {
        parkingPrice parkingPrice = null;
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                parkingPrice = new parkingPrice(
                        resultSet.getInt("id"),
                        resultSet.getBigDecimal("morning_price"),
                        resultSet.getBigDecimal("midday_price"),
                        resultSet.getBigDecimal("evening_price"),
                        resultSet.getBigDecimal("all_day_price")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parkingPrice;
    }

    @Override
    public void create(parkingPrice parkingPrice) throws SQLException {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setBigDecimal(1, parkingPrice.getMorningPrice());
            statement.setBigDecimal(2, parkingPrice.getMiddayPrice());
            statement.setBigDecimal(3, parkingPrice.getEveningPrice());
            statement.setBigDecimal(4, parkingPrice.getAllDayPrice());
            statement.executeUpdate();

            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, parkingPrice parkingPrice) {
        try (PreparedStatement statement = DatabaseConnector.getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setBigDecimal(1, parkingPrice.getMorningPrice());
            statement.setBigDecimal(2, parkingPrice.getMiddayPrice());
            statement.setBigDecimal(3, parkingPrice.getEveningPrice());
            statement.setBigDecimal(4, parkingPrice.getAllDayPrice());
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
