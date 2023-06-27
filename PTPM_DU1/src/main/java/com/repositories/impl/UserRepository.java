package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.User;
import com.repositories.IUserRepository;
import java.util.ArrayList;
import java.sql.*;

public class UserRepository implements IUserRepository {

    @Override
    public User user(String username, String pass) {
        User u = new User();
        String sql = "SELECT * FROM dbo.[USER] WHERE Username = ? AND Pass = ?";

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, username);
            ps.setObject(2, pass);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u.setId(rs.getString(1));
                u.setUser(rs.getString(2));
                u.setPassWord(rs.getString(3));
                u.setIdNhanVien(rs.getString(4));
                u.setChucVu(rs.getString(5));

            }
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi cau lenh select");
        }
        return null;
    }

    public static void main(String[] args) {
        UserRepository u = new UserRepository();
        System.out.println(u.user("a", "s"));
    }
    
}
