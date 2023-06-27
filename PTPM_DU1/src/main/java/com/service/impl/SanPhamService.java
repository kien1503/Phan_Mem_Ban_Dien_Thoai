package com.service.impl;

import com.repositories.impl.SanPhamRepo;
import com.service.ISanPhamService;
import com.viewmodel.QLSanPham;
import com.model.SanPham;
import java.util.ArrayList;

public class SanPhamService implements ISanPhamService {

    private SanPhamRepo sPRp;
    private ArrayList<QLSanPham> listSp;

    public SanPhamService() {
        sPRp = new SanPhamRepo();
        listSp = new ArrayList<>();
    }

    @Override
    public ArrayList<QLSanPham> getList() {
        var sp = sPRp.all();
        for (SanPham x : sp) {
            listSp.add(new QLSanPham(x.getId(), x.getMa(), x.getTen()));
        }
        return listSp;
    }
}
