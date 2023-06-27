package com.repositories;

import com.model.ChiTietSanPham;
import com.viewmodel.QLCTSanPham;
import java.util.ArrayList;

public interface ICTSanPhamRepo {

    ArrayList<QLCTSanPham> view();

    ArrayList<ChiTietSanPham> all();

    Boolean add(ChiTietSanPham ctsp);

    Boolean update(ChiTietSanPham ctsp, String id);

    Boolean delete(String id);
}
