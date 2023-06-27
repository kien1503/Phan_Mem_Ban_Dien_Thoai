package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.XuatXu;
import com.repositories.IXuatXuRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class XuatXuRepo_1 implements IXuatXuRepo_1{

    private Connection conn;

    public XuatXuRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public XuatXu insert(XuatXu xuatXu) {
        String sql = "INSERT INTO XuatXu(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xuatXu.getMa());
            ps.setString(2, xuatXu.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return xuatXu;
    }

    @Override
    public void update(XuatXu xuatXu, String maXuatXu) {
        String sql = "UPDATE XuatXu SET Ten = ? WHERE Ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, xuatXu.getTen());
            ps.setString(2, maXuatXu);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maXuatXu) {
        String sql = "DELETE XuatXu WHERE Ma =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maXuatXu);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<XuatXu> all() {
        ArrayList<XuatXu> listXuatXu = new ArrayList<>();
        String sql = "SELECT * FROM XuatXu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listXuatXu.add(new XuatXu(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listXuatXu;
    }
}
