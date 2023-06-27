/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

/**
 *
 * @author ADMIN
 */
public class QLNhanVien {

    private String id;
    private String ma;
    private String ten;
    private String ngaySinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String matKhau;
    private String ngayTao;
    private String ghiChu;
    private int trangThai;
    private String tenChucVu;

    public QLNhanVien() {
    }

    public QLNhanVien(String id, String ma, String ten, String ngaySinh, String diaChi, String sdt, String email, String matKhau, String ngayTao, String ghiChu, int trangThai, String tenChucVu) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.tenChucVu = tenChucVu;
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

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setNgaySinh(String ngaySinh) {
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

   

}
