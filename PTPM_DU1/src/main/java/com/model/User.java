package com.model;

public class User {

    private String id;
    private String user;
    private String passWord;
    private String idNhanVien;
    private String chucVu;

    public User() {
    }

    public User(String id, String user, String passWord, String idNhanVien, String chucVu) {
        this.id = id;
        this.user = user;
        this.passWord = passWord;
        this.idNhanVien = idNhanVien;
        this.chucVu = chucVu;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", user=" + user + ", passWord=" + passWord + ", idNhanVien=" + idNhanVien + ", chucVu=" + chucVu + '}';
    }

}
