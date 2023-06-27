package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.MauSac;
import com.repositories.IMauSacRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class MauSacRepo_1 implements IMauSacRepo_1 {

    private Connection conn;

    public MauSacRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MauSac insert(MauSac mauSac) {
        String sql = "INSERT INTO MauSac(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mauSac.getMa());
            ps.setString(2, mauSac.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    @Override
    public void update(MauSac mauSac, String maMau) {
        String sql = "UPDATE MauSac SET Ten = ? WHERE Ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mauSac.getTen());
            ps.setString(2, maMau);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maMau) {
        String sql = "DELETE MauSac WHERE Ma =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maMau);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<MauSac> all() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        String sql = "SELECT * FROM MauSac";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listMauSac.add(new MauSac(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMauSac;
    }
}
