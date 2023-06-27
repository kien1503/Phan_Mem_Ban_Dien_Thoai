/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.ISanPhamRepository;
import com.sun.mail.imap.Utility;
import com.viewmodel.QLSanPhamDAT;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class SanPhamRepositoryDAT implements ISanPhamRepository {

    public ArrayList<QLSanPhamDAT> listSP() {
        ArrayList<QLSanPhamDAT> list = new ArrayList<>();
        String sql = "select a.Id,b.Ten,b.Ma,a.giaBan\n"
                + "from ChiTietSP a join SanPham b\n"
                + "on a.IdSP = b.Id";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QLSanPhamDAT(rs.getString(1), rs.getString(3), rs.getString(2), rs.getLong(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

  

    public ArrayList<QLSanPhamDAT> getOne(String id) {
        ArrayList<QLSanPhamDAT> list = new ArrayList<>();
          String sql = "SELECT distinct c.id,d.Ten,d.Ma,c.GiaBan\n"
            + "from GiamGia a join GiamGiaChiTiet b on a.Id = b.IdGiamGia\n"
            + "               join ChiTietSP c on b.IdChiTietSP = c.Id\n"
            + "               join SanPham d on c.IdSP = d.Id\n"
            + "WHERE a.Ma = ?";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new QLSanPhamDAT(rs.getString(1), rs.getString(3), rs.getString(2), rs.getLong(4)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        SanPhamRepositoryDAT sp =new SanPhamRepositoryDAT();
        sp.listSP().forEach(s -> System.out.println(s.getGiaBan()));
    }
}
