package com.repositories.impl;

import com.repositories.IImeiRepo;
import com.viewmodel.QLCTSanPham;
import com.model.Imei;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class ImeiRepo implements IImeiRepo {

    private Connection conn;

    public ImeiRepo() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Imei imei) {
        String sql = "INSERT INTO Imei(SoImei, TrangThai, idChiTietSP) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, imei.getSoImei());
            ps.setInt(2, imei.getTrangThai());
            ps.setObject(3, imei.getIdChiTietSP());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("them that bai");
        }

    }

    @Override
    public void update(Imei imei, String maImei) {
        String sql = "UPDATE Imei SET SoImei = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, imei.getSoImei());
            ps.setString(2, maImei);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maImei) {
        String sql = "DELETE Imei WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maImei);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Imei> all(String idChiTietSp) {
        ArrayList<Imei> listImei = new ArrayList<>();
        String sql = "SELECT * FROM Imei where idChiTietSp = ? AND TrangThai = 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idChiTietSp);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listImei.add(new Imei(rs.getString(1), rs.getLong(2), rs.getInt(3), rs.getString(4)));
            }
            return listImei;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Loi select");
        }
        return null;
    }

    @Override
    public int count(String anh) {
        String sql = "select COUNT(anh) from ChiTietSP where anh = ?";
        int check = 0;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, anh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                check = rs.getInt(1);
            }
            return check;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("San pham da ton tai");
        }

        return 1;
    }

    @Override
    public Boolean updateTrangThai(int trangThai, Long maImei) {
        String sql = "UPDATE Imei SET TrangThai = ? Where soImei = ?";
        int check = 0;

        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, trangThai);
            ps.setObject(2, maImei);
            check = ps.executeUpdate();

            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi update imei");
        }

        return null;
    }

    @Override
    public Long searchImei(Long imei, String idChiTietSP, int i) {
        String sql = "SELECT SoImei FROM Imei where SoImei = ? and IdChiTietSP = ? and TrangThai = ?";
        Long soImei = 0l;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, imei);
            ps.setObject(2, idChiTietSP);
            ps.setObject(3, i);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soImei = rs.getLong(1);
            }
            return soImei;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi search imei");
        }
        return null;
    }

}
