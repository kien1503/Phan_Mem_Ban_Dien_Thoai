package com.service.impl;

import com.repositories.impl.ChipSERepo;
import com.service.IChipService;
import com.viewmodel.QLChipSE;
import com.model.Chipse;
import java.util.ArrayList;

public class ChipSeService implements IChipService {

    private ChipSERepo chipRp;

    public ChipSeService() {
        chipRp = new ChipSERepo();
    }

    @Override
    public ArrayList<QLChipSE> getList() {
        ArrayList<QLChipSE> listChip = new ArrayList<>();

        var chip = chipRp.all();
        for (Chipse x : chip) {
            listChip.add(new QLChipSE(x.getId(), x.getMa(), x.getTen()));
        }
        return listChip;
    }

    @Override
    public void insert(Chipse chipse) {
        chipRp.insert(chipse);
    }

    @Override
    public void update(Chipse chipse, String id) {
        chipRp.update(chipse, id);
    }

    @Override
    public void delete(String id) {
        chipRp.delete(id);
    }
}
