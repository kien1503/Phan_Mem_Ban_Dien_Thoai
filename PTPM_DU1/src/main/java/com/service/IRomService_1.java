package com.service;

import com.model.Rom;
import com.viewmodel.QLRom;
import java.util.ArrayList;

public interface IRomService_1 {

    Rom insert(Rom x);
    void update(Rom x, String maRom);
    void delete(String maRom);
    ArrayList<QLRom> getList();
}
