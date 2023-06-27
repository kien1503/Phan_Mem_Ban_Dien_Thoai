package com.service.impl;

import com.model.Rom;
import com.repositories.impl.RomRepo_1;
import com.service.IRomService_1;
import com.viewmodel.QLRom;
import java.util.ArrayList;

public class RomService_1 implements IRomService_1 {

    private RomRepo_1 romRp;
    private ArrayList<QLRom> listRom;

    public RomService_1() {
        romRp = new RomRepo_1();
        listRom = new ArrayList<>();
    }

    @Override
    public Rom insert(Rom x) {
       return this.romRp.insert(x);
    }

    @Override
    public void update(Rom x, String maRom) {
        this.romRp.update(x, maRom);
    }

    @Override
    public void delete(String maRom) {
        this.romRp.delete(maRom);
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
