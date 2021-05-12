package com.yragurman.controller;

import com.yragurman.model.entity.coupon;
import com.yragurman.model.dao.couponDao;

import java.sql.*;
import java.util.List;

public class couponController implements AbstractGenericController<coupon>{
    private static final couponDao dao = new couponDao();

    public couponController() {

    }

    @Override
    public List<coupon> findAll() {
        return dao.findAll();
    }

    @Override
    public coupon find(Integer id) {
        return dao.find(id);
    }

    @Override
    public void create(coupon coupon) throws SQLException {
        dao.create(coupon);
    }

    @Override
    public void update(Integer id, coupon coupon) {
        dao.update(id, coupon);
    }

    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }
}
