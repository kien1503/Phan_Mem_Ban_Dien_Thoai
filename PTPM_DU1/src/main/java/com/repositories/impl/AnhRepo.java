package com.repositories.impl;

import com.repositories.IAnhRepo;
import com.model.Anh;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class AnhRepo implements IAnhRepo{

    private Connection conn;

    public AnhRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void insert(Anh img){
        String sql = "INSERT INTO Anh(DuongDan) VALUES (?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, img.getDuongDanAnh());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public void update(Anh img, String idImg){
        String sql = "UPDATE Anh SET DuongDan = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, img.getDuongDanAnh());
            ps.setString(2, idImg);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void delete(String idImg){
        String sql = "DELETE Anh WHERE Id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(idImg);
            ps.setString(1, idImg);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    @Override
    public ArrayList<Anh> all() {
        ArrayList<Anh> listAnh = new ArrayList<>();
        String sql = "SELECT * FROM Anh";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listAnh.add(new Anh(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listAnh;
    }
}
