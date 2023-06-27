package com.viewmodel;

public class QLPIN {

    private String id;
    private String maPIN;
    private String dungLuong;

    public QLPIN() {
    }

    public QLPIN(String id, String maPIN, String dungLuong) {
        this.id = id;
        this.maPIN = maPIN;
        this.dungLuong = dungLuong;
    }

    public String getMaPIN() {
        return maPIN;
    }

    public void setMaPIN(String maPIN) {
        this.maPIN = maPIN;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
