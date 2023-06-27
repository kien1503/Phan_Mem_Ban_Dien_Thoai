package com.service.impl;

import com.model.Pin;
import com.repositories.impl.PinRepo_1;
import com.service.IPinService_1;
import com.viewmodel.QLPIN;
import java.util.ArrayList;

public class PinService_1 implements IPinService_1 {

    private PinRepo_1 pinRp;
    private ArrayList<QLPIN> listPin;

    public PinService_1() {
        pinRp = new PinRepo_1();
        listPin = new ArrayList<>();
    }

    @Override
    public Pin insert(Pin x) {
        return this.pinRp.insert(x);
    }

    @Override
    public void update(Pin x, String maPin) {
        this.pinRp.update(x, maPin);
    }

    @Override
    public void delete(String maPin) {
        this.pinRp.delete(maPin);
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
