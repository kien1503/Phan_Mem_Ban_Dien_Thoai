package com.repositories;

import com.model.SanPham;
import java.util.ArrayList;


public interface ISanPhamRepo {
    void insert(SanPham sp);
    void update(SanPham sp, String maSP);
    void delete(String maSP);
    ArrayList<SanPham>all();
}
