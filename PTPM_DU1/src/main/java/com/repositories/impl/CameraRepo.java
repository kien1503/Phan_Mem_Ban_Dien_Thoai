package com.repositories.impl;

import com.repositories.ICameraRepo;
import com.model.Camera;
import java.sql.*;
import java.util.ArrayList;
import com.dbcontext.DbConnection;

public class CameraRepo implements ICameraRepo {

    private Connection conn;

    public CameraRepo() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Camera cam) {
        String sql = "INSERT INTO Camera(Ma, Ten) VALUES (?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cam.getMa());
            ps.setString(2, cam.getTen());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Camera cam, String maCam) {
        String sql = "UPDATE Camera SET Ten = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cam.getTen());
            ps.setString(2, maCam);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        String sql = "DELETE Camera WHERE Id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Camera> all() {
        ArrayList<Camera> listCam = new ArrayList<>();
        String sql = "SELECT * FROM Camera";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listCam.add(new Camera(rs.getString(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listCam;
    }
}
