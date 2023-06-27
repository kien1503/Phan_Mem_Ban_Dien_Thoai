package com.service.impl;

import com.repositories.impl.RamRepo;
import com.service.IRamService;
import com.viewmodel.QLRam;
import com.model.Ram;
import java.util.ArrayList;

public class RamService implements IRamService {

    private RamRepo ramRp;
    private ArrayList<QLRam> listRam;

    public RamService() {
        ramRp = new RamRepo();
        listRam = new ArrayList<>();
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
