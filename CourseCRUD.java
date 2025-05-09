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
import java.sql.SQLException;
import java.sql.ResultSet;


public class CourseCRUD {

    public static void insertCourse(Course course) {
        String query = "INSERT INTO course (dept_id, crs_code, crs_name) VALUES (?, ?, ?)";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, course.getDeptId());
            pstmt.setString(2, course.getCrsCode());
            pstmt.setString(3, course.getCrsName());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Course successfully added.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while adding the course.");
        }
    }
    public static void listCourses() {
    String query = "SELECT * FROM course";
    try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        ResultSet rs = pstmt.executeQuery();

        System.out.println("\n--- Course List ---");
        while (rs.next()) {
            System.out.printf("Course ID: %d\n", rs.getInt("crs_id"));
            System.out.printf("Department ID: %d\n", rs.getInt("dept_id"));
            System.out.printf("Course Code: %s\n", rs.getString("crs_code"));
            System.out.printf("Course Name: %s\n", rs.getString("crs_name"));
            System.out.println("-------------------------------");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while listing courses.");
    }
}
    public static void updateCourse(Course course) {
    String query = "UPDATE course SET dept_id = ?, crs_code = ?, crs_name = ? WHERE crs_id = ?";
    try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, course.getDeptId());
        pstmt.setString(2, course.getCrsCode());
        pstmt.setString(3, course.getCrsName());
        pstmt.setInt(4, course.getCrsId());

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Course successfully updated.");
        } else {
            System.out.println("No course found with the specified ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while updating the course.");
    }
}

    public static void deleteCourse(int crsId) {
    String query = "DELETE FROM course WHERE crs_id = ?";
    try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, crsId);

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Course successfully deleted.");
        } else {
            System.out.println("No course found with the specified ID.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("An error occurred while deleting the course.");
    }
}

    

}