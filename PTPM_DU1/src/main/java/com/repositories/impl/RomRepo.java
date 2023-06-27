package com.repositories.impl;

import com.repositories.IRomRepo;
import com.model.Rom;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class RomRepo implements IRomRepo {

    private Connection conn;

    public RomRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Rom rom) {
        String sql = "INSERT INTO Rom(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rom.getMa());
            ps.setString(2, rom.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Rom rom, String maRom) {
        String sql = "UPDATE Rom SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, rom.getTen());
            ps.setString(2, maRom);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maRom) {
        String sql = "DELETE Rom WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maRom);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Rom> all() {
        ArrayList<Rom> listRom = new ArrayList<>();
        String sql = "SELECT * FROM Rom";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listRom.add(new Rom(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listRom;
    }
}
