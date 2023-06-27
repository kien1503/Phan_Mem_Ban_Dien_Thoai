package com.service;

import com.model.GiamGia;
import com.model.HoaDon;
import com.viewmodel.HoaDonView;
import java.util.ArrayList;
import java.util.Date;

public interface IHoaDonService {

    ArrayList<HoaDonView> listHoaDonView();

    Boolean add(HoaDon hd);

    Boolean update(HoaDon hd, String id);
    
    Boolean updateNoIdKhachHang(HoaDon hd, String id);

    Boolean delete(String id);
    
    ArrayList<GiamGia> listGiamGia(Date ngay, String ma);
}
