package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.ICTSanPhamRepo_1;
import com.viewmodel.QLCTSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CtSanPhamRepo_1 implements ICTSanPhamRepo_1 {

    private Connection conn;

    public CtSanPhamRepo_1() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<QLCTSanPham> seachSP(String tenSP) {
        ArrayList<QLCTSanPham> seachSp = new ArrayList<>();
        String sql = "SELECT SanPham.Ten, PhanLoaiHang.Ten, Ram.Ten, Rom.Ten, ManHinh.Ten, a.SoLuongTon, a.GiaBan"
                + " FROM ChiTietSP a join SanPham on a.IdSP = SanPham.id"
                + " join PhanLoaiHang on a.IdPhanLoaiHang = PhanLoaiHang.id"
                + " join Ram on a.IdRam = Ram.id"
                + " join Rom on a.IdRom = Rom.id"
                + " join ManHinh on a.IdManHinh = ManHinh.id"
                + " WHERE SanPham.Ten = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenSP);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tenSp = rs.getString("Ten");
                String loaiSp = rs.getString("Ten");
                String ramSp = rs.getString("Ten");
                String romSP = rs.getString("Ten");
                String manHinh = rs.getString("Ten");
                int soLuongTon = rs.getInt("SoLuongTon");
                long giaBan = rs.getLong("GiaBan");

                QLCTSanPham qlSp = new QLCTSanPham();
                qlSp.setTenSP(tenSp);
                qlSp.setLoai(loaiSp);
                qlSp.setRam(ramSp);
                qlSp.setRom(romSP);
                qlSp.setManhinh(manHinh);
                qlSp.setSoLuong(soLuongTon);
                qlSp.setGiaBan(giaBan);

                seachSp.add(qlSp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seachSp;
    }

    @Override
    public ArrayList<QLCTSanPham> all() {
        ArrayList<QLCTSanPham> listSP = new ArrayList<>();
        String sql = "Select SanPham.Ten, PhanLoaiHang.Ten, Ram.Ten, Rom.Ten, ManHinh.Ten, SoLuongTon, GiaBan\n"
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
                String tenSp = rs.getString("Ten");
                String loaiSp = rs.getString("Ten");
                String ramSp = rs.getString("Ten");
                String romSP = rs.getString("Ten");
                String manHinh = rs.getString("Ten");
                int soLuongTon = rs.getInt("SoLuongTon");
                long giaBan = rs.getLong("GiaBan");

                QLCTSanPham qlSp = new QLCTSanPham();
                qlSp.setTenSP(tenSp);
                qlSp.setLoai(loaiSp);
                qlSp.setRam(ramSp);
                qlSp.setRom(romSP);
                qlSp.setManhinh(manHinh);
                qlSp.setSoLuong(soLuongTon);
                qlSp.setGiaBan(giaBan);

                listSP.add(qlSp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public static void main(String[] args) {
        CtSanPhamRepo_1 bill = new CtSanPhamRepo_1();
        bill.all().forEach(s -> System.out.println(s.toString()));
    }
}
