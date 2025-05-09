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
import java.util.ArrayList;
import java.util.List;

public class StudentCRUD {

    
    //list students
    public static void listStudents() {
    List<Student> students = getAllStudents(); // getAllStudents metodunu çağır
    for (Student student : students) {
        System.out.println(student); // Konsola yazdır
    }
}

    
    
    
    // Öğrenci ekleme metodu
    public static void insertStudent(Student student) {
        String query = "INSERT INTO student (std_no, std_name, std_surname, std_gender, std_nationality, std_birthday) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getStdNo());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSurname());
            pstmt.setString(4, String.valueOf(student.getGender())); // char -> String dönüşümü
            pstmt.setString(5, student.getNationality());
            pstmt.setDate(6, student.getBirthday()); // java.sql.Date kullanımı

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error while adding the student.");
        }
    }

    // Öğrenci güncelleme metodu
    public static void editStudent(Student student) {
        String query = "UPDATE student SET std_no = ?, std_name = ?, std_surname = ?, std_gender = ?, std_nationality = ?, std_birthday = ? WHERE std_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, student.getStdNo());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getSurname());
            pstmt.setString(4, String.valueOf(student.getGender())); // char -> String dönüşümü
            pstmt.setString(5, student.getNationality());
            pstmt.setDate(6, student.getBirthday()); // java.sql.Date kullanımı
            pstmt.setInt(7, student.getId());

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found, update failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error while updating the student.");
        }
    }

    // Öğrenci listesini getirme metodu
    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        String query = "SELECT * FROM student";

        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Student student = new Student(
                    rs.getString("std_no"),
                    rs.getString("std_name"),
                    rs.getString("std_surname"),
                    rs.getString("std_gender").charAt(0),
                    rs.getString("std_nationality"),
                    rs.getDate("std_birthday") // java.sql.Date doğrudan alınıyor
                );
                student.setId(rs.getInt("std_id")); // ID'yi de set ediyoruz
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error while fetching the student list.");
        }

        return studentList;
    }

    // Öğrenci silme metodu
    public static void deleteStudent(int id) {
        String query = "DELETE FROM student WHERE std_id = ?";
        try (Connection conn = DB.connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully. ID: " + id);
            } else {
                System.out.println("No student found with the specified ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("There was an error while deleting the student.");
        }
    }
}