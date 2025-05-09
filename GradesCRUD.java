/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author can
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradesCRUD {

    
    public static void insertGrade(Grades grade) {
        String query = "INSERT INTO grades (std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, grade.getStdId());
            pstmt.setInt(2, grade.getCrsId());
            pstmt.setFloat(3, grade.getGrdMt());
            pstmt.setFloat(4, grade.getGrdHw());
            pstmt.setFloat(5, grade.getGrdFinal());
            pstmt.setString(6, grade.getGrdLgrade());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade successfully added.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while adding the grade.");
        }
    }


    public static void listGrades() {
        String query = "SELECT * FROM grades";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\n--- Grades List ---");
            while (rs.next()) {
                System.out.printf("Grade ID: %d\n", rs.getInt("grd_id"));
                System.out.printf("Student ID: %d\n", rs.getInt("std_id"));
                System.out.printf("Course ID: %d\n", rs.getInt("crs_id"));
                System.out.printf("Midterm Grade: %.2f\n", rs.getFloat("grd_mt"));
                System.out.printf("Homework Grade: %.2f\n", rs.getFloat("grd_hw"));
                System.out.printf("Final Grade: %.2f\n", rs.getFloat("grd_final"));
                System.out.printf("Letter Grade: %s\n", rs.getString("grd_lgrade"));
                System.out.println("-------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while listing grades.");
        }
    }

  
    public static void updateGrade(Grades grade) {
        String query = "UPDATE grades SET grd_mt = ?, grd_hw = ?, grd_final = ?, grd_lgrade = ? WHERE grd_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setFloat(1, grade.getGrdMt());
            pstmt.setFloat(2, grade.getGrdHw());
            pstmt.setFloat(3, grade.getGrdFinal());
            pstmt.setString(4, grade.getGrdLgrade());
            pstmt.setInt(5, grade.getGrdId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade successfully updated.");
            } else {
                System.out.println("No grade found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while updating the grade.");
        }
    }

   
    public static void deleteGrade(int grdId) {
        String query = "DELETE FROM grades WHERE grd_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, grdId);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Grade successfully deleted.");
            } else {
                System.out.println("No grade found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while deleting the grade.");
        }
    }
    public static List<Grades> getAllGrades() {
    List<Grades> gradesList = new ArrayList<>();
    String query = "SELECT * FROM grades";

    try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Grades grade = new Grades(
                rs.getInt("grd_id"),
                rs.getInt("std_id"),
                rs.getInt("crs_id"),
                rs.getFloat("grd_mt"),
                rs.getFloat("grd_hw"),
                rs.getFloat("grd_final"),
                rs.getString("grd_lgrade")
            );
            gradesList.add(grade);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while fetching grades.");
    }

    return gradesList;
}

    
}