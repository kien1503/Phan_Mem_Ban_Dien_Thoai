package com.viewmodel;

public class QLTaiKhoan {

    private String idNhanVien;
    private String sdt;
    private String email;
    private String matKhau;
    private String tenCV;

    public QLTaiKhoan() {
    }

    public QLTaiKhoan(String idNhanVien, String sdt, String email, String matKhau, String tenCV) {
        this.idNhanVien = idNhanVien;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.tenCV = tenCV;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }

}
