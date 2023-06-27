package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.ManHinh;
import com.repositories.IManHinhRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class ManHinhRepo_1 implements IManHinhRepo_1{

    private Connection conn;

    public ManHinhRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ManHinh insert(ManHinh mh){
        String sql = "INSERT INTO ManHinh(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mh.getMa());
            ps.setString(2, mh.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mh;
    }
    @Override
    public void update(ManHinh mh, String maMH){
        String sql = "UPDATE ManHinh SET Ten = ? WHERE Ma = ?";
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
    public void delete(String maMH){
        String sql = "DELETE ManHinh WHERE Ma =?";
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
