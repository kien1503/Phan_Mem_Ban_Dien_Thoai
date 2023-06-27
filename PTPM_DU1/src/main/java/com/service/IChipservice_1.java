package com.service;

import com.model.Chipse;
import com.viewmodel.QLChipSE;
import java.util.ArrayList;

public interface IChipservice_1 {

    Chipse insert(Chipse chip);

    void update(Chipse ship, String maChip);

    void delete(String maChip);

    ArrayList<QLChipSE> getList();
}
