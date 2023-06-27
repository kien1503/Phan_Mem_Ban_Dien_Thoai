package com.service.impl;

import com.model.ChiTietSanPham;
import com.service.ICTSanPhamService;
import com.repositories.impl.CtSanPhamRepo;
import com.viewmodel.QLCTSanPham;
import java.util.ArrayList;
import com.repositories.ICTSanPhamRepo;

public class CTSanPhamService implements ICTSanPhamService {

    private ICTSanPhamRepo ctspService;

    public CTSanPhamService() {
        ctspService = new CtSanPhamRepo();
    }

    @Override
    public ArrayList<QLCTSanPham> getList() {
        return ctspService.view();
    }

    @Override
    public Boolean add(ChiTietSanPham ctsp) {
        return ctspService.add(ctsp);
    }

    @Override
    public Boolean update(ChiTietSanPham ctsp, String id) {
        return ctspService.update(ctsp, id);
    }

    @Override
    public ArrayList<ChiTietSanPham> getAll() {
        return ctspService.all();
    }

}
