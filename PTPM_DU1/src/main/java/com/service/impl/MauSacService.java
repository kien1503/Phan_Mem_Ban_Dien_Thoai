package com.service.impl;

import com.repositories.impl.MauSacRepo;
import com.service.IMauSacService;
import com.viewmodel.QLMauSac;
import com.model.MauSac;
import java.util.ArrayList;

public class MauSacService implements IMauSacService {

    private MauSacRepo mauSacRp;
    private ArrayList<QLMauSac> listMau;

    public MauSacService() {
        mauSacRp = new MauSacRepo();
        listMau = new ArrayList<>();
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
