package com.repositories;

import com.model.HoaDonChiTiet;
import com.viewmodel.HoaDonChiTietViewModel;
import com.viewmodel.HoaDonChiTietViewModelTuan;
import com.viewmodel.ImeiDaBanView;
import java.util.List;

public interface IHoaDonCTRepositoryHD {

    List<HoaDonChiTietViewModelTuan> getAll();

    List<HoaDonChiTietViewModelTuan> getOne(String id);

    List<ImeiDaBanView> getOneHDct(String id);

    List<HoaDonChiTietViewModelTuan> listNoGiamGia(String idHoaDon);

    Long soTienGiam(String idChiTietSP);

}
