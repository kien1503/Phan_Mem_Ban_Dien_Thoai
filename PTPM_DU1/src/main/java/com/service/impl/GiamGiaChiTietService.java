package com.service.impl;

import com.repositories.impl.GiamGiaChiTietRepository;
import com.viewmodel.QLGiamGiaChiTiet;

public class GiamGiaChiTietService {

    GiamGiaChiTietRepository giamGiaChiTietRepository = new GiamGiaChiTietRepository();

    public void insert(QLGiamGiaChiTiet qlggct) {
        giamGiaChiTietRepository.insert(qlggct);
    }

    public void update(String idSP, String idGG, long qlggct) {
        giamGiaChiTietRepository.update(idSP, idGG, qlggct);
    }

    public boolean check(String idCTSP) {
        return giamGiaChiTietRepository.check(idCTSP);
    }

}
