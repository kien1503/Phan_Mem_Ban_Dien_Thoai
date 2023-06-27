package com.viewmodel;

public class QLCamera {

    private String id;
    private String ma;
    private String cam;

    public QLCamera() {
    }

    public QLCamera(String id, String ma, String cam) {
        this.id = id;
        this.ma = ma;
        this.cam = cam;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getCam() {
        return cam;
    }

    public void setCam(String cam) {
        this.cam = cam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "QLCamera{" + "id=" + id + ", ma=" + ma + ", cam=" + cam + '}';
    }

}
