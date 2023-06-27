package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.Ram;
import com.repositories.IRamRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class RamRepo_1 implements IRamRepo_1{

    private Connection conn;

    public RamRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ram insert(Ram ram) {
        String sql = "INSERT INTO Ram(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getMa());
            ps.setString(2, ram.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ram;
    }

    @Override
    public void update(Ram ram, String maRam) {
        String sql = "UPDATE Ram SET Ten = ? WHERE Ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ram.getTen());
            ps.setString(2, maRam);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maRam) {
        String sql = "DELETE Ram WHERE Ma =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maRam);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Ram> all() {
        ArrayList<Ram> listRam = new ArrayList<>();
        String sql = "SELECT * FROM Ram";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listRam.add(new Ram(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRam;
    }
}
