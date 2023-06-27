package com.repositories.impl;

import com.repositories.ICTSanPhamRepo;
import com.viewmodel.QLCTSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.dbcontext.DbConnection;
import com.model.ChiTietSanPham;

public class CtSanPhamRepo implements ICTSanPhamRepo {

    private Connection conn;

    public CtSanPhamRepo() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<QLCTSanPham> view() {
        ArrayList<QLCTSanPham> listSP = new ArrayList<>();
        String sql = "Select a.Anh, SanPham.Ten, PhanLoaiHang.Ten, Ram.Ten, Rom.Ten, ManHinh.Ten, SoLuongTon, a.GiaBan, "
                + "a.id, a.GiaNhap\n"
                + "from ChiTietSP a join SanPham on a.IdSP = SanPham.Id\n"
                + "				 join PhanLoaiHang on a.IdPhanLoaiHang = PhanLoaiHang.Id\n"
                + "				 join Ram on a.IdRam = Ram.Id\n"
                + "				 join Rom on a.IdRom = Rom.Id\n"
                + "				 join ManHinh on a.IdManHinh = ManHinh.Id\n"
                + "	";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String anh = rs.getString(1);
                String tenSp = rs.getString(2);
                String loaiSp = rs.getString(3);
                String ramSp = rs.getString(4);
                String romSP = rs.getString(5);
                String manHinh = rs.getString(6);
                int soLuongTon = rs.getInt(7);
                long giaBan = rs.getLong(8);
                String id = rs.getString(9);
                long giaNhap = rs.getLong(10);

                QLCTSanPham qlSp = new QLCTSanPham();
                qlSp.setId(id);
                qlSp.setAnh(anh);
                qlSp.setTenSP(tenSp);
                qlSp.setLoai(loaiSp);
                qlSp.setRam(ramSp);
                qlSp.setRom(romSP);
                qlSp.setManhinh(manHinh);
                qlSp.setSoLuong(soLuongTon);
                qlSp.setGiaBan(giaBan);
                qlSp.setGiaNhap(giaNhap);

                listSP.add(qlSp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }

    @Override
    public Boolean add(ChiTietSanPham ctsp) {
        String sql = "INSERT INTO ChiTietSP(IdSP, IdMauSac, IdChipse, IdPin, IdPhanLoaiHang, IdRam, IdRom,\n"
                + "   IdManHinh, IdCamera, IdXuatXu, IdDongSP, GiaNhap, GiaBan, NamBH, MoTa, SoLuongTon, TrangThai, Anh)\n"
                + "   VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, ctsp.getIdSP());
            ps.setObject(2, ctsp.getIdMauSac());
            ps.setObject(3, ctsp.getIdChipse());
            ps.setObject(4, ctsp.getIdPin());
            ps.setObject(5, ctsp.getIdPhanLoaiHang());
            ps.setObject(6, ctsp.getIdRam());
            ps.setObject(7, ctsp.getIdRom());
            ps.setObject(8, ctsp.getIdManHinh());
            ps.setObject(9, ctsp.getIdCamera());
            ps.setObject(10, ctsp.getIdXuatXu());
            ps.setObject(11, ctsp.getIdDongSP());
            ps.setObject(12, ctsp.getGiaNhap());
            ps.setObject(13, ctsp.getGiaBan());
            ps.setObject(14, ctsp.getNamBH());
            ps.setObject(15, ctsp.getMoTa());
            ps.setObject(16, ctsp.getSoLuongTon());
            ps.setObject(17, ctsp.getTrangThai());
            ps.setObject(18, ctsp.getAnh());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi insert");
        }

        return null;
    }

    @Override
    public Boolean update(ChiTietSanPham ctsp, String id) {
        String sql = "UPDATE ChiTietSp SET IdSP = ?, IdMauSac = ?, IdChipse = ?, IdPin = ?, IdPhanLoaiHang = ?,"
                + " IdRam = ?, IdRom = ?, IdManHinh = ?, IdCamera = ?, IdXuatXu = ?, IdDongSp = ?, GiaNhap = ?, "
                + " GiaBan = ?, NamBH = ?, MoTa = ?, SoLuongTon = ?, TrangThai = ?, Anh = ? WHERE Id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, ctsp.getIdSP());
            ps.setObject(2, ctsp.getIdMauSac());
            ps.setObject(3, ctsp.getIdChipse());
            ps.setObject(4, ctsp.getIdPin());
            ps.setObject(5, ctsp.getIdPhanLoaiHang());
            ps.setObject(6, ctsp.getIdRam());
            ps.setObject(7, ctsp.getIdRom());
            ps.setObject(8, ctsp.getIdManHinh());
            ps.setObject(9, ctsp.getIdCamera());
            ps.setObject(10, ctsp.getIdXuatXu());
            ps.setObject(11, ctsp.getIdDongSP());
            ps.setObject(12, ctsp.getGiaNhap());
            ps.setObject(13, ctsp.getGiaBan());
            ps.setObject(14, ctsp.getNamBH());
            ps.setObject(15, ctsp.getMoTa());
            ps.setObject(16, ctsp.getSoLuongTon());
            ps.setObject(17, ctsp.getTrangThai());
            ps.setObject(18, ctsp.getAnh());
            ps.setObject(19, id);

            check = ps.executeUpdate();

            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update loi");
        }
        return null;
    }

    @Override
    public Boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietSanPham> all() {
        ArrayList<ChiTietSanPham> getAll = new ArrayList<>();
        String sql = "select * from chitietsp";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                getAll.add(new ChiTietSanPham(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getLong(13),
                        rs.getLong(14), rs.getInt(15), rs.getString(16), rs.getInt(17), rs.getInt(18), rs.getString(19)));
            }
            return getAll;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select all");
        }

        return null;
    }

    public static void main(String[] args) {
        CtSanPhamRepo c = new CtSanPhamRepo();
        System.out.println(c.all());
    }
}
