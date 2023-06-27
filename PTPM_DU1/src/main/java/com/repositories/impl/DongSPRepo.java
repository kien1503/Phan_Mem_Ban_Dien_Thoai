package com.repositories.impl;

import com.repositories.IDongSPRepo;
import com.model.DongSP;
import com.model.ManHinh;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class DongSPRepo implements IDongSPRepo {

    private Connection conn;

    public DongSPRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(DongSP dongSp) {
        String sql = "INSERT INTO DongSp(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dongSp.getMa());
            ps.setString(2, dongSp.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(DongSP dongSp, String maDongSp) {
        String sql = "UPDATE DongSp SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dongSp.getTen());
            ps.setString(2, maDongSp);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maDongSp) {
        String sql = "DELETE DongSp WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDongSp);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<DongSP> all() {
        ArrayList<DongSP> listDongSP = new ArrayList<>();
        String sql = "SELECT * FROM DongSP";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listDongSP.add(new DongSP(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listDongSP;
    }
}
