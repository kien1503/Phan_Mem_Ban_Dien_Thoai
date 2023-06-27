package com.viewmodel;

public class QLChipSE {

    private String id;
    private String ma;
    private String chip;

    public QLChipSE() {
    }

    public QLChipSE(String id, String ma, String chip) {
        this.id = id;
        this.ma = ma;
        this.chip = chip;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
