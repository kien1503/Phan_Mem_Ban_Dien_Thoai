package com.service.impl;

import com.model.SanPham;
import com.repositories.impl.SanPhamRepo_1;
import com.service.ISanPhamService_1;
import com.viewmodel.QLSanPham;
import java.util.ArrayList;

public class SanPhamService_1 implements ISanPhamService_1{

    private SanPhamRepo_1 sPRp;
    private ArrayList<QLSanPham> listSp;

    public SanPhamService_1() {
        sPRp = new SanPhamRepo_1();
        listSp= new ArrayList<>();
    }

        @Override
    public SanPham insert(SanPham x) {
        return this.sPRp.insert(x);
    }

    @Override
    public void update(SanPham x, String maSP) {
        this.sPRp.update(x, maSP);
    }

    @Override
    public void delete(String maSP) {
        this.sPRp.delete(maSP);
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
