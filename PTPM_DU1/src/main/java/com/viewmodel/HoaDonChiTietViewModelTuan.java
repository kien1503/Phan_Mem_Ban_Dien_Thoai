package com.viewmodel;

public class HoaDonChiTietViewModelTuan {

    private String id;
    private String tenSP;
    private Long imei;
    private int soLuong;
    private Long donGia;
    private Long tongTien;
    private Long sale;
    private String idChiTietSP;

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
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

    public Long getTongTien() {
        return (getDonGia() * getSoLuong());
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    public Long getSale() {
        return sale;
    }

    public void setSale(Long sale) {
        this.sale = sale;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    @Override
    public String toString() {
        return "HoaDonChiTietViewModelTuan{" + "id=" + id + ", tenSP=" + tenSP + ", imei=" + imei + ", soLuong=" + soLuong + ", donGia=" + donGia + ", tongTien=" + tongTien + ", sale=" + sale + '}';
    }

}
