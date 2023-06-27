package com.viewmodel;

public class QLSanPham {

    private String id;
    private String maSP;
    private String tenSP;

    public QLSanPham() {
    }

    public QLSanPham(String id, String maSP, String tenSP) {
        this.id = id;
        this.maSP = maSP;
        this.tenSP = tenSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
