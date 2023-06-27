package com.service.impl;

import com.model.Chipse;
import com.repositories.impl.ChipSERepo_1;
import com.viewmodel.QLChipSE;
import com.service.IChipservice_1;
import java.util.ArrayList;

public class ChipseService_1 implements IChipservice_1 {

    private ChipSERepo_1 chipRp;
    private ArrayList<QLChipSE> listChip;

    public ChipseService_1() {
        chipRp = new ChipSERepo_1();
        listChip = new ArrayList<>();
    }

    @Override
    public Chipse insert(Chipse chip) {
        return this.chipRp.insert(chip);
    }

    @Override
    public void update(Chipse ship, String maChip) {
        this.chipRp.update(ship, maChip);
    }

    @Override
    public void delete(String maChip) {
        this.chipRp.delete(maChip);
    }

    @Override
    public ArrayList<QLChipSE> getList() {
        var chip = chipRp.all();
        for (Chipse x : chip) {
            listChip.add(new QLChipSE(x.getId(), x.getMa(), x.getTen()));
        }
        return listChip;
    }
}
