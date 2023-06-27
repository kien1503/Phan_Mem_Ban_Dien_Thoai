package com.viewmodel;

public class QLMauSac {

    private String id;
    private String ma;
    private String mau;

    public QLMauSac() {
    }

    public QLMauSac(String id, String ma, String mau) {
        this.id = id;
        this.ma = ma;
        this.mau = mau;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
