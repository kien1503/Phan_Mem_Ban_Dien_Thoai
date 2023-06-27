/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.NhanVien;
import com.repositories.INhanVienRepository;
import com.viewmodel.QLNhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository implements INhanVienRepository {

    private Connection conn;

    public NhanVienRepository() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<QLNhanVien> getAll() {
        List<QLNhanVien> ds = new ArrayList<>();
        String sql = "select a.Id,a.Ma,a.Ten,a.NgaySinh,a.DiaChi,a.Sdt,\n"
                + "a.Email,a.MatKhau,a.NgayTao,a.GhiChu,a.TrangThai,b.Ten\n"
                + "from NhanVien a join ChucVu b on a.IdChucVu = b.Id";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getString(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public void insert(QLNhanVien nv) {
        String sql = "insert into NhanVien(Ma,Ten,NgaySinh,DiaChi,Sdt,Email,MatKhau,NgayTao,GhiChu,TrangThai,IdChucVu)\n"
                + "values(?,?,?,?,?,?,?,GETDATE(),?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMa());
            ps.setString(2, nv.getTen());
            ps.setString(3, nv.getNgaySinh());
            ps.setString(4, nv.getDiaChi());
            ps.setString(5, nv.getSdt());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getMatKhau());
            ps.setString(8, nv.getGhiChu());
            ps.setInt(9, nv.getTrangThai());
            ps.setString(10, nv.getTenChucVu());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, QLNhanVien nv) {
        String sql = "update NhanVien set Ten = ?, NgaySinh = ?,DiaChi = ?, Sdt = ?,\n"
                + "MatKhau = ?,GhiChu = ?,TrangThai = ?,IdChucVu = ?\n"
                + "where Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getNgaySinh());
            ps.setString(3, nv.getDiaChi());
            ps.setString(4, nv.getSdt());
            ps.setString(5, nv.getMatKhau());
            ps.setString(6, nv.getGhiChu());
            ps.setInt(7, nv.getTrangThai());
            ps.setString(8, nv.getTenChucVu());
            ps.setString(9, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "delete NhanVien where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QLNhanVien> search(String string) {
        List<QLNhanVien> ds = new ArrayList<>();
        String sql = "select a.Id,a.Ma,a.Ten,a.NgaySinh,a.DiaChi,a.Sdt,\n"
                + "a.Email,a.MatKhau,a.NgayTao,a.GhiChu,a.TrangThai,b.Ten\n"
                + "from NhanVien a join ChucVu b on a.IdChucVu = b.Id\n"
                + "where a.Ma like '%"+string+"%' or a.ten like '%"+string+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new QLNhanVien(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getString(12)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

   
}
