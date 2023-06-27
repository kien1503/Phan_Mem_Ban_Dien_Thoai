package com.repositories.impl;

import com.repositories.ISanPhamRepo;
import com.model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class SanPhamRepo implements ISanPhamRepo {

    private Connection conn;

    public SanPhamRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(SanPham sp) {
        String sql = "INSERT INTO SanPham(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(SanPham sp, String maSP) {
        String sql = "UPDATE SanPham SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sp.getTen());
            ps.setString(2, maSP);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maSP) {
        String sql = "DELETE SanPham WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSP);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<SanPham> all() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listSanPham.add(new SanPham(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
}
