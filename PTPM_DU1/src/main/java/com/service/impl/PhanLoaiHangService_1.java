package com.service.impl;


import com.model.PhanLoaiHang;
import com.repositories.impl.PhanLoaiHangRepo_1;
import com.service.IPhanLoaiHangService_1;
import com.viewmodel.QLPhanLoaiHang;
import java.util.ArrayList;

public class PhanLoaiHangService_1 implements IPhanLoaiHangService_1{

    private PhanLoaiHangRepo_1 plRp;
    private ArrayList<QLPhanLoaiHang> listPL;

    public PhanLoaiHangService_1() {
        plRp = new PhanLoaiHangRepo_1();
        listPL= new ArrayList<>();
    }

        @Override
    public PhanLoaiHang insert(PhanLoaiHang x) {
       return this.plRp.insert(x);
    }

    @Override
    public void update(PhanLoaiHang x, String maPhanLoai) {
        this.plRp.update(x, maPhanLoai);
    }

    @Override
    public void delete(String maPhanLoai) {
        this.plRp.delete(maPhanLoai);
    }

    @Override
    public ArrayList<QLPhanLoaiHang> getList() {
        var pl = plRp.all();
        for (PhanLoaiHang x : pl) {
            listPL.add(new QLPhanLoaiHang(x.getId(), x.getMa(), x.getTen()));
        }
        return listPL;
    }
}
