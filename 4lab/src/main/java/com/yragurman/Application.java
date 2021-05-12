package com.yragurman;

import com.yragurman.view.View;

import java.sql.*;
import java.text.ParseException;

public class Application {
    public static void main(String[] args) throws SQLException, ParseException {
        new View().show();
    }
}
