package com.viewmodel;

public class ImeiDaBanView {

    private String tenSp;
    private Long imei;

    public ImeiDaBanView() {
    }

    public ImeiDaBanView(Long imei, String tenSp) {
        this.imei = imei;
        this.tenSp = tenSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public Long getImei() {
        return imei;
    }

    public void setImei(Long imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "ImeiDaBanView{" + "tenSp=" + tenSp + ", imei=" + imei + '}';
    }

}
