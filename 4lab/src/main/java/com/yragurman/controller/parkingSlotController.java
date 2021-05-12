package com.yragurman.controller;

import com.yragurman.model.dao.parkingSlotDao;
import com.yragurman.model.entity.parkingSlot;

import java.sql.SQLException;
import java.util.List;

public class parkingSlotController implements AbstractGenericController<parkingSlot>{
    private static final parkingSlotDao dao = new parkingSlotDao();

    public parkingSlotController() {

    }

    @Override
    public List<parkingSlot> findAll() {
        return dao.findAll();
    }

    @Override
    public parkingSlot find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(parkingSlot parkingSlot) throws SQLException {
        dao.create(parkingSlot);
    }

    @Override
    public void update(Integer id, parkingSlot parkingSlot) {
        dao.update(id, parkingSlot);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
