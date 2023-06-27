package com.repositories.impl;

import com.repositories.IManHinhRepo;
import com.model.ManHinh;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class ManHinhRepo implements IManHinhRepo {

    private Connection conn;

    public ManHinhRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(ManHinh mh) {
        String sql = "INSERT INTO ManHinh(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mh.getMa());
            ps.setString(2, mh.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(ManHinh mh, String maMH) {
        String sql = "UPDATE ManHinh SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mh.getTen());
            ps.setString(2, maMH);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maMH) {
        String sql = "DELETE ManHinh WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maMH);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<ManHinh> all() {
        ArrayList<ManHinh> listManHinh = new ArrayList<>();
        String sql = "SELECT * FROM ManHinh";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listManHinh.add(new ManHinh(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listManHinh;
    }
}
