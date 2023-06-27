package com.repositories;

import com.model.GiamGia;
import com.model.HinhThucThanhToan;
import com.model.HoaDon;
import com.viewmodel.HoaDonView;
import java.util.ArrayList;
import java.util.Date;

public interface IHoaDonRepository {

    ArrayList<HoaDonView> listHoaDonView();

    Boolean add(HoaDon hd);

    Boolean update(HoaDon hd, String id);

    Boolean updateNoIdKhachHang(HoaDon hd, String id);

    Boolean updateHDToTaiQuay(HoaDon hd, String id);

    Boolean updateHDToShipHang(HoaDon hd, String id);

    Boolean delete(String id);

    ArrayList<GiamGia> listGiamGia(Date ngayChon, String ma);

    Boolean updateHinhThucThanhToan(HinhThucThanhToan htth);

}
