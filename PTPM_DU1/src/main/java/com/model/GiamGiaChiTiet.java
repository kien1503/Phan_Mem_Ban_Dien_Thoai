package com.model;

public class GiamGiaChiTiet {

    private String id;
    private String idGiamGia;
    private String idChiTietSp;
    private Long donGia;
    private Long soTien;
    private int trangThai;

    public GiamGiaChiTiet() {
    }

    public GiamGiaChiTiet(String id, String idGiamGia, String idChiTietSp, Long donGia, Long soTien, int trangThai) {
        this.id = id;
        this.idGiamGia = idGiamGia;
        this.idChiTietSp = idChiTietSp;
        this.donGia = donGia;
        this.soTien = soTien;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdGiamGia() {
        return idGiamGia;
    }

    public void setIdGiamGia(String idGiamGia) {
        this.idGiamGia = idGiamGia;
    }

    public String getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(String idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public Long getDonGia() {
        return donGia;
    }

    public void setDonGia(Long donGia) {
        this.donGia = donGia;
    }

    public Long getSoTien() {
        return soTien;
    }

    public void setSoTien(Long soTien) {
        this.soTien = soTien;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "GiamGiaChiTiet{" + "id=" + id + ", idGiamGia=" + idGiamGia + ", idChiTietSp=" + idChiTietSp + ", donGia=" + donGia + ", soTien=" + soTien + ", trangThai=" + trangThai + '}';
    }

}
