package com.service.impl;

import com.repositories.impl.PinRepo;
import com.service.IPinService;
import com.viewmodel.QLPIN;
import com.model.Pin;
import java.util.ArrayList;

public class PinService implements IPinService{

    private PinRepo pinRp;
    private ArrayList<QLPIN> listPin;

    public PinService() {
        pinRp = new PinRepo();
        listPin= new ArrayList<>();
    }

    @Override
    public ArrayList<QLPIN> getList() {
        var pin = pinRp.all();
        for (Pin x : pin) {
            listPin.add(new QLPIN(x.getId(), x.getMa(), x.getTen()));
        }
        return listPin;
    }
}
