package com.viewmodel;

public class QLImeil {

    private String id;
    private String maImei;
    private Long soImei;
    private String idChiTietSP;
    private int trangThai;

    public QLImeil() {
    }

    public QLImeil(String id, Long soImei) {
        this.id = id;
        this.soImei = soImei;
    }

    public QLImeil(String id, String maImei, Long soImei, String idChiTietSP, int trangThai) {
        this.id = id;
        this.maImei = maImei;
        this.soImei = soImei;
        this.idChiTietSP = idChiTietSP;
        this.trangThai = trangThai;
    }

    public String getMaImei() {
        return maImei;
    }

    public void setMaImei(String maImei) {
        this.maImei = maImei;
    }

    public Long getSoImei() {
        return soImei;
    }

    public void setSoImei(Long soImei) {
        this.soImei = soImei;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "QLImeil{" + "id=" + id + ", maImei=" + maImei + ", soImei=" + soImei + ", idChiTietSP=" + idChiTietSP + ", trangThai=" + trangThai + '}';
    }

}
