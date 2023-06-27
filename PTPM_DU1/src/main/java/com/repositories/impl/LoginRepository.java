package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.viewmodel.QLTaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.repositories.ILogin;

public class LoginRepository implements ILogin {

    private Connection conn;

    public LoginRepository() {
        conn = DbConnection.getConnection();
    }

    @Override
    public QLTaiKhoan checkAccount(String sdt, String matKhau) {
        String sql = "select a.Id,Sdt,Email, MatKhau, b.Ten\n"
                + "                from NhanVien a join ChucVu b \n"
                + "                on a.IdChucVu = b.Id\n"
                + "                where Sdt = ? and MatKhau = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sdt);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                QLTaiKhoan tk = new QLTaiKhoan(rs.getString(1), sdt,
                        rs.getString(3), matKhau, rs.getString(5));
                System.out.println("Login Success");
                return tk;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
