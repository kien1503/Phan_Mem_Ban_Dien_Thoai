package com.model;

public class Imei {

    private String id;
    private Long soImei;
    private int trangThai;
    private String idChiTietSP;

    public Imei() {
    }

    public Imei(String id, Long soImei, int trangThai, String idChiTietSP) {
        this.id = id;
        this.soImei = soImei;
        this.trangThai = trangThai;
        this.idChiTietSP = idChiTietSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getSoImei() {
        return soImei;
    }

    public void setSoImei(Long soImei) {
        this.soImei = soImei;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    @Override
    public String toString() {
        return "Imei{" + "id=" + id + ", ma=" + ", soImei=" + soImei + ", trangThai=" + trangThai + ", idChiTietSP=" + idChiTietSP + '}';
    }

}
