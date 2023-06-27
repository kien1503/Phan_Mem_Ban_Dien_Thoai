package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.Pin;
import com.repositories.IPinRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class PinRepo_1 implements IPinRepo_1 {

    private Connection conn;

    public PinRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Pin insert(Pin pin) {
        String sql = "INSERT INTO Pin(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pin.getMa());
            ps.setString(2, pin.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pin;
    }

    @Override
    public void update(Pin pin, String maPin) {
        String sql = "UPDATE Pin SET Ten = ? WHERE Ma = ?";
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
        String sql = "DELETE Pin WHERE Ma =?";
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
