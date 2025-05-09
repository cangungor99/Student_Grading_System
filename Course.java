/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */
public class Course {
    private int crsId;   
    private int deptId;
    private String crsCode;
    private String crsName;

   
    public Course(int crsId, int deptId, String crsCode, String crsName) {
        this.crsId = crsId;
        this.deptId = deptId;
        this.crsCode = crsCode;
        this.crsName = crsName;
    }

   
    public int getCrsId() {
        return crsId;
    }
    public void setCrsId(int crsId) {
        this.crsId = crsId;
    }

    public int getDeptId() {
        return deptId;
    }
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getCrsCode() {
        return crsCode;
    }
    public void setCrsCode(String crsCode) {
        this.crsCode = crsCode;
    }

    public String getCrsName() {
        return crsName;
    }
    public void setCrsName(String crsName) {
        this.crsName = crsName;
    }
}