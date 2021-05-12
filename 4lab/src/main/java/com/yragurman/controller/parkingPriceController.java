package com.yragurman.controller;

import com.yragurman.model.dao.parkingPriceDao;
import com.yragurman.model.entity.parkingPrice;

import java.sql.SQLException;
import java.util.List;

public class parkingPriceController implements AbstractGenericController<parkingPrice>{
    private static final parkingPriceDao dao = new parkingPriceDao();

    public parkingPriceController() {

    }

    @Override
    public List<parkingPrice> findAll() {
        return dao.findAll();
    }

    @Override
    public parkingPrice find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(parkingPrice parkingPrice) throws SQLException {
        dao.create(parkingPrice);
    }

    @Override
    public void update(Integer id, parkingPrice parkingPrice) {
        dao.update(id, parkingPrice);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
