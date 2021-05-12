package com.yragurman.controller;

import com.yragurman.model.dao.regularCustomerDao;
import com.yragurman.model.entity.regularCustomer;

import java.sql.SQLException;
import java.util.List;

public class regularCustomerController implements AbstractGenericController<regularCustomer>{
    private static final regularCustomerDao dao = new regularCustomerDao();

    public regularCustomerController() {

    }

    @Override
    public List<regularCustomer> findAll() {
        return dao.findAll();
    }

    @Override
    public regularCustomer find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(regularCustomer regularCustomer) throws SQLException {
        dao.create(regularCustomer);
    }

    @Override
    public void update(Integer id, regularCustomer regularCustomer) {
        dao.update(id, regularCustomer);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
