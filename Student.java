/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */
public class Student {
    private int id; // Öğrenci ID
    private String stdNo; // Öğrenci Numarası
    private String name; // Öğrenci Adı
    private String surname; // Öğrenci Soyadı
    private char gender; // Öğrenci Cinsiyeti ('M' veya 'F')
    private String nationality; // Öğrenci Uyruğu
    private java.sql.Date birthday; // Doğum Tarihi (SQL Date)

    // Constructor
    public Student(String stdNo, String name, String surname, char gender, String nationality, java.sql.Date birthday) {
        this.stdNo = stdNo;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.nationality = nationality;
        this.birthday = birthday;
    }

    // Getter ve Setter metodları
    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getStdNo() { 
        return stdNo; 
    }
    public void setStdNo(String stdNo) {
        this.stdNo = stdNo;
    }

    public String getName() { 
        return name; 
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() { 
        return surname; 
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getGender() { 
        return gender; 
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNationality() { 
        return nationality; 
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public java.sql.Date getBirthday() { 
        return birthday; 
    }
    public void setBirthday(java.sql.Date birthday) {
        this.birthday = birthday;
    }

    // Yardımcı metot (isteğe bağlı)
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stdNo='" + stdNo + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", nationality='" + nationality + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}