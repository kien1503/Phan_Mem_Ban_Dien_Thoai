package com.viewmodel;

public class QLPhanLoaiHang {

    private String id;
    private String ma;
    private String tenLoai;

    public QLPhanLoaiHang() {
    }

    public QLPhanLoaiHang(String id, String ma, String tenLoai) {
        this.id = id;
        this.ma = ma;
        this.tenLoai = tenLoai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
