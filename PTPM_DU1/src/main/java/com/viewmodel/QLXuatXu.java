package com.viewmodel;

public class QLXuatXu {

    private String id;
    private String maXuatXu;
    private String tenXuatXu;

    public QLXuatXu() {
    }

    public QLXuatXu(String id, String maXuatXu, String tenXuatXu) {
        this.id = id;
        this.maXuatXu = maXuatXu;
        this.tenXuatXu = tenXuatXu;
    }

    public String getMaXuatXu() {
        return maXuatXu;
    }

    public void setMaXuatXu(String maXuatXu) {
        this.maXuatXu = maXuatXu;
    }

    public String getTenXuatXu() {
        return tenXuatXu;
    }

    public void setTenXuatXu(String tenXuatXu) {
        this.tenXuatXu = tenXuatXu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
