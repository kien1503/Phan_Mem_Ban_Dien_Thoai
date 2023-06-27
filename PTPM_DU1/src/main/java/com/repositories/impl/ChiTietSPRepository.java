package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.IChiTietSPRepository;
import com.viewmodel.ChiTietSpViewModel;
import java.sql.*;
import java.util.ArrayList;
import com.model.ChiTietSanPham;
import com.viewmodel.GiamGiaSanPhamView;

public class ChiTietSPRepository implements IChiTietSPRepository {

    private ArrayList<ChiTietSpViewModel> listChiTietSP;

    @Override
    public ArrayList<ChiTietSpViewModel> getListChiTietSp() {
        listChiTietSP = new ArrayList<>();
        String sql = "select ctsp.id, sp.Ma,sp.ten + ' - ' + ms.Ten + ' - ' + plh.Ten , ctsp.SoLuongTon, ctsp.GiaBan\n"
                + "from ChiTietSP ctsp\n"
                + "JOIN SanPham sp ON ctsp.IdSP = sp.Id\n"
                + "JOIN MauSac ms on ctsp.IdMauSac = ms.Id\n"
                + "JOIN PhanLoaiHang plh ON ctsp.IdPhanLoaiHang = plh.id ";
//                + "JOIN GiamGiaChiTiet ggct ON ggct.IdChiTietSP = ctsp.id\n"
//                + "JOIN giamgia on ggct.IdGiamGia = giamgia.id";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietSpViewModel c = new ChiTietSpViewModel();

                c.setId(rs.getString(1));
                c.setMaSp(rs.getString(2));
                c.setTenSp(rs.getString(3));
                c.setSoLuong(rs.getInt(4));
                c.setDonGia(rs.getLong(5));

                listChiTietSP.add(c);
            }

            return listChiTietSP;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Loi select");
        }

        return null;
    }

    @Override
    public ChiTietSpViewModel getSoLuong(String id) {
        String sql = "select SoLuongTon from ChiTietSP where id = ?";
        ChiTietSpViewModel c = new ChiTietSpViewModel();

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int soLuongTon = rs.getInt(1);
                c.setSoLuong(soLuongTon);
            }
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Loi select");
        }

        return null;
    }

    @Override
    public Boolean update(int soLuong, String id) {
        String sql = "UPDATE ChiTietSP SET SoLuongTon = ? WHERE id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, soLuong);
            ps.setObject(2, id);

            check = ps.executeUpdate();

            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update that bai");
        }

        return null;
    }

    @Override
    public ArrayList<ChiTietSpViewModel> listChiTietSpToNameOrMa(String tenOrMa) {
        listChiTietSP = new ArrayList<>();
        String sql = "select ctsp.id, sp.ten + ' - ' + ms.Ten + ' - ' + plh.Ten , ctsp.SoLuongTon, ctsp.GiaBan, Imei.SoImei from ChiTietSP ctsp \n"
                + "JOIN SanPham sp ON ctsp.IdSP = sp.Id\n"
                + "JOIN MauSac ms on ctsp.IdMauSac = ms.Id\n"
                + "JOIN PhanLoaiHang plh ON ctsp.IdPhanLoaiHang = plh.id\n"
                + "JOIN Imei ON ctsp.IdImei = Imei.id "
                + "WHERE sp.Ten LIKE ? or sp.Ma LIKE ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + tenOrMa + "%");
            ps.setObject(2, "%" + tenOrMa + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listChiTietSP.add(new ChiTietSpViewModel(rs.getString(1), "Null", rs.getString(2), rs.getInt(3), rs.getLong(4), rs.getLong(5)));
            }

            return listChiTietSP;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" Loi select");
        }

        return null;
    }

    @Override
    public ArrayList<GiamGiaSanPhamView> getListGiamGia(String id) {
        ArrayList<GiamGiaSanPhamView> list = new ArrayList<>();
        String sql = "select ggct.id, giamgia.GiamGiaTienMat, giamgia.GiamGiaPhanTram "
                + "from GiamGiaChiTiet ggct \n"
                + "join giamgia on ggct.IdGiamGia = giamgia.id\n"
                + "join chitietsp ctsp on ctsp.id = ggct.idChitietsp\n"
                + "where ctsp.id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GiamGiaSanPhamView giamGia = new GiamGiaSanPhamView();

                giamGia.setId(rs.getString(1));
                giamGia.setSoTienGiam(rs.getLong(2));
                giamGia.setSoPhanTram(rs.getInt(3));
                list.add(giamGia);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi selcet cbb giamgiasp");
        }

        return null;
    }

    @Override
    public Long giamGia(String idChiTietSP) {
        String sql = "select giamgia.GiamGiaTienMat, giamgia.GiamGiaPhanTram from ChiTietSP ctsp \n"
                + "join GiamGiaChiTiet ggct on ctsp.id = ggct.IdChiTietSP\n"
                + "join giamgia on ggct.IdGiamGia = giamgia.id\n"
                + "where ctsp.Id = ? ";
        Long giamGia = 0l;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idChiTietSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                giamGia = rs.getLong(1);

                if (giamGia == null || giamGia == 0) {
                    giamGia = rs.getLong(2);
                }
            }
            return giamGia;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select giam gia to idChitietSp");
        }

        return null;
    }
    
    public static void main(String[] args) {
        ChiTietSPRepository c = new ChiTietSPRepository();
        System.out.println(c.giamGia("a61b601f-e44f-4898-a4b3-b093eeff772e"));
    }

}
