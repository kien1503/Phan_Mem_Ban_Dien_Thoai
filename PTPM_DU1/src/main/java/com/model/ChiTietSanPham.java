 
package com.model;

 
public class ChiTietSanPham {
    private String id,idSP,idImei,idMauSac,idChipse,
            idPin,idPhanLoaiHang,idRam,idRom,idManHinh,
            idCamera,idXuatXu,idDongSP;
    private Long giaNhap;
    private Long giaBan;
    private int namBH;
    private String moTa;
    private int soLuongTon;
    private int trangThai;
    private String anh;
    public ChiTietSanPham() {
    }

    public ChiTietSanPham(String id, String idSP, String idMauSac, String idChipse, String idPin, String idPhanLoaiHang, String idRam, String idRom, String idManHinh, String idCamera, String idXuatXu, String idDongSP, Long giaNhap, Long giaBan, int namBH, String moTa, int soLuongTon, int trangThai, String anh) {
        this.id = id;
        this.idSP = idSP;
        this.idMauSac = idMauSac;
        this.idChipse = idChipse;
        this.idPin = idPin;
        this.idPhanLoaiHang = idPhanLoaiHang;
        this.idRam = idRam;
        this.idRom = idRom;
        this.idManHinh = idManHinh;
        this.idCamera = idCamera;
        this.idXuatXu = idXuatXu;
        this.idDongSP = idDongSP;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.trangThai = trangThai;
        this.anh = anh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSP() {
        return idSP;
    }

    public void setIdSP(String idSP) {
        this.idSP = idSP;
    }

    public String getIdImei() {
        return idImei;
    }

    public void setIdImei(String idImei) {
        this.idImei = idImei;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdChipse() {
        return idChipse;
    }

    public void setIdChipse(String idChipse) {
        this.idChipse = idChipse;
    }

    public String getIdPin() {
        return idPin;
    }

    public void setIdPin(String idPin) {
        this.idPin = idPin;
    }

    public String getIdPhanLoaiHang() {
        return idPhanLoaiHang;
    }

    public void setIdPhanLoaiHang(String idPhanLoaiHang) {
        this.idPhanLoaiHang = idPhanLoaiHang;
    }

    public String getIdRam() {
        return idRam;
    }

    public void setIdRam(String idRam) {
        this.idRam = idRam;
    }

    public String getIdRom() {
        return idRom;
    }

    public void setIdRom(String idRom) {
        this.idRom = idRom;
    }

    public String getIdManHinh() {
        return idManHinh;
    }

    public void setIdManHinh(String idManHinh) {
        this.idManHinh = idManHinh;
    }

    public String getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(String idCamera) {
        this.idCamera = idCamera;
    }

    public String getIdXuatXu() {
        return idXuatXu;
    }

    public void setIdXuatXu(String idXuatXu) {
        this.idXuatXu = idXuatXu;
    }

    public String getIdDongSP() {
        return idDongSP;
    }

    public void setIdDongSP(String idDongSP) {
        this.idDongSP = idDongSP;
    }

    public Long getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Long giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Long giaBan) {
        this.giaBan = giaBan;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
    
}
