package com.repositories.impl;

import com.repositories.IPinRepo;
import com.model.Pin;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class PinRepo implements IPinRepo {

    private Connection conn;

    public PinRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Pin pin) {
        String sql = "INSERT INTO Pin(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pin.getMa());
            ps.setString(2, pin.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Pin pin, String maPin) {
        String sql = "UPDATE Pin SET Ten = ? WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pin.getTen());
            ps.setString(2, maPin);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maPin) {
        String sql = "DELETE Pin WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maPin);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Pin> all() {
        ArrayList<Pin> listPin = new ArrayList<>();
        String sql = "SELECT * FROM Pin";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listPin.add(new Pin(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listPin;
    }
}
