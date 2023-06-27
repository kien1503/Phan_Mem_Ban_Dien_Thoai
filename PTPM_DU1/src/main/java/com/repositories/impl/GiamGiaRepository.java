/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.GiamGia;
import com.model.GiamGiaChiTiet;
import com.repositories.IGiamGiaRepository;
import com.viewmodel.QLGiamGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class GiamGiaRepository implements IGiamGiaRepository {

    Connection conn;

    public GiamGiaRepository() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GiamGia insert(GiamGia giamGia) {
        String sql = "INSERT INTO GIAMGIA(ma,tenCT,ngayTao,ngayBatDau,ngayKetThuc,giamGiaTienMat,trangThai) values(?,?,GETDATE(),?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, giamGia.getMa());
            ps.setString(2, giamGia.getTenCT());
            ps.setObject(3, giamGia.getNgayBatDau());
            ps.setObject(4, giamGia.getNgayKetThuc());
            ps.setObject(5, giamGia.getGiamGiaTienMat());
            ps.setInt(6, giamGia.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giamGia;
    }

    @Override
    public void update(String ma, GiamGia giamGia) {
        String sql = "update giamgia set tenCT=?,ngayBatDau=?,ngayKetThuc=?,giamGiaTienMat=?,trangThai=?" + " where ma=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, giamGia.getTenCT());
            ps.setObject(2, giamGia.getNgayBatDau());
            ps.setObject(3, giamGia.getNgayKetThuc());
            ps.setObject(4, giamGia.getGiamGiaTienMat());
            ps.setInt(5, giamGia.getTrangThai());
            ps.setString(6, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(String ma) {
        String sql = "Delete from giamgia where ma=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<QLGiamGia> all() {
        ArrayList<QLGiamGia> list = new ArrayList<>();
        try {
            Connection conn = DbConnection.getConnection();
            String sql = "select * from giamgia";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next() == true) {
                String id = rs.getString("id");
                String ma = rs.getString("ma");
                String tenCT = rs.getString("tenCT");
                Date ngayTao = rs.getDate("ngayTao");
                Date ngayBatDau = rs.getDate("ngayBatDau");
                Date ngayKetThuc = rs.getDate("ngayKetThuc");
                Long giamGiaTienMat = rs.getLong("giamGiaTienMat");
                int trangThai = rs.getInt("trangThai");
                QLGiamGia qlgg = new QLGiamGia(id, ma, tenCT, ngayTao, ngayBatDau, ngayKetThuc, null, giamGiaTienMat, -1, trangThai);
                list.add(qlgg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateDate() {
        String sql = "update GiamGia SET TrangThai = ? where NgayKetThuc < GETDATE()";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, 3);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public GiamGiaChiTiet ggct(String idGiamGia) {
        GiamGiaChiTiet ggct = new GiamGiaChiTiet();
        String sql = "select GiamGiaChiTiet.Id, GiamGiaChiTiet.IdChiTietSP, "
                + "         GiamGiaChiTiet.IdGiamGia, GiamGiaChiTiet.SoTienConLai \n"
                + "from GiamGiaChiTiet join giamgia on GiamGiaChiTiet.IdGiamGia = giamgia.id\n"
                + "where giamgia.id = ?";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idGiamGia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ggct = new GiamGiaChiTiet(rs.getString(1),
                        rs.getString(3), rs.getString(2), 0l, rs.getLong(4), 0);
            }
            return ggct;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi update");
        }

        return null;
    }

    public static void main(String[] args) {
        GiamGiaRepository g = new GiamGiaRepository();
        System.out.println(g.all());
    }
    
}
