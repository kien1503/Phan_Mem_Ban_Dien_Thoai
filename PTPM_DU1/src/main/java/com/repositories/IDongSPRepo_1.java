package com.repositories;

import com.model.DongSP;
import java.util.ArrayList;


public interface IDongSPRepo_1 {
    DongSP insert(DongSP dongSp);
    void update(DongSP dongSp, String maDongSp);
    void delete(String maDongSp);
    ArrayList<DongSP>all();
}
