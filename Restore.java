/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Restore {

  
 public static void restoreStudents() {
   
    String query = "INSERT INTO student (std_no, std_name, std_surname, std_gender, std_nationality, std_birthday) VALUES (?, ?, ?, ?, ?, ?)";
    String fileName = "students_backup.txt";

    try (Connection conn = DB.connect();
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        System.out.println("Restore process started for students...");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length != 7) {
                System.out.println("Invalid line format: " + line);
                continue; // Hatalı satırı atla
            }

          
            pstmt.setString(1, data[1].trim()); 
            pstmt.setString(2, data[2].trim()); 
            pstmt.setString(3, data[3].trim()); 
            pstmt.setString(4, data[4].trim().toUpperCase()); 
            pstmt.setString(5, data[5].trim()); 
            pstmt.setString(6, data[6].trim());

      
            pstmt.executeUpdate();
        }

        System.out.println("Students restored successfully!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error while restoring students.");
    }
}

   public static void restoreCourses() {
   
    String query = "INSERT INTO course (dept_id, crs_code, crs_name) VALUES (?, ?, ?)";
    String fileName = "course_backup.txt";

    try (Connection conn = DB.connect();
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        System.out.println("Restore process started for courses...");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length != 4) {
                System.out.println("Invalid line format: " + line);
                continue; 
            }

            pstmt.setInt(1, Integer.parseInt(data[1].trim())); // dept_id
            pstmt.setString(2, data[2].trim()); // crs_code
            pstmt.setString(3, data[3].trim()); // crs_name

            pstmt.executeUpdate();
        }

        System.out.println("Courses restored successfully!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error while restoring courses.");
    }
}

    public static void restoreAttendance() {
    String query = "INSERT INTO attendance (att_id, std_id, crs_id, att_date) VALUES (?, ?, ?, ?)";
    String fileName = "attendance_backup.txt";

    try (Connection conn = DB.connect();
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        System.out.println("Restore process started for attendance...");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            pstmt.setInt(1, Integer.parseInt(data[0]));
            pstmt.setInt(2, Integer.parseInt(data[1])); 
            pstmt.setInt(3, Integer.parseInt(data[2]));
            pstmt.setString(4, data[3]);               

            pstmt.executeUpdate();
        }

        System.out.println("Attendance restored successfully!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error while restoring attendance.");
    }
}



   public static void restoreGrades() {
    String query = "INSERT INTO grades (std_id, crs_id, grd_mt, grd_hw, grd_final, grd_lgrade) VALUES (?, ?, ?, ?, ?, ?)";
    String fileName = "grades_backup.txt";

    try (Connection conn = DB.connect();
         BufferedReader reader = new BufferedReader(new FileReader(fileName));
         PreparedStatement pstmt = conn.prepareStatement(query)) {

        System.out.println("Restore process started for grades...");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\."); 

            if (data.length != 6) { 
                System.out.println("Invalid line format: " + line);
                continue;
            }

            pstmt.setInt(1, Integer.parseInt(data[0].trim())); 
            pstmt.setInt(2, Integer.parseInt(data[1].trim()));  
            pstmt.setFloat(3, Float.parseFloat(data[2].trim()));
            pstmt.setFloat(4, Float.parseFloat(data[3].trim())); 
            pstmt.setFloat(5, Float.parseFloat(data[4].trim())); 
            pstmt.setString(6, data[5].trim().toUpperCase());   

            pstmt.executeUpdate();
        }

        System.out.println("Grades restored successfully!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error while restoring grades.");
    }
}

    public static void main(String[] args) {
        restoreStudents();
        restoreCourses();
        restoreAttendance();
        restoreGrades();
    }
}
