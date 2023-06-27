package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.KhachHang;
import com.repositories.IKhachHangRepository;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class KhachHangRepository implements IKhachHangRepository {

    private ArrayList<KhachHang> listKh;

    @Override
    public ArrayList<KhachHang> listKhachHang() {
        listKh = new ArrayList<>();
        String sql = "SELECT * FROM KhachHang";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listKh.add(new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10)));
            }
            return listKh;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select");
        }
        return null;
    }

    @Override
    public Boolean add(KhachHang kh) {
        String sql = "INSERT INTO KhachHang(Ma, Ten, Sdt, NgaySinh, DiaChi, GioiTinh, TrangThai, GhiChu, SoLanMua) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, kh.getMa());
            ps.setObject(2, kh.getTen());
            ps.setObject(3, kh.getSdt());
            ps.setObject(4, kh.getNgaySinh());
            ps.setObject(5, kh.getDiaChi());
            ps.setObject(6, kh.getGioiTinh());
            ps.setObject(7, kh.getTrangThai());
            ps.setObject(8, kh.getGhiChu());
            ps.setObject(9, kh.getSoLanMua());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi insert");
        }

        return null;
    }

    @Override
    public Boolean delete(String id) {
        String sql = "DELETE FROM KhachHang WHERE id = ?";
        int check = 0;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi delete");
        }

        return null;
    }

    @Override
    public Boolean update(KhachHang kh, String id) {
        String sql = "UPDATE KhachHang SET Ten=?, Sdt=?, NgaySinh=?, DiaChi=?, GioiTinh=?, GhiChu=?, SoLanMua=? "
                + "WHERE id = ?";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, kh.getTen());
            ps.setObject(2, kh.getSdt());
            ps.setObject(3, kh.getNgaySinh());
            ps.setObject(4, kh.getDiaChi());
            ps.setObject(5, kh.getGioiTinh());
            ps.setObject(6, kh.getGhiChu());
            ps.setObject(7, kh.getSoLanMua());
            ps.setObject(8, id);

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Update loi");
        }

        return null;
    }

    @Override
    public KhachHang getKhToSdt(String sdt) {
        String sql = "SELECT * FROM KhachHang where sdt = ?";
        KhachHang kh = null;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, sdt);
            ps.execute();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kh = new KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8), rs.getString(9), rs.getInt(10));
            }
            return kh;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select");
        }
        return null;
    }

    @Override
    public Boolean updateSoLanMua(int soLanMua, String id) {
        String sql = "UPDATE FROM KhachHang SET SoLanMua = ? WHERE Id = ?";
        int check = 0;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, soLanMua);
            ps.setObject(2, id);
            check = ps.executeUpdate();
            
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi select kh");
        }
        return null;
    }

    public static void main(String[] args) {
        KhachHangRepository kh = new KhachHangRepository();

        System.out.println(kh.getKhToSdt("0337970185"));
    }

}
