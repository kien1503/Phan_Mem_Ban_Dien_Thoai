package com.service.impl;

import com.model.KhachHang;
import com.repositories.IKhachHangRepository;
import com.repositories.impl.KhachHangRepository;
import com.service.IKhachHangService;
import java.util.ArrayList;

public class KhachHangService implements IKhachHangService {
    
    private IKhachHangRepository iKhachHangRepository = new KhachHangRepository();
    
    @Override
    public ArrayList<KhachHang> listKhachHang() {
        return iKhachHangRepository.listKhachHang();
    }
    
    @Override
    public Boolean add(KhachHang kh) {
        return iKhachHangRepository.add(kh);
    }
    
    @Override
    public Boolean delete(String id) {
        return iKhachHangRepository.delete(id);
    }
    
    @Override
    public Boolean update(KhachHang kh, String id) {
        return iKhachHangRepository.update(kh, id);
    }
    
    @Override
    public KhachHang getKhToSdt(String sdt) {
        return iKhachHangRepository.getKhToSdt(sdt);
    }
    
    @Override
    public Boolean soLanMua(int soLanMua, String id) {
        return iKhachHangRepository.updateSoLanMua(soLanMua, id);
    }
    
}
