package com.model;

public class ImeiDaBan {

    private String id;
    private Long maImei;
    private int trangThai;
    private String idHoaDonCT;

    public ImeiDaBan() {
    }

    public ImeiDaBan(String id, Long maImei, int trangThai, String idHoaDonCT) {
        this.id = id;
        this.maImei = maImei;
        this.trangThai = trangThai;
        this.idHoaDonCT = idHoaDonCT;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMaImei() {
        return maImei;
    }

    public void setMaImei(Long maImei) {
        this.maImei = maImei;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdHoaDonCT() {
        return idHoaDonCT;
    }

    public void setIdHoaDonCT(String idHoaDonCT) {
        this.idHoaDonCT = idHoaDonCT;
    }

    @Override
    public String toString() {
        return "ImeiDaBan{" + "id=" + id + ", maImei=" + maImei + ", trangThai=" + trangThai + ", idHoaDonCT=" + idHoaDonCT + '}';
    }

}
