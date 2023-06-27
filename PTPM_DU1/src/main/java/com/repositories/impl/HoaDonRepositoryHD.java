/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.IHoaDonRepositoryHD;
import com.viewmodel.HoaDonViewModel;
import com.viewmodel.HoaDonViewModelTuan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonRepositoryHD implements IHoaDonRepositoryHD {

    private Connection conn;

    public HoaDonRepositoryHD() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDonViewModelTuan> getAll() {
        List<HoaDonViewModelTuan> ds = new ArrayList<>();
        String sql = "select a.Ma,c.Ten,c.Sdt,b.Ten,a.NgayTao,a.NgayThanhToan,"
                + "a.HinhThucThanhToan ,a.TinhTrang,a.GhiChu, a.Id \n"
                + "from HoaDon a join NhanVien b on a.IdNhanVien = b.Id\n"
                + "              join KhachHang c on a.IdKH = c.Id\n";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModelTuan hd = new HoaDonViewModelTuan();
                hd.setMa(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setSdtKH(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setNgayThanhToan(rs.getString(6));
                hd.setHinhThucThanhToan(rs.getInt(7));
                hd.setTinhTrang(rs.getInt(8));
                hd.setGhiChu(rs.getString(9));
                hd.setId(rs.getString(10));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static void main(String[] args) {
        HoaDonRepositoryHD hd = new HoaDonRepositoryHD();
        hd.getAll().forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public List<HoaDonViewModelTuan> search(String string) {
        List<HoaDonViewModelTuan> ds = new ArrayList<>();
        String sql = "select a.Ma,c.Ten,c.Sdt,b.Ten,a.NgayTao,a.NgayThanhToan,"
                + "a.HinhThucThanhToan,a.TinhTrang,a.GhiChu\n"
                + "from HoaDon a join NhanVien b on a.IdNhanVien = b.Id\n"
                + "join KhachHang c on a.IdKH = c.Id\n"
                + "where a.Ma like '%" + string + "%' or c.Ten like '%" + string + "%'";
        System.out.println(sql);
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModelTuan hd = new HoaDonViewModelTuan();
                hd.setId(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setSdtKH(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setNgayThanhToan(rs.getString(6));
                hd.setHinhThucThanhToan(rs.getInt(7));
                hd.setTinhTrang(rs.getInt(8));
                hd.setGhiChu(rs.getString(9));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public void update(String id, HoaDonViewModel hd) {
        String sql = "update HoaDon set NgayTao = ?, NgayThanhToan = ?, TinhTrang = ?, GhiChu = ?"
                + " where id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, hd.getNgayTao());
            ps.setString(2, hd.getNgayThanhToan());
            ps.setInt(3, hd.getTinhTrang());
            ps.setString(4, hd.getGhiChu());
            ps.setString(5, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<HoaDonViewModelTuan> sortPayDate() {
        List<HoaDonViewModelTuan> ds = new ArrayList<>();
        String sql = "select a.Ma,c.Ten,c.Sdt,b.Ten,a.NgayTao,a.NgayThanhToan,"
                + "a.HinhThucThanhToan ,a.TinhTrang,a.GhiChu\n"
                + "from HoaDon a join NhanVien b on a.IdNhanVien = b.Id\n"
                + "              join KhachHang c on a.IdKH = c.Id\n"
                + "order by a.NgayThanhToan desc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModelTuan hd = new HoaDonViewModelTuan();
                hd.setId(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setSdtKH(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setNgayThanhToan(rs.getString(6));
                hd.setHinhThucThanhToan(rs.getInt(7));
                hd.setTinhTrang(rs.getInt(8));
                hd.setGhiChu(rs.getString(9));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public List<HoaDonViewModelTuan> sortName() {
        List<HoaDonViewModelTuan> ds = new ArrayList<>();
        String sql = "select a.Ma,c.Ten,c.Sdt,b.Ten,a.NgayTao,a.NgayThanhToan,"
                + "a.HinhThucThanhToan ,a.TinhTrang,a.GhiChu\n"
                + "from HoaDon a join NhanVien b on a.IdNhanVien = b.Id\n"
                + "              join KhachHang c on a.IdKH = c.Id\n"
                + "order by c.Ten";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonViewModelTuan hd = new HoaDonViewModelTuan();
                hd.setId(rs.getString(1));
                hd.setTenKH(rs.getString(2));
                hd.setSdtKH(rs.getString(3));
                hd.setTenNV(rs.getString(4));
                hd.setNgayTao(rs.getString(5));
                hd.setNgayThanhToan(rs.getString(6));
                hd.setHinhThucThanhToan(rs.getInt(7));
                hd.setTinhTrang(rs.getInt(8));
                hd.setGhiChu(rs.getString(9));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
}
