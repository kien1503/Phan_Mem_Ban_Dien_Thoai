package com.service.impl;


import com.model.DongSP;
import com.repositories.impl.DongSPRepo;
import com.repositories.impl.DongSPRepo_1;
import com.service.IDongSpService_1;
import com.viewmodel.QLDongSp;
import java.util.ArrayList;

public class DongSPService_1 implements IDongSpService_1{

    private DongSPRepo_1 dongSPRp;
    private ArrayList<QLDongSp> listDongSP;

    public DongSPService_1() {
        dongSPRp = new DongSPRepo_1();
        listDongSP = new ArrayList<>();
    }

     @Override
    public DongSP insert(DongSP dongSP){
        return this.dongSPRp.insert(dongSP);
    }
    @Override
    public void update(DongSP dongSP, String maDongSP){
        this.dongSPRp.update(dongSP, maDongSP);
    }
    @Override
    public void delete(String maDongSP){
        this.dongSPRp.delete(maDongSP);
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
