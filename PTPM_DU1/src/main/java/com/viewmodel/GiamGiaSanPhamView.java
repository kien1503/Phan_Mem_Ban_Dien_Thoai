package com.viewmodel;

public class GiamGiaSanPhamView {

    private String id;
    private String ma;
    private Long soTienGiam;
    private int soPhanTram;

    public GiamGiaSanPhamView() {
    }

    public GiamGiaSanPhamView(String id, String ma, Long soTienGiam, int soPhanTram) {
        this.id = id;
        this.ma = ma;
        this.soTienGiam = soTienGiam;
        this.soPhanTram = soPhanTram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Long getSoTienGiam() {
        return soTienGiam;
    }

    public void setSoTienGiam(Long soTienGiam) {
        this.soTienGiam = soTienGiam;
    }

    public int getSoPhanTram() {
        return soPhanTram;
    }

    public void setSoPhanTram(int soPhanTram) {
        this.soPhanTram = soPhanTram;
    }

    @Override
    public String toString() {
        return "GiamGiaSanPhamView{" + "id=" + id + ", ma=" + ma + ", soTienGiam=" + soTienGiam + '}';
    }

}
