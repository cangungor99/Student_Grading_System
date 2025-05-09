/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:8889/grading_system";
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; 

    public static Connection connect() {
        Connection conn = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına bağlantı başarılı!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Veritabanına bağlanırken hata oluştu!");
        }
        return conn;
    }
}
