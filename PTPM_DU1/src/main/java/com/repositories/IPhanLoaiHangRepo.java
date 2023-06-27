package com.repositories;

import com.model.PhanLoaiHang;
import java.util.ArrayList;


public interface IPhanLoaiHangRepo {
    void insert(PhanLoaiHang plHang);
    void update(PhanLoaiHang plHang, String maPL);
    void delete(String maPL);
    ArrayList<PhanLoaiHang>all();
}
