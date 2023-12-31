/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.viewmodel;

/**
 *
 * @author ADMIN
 */
public class HoaDonViewModelTuan {

    private String id;
    private String tenKH;
    private String sdtKH;
    private String tenNV;
    private String ngayTao;
    private String ngayThanhToan;
    private int hinhThucThanhToan;
    private int tinhTrang;
    private String ghiChu;
    private String ma;

    public HoaDonViewModelTuan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(String ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public int getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(int hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String checkHinhThucThanhToan(int check) {
        String trangThai = "";

        switch(check) {
            case 0:
                trangThai = "Tiền mặt";
                break;
            case 1:
                trangThai = "Chuyển khoản";
                break;
            case 2:
                trangThai = "Cả 2";
                break;
            default:
                trangThai = "Chưa cập nhập";
                break;
        }
        return trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonViewModel{" + "id=" + id + ", tenKH=" + tenKH + ", sdtKH=" + sdtKH + ", tenNV=" + tenNV + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", hinhThucThanhToan=" + hinhThucThanhToan + ", tinhTrang=" + tinhTrang + ", ghiChu=" + ghiChu + '}';
    }

}
