package com.service.impl;

import com.repositories.impl.ImeiRepo;
import com.service.IImeiService;
import com.viewmodel.QLImeil;
import com.model.Imei;
import java.util.ArrayList;

public class ImeiService implements IImeiService {

    private ImeiRepo imeiRp;

    public ImeiService() {
        imeiRp = new ImeiRepo();
    }

    @Override
    public ArrayList<Imei> getList(String idChiTietSp) {
        return imeiRp.all(idChiTietSp);
    }

    @Override
    public Boolean add(Imei imei) {
        imeiRp.insert(imei);
        return null;
    }

    @Override
    public int count(String imei) {
        return imeiRp.count(imei);
    }

    @Override
    public Boolean updateTrangThai(int trangThai, Long maImei) {
        return imeiRp.updateTrangThai(trangThai, maImei);
    }

    @Override
    public Long searchImei(Long imei, String idChiTietSP, int i) {
        return imeiRp.searchImei(imei, idChiTietSP, i);
    }
}
