/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */


public class Department {
    private int deptId;          
    private String deptName;   

   
    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    
    public Department(String deptName) {
        this.deptName = deptName;
    }

   
    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
