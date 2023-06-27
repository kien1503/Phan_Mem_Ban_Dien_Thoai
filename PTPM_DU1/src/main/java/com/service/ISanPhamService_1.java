package com.service;

import com.model.SanPham;
import com.viewmodel.QLSanPham;
import java.util.ArrayList;

public interface ISanPhamService_1 {

    SanPham insert(SanPham x);

    void update(SanPham x, String maSP);

    void delete(String maSP);

    ArrayList<QLSanPham> getList();
}
