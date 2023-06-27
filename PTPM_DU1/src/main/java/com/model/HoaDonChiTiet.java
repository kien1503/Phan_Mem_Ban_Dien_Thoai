package com.model;

public class HoaDonChiTiet {

    private String id;
    private String idHoaDon;
    private String idChiTietSP;
    private int soLuong;
    private Long donGia;
    private int trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String idHoaDon, String idChiTietSP, int soLuong, Long donGia, int trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idChiTietSP = idChiTietSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idChiTietSP=" + idChiTietSP + ", soLuong=" + soLuong + ", donGia=" + donGia + ", trangThai=" + trangThai + '}';
    }

}
