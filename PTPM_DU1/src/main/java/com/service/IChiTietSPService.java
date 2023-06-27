package com.service;

import com.viewmodel.ChiTietSpViewModel;
import java.util.ArrayList;

public interface IChiTietSPService {

    ArrayList<ChiTietSpViewModel> listChiTietSP();

    ArrayList<ChiTietSpViewModel> listChiTietSPToNameorMa(String tenOrMa);

    ChiTietSpViewModel getSoLuong(String id);

    Boolean update(int soLuong, String id);

    Long giamGia(String idChiTietSP);

}
