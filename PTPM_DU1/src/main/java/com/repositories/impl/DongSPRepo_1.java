package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.DongSP;
import com.repositories.IDongSPRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class DongSPRepo_1 implements IDongSPRepo_1{

    private Connection conn;

    public DongSPRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public DongSP insert(DongSP dongSp){
        String sql = "INSERT INTO DongSp(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dongSp.getMa());
            ps.setString(2, dongSp.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dongSp;
    }
    @Override
    public void update(DongSP dongSp, String maDongSp){
        String sql = "UPDATE DongSp SET Ten = ? WHERE Ma = ?";
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
    public void delete(String maDongSp){
        String sql = "DELETE DongSp WHERE Ma =?";
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
