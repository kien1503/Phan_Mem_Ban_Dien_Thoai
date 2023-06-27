package com.service.impl;


import com.repositories.impl.DongSPRepo;
import com.service.IDongSpService;
import com.viewmodel.QLDongSp;
import com.model.DongSP;
import java.util.ArrayList;

public class DongSPService implements IDongSpService{

    private DongSPRepo dongSPRp;
    private ArrayList<QLDongSp> listDongSP;

    public DongSPService() {
        dongSPRp = new DongSPRepo();
        listDongSP = new ArrayList<>();
    }

    @Override
    public ArrayList<QLDongSp> getList() {
        var dongSp = dongSPRp.all();
        for (DongSP x : dongSp) {
            listDongSP.add(new QLDongSp(x.getId(), x.getMa(), x.getTen()));
        }
        return listDongSP;
    }
}
