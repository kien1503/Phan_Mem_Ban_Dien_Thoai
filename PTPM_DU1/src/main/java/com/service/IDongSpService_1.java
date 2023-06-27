package com.service;

import com.model.DongSP;
import com.viewmodel.QLDongSp;
import java.util.ArrayList;

public interface IDongSpService_1 {

    DongSP insert(DongSP dongSP);

    void update(DongSP dongSP, String maDongSP);

    void delete(String maDongSP);

    ArrayList<QLDongSp> getList();
}
