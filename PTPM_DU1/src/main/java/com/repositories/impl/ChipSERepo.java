package com.repositories.impl;

import com.repositories.IChipSeRepo;
import com.model.Chipse;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class ChipSERepo implements IChipSeRepo {

    private Connection conn;

    public ChipSERepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Chipse chip) {
        String sql = "INSERT INTO Chipse(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, chip.getMa());
            ps.setString(2, chip.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Chipse chip, String maChip) {
        String sql = "UPDATE ChipSe SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, chip.getTen());
            ps.setString(2, maChip);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String maChip) {
        String sql = "DELETE ChipSe WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maChip);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Chipse> all() {
        ArrayList<Chipse> listChip = new ArrayList<>();
        String sql = "SELECT * FROM Chipse";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listChip.add(new Chipse(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listChip;
    }
}
