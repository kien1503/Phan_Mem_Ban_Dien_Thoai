package com.repositories.impl;

import com.dbcontext.DbConnection;
import com.model.ImeiDaBan;
import com.repositories.IImeiDaBanRepository;
import java.sql.*;

public class ImeiDaBanRepository implements IImeiDaBanRepository {

    @Override
    public Boolean add(ImeiDaBan imeiDaBan) {
        String sql = "INSERT INTO ImeiDaBan(MaImei, TrangThai, IdHoaDonCT) VALUES(?, ?, ?)";
        int check = 0;

        try {
            Connection conn = DbConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, imeiDaBan.getMaImei());
            ps.setObject(2, imeiDaBan.getTrangThai());
            ps.setObject(3, imeiDaBan.getIdHoaDonCT());

            check = ps.executeUpdate();
            return check > 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi insert");
        }

        return null;
    }

}
