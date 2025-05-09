/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */


import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Backup {


    public static void backupStudents() {
    String query = "SELECT * FROM student"; 
    String fileName = "students_backup.txt";

    try (Connection conn = DB.connect();
         PreparedStatement pstmt = conn.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery();
         PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

        System.out.println("Backup process started for students...");

        while (rs.next()) {
            writer.printf("%d,%s,%s,%s,%s,%s,%s\n",
                    rs.getInt("std_id"),             
                    rs.getString("std_no"),
                    rs.getString("std_name"),
                    rs.getString("std_surname"),
                    rs.getString("std_gender"),
                    rs.getString("std_nationality"),
                    rs.getString("std_birthday"));
        }

        System.out.println("Students backup completed successfully. File saved as: " + fileName);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("An error occurred while backing up students.");
    }
}



    public static void backupCourses() {
        String query = "SELECT * FROM course";
        String fileName = "course_backup.txt";

        try (Connection conn = DB.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();
             PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            System.out.println("Backup process started for courses...");

            while (rs.next()) {
                writer.printf("%d,%d,%s,%s\n",
                        rs.getInt("crs_id"),
                        rs.getInt("dept_id"),
                        rs.getString("crs_code"),
                        rs.getString("crs_name"));
            }

            System.out.println("Courses backup completed successfully. File saved as: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while backing up courses.");
        }
    }

  
    public static void backupAttendance() {
        String query = "SELECT * FROM attendance";
        String fileName = "attendance_backup.txt";

        try (Connection conn = DB.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();
             PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            System.out.println("Backup process started for attendance...");

            while (rs.next()) {
                writer.printf("%d,%d,%d,%s\n",
                        rs.getInt("att_id"),
                        rs.getInt("std_id"),
                        rs.getInt("crs_id"),
                        rs.getString("att_date"));
            }

            System.out.println("Attendance backup completed successfully. File saved as: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while backing up attendance.");
        }
    }

    public static void backupGrades() {
        String query = "SELECT * FROM grades";
        String fileName = "grades_backup.txt";

        try (Connection conn = DB.connect();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();
             PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            System.out.println("Backup process started for grades...");

            while (rs.next()) {
                writer.printf("%d,%d,%d,%.2f,%.2f,%.2f,%s\n",
                        rs.getInt("grd_id"),
                        rs.getInt("std_id"),
                        rs.getInt("crs_id"),
                        rs.getFloat("grd_mt"),
                        rs.getFloat("grd_hw"),
                        rs.getFloat("grd_final"),
                        rs.getString("grd_lgrade"));
            }

            System.out.println("Grades backup completed successfully. File saved as: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while backing up grades.");
        }
    }


    public static void main(String[] args) {
        backupStudents();
        backupCourses();
        backupAttendance();
        backupGrades();
    }
}
