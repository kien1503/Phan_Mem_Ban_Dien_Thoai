package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.Camera;
import com.repositories.ICameraRepo_1;
import java.sql.*;
import java.util.ArrayList;

public class CameraRepo_1 implements ICameraRepo_1{

    private Connection conn;

    public CameraRepo_1() {

        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public Camera insert(Camera cam){
        String sql = "INSERT INTO Camera(Ma,Ten) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cam.getMa());
            ps.setString(2, cam.getTen());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cam;
    }
    @Override
    public void update(Camera cam, String maCam){
        String sql = "UPDATE Camera SET Ten = ? WHERE Ma = ?";
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
    public void delete(String maCam){
        String sql = "DELETE Camera WHERE Ten =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maCam);
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
