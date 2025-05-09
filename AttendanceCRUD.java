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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceCRUD {

  
  public static void insertAttendance(Attendance attendance) {
    String query = "INSERT INTO attendance (std_id, crs_id, att_date) VALUES (?, ?, ?)";
    try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, attendance.getStdId());
        pstmt.setInt(2, attendance.getCrsId());
        pstmt.setString(3, attendance.getAttDate());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Attendance successfully added.");
        } else {
            System.out.println("Failed to add attendance.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while adding attendance.");
    }
}

   
    public static void listAttendance() {
        String query = "SELECT * FROM attendance";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--- Attendance List ---");
            while (rs.next()) {
                System.out.printf("Attendance ID: %d\n", rs.getInt("att_id"));
                System.out.printf("Student ID: %d\n", rs.getInt("std_id"));
                System.out.printf("Course ID: %d\n", rs.getInt("crs_id"));
                System.out.printf("Attendance Date: %s\n", rs.getString("att_date"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while listing attendance.");
        }
    }

 
    public static void updateAttendance(Attendance attendance) {
        String query = "UPDATE attendance SET std_id = ?, crs_id = ?, att_date = ? WHERE att_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, attendance.getStdId());
            pstmt.setInt(2, attendance.getCrsId());
            pstmt.setString(3, attendance.getAttDate());
            pstmt.setInt(4, attendance.getAttId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Attendance successfully updated.");
            } else {
                System.out.println("No attendance found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while updating attendance.");
        }
    }

  
    public static void deleteAttendance(int attId) {
        String query = "DELETE FROM attendance WHERE att_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, attId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Attendance successfully deleted.");
            } else {
                System.out.println("No attendance found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while deleting attendance.");
        }
    }
}