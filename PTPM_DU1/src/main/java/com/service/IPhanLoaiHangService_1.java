package com.service;

import com.model.PhanLoaiHang;
import com.viewmodel.QLPhanLoaiHang;
import java.util.ArrayList;

public interface IPhanLoaiHangService_1 {

    PhanLoaiHang insert(PhanLoaiHang x);

    void update(PhanLoaiHang x, String maPhanLoai);

    void delete(String maPhanLoai);

    ArrayList<QLPhanLoaiHang> getList();
}
