/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */


import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DepartmentCRUD {

 
    public static void addDepartment(Department department) {
        String query = "INSERT INTO department (dept_name) VALUES (?)";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, department.getDeptName());
            pstmt.executeUpdate();
            System.out.println("Department added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editDepartment(Department department) {
        String query = "UPDATE department SET dept_name = ? WHERE dept_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, department.getDeptName());
            pstmt.setInt(2, department.getDeptId());
            pstmt.executeUpdate();
            System.out.println("Department updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteDepartment(int deptId) {
        String query = "DELETE FROM department WHERE dept_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, deptId);
            pstmt.executeUpdate();
            System.out.println("Department deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void listAllDepartments() {
        String query = "SELECT * FROM department";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.printf("Department ID: %d, Name: %s%n", rs.getInt("dept_id"), rs.getString("dept_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void listDepartment(int deptId) {
        String query = "SELECT * FROM department WHERE dept_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, deptId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.printf("Department ID: %d, Name: %s%n", rs.getInt("dept_id"), rs.getString("dept_name"));
            } else {
                System.out.println("Department not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void deleteAllDepartments() {
        String query = "DELETE FROM department";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
            System.out.println("All departments deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void backupDepartments() {
        String query = "SELECT * FROM department";
        String fileName = "departments_backup.txt";
        try (Connection conn = DB.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();
             PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            while (rs.next()) {
                writer.printf("%d,%s%n", rs.getInt("dept_id"), rs.getString("dept_name"));
            }
            System.out.println("Departments backup completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    public static void restoreDepartments() {
        String query = "INSERT INTO department (dept_id, dept_name) VALUES (?, ?)";
        String fileName = "departments_backup.txt";
        try (Connection conn = DB.connect();
             BufferedReader reader = new BufferedReader(new FileReader(fileName));
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                pstmt.setInt(1, Integer.parseInt(data[0])); 
                pstmt.setString(2, data[1]);               
                pstmt.executeUpdate();
            }
            System.out.println("Departments restored successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
