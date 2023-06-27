package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.HoaDonChiTiet;
import com.repositories.IHoaDonCTRepository;
import com.viewmodel.GioHangChiTiet;
import java.sql.*;
import java.util.ArrayList;

public class HoaDonChiTietRepository implements IHoaDonCTRepository {

    private ArrayList<GioHangChiTiet> listGioHang;

    @Override
    public ArrayList<GioHangChiTiet> getListGioHang() {
//        listGioHang = new ArrayList<>();
//        String sql = "select ctsp.id, sp.ten + ' - ' + ms.Ten + ' - ' + plh.Ten , ctsp.SoLuongTon, ctsp.GiaBan, Imei.SoImei from ChiTietSP ctsp \n"
//                + "JOIN SanPham sp ON ctsp.IdSP = sp.Id\n"
//                + "JOIN MauSac ms on ctsp.IdMauSac = ms.Id\n"
//                + "JOIN PhanLoaiHang plh ON ctsp.IdPhanLoaiHang = plh.id\n"
//                + "JOIN Imei ON ctsp.IdImei = Imei.id\n"
//                + "JOIN HoaDonChiTiet hdct on ctsp.Id = hdct.IdChiTietSP\n"
//                + "JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id\n"
//                + "WHERE hd.Id = ?";
//
//        try ( Connection conn = DbConnection.getConnection()) {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, id);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listGioHang.add(new GioHangChiTiet(rs.getString(1), "Null", rs.getString(2), rs.getInt(3), rs.getLong(4)));
//            }
//            return listGioHang;
//        } catch (Exception e) {
//        }

        return null;
    }

    @Override
    public ArrayList<GioHangChiTiet> getListGioHangToIdHoaDon(String id) {
        listGioHang = new ArrayList<>();
        String sql = "select ctsp.id, sp.ten + ' - ' + ms.Ten + ' - ' + plh.Ten , ctsp.SoLuongTon, ctsp.GiaBan, Imei.SoImei from ChiTietSP ctsp \n"
                + "JOIN SanPham sp ON ctsp.IdSP = sp.Id\n"
                + "JOIN MauSac ms on ctsp.IdMauSac = ms.Id\n"
                + "JOIN PhanLoaiHang plh ON ctsp.IdPhanLoaiHang = plh.id\n"
                + "JOIN Imei ON ctsp.IdImei = Imei.id\n"
                + "JOIN HoaDonChiTiet hdct on ctsp.Id = hdct.IdChiTietSP\n"
                + "JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id\n"
                + "WHERE hd.Id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listGioHang.add(new GioHangChiTiet(rs.getString(1), "Null", rs.getString(2), rs.getInt(3), rs.getLong(4)));
            }
            return listGioHang;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select listGioHangToIdHoadon");
        }

        return null;
    }

    @Override
    public Boolean add(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO HoaDonChiTiet(idChiTietSP, idHoaDon, SoLuong, DonGia, TrangThai) "
                + "VALUES(?, ?, ?, ?, ?)";
        int check = 0;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, hdct.getIdChiTietSP());
            ps.setObject(2, hdct.getIdHoaDon());
            ps.setObject(3, hdct.getSoLuong());
            ps.setObject(4, hdct.getDonGia());
            ps.setObject(5, hdct.getTrangThai());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Insert loi");
        }

        return null;
    }

    @Override
    public String listToIdHoaDonAndIdChiTietSP(String idHoaDon, String idChiTietSP) {
        String sql = "SELECT * FROM HoaDonChiTiet WHERE IdHoaDon = ? AND IdChiTietSP = ?";
        String idHdct = "";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ps.setObject(2, idChiTietSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idHdct = rs.getString(1);
            }
            return idHdct;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select idHoaDonCT");
        }

        return null;
    }

    @Override
    public GioHangChiTiet ghct(Long imei) {
        String sql = "select ChiTietSP.id , SanPham.Ten, ChiTietSP.GiaBan\n"
                + "from ChiTietSP \n"
                + "JOIN imei on imei.idchitietsp = ChiTietSP.Id\n"
                + "JOIN SanPham on SanPham.Id = ChiTietSP.IdSP\n"
                + "where imei.soimei = ? and imei.trangthai = 0";
        GioHangChiTiet ghct1 = new GioHangChiTiet();

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, imei);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ghct1.setIdChiTietSp(rs.getString(1));
                ghct1.setTenSp(rs.getString(2));
                ghct1.setDonGia(rs.getLong(3));
            }
            return ghct1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi");
        }
        return null;
    }

    public static void main(String[] args) {
        HoaDonChiTietRepository hd = new HoaDonChiTietRepository();
        if(hd.ghct(182123718371283l) == null) {
            System.out.println("nun");
        }
        System.out.println("test: " + hd.ghct(112234567888775l));
    }
}
