package com.service.impl;

import com.model.MauSac;
import com.repositories.impl.MauSacRepo_1;
import com.service.IMauSacService_1;
import com.viewmodel.QLMauSac;
import java.util.ArrayList;

public class MauSacService_1 implements IMauSacService_1 {

    private MauSacRepo_1 mauSacRp;
    private ArrayList<QLMauSac> listMau;

    public MauSacService_1() {
        mauSacRp = new MauSacRepo_1();
        listMau = new ArrayList<>();
    }

    @Override
    public MauSac insert(MauSac x) {
        return this.mauSacRp.insert(x);
    }

    @Override
    public void update(MauSac x, String maMau) {
        this.mauSacRp.update(x, maMau);
    }

    @Override
    public void delete(String maMau) {
        this.mauSacRp.delete(maMau);
    }

    @Override
    public ArrayList<QLMauSac> getList() {
        var ms = mauSacRp.all();
        for (MauSac x : ms) {
            listMau.add(new QLMauSac(x.getId(), x.getMa(), x.getTen()));
        }
        return listMau;
    }
}
