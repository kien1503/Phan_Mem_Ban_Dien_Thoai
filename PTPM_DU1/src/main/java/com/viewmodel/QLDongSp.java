package com.viewmodel;

public class QLDongSp {

    private String id;
    private String maDongSP;
    private String tenDongSP;

    public QLDongSp() {
    }

    public QLDongSp(String id, String maDongSP, String tenDongSP) {
        this.id = id;
        this.maDongSP = maDongSP;
        this.tenDongSP = tenDongSP;
    }

    public String getMaDongSP() {
        return maDongSP;
    }

    public void setMaDongSP(String maDongSP) {
        this.maDongSP = maDongSP;
    }

    public String getTenDongSP() {
        return tenDongSP;
    }

    public void setTenDongSP(String tenDongSP) {
        this.tenDongSP = tenDongSP;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
