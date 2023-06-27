package com.repositories;

import com.model.Rom;
import java.util.ArrayList;


public interface IRomRepo {
    void insert(Rom rom);
    void update(Rom rom, String maRom);
    void delete(String maRom);
    ArrayList<Rom>all();
}
