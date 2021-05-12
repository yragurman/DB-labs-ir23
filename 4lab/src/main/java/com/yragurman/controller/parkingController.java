package com.yragurman.controller;

import com.yragurman.model.dao.parkingDao;
import com.yragurman.model.entity.parking;

import java.sql.SQLException;
import java.util.List;

public class parkingController implements AbstractGenericController<parking>{
    private static final parkingDao dao = new parkingDao();

    public parkingController() {

    }

    @Override
    public List<parking> findAll() {
        return dao.findAll();
    }

    @Override
    public parking find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(parking parking) throws SQLException {
        dao.create(parking);
    }

    @Override
    public void update(Integer id, parking parking) {
        dao.update(id, parking);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
