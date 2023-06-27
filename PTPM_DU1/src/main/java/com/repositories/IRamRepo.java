package com.repositories;

import com.model.Ram;
import java.util.ArrayList;


public interface IRamRepo {
    void insert(Ram ram);
    void update(Ram ram, String maRam);
    void delete(String maRam);
    ArrayList<Ram>all();
}
