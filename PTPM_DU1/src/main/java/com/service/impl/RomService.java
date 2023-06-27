package com.service.impl;

import com.repositories.impl.RomRepo;
import com.service.IRomService;
import com.viewmodel.QLRom;
import com.model.Rom;
import java.util.ArrayList;

public class RomService implements IRomService {

    private RomRepo romRp;
    private ArrayList<QLRom> listRom;

    public RomService() {
        romRp = new RomRepo();
        listRom = new ArrayList<>();
    }

    @Override
    public ArrayList<QLRom> getList() {
        var rom = romRp.all();
        for (Rom x : rom) {
            listRom.add(new QLRom(x.getId(), x.getMa(), x.getTen()));
        }
        return listRom;
    }
}
