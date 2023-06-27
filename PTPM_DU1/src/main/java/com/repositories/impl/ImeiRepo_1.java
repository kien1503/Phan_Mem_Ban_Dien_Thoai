package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.Imei;
import com.repositories.IImeiRepo_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImeiRepo_1 implements IImeiRepo_1 {

    private Connection conn;

    public ImeiRepo_1() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Imei insert(Imei imei){
        String sql = "INSERT INTO Imei(SoImei,TrangThai,IdChiTietSP) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, imei.getSoImei());
            ps.setObject(2, imei.getTrangThai());
            ps.setObject(3, imei.getIdChiTietSP());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imei;
    }
    @Override
    public void update(Imei imei, String maImei){
        String sql = "UPDATE Imei SET SoImei = ?,TrangThai = ?, IdChiTietSP = ? WHERE Ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, imei.getSoImei());
            ps.setInt(2, imei.getTrangThai());
            ps.setString(3, imei.getIdChiTietSP());
            ps.setString(4, maImei);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void delete(String maImei){
        String sql = "DELETE Imei WHERE Ma =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maImei);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public ArrayList<Imei> all() {
        ArrayList<Imei> listImei = new ArrayList<>();
        String sql = "SELECT * FROM Imei";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listImei.add(new Imei(rs.getString(1), rs.getLong(2), rs.getInt(3), rs.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listImei;
    }

    public static void main(String[] args) {
        ImeiRepo_1 repo = new ImeiRepo_1();
        System.out.println(repo.all());
    }

  
}
