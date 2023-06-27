package com.service.impl;

import com.model.Ram;
import com.repositories.impl.RamRepo_1;
import com.service.IRamService_1;
import com.viewmodel.QLRam;
import java.util.ArrayList;

public class RamService_1 implements IRamService_1{

    private RamRepo_1 ramRp;
    private ArrayList<QLRam> listRam;

    public RamService_1() {
        ramRp = new RamRepo_1();
        listRam= new ArrayList<>();
    }

    @Override
    public Ram insert(Ram x) {
       return this.ramRp.insert(x);
    }

    @Override
    public void update(Ram x, String maRam) {
        this.ramRp.update(x, maRam);
    }

    @Override
    public void delete(String maRam) {
        this.ramRp.delete(maRam);
    }
    @Override
    public ArrayList<QLRam> getList() {
        var ram = ramRp.all();
        for (Ram x : ram) {
            listRam.add(new QLRam(x.getId(), x.getMa(), x.getTen()));
        }
        return listRam;
    }
}
