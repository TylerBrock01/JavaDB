package com.pedro.spring;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/zoologico";
        String username="root";
        String password="kali";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(url,username,password);
            stmt =conn.createStatement();
            rs = stmt.executeQuery("select * from santuario");
            System.out.println("\n\n\n");
            System.out.println("######################");
            System.out.println(" #     Santuario    #");
            System.out.println("######################\n");
            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) +
                                " tipo: "+rs.getString("nombre")+
                                " edad: "+rs.getInt("edad")+
                                " genero: "+rs.getString("genero")+
                                " tamanio: "+rs.getString("tamanio")+
                                " habitat: "+rs.getString("habitat"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}