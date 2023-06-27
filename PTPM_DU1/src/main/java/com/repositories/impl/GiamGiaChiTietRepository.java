/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.IGGCTRepository;
import com.viewmodel.QLGiamGiaChiTiet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class GiamGiaChiTietRepository implements IGGCTRepository {

    public void insert(QLGiamGiaChiTiet qlggct) {
        String sql = "INSERT INTO GIAMGIACHITIET(idChiTietSP,idGiamGia,soTienConLai) values(?,?,?)";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, qlggct.getIdChiTietSP());
            ps.setString(2, qlggct.getIdGiamGia());
            ps.setLong(3, qlggct.getSoTienConLai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(String idSP, String idGG, Long qlggct) {
        String sql = "update GiamGiaChiTiet set IdChiTietSP  = ?, SoTienConLai = ? where Id  = ? ";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSP);
            ps.setString(3, idGG);
            ps.setLong(2, qlggct);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean check(String idCTSP) {
        String sql = "select Id\n"
                + "From ChiTietSP\n"
                + "where ? in (select IdChiTietSP from GiamGiaChiTiet)";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idCTSP);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
