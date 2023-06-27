package com.service;

import com.model.KhachHang;
import java.util.ArrayList;

public interface IKhachHangService {

    ArrayList<KhachHang> listKhachHang();

    Boolean add(KhachHang kh);

    Boolean delete(String id);

    Boolean update(KhachHang kh, String id);

    KhachHang getKhToSdt(String sdt);
    
    Boolean soLanMua(int soLanMua, String id);

}
