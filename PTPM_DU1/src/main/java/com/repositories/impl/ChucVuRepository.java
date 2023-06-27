/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.repositories.IChucVuRepository;
import com.viewmodel.QLChucVuViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChucVuRepository implements IChucVuRepository {

    private Connection conn;

    public ChucVuRepository() {
        conn = DbConnection.getConnection();
    }

    @Override
    public List<QLChucVuViewModel> getAll() {
        List<QLChucVuViewModel>  ds = new ArrayList<>();
        String sql = "select id,ten from chucvu";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ds.add(new QLChucVuViewModel(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

}
