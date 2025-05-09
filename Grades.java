/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hw1.student_grading_system;

/**
 *
 * @author can
 */


public class Grades {
    private int grdId;
    private int stdId;
    private int crsId;
    private float grdMt;
    private float grdHw;
    private float grdFinal;
    private String grdLgrade;

    
    public Grades(int grdId, int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) {
        this.grdId = grdId;
        this.stdId = stdId;
        this.crsId = crsId;
        this.grdMt = grdMt;
        this.grdHw = grdHw;
        this.grdFinal = grdFinal;
        this.grdLgrade = grdLgrade;
    }

 
    public Grades(int stdId, int crsId, float grdMt, float grdHw, float grdFinal, String grdLgrade) {
        this.stdId = stdId;
        this.crsId = crsId;
        this.grdMt = grdMt;
        this.grdHw = grdHw;
        this.grdFinal = grdFinal;
        this.grdLgrade = grdLgrade;
    }

    
    public int getGrdId() {
        return grdId;
    }

    public void setGrdId(int grdId) {
        this.grdId = grdId;
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

    public float getGrdMt() {
        return grdMt;
    }

    public void setGrdMt(float grdMt) {
        this.grdMt = grdMt;
    }

    public float getGrdHw() {
        return grdHw;
    }

    public void setGrdHw(float grdHw) {
        this.grdHw = grdHw;
    }

    public float getGrdFinal() {
        return grdFinal;
    }

    public void setGrdFinal(float grdFinal) {
        this.grdFinal = grdFinal;
    }

    public String getGrdLgrade() {
        return grdLgrade;
    }

    public void setGrdLgrade(String grdLgrade) {
        this.grdLgrade = grdLgrade;
    }
}
