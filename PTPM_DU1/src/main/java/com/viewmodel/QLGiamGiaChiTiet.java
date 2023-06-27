/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

/**
 *
 * @author Admin
 */
public class QLGiamGiaChiTiet {

    private String idChiTietSP, idGiamGia;
    private Long soTienConLai;

    public QLGiamGiaChiTiet() {
    }

    public QLGiamGiaChiTiet(String idChiTietSP, String idGiamGia, Long soTienConLai) {
        this.idChiTietSP = idChiTietSP;
        this.idGiamGia = idGiamGia;
        this.soTienConLai = soTienConLai;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public String getIdGiamGia() {
        return idGiamGia;
    }

    public void setIdGiamGia(String idGiamGia) {
        this.idGiamGia = idGiamGia;
    }

    public Long getSoTienConLai() {
        return soTienConLai;
    }

    public void setSoTienConLai(Long soTienConLai) {
        this.soTienConLai = soTienConLai;
    }

}
