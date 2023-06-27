package com.repositories;

import com.model.KhachHang;
import java.util.ArrayList;

public interface IKhachHangRepository {
    
    ArrayList<KhachHang> listKhachHang();
    
    Boolean add(KhachHang kh);
    
    Boolean delete(String id);
    
    Boolean update(KhachHang kh, String id);
    
    KhachHang getKhToSdt(String sdt);
    
    Boolean updateSoLanMua(int soLanMua, String id);
    
}
