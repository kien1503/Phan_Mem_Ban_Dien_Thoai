package com.repositories;

import com.model.HoaDonChiTiet;
import com.viewmodel.GioHangChiTiet;
import java.util.ArrayList;

public interface IHoaDonCTRepository {

    ArrayList<GioHangChiTiet> getListGioHang();

    ArrayList<GioHangChiTiet> getListGioHangToIdHoaDon(String id);

    Boolean add(HoaDonChiTiet hdct);

    String listToIdHoaDonAndIdChiTietSP(String idHoaDon, String idChiTietSP);
    
    GioHangChiTiet ghct(Long imei);

}
