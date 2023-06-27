/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTietViewModel {
    private String tenSP;
    private String imei;
    private int soLuong;
    private Long donGia;
    private Long sale;
    private Long tongTien;

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public Long getTongTien() {
        return (getDonGia() * getSoLuong()) - getSale();
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }
    
}
