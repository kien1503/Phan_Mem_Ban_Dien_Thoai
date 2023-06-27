package com.repositories;

import com.model.GiamGia;
import com.model.GiamGiaChiTiet;
import com.viewmodel.QLGiamGia;
import java.util.ArrayList;

public interface IGiamGiaRepository {

    GiamGia insert(GiamGia giamGia);

    void update(String id, GiamGia giamGia);

    void delete(String ma);

    ArrayList<QLGiamGia> all();

    void updateDate();
    
    GiamGiaChiTiet ggct(String idGiamGia);
}
