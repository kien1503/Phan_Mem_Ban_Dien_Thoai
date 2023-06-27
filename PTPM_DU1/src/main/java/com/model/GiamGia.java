package com.model;

import java.util.Date;

public class GiamGia {

    private String id;
    private String ma;
    private Date ngayTao;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Double giamGiaPhanTram;
    private Long giamGiaTienMat;
    private Long dieuKienGiamGia;
    private int loaiGiamGia;
    private int trangThai;
    private String tenCT;

    public GiamGia() {
    }

    public GiamGia(String id, String ma, Date ngayTao, Date ngayBatDau, Date ngayKetThuc, Double giamGiaPhanTram, Long giamGiaTienMat, Long dieuKienGiamGia, int loaiGiamGia, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGiaPhanTram = giamGiaPhanTram;
        this.giamGiaTienMat = giamGiaTienMat;
        this.dieuKienGiamGia = dieuKienGiamGia;
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

    public Double getGiamGiaPhanTram() {
        return giamGiaPhanTram;
    }

    public void setGiamGiaPhanTram(Double giamGiaPhanTram) {
        this.giamGiaPhanTram = giamGiaPhanTram;
    }

    public Long getGiamGiaTienMat() {
        return giamGiaTienMat;
    }

    public void setGiamGiaTienMat(Long giamGiaTienMat) {
        this.giamGiaTienMat = giamGiaTienMat;
    }

    public Long getDieuKienGiamGia() {
        return dieuKienGiamGia;
    }

    public void setDieuKienGiamGia(Long dieuKienGiamGia) {
        this.dieuKienGiamGia = dieuKienGiamGia;
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

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

   

}
