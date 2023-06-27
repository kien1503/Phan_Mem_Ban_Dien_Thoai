package com.service;

import com.model.ChiTietSanPham;
import com.viewmodel.QLCTSanPham;
import java.util.ArrayList;

public interface ICTSanPhamService {

    ArrayList<QLCTSanPham> getList();

    ArrayList<ChiTietSanPham> getAll();

    Boolean add(ChiTietSanPham ctsp);

    Boolean update(ChiTietSanPham ctsp, String id);
}
