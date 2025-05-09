/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */
public class Attendance {
    private int attId;     
    private int stdId;     
    private int crsId;    
    private String attDate; 

    
    public Attendance(int attId, int stdId, int crsId, String attDate) {
        this.attId = attId;
        this.stdId = stdId;
        this.crsId = crsId;
        this.attDate = attDate;
    }

  
    public Attendance(int stdId, int crsId, String attDate) {
        this.stdId = stdId;
        this.crsId = crsId;
        this.attDate = attDate;
    }

  
    public int getAttId() {
        return attId;
    }
    public void setAttId(int attId) {
        this.attId = attId;
    }

    public int getStdId() {
        return stdId;
    }
    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getCrsId() {
        return crsId;
    }
    public void setCrsId(int crsId) {
        this.crsId = crsId;
    }

    public String getAttDate() {
        return attDate;
    }
    public void setAttDate(String attDate) {
        this.attDate = attDate;
    }
}