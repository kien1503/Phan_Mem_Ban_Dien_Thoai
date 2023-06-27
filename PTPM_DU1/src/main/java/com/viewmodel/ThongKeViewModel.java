package com.viewmodel;

import java.util.Date;

public class ThongKeViewModel {

    private String mahd;
    private Date ngay;
    private String masp;
    private String tensp;
    private int sldaban;
    private Long dongia;
    private int slton;
    private Long tongTien;

    public ThongKeViewModel() {
    }

    public ThongKeViewModel(String mahd, Date ngay, String masp, String tensp, int sldaban, Long dongia, int slton) {

        this.mahd = mahd;
        this.ngay = ngay;
        this.masp = masp;
        this.tensp = tensp;
        this.sldaban = sldaban;
        this.dongia = dongia;
        this.slton = slton;
    }

    public ThongKeViewModel(String mahd, Date ngay, String tensp, int sldaban, Long dongia, int slton) {

        this.mahd = mahd;
        this.ngay = ngay;
        this.tensp = tensp;
        this.sldaban = sldaban;
        this.dongia = dongia;
        this.slton = slton;
    }

    public ThongKeViewModel(int soLuong, Long donGia) {
        this.sldaban = soLuong;
        this.dongia = donGia;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSldaban() {
        return sldaban;
    }

    public void setSldaban(int sldaban) {
        this.sldaban = sldaban;
    }

    public Long getDongia() {
        return dongia;
    }

    public void setDongia(Long dongia) {
        this.dongia = dongia;
    }

    public int getSlton() {
        return slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }

    public Long getTongTien() {
        return tongTien;
    }

    public void setTongTien(Long tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ThongKeViewModel{" + "mahd=" + mahd + ", ngay=" + ngay + ", masp=" + masp + ", tensp=" + tensp + ", sldaban=" + sldaban + ", dongia=" + dongia + ", slton=" + slton + ", tongTien=" + tongTien + '}';
    }

}
