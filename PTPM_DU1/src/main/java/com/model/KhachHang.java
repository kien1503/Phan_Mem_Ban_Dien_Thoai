package com.model;


public class KhachHang {

    private String id;
    private String ma;
    private String ten;
    private String sdt;
    private String ngaySinh;
    private String diaChi;
    private int gioiTinh;
    private int trangThai;
    private String ghiChu;
    private int soLanMua;

    public KhachHang() {
    }

    public KhachHang(String id, String ma, String ten, String sdt, String ngaySinh, String diaChi, int gioiTinh, int trangThai, String ghiChu, int soLanMua) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
        this.soLanMua = soLanMua;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getSoLanMua() {
        return soLanMua;
    }

    public void setSoLanMua(int soLanMua) {
        this.soLanMua = soLanMua;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ma=" + ma + ", ten=" + ten + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", gioiTinh=" + gioiTinh + ", trangThai=" + trangThai + ", ghiChu=" + ghiChu + ", soLanMua=" + soLanMua + '}';
    }

}
