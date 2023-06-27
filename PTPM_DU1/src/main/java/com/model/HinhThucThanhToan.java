package com.model;

public class HinhThucThanhToan {

    private String id;
    private String idHoaDon;
    private String idNhanVien;
    private String ma;
    private String maBanking;
    private String ngayTao;
    private String ngaySua;
    private String loaiHinhThanhToan;
    private String tongTienThanhToan;
    private String trangThai;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String id, String idHoaDon, String idNhanVien, String ma, String maBanking, String ngayTao, String ngaySua, String loaiHinhThanhToan, String tongTienThanhToan, String trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idNhanVien = idNhanVien;
        this.ma = ma;
        this.maBanking = maBanking;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.loaiHinhThanhToan = loaiHinhThanhToan;
        this.tongTienThanhToan = tongTienThanhToan;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMaBanking() {
        return maBanking;
    }

    public void setMaBanking(String maBanking) {
        this.maBanking = maBanking;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getLoaiHinhThanhToan() {
        return loaiHinhThanhToan;
    }

    public void setLoaiHinhThanhToan(String loaiHinhThanhToan) {
        this.loaiHinhThanhToan = loaiHinhThanhToan;
    }

    public String getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(String tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HinhThucThanhToan{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idNhanVien=" + idNhanVien + ", ma=" + ma + ", maBanking=" + maBanking + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", loaiHinhThanhToan=" + loaiHinhThanhToan + ", tongTienThanhToan=" + tongTienThanhToan + ", trangThai=" + trangThai + '}';
    }

}
