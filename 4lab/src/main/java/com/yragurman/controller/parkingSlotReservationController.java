package com.yragurman.controller;

import com.yragurman.model.dao.parkingSlotReservationDao;
import com.yragurman.model.entity.parkingSlotReservation;

import java.sql.SQLException;
import java.util.List;

public class parkingSlotReservationController implements AbstractGenericController<parkingSlotReservation>{
    private static final parkingSlotReservationDao dao = new parkingSlotReservationDao();

    public parkingSlotReservationController() {

    }

    @Override
    public List<parkingSlotReservation> findAll() {
        return dao.findAll();
    }

    @Override
    public parkingSlotReservation find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(parkingSlotReservation parkingSlotReservation) throws SQLException {
        dao.create(parkingSlotReservation);
    }

    @Override
    public void update(Integer id, parkingSlotReservation parkingSlotReservation) {
        dao.update(id, parkingSlotReservation);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
