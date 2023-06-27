/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class QLGiamGia {

    private String id;
    private String ma;
    private String tenCT;
    private Date ngayTao, ngayBatDau, ngayKetThuc;
    private Long giamGiaPhanTram;
    private Long giamGiaTienMat;
    private int loaiGiamGia;
    ;
    private int trangThai;

    public QLGiamGia() {
    }

    public QLGiamGia(String id, String ma, String tenCT, Date ngayTao, Date ngayBatDau, Date ngayKetThuc, Long giamGiaPhanTram, Long giamGiaTienMat, int loaiGiamGia, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.tenCT = tenCT;
        this.ngayTao = ngayTao;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGiaPhanTram = giamGiaPhanTram;
        this.giamGiaTienMat = giamGiaTienMat;
        this.loaiGiamGia = loaiGiamGia;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Long getGiamGiaPhanTram() {
        return giamGiaPhanTram;
    }

    public void setGiamGiaPhanTram(Long giamGiaPhanTram) {
        this.giamGiaPhanTram = giamGiaPhanTram;
    }

    public Long getGiamGiaTienMat() {
        return giamGiaTienMat;
    }

    public void setGiamGiaTienMat(Long giamGiaTienMat) {
        this.giamGiaTienMat = giamGiaTienMat;
    }

    public int getLoaiGiamGia() {
        return loaiGiamGia;
    }

    public void setLoaiGiamGia(int loaiGiamGia) {
        this.loaiGiamGia = loaiGiamGia;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String checkLoaiGiamGia(int loaiGiamGia) {
        String a = "";
        if (loaiGiamGia == 0) {
            a = "Giam gia toan shop";
        } else if (loaiGiamGia == 1) {
            a = "Giam gia 1 san pham";
        } else {
            a = "Giam gia theo hoa don";
        }

        return a;

    }

    @Override
    public String toString() {
        return "QLGiamGia{" + "id=" + id + ", ma=" + ma + ", tenCT=" + tenCT + ", ngayTao=" + ngayTao + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", giamGiaPhanTram=" + giamGiaPhanTram + ", giamGiaTienMat=" + giamGiaTienMat + ", loaiGiamGia=" + loaiGiamGia + ", trangThai=" + trangThai + '}';
    }
}
