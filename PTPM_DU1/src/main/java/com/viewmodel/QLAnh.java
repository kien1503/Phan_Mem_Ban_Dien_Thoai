package com.viewmodel;

public class QLAnh {

    private String id;
    private String anh;

    public QLAnh() {
    }

    public QLAnh(String id, String anh) {
        this.id = id;
        this.anh = anh;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QLAnh{" + "id=" + id + ", anh=" + anh + '}';
    }

}
