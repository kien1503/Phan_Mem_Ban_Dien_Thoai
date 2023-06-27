package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.GiamGia;
import com.model.HinhThucThanhToan;
import com.model.HoaDon;
import com.repositories.IHoaDonRepository;
import com.viewmodel.HoaDonView;
import java.util.ArrayList;
import java.sql.*;

public class HoaDonRepository implements IHoaDonRepository {

    private ArrayList<HoaDonView> listHoaDon;

    @Override
    public ArrayList<HoaDonView> listHoaDonView() {
        listHoaDon = new ArrayList<>();
        try {
            Connection conn = DbConnection.getConnection();
            String sql = "SELECT hd.id, hd.Ma, nv.Ten, hd.TenKh, hd.NgayTao, hd.NgayThanhToan, hd.TinhTrang "
                    + "FROM HoaDon hd JOIN NhanVien nv ON hd.IdNhanVien = nv.Id "
                    + "WHERE hd.TinhTrang = 0 or hd.TinhTrang = 2\n"
                    + "ORDER BY NgayTao DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String tenNv = rs.getString(3);
                String tenKh = rs.getString(4);
                Date ngayTao = rs.getDate(5);
                Date ngayThanhToan = rs.getDate(6);
                int tinhTrang = rs.getInt(7);

                HoaDonView hdView = new HoaDonView(id, ma, tenNv, tenKh, ngayTao, ngayThanhToan, tinhTrang);
                listHoaDon.add(hdView);

            }
            return listHoaDon;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select");
        }
        return null;
    }

    @Override
    public Boolean add(HoaDon hd) {
        String sql = "INSERT INTO HoaDon(ma, idNhanVien, TenKh, NgayTao, TinhTrang) "
                + "VALUES(?, ?, ?, ?, ?)";

        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, hd.getMa());
            ps.setObject(2, hd.getIdNhanVien());
            ps.setObject(3, hd.getTenKh());
            ps.setObject(4, hd.getNgayTao());
            ps.setObject(5, hd.getTinhTrang());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi insert");
        }

        return false;
    }

    @Override
    public Boolean update(HoaDon hd, String id) {
        String sql = "UPDATE HoaDon SET TenKh = ?, IdKh = ?, SdtNguoiNhan = ?, NgayThanhToan = ?, "
                + "NgayShip = ?, TienShip = ?, TienCoc = ?, NgayNhan = ?, SdtNguoiShip = ?, "
                + "TenNguoiShip = ?, MaVanChuyen = ?, TinhTrang = ?, HinhThucThanhToan = ?, "
                + "MaGiaoDichBanking = ?, GhiChu = ?, DiaChiNhanHang = ? "
                + "WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, hd.getTenKh());
            ps.setObject(2, hd.getIdKh());
            ps.setObject(3, hd.getSdtNguoiNhan());
            ps.setObject(4, hd.getNgayThanhToan());
            ps.setObject(5, hd.getNgayShip());
            ps.setObject(6, hd.getTienShip());
            ps.setObject(7, hd.getTienCoc());
            ps.setObject(8, hd.getNgayNhan());
            ps.setObject(9, hd.getSdtNguoiShip());
            ps.setObject(10, hd.getTenNguoiShip());
            ps.setObject(11, hd.getMaVanChuyen());
            ps.setObject(12, hd.getTinhTrang());
            ps.setObject(13, hd.getHinhThucThanhToan());
            ps.setObject(14, hd.getMaGiaoDich());
            ps.setObject(15, hd.getGhiChu());
            ps.setObject(16, hd.getDiaChiNhanHang());

            ps.setObject(17, id);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update hoadon1");
        }

        return false;
    }

    @Override
    public Boolean delete(String id) {
        String sql = "DELETE FROM HoaDon WHERE id = ?";
        int check = 0;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi xoa");
        }
        return false;
    }

    @Override
    public ArrayList<GiamGia> listGiamGia(java.util.Date ngayChon, String ma) {
//        ArrayList<GiamGia> listGiamGia = new ArrayList<>();
//        String sql = "select * from GiamGia \n"
//                + "WHERE Ma = ? AND (? > NgayDienRa AND ? < NgayKetThuc)";
//
//        try {
//            Connection conn = DbConnection.getConnection();
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setObject(1, ma);
//            ps.setObject(2, ngayChon);
//            ps.setObject(3, ngayChon);
//
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                listGiamGia.add(new GiamGia(rs.getString(1), rs.getString(2), rs.getString(3),
//                        rs.getLong(4), rs.getDate(5), rs.getDate(6), rs.getDate(7), rs.getInt(8)));
//            }
//            return listGiamGia;
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Loi select giamgia");
//        }

        return null;
    }

    @Override
    public Boolean updateHinhThucThanhToan(HinhThucThanhToan htth) {
        return null;
    }

    @Override
    public Boolean updateNoIdKhachHang(HoaDon hd, String id) {
        String sql = "UPDATE HoaDon SET TenKh = ?, NgayThanhToan = ?, TinhTrang = ?, "
                + "SdtNguoiNhan = ?, GhiChu = ?, IdGiamGia = ?, SoTienGiam = ? WHERE id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getTenKh());
            ps.setObject(2, hd.getNgayThanhToan());
            ps.setObject(3, hd.getTinhTrang());
            ps.setObject(4, hd.getSdtNguoiNhan());
            ps.setObject(5, hd.getGhiChu());
            ps.setObject(7, hd.getSoTienGiam());
            ps.setObject(8, id);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update hoadon");
        }

        return false;
    }

    @Override
    public Boolean updateHDToTaiQuay(HoaDon hd, String id) {
        String sql = "UPDATE HoaDon SET TenKh = ?, NgayThanhToan = ?, TinhTrang = ?, IdKh = ?, "
                + "SdtNguoiNhan = ?, GhiChu = ?, HinhThucThanhToan WHERE id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getTenKh());
            ps.setObject(2, hd.getNgayThanhToan());
            ps.setObject(3, hd.getTinhTrang());
            ps.setObject(4, hd.getSdtNguoiNhan());
            ps.setObject(5, hd.getGhiChu());
            ps.setObject(7, hd.getSoTienGiam());
            ps.setObject(8, id);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update hoadon");
        }

        return false;
    }

    @Override
    public Boolean updateHDToShipHang(HoaDon hd, String id) {
        String sql = "UPDATE HoaDon SET TenKh = ?, NgayThanhToan = ?, TinhTrang = ?, "
                + "SdtNguoiNhan = ?, GhiChu = ?, IdGiamGia = ?, SoTienGiam = ? WHERE id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getTenKh());
            ps.setObject(2, hd.getNgayThanhToan());
            ps.setObject(3, hd.getTinhTrang());
            ps.setObject(4, hd.getSdtNguoiNhan());
            ps.setObject(5, hd.getGhiChu());
            ps.setObject(7, hd.getSoTienGiam());
            ps.setObject(8, id);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update hoadon");
        }

        return false;
    }

//    @Override
//    public Boolean updateGiaoHang(HoaDon hd, String id) {
//        String sql = "UPDATE HoaDon SET TinhTrang = 2";
//    }

}
