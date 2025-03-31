package com.pedro.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static final String url="jdbc:mysql://localhost:3306/zoologico";
    private static final String username="root";
    private static final String password="kali";

    public static Connection getinstance() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
