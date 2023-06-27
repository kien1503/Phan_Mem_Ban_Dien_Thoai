package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.IFThongKeRepository;
import com.viewmodel.ThongKeViewModel;
import java.sql.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ThongKeRepostiory implements IFThongKeRepository {

    @Override
    public ArrayList<ThongKeViewModel> getAll() {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select HoaDon.Ma ,HoaDon.NgayThanhToan, SanPham.Ten, \n"
                + "HoaDonChiTiet.SoLuong ,HoaDonChiTiet.DonGia ,ChiTietSP.SoLuongTon\n"
                + "from HoaDon \n"
                + "join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "join SanPham on ChiTietSP.IdSP=SanPham.Id";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tk.add(new ThongKeViewModel(rs.getString(1), rs.getDate(2),
                        rs.getString(3), rs.getInt(4), rs.getLong(5), rs.getInt(6)));
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public ArrayList<ThongKeViewModel> sapxepsldaban() {
        ArrayList<ThongKeViewModel> tkv = new ArrayList<>();
        String sql = "select HoaDon.Ma ,HoaDon.NgayThanhToan ,SanPham.Ma, SanPham.Ten\n"
                + "          ,HoaDonChiTiet.SoLuong ,HoaDonChiTiet.DonGia ,ChiTietSP.SoLuongTon\n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon \n"
                + "            			join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id	\n"
                + "              			join SanPham on ChiTietSP.IdSP=SanPham.Id \n"
                + "						order by HoaDonChiTiet.SoLuong desc";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tkv.add(new ThongKeViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getInt(7)));

            }
            return tkv;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> sreach(String ngaymin, String ngayMax) {
        ArrayList<ThongKeViewModel> tkv1 = new ArrayList<>();
        String sql = "select HoaDon.Ma ,HoaDon.NgayThanhToan ,SanPham.Ma, SanPham.Ten\n"
                + "          , HoaDonChiTiet.SoLuong ,HoaDonChiTiet.DonGia ,ChiTietSP.SoLuongTon\n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon \n"
                + "            			join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id	\n"
                + "              			join SanPham on ChiTietSP.IdSP=SanPham.Id \n"
                + "where  HoaDon.NgayThanhToan>=? and HoaDon.NgayThanhToan<=? ";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, ngaymin);
            ps.setObject(2, ngayMax);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tkv1.add(new ThongKeViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getInt(7)));

            }
            return tkv1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> sapxepslton() {
        ArrayList<ThongKeViewModel> tkv2 = new ArrayList<>();
        String sql = "select HoaDon.Ma ,HoaDon.NgayThanhToan ,SanPham.Ma, SanPham.Ten\n"
                + "          ,HoaDonChiTiet.SoLuong ,HoaDonChiTiet.DonGia ,ChiTietSP.SoLuongTon\n"
                + "from HoaDon join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon \n"
                + "            			join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id	\n"
                + "              			join SanPham on ChiTietSP.IdSP=SanPham.Id \n"
                + "						order by ChiTietSP.SoLuongTon desc";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tkv2.add(new ThongKeViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getLong(6), rs.getInt(7)));

            }
            return tkv2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> baoCao(LocalDate date) {
        ArrayList<ThongKeViewModel> list = new ArrayList<>();
        String sql = "select HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia \n"
                + "from hoadonchitiet join hoadon on hoadonchitiet.idHoaDon = hoadon.id \n"
                + "where hoadon.ngaythanhtoan = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, date);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ThongKeViewModel(rs.getInt(1), rs.getLong(2)));
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi select");
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> listThongKe() {
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> countSanPham() {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select HoaDon.NgayThanhToan, sum(hoadonchitiet.soluong)\n"
                + "from HoaDon\n"
                + "        join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "        join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "        join SanPham on ChiTietSP.IdSP=SanPham.Id\n"
                + "GROUP BY HoaDon.NgayThanhToan\n"
                + "ORDER BY HoaDon.NgayThanhToan asc";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tkv = new ThongKeViewModel();

                tkv.setNgay(rs.getDate(1));
                tkv.setSldaban(rs.getInt(2));

                tk.add(tkv);
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> doanhThu() {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select HoaDon.NgayThanhToan, sum(hoadonchitiet.soluong * hoadonchitiet.dongia)\n"
                + "from HoaDon\n"
                + "        join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "        join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "        join SanPham on ChiTietSP.IdSP=SanPham.Id\n"
                + "GROUP BY HoaDon.NgayThanhToan\n"
                + "ORDER BY HoaDon.NgayThanhToan asc";
        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tkv = new ThongKeViewModel();

                tkv.setNgay(rs.getDate(1));
                tkv.setTongTien(rs.getLong(2));

                tk.add(tkv);
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> top5SanPham() {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select sanpham.Ten ,sum(hoadonchitiet.soluong)\n"
                + "from HoaDon\n"
                + "join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "join SanPham on ChiTietSP.IdSP=SanPham.Id\n"
                + "GROUP BY sanpham.ten\n";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tkv = new ThongKeViewModel();

                tkv.setTensp(rs.getString(1));
                tkv.setSldaban(rs.getInt(2));

                tk.add(tkv);
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) throws ParseException {
        ThongKeRepostiory tk = new ThongKeRepostiory();
        System.out.println("List: " + tk.top5SanPham());

    }

    @Override
    public ArrayList<ThongKeViewModel> searchKhoangNgayDoanhThu(Date dateMin, Date dateMax) {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select HoaDon.NgayThanhToan, sum(hoadonchitiet.soluong * hoadonchitiet.dongia)\n"
                + "from HoaDon\n"
                + "        join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "        join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "        join SanPham on ChiTietSP.IdSP=SanPham.Id\n"
                + "        WHERE HoaDon.NgayThanhToan BETWEEN ? AND ? \n"
                + "GROUP BY HoaDon.NgayThanhToan\n"
                + "ORDER BY HoaDon.NgayThanhToan asc";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, dateMin);
            ps.setObject(2, dateMax);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tkv = new ThongKeViewModel();

                tkv.setNgay(rs.getDate(1));
                tkv.setTongTien(rs.getLong(2));

                tk.add(tkv);
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<ThongKeViewModel> searchKhoangNgaySanPham(Date dateMin, Date dateMax) {
        ArrayList<ThongKeViewModel> tk = new ArrayList<>();
        String sql = "select HoaDon.NgayThanhToan, sum(hoadonchitiet.soluong)\n"
                + "from HoaDon\n"
                + "        join HoaDonChiTiet on HoaDon.Id=HoaDonChiTiet.IdHoaDon\n"
                + "        join ChiTietSP on HoaDonChiTiet.IdChiTietSP=ChiTietSP.Id\n"
                + "        join SanPham on ChiTietSP.IdSP=SanPham.Id\n"
                + "WHERE HoaDon.NgayThanhToan BETWEEN ? AND ? \n"
                + "GROUP BY HoaDon.NgayThanhToan\n"
                + "ORDER BY HoaDon.NgayThanhToan asc";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setObject(1, dateMin);
            ps.setObject(2, dateMax);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeViewModel tkv = new ThongKeViewModel();

                tkv.setNgay(rs.getDate(1));
                tkv.setSldaban(rs.getInt(2));

                tk.add(tkv);
            }
            return tk;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
