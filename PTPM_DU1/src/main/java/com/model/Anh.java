package com.model;


public class Anh {
    private String id;
    private String duongDanAnh;

    public Anh() {
    }

    public Anh(String id, String duongDanAnh) {
        this.id = id;
        this.duongDanAnh = duongDanAnh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDuongDanAnh() {
        return duongDanAnh;
    }

    public void setDuongDanAnh(String duongDanAnh) {
        this.duongDanAnh = duongDanAnh;
    }

    @Override
    public String toString() {
        return "Anh{" + "id=" + id + ", duongDanAnh=" + duongDanAnh + '}';
    }
    
    
}
