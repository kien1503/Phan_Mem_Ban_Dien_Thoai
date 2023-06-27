package com.viewmodel;

public class ImeiSanPhamView {

    private String idHoaDon;
    private String idChiTietSp;
    private Long imei;

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(String idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "ImeiSanPhamView{" + "idHoaDon=" + idHoaDon + ", idChiTietSp=" + idChiTietSp + ", imei=" + imei + '}';
    }

}
