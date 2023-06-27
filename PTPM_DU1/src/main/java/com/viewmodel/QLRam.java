package com.viewmodel;

public class QLRam {

    private String id;
    private String ma;
    private String ram;

    public QLRam() {
    }

    public QLRam(String id, String ma, String ram) {
        this.id = id;
        this.ma = ma;
        this.ram = ram;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
