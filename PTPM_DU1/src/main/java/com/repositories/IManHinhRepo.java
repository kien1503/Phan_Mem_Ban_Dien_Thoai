package com.repositories;

import com.model.ManHinh;
import java.util.ArrayList;


public interface IManHinhRepo {
    void insert(ManHinh mh);
    void update(ManHinh mh, String maMH);
    void delete(String maMH);
    ArrayList<ManHinh>all();
}
