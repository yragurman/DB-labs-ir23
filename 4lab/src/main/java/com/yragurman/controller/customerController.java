package com.yragurman.controller;

import com.yragurman.model.dao.customerDao;
import com.yragurman.model.entity.customer;

import java.sql.*;
import java.util.List;

public class customerController implements AbstractGenericController<customer> {
    private static final customerDao dao = new customerDao();

    public customerController() {

    }

    @Override
    public List<customer> findAll() {
        return dao.findAll();
    }

    @Override
    public customer find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(customer customer) throws SQLException {
        dao.create(customer);
    }

    @Override
    public void update(Integer id, customer customer) {
        dao.update(id, customer);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
