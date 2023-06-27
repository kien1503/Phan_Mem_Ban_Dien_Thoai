/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

/**
 *
 * @author Admin
 */
public class QLSanPhamDAT {

    private String id, maSP, tenSP;
    private Long giaBan;

    public QLSanPhamDAT() {
    }

    public QLSanPhamDAT(String id, String maSP, String tenSP, Long giaBan) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

}
