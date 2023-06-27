package com.viewmodel;


public class QLRom {
    private String id;
    private String ma;
    private String rom;

    public QLRom() {
    }

    public QLRom(String id, String ma, String rom) {
        this.id = id;
        this.ma = ma;
        this.rom = rom;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
