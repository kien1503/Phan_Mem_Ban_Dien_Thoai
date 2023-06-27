package com.service;

import com.model.HoaDonChiTiet;
import com.viewmodel.GioHangChiTiet;
import java.util.ArrayList;

public interface IChiTietHdService {

    ArrayList<GioHangChiTiet> getListGioHang();

    ArrayList<GioHangChiTiet> getListGioHangToIdHoaDon(String id);

    Boolean add(HoaDonChiTiet hdct);

    String idHdct(String idHoaDon, String idChiTiet);

    GioHangChiTiet ghct(Long imei);
}
