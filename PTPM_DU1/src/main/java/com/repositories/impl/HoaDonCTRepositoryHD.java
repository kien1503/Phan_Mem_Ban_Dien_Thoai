package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.HoaDonChiTiet;
import com.repositories.IHoaDonCTRepositoryHD;
import com.viewmodel.HoaDonChiTietViewModelTuan;
import com.viewmodel.ImeiDaBanView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HoaDonCTRepositoryHD implements IHoaDonCTRepositoryHD {

    private Connection conn;

    public HoaDonCTRepositoryHD() {
        try {
            conn = DbConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HoaDonChiTietViewModelTuan> getAll() {
        List<HoaDonChiTietViewModelTuan> ds = new ArrayList<>();
        String sql = "select c.Ten,f.MaImei,SoLuong,b.GiaBan,e.SoTienGiam\n"
                + "from HoaDonChiTiet a join ChiTietSP b on a.IdChiTietSP = b.Id\n"
                + "join SanPham c on b.IdSP = c.Id\n"
                + "join GiamGiaChiTiet d on b.Id = d.IdChiTietSP\n"
                + "join GiamGia e on e.Id = d.IdGiamGia\n"
                + "join ImeiDaBan f on a.Id = f.idHoaDonCT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModelTuan hd = new HoaDonChiTietViewModelTuan();
                hd.setTenSP(rs.getString(1));
                hd.setImei(rs.getLong(2));
                hd.setSoLuong(rs.getInt(3));
                hd.setDonGia(rs.getLong(4));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public List<HoaDonChiTietViewModelTuan> getOne(String id) {
        List<HoaDonChiTietViewModelTuan> ds = new ArrayList<>();
        String sql = "select distinct sp.Ten, hdct.SoLuong,gg.GiamGiaTienMat,chitietsp.GiaBan, hdct.id\n"
                + "                from HoaDon hd join HoaDonChiTiet hdct on hd.id = hdct.IdHoaDon\n"
                + "                join ChiTietSP on hdct.idChiTietSp = ChiTietSP.id\n"
                + "                join SanPham sp on ChiTietSP.idSP = sp.Id\n"
                + "                join GiamGiaChiTiet ggct on ggct.IdChiTietSP = ChiTietSP.Id\n"
                + "                join GiamGia gg on ggct.IdGiamGia = gg.id\n"
                + "                where hd.Ma = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModelTuan hd = new HoaDonChiTietViewModelTuan();
                hd.setTenSP(rs.getString(1));
                hd.setSoLuong(rs.getInt(2));
                hd.setSale(rs.getLong(3));
                hd.setDonGia(rs.getLong(4));
                hd.setId(rs.getString(5));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public List<ImeiDaBanView> getOneHDct(String id) {
        ArrayList<ImeiDaBanView> listImeiDaBan = new ArrayList<>();
        String sql = "select  ImeiDaBan.MaImei, SanPham.Ten from HoaDonChiTiet hdct \n"
                + "join ImeiDaBan on hdct.id = ImeiDaBan.idHoaDonCT\n"
                + "join ChiTietSP on hdct.IdChiTietSP = ChiTietSP.Id\n"
                + "join SanPham on ChiTietSP.IdSP = SanPham.Id\n"
                + "where hdct.id = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listImeiDaBan.add(new ImeiDaBanView(rs.getLong(1), rs.getString(2)));
            }
            return listImeiDaBan;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi getOne CTHD");
        }
        return null;
    }

    @Override
    public List<HoaDonChiTietViewModelTuan> listNoGiamGia(String idHoaDon) {
        List<HoaDonChiTietViewModelTuan> ds = new ArrayList<>();
        String sql = "select distinct sp.Ten, hdct.SoLuong, chitietsp.GiaBan, hdct.id, chitietsp.id\n"
                + "                from HoaDon hd join HoaDonChiTiet hdct on hd.id = hdct.IdHoaDon\n"
                + "                join ChiTietSP on hdct.idChiTietSp = ChiTietSP.id\n"
                + "                join SanPham sp on ChiTietSP.idSP = sp.Id\n"
                + "                where hd.Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTietViewModelTuan hd = new HoaDonChiTietViewModelTuan();
                hd.setTenSP(rs.getString(1));
                hd.setSoLuong(rs.getInt(2));
                hd.setDonGia(rs.getLong(3));
                hd.setId(rs.getString(4));
                hd.setIdChiTietSP(rs.getString(5));
                ds.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    @Override
    public Long soTienGiam(String id) {
        String sql = "select giamgia.giamgiatienmat, giamgia.giamGiaphantram from GiamGiaChiTiet ggct \n"
                + "join giamgia on ggct.IdGiamGia = giamgia.id\n"
                + "join ChiTietSP on ggct.IdChiTietSP = ChiTietSP.Id\n"
                + "where ChiTietSP.id = ? ";
        Long tienGiamGia = 0l;
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long giamGia1 = rs.getLong(1);
                Long giamGia2 = rs.getLong(2);
                if (giamGia1 == 0l) {
                    tienGiamGia = giamGia2;
                } else {
                    tienGiamGia = giamGia1;
                }
            }
            return tienGiamGia;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("select Loi repo dong 139");
        }

        return null;
    }

}
