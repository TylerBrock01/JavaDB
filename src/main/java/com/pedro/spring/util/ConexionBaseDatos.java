package com.pedro.spring.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url="jdbc:mysql://localhost:3306/zoologico";
    private static String username="root";
    private static String password="kali";

    private static Connection con;

    public static Connection getinstance() throws SQLException {
        if(con==null){
            con = DriverManager.getConnection(url,username,password);
        }
        return con;
    }
}
