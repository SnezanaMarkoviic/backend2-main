package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    public static Connection open(){


        String url = "jdbc:mysql://maglev.proxy.rlwy.net:12688/railway";
        String user = "root";
        String password = "DSwdxGCQbTLPPNYyEmCbGJWrFNcnomrY";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
