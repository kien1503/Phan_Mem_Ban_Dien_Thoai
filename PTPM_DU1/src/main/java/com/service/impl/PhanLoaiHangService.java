package com.service.impl;

import com.repositories.impl.PhanLoaiHangRepo;
import com.service.IPhanLoaiHangService;
import com.viewmodel.QLPhanLoaiHang;
import com.model.PhanLoaiHang;
import java.util.ArrayList;

public class PhanLoaiHangService implements IPhanLoaiHangService {

    private PhanLoaiHangRepo plRp;
    private ArrayList<QLPhanLoaiHang> listPL;

    public PhanLoaiHangService() {
        plRp = new PhanLoaiHangRepo();
        listPL = new ArrayList<>();
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
