package com.repositories.impl;

import com.repositories.IPhanLoaiHangRepo;
import com.model.PhanLoaiHang;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class PhanLoaiHangRepo implements IPhanLoaiHangRepo {

    private Connection conn;

    public PhanLoaiHangRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(PhanLoaiHang plHang) {
        String sql = "INSERT INTO PhanLoaiHang(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, plHang.getMa());
            ps.setString(2, plHang.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(PhanLoaiHang plHang, String maPL) {
        String sql = "UPDATE PhanLoaiHang SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, plHang.getTen());
            ps.setString(2, maPL);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maPL) {
        String sql = "DELETE PhanLoaiHang WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPL);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<PhanLoaiHang> all() {
        ArrayList<PhanLoaiHang> listPhanLoaiHang = new ArrayList<>();
        String sql = "SELECT * FROM PhanLoaiHang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listPhanLoaiHang.add(new PhanLoaiHang(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPhanLoaiHang;
    }
}
