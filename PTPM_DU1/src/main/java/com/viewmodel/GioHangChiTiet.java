package com.viewmodel;

public class GioHangChiTiet {

    private String idHoaDon;
    private String idChiTietSp;
    private String tenSp;
    private int soLuong;
    private Long donGia;
    private Long giamGia;
    private Long imei;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(String idHoaDon, String idChiTietSp, String tenSp, int soLuong, Long donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public GioHangChiTiet(String idChiTietSp, String tenSp, int soLuong, Long donGia) {
        this.idChiTietSp = idChiTietSp;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(String idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
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

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Long getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Long giamGia) {
        this.giamGia = giamGia;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "idHoaDon=" + idHoaDon + ", idChiTietSp=" + idChiTietSp + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", donGia=" + donGia + ", giamGia=" + giamGia + ", imei=" + imei + '}';
    }

}
