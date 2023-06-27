package com.repositories;

import com.model.Imei;
import java.util.ArrayList;

public interface IImeiRepo {

    void insert(Imei imei);

    void update(Imei imei, String maImei);

    void delete(String maImei);

    ArrayList<Imei> all(String idChiTietSp);

    int count(String anh);

    Boolean updateTrangThai(int trangThai, Long maImei);
    
    Long searchImei(Long imei, String idChiTietSP, int i);
}
