package com.yragurman.controller;

import com.yragurman.model.entity.address;
import com.yragurman.model.dao.addressDao;

import java.sql.*;
import java.util.List;

public class addressController implements AbstractGenericController<address>{
    private static final addressDao dao = new addressDao();

    public addressController() {

    }

    @Override
    public List<address> findAll() {
        return dao.findAll();
    }

    @Override
    public address find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(address address) throws SQLException {
        dao.create(address);
    }

    @Override
    public void update(Integer id, address address) {
        dao.update(id, address);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
