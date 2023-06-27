package com.viewmodel;

import java.util.Date;

public class HoaDonView {

    private String id;
    private String maHd;
    private String maNv;
    private String tenKh;
    private Date ngayTao;
    private Date ngayThanhToan;
    private int tinhTrang;

    public HoaDonView() {
    }

    public HoaDonView(String id, String maHd, String maNv, String tenKh, Date ngayTao, Date ngayThanhToan, int tinhTrang) {
        this.id = id;
        this.maHd = maHd;
        this.maNv = maNv;
        this.tenKh = tenKh;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String checkTinhTrang(int tinhTrang) {
        String trangThai = "";

        switch (tinhTrang) {
            case 0:
                trangThai = "Chua thanh toan";
                break;
            case 1:
                trangThai = "Da thanh toan";
                break;
            case 2:
                trangThai = "Dang giao hang";
                break;
            case 3:
                trangThai = "Giao hang thanh cong";
                break;
            default:
                trangThai = "Chua cap nhap";
                break;
        }

        return trangThai;

    }

    @Override
    public String toString() {
        return "HoaDonView{" + "id=" + id + ", maHd=" + maHd + ", maNv=" + maNv + ", tenKh=" + tenKh + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", tinhTrang=" + tinhTrang + '}';
    }

}
