package com.model;

import java.util.Date;

public class NhanVien {

    private String id;
    private String ten;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String matKhau;
    private String ngayTao;
    private String ghiChu;
    private String trangThai;
    private String idChucVu;

    public NhanVien() {
    }

    public NhanVien(String id, String ten, Date ngaySinh, String diaChi, String sdt, String email, String matKhau, String ngayTao, String ghiChu, String trangThai, String idChucVu) {
        this.id = id;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.idChucVu = idChucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(String idChucVu) {
        this.idChucVu = idChucVu;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", ten=" + ten + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", sdt=" + sdt + ", email=" + email + ", matKhau=" + matKhau + ", ngayTao=" + ngayTao + ", ghiChu=" + ghiChu + ", trangThai=" + trangThai + ", idChucVu=" + idChucVu + '}';
    }

}
