package com.service;

import com.model.HoaDonChiTiet;
import com.viewmodel.HoaDonChiTietViewModelTuan;
import com.viewmodel.ImeiDaBanView;
import java.util.ArrayList;
import java.util.List;

public interface IHoaDonCTSer {

    List<HoaDonChiTietViewModelTuan> getAll();

    List<HoaDonChiTietViewModelTuan> getOne(String id);

    List<ImeiDaBanView> listImei(String id);

    List<HoaDonChiTietViewModelTuan> listNoGiamGia(String id);

    Long soTienGiam(String idChiTietSP);

}
