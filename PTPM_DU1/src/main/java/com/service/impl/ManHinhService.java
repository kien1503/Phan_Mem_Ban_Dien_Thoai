package com.service.impl;

import com.repositories.impl.ManHinhRepo;
import com.service.IManHinhService;
import com.viewmodel.QLManHinh;
import com.model.ManHinh;
import java.util.ArrayList;

public class ManHinhService implements IManHinhService {

    private ManHinhRepo manHinhRp;
    private ArrayList<QLManHinh> listMh;

    public ManHinhService() {
        manHinhRp = new ManHinhRepo();
        listMh = new ArrayList<>();
    }

    @Override
    public ArrayList<QLManHinh> getList() {
        var mh = manHinhRp.all();
        for (ManHinh x : mh) {
            listMh.add(new QLManHinh(x.getId(), x.getMa(), x.getTen()));
        }
        return listMh;
    }
}
