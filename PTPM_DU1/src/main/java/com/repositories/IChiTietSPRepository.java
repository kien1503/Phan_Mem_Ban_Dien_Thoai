package com.repositories;

import com.viewmodel.ChiTietSpViewModel;
import com.viewmodel.GiamGiaSanPhamView;
import java.util.ArrayList;

public interface IChiTietSPRepository {

    ArrayList<ChiTietSpViewModel> getListChiTietSp();

    ArrayList<ChiTietSpViewModel> listChiTietSpToNameOrMa(String tenOrMa);

    ChiTietSpViewModel getSoLuong(String id);

    Boolean update(int soLuong, String id);

    ArrayList<GiamGiaSanPhamView> getListGiamGia(String id);
    
    Long giamGia(String idChiTietSP);

//    ArrayList<>
}
