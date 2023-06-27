package com.repositories;

import com.model.Anh;
import java.util.ArrayList;


public interface IAnhRepo {
    void insert(Anh img);
    void update(Anh img, String idImg);
    void delete(String idImg);
    ArrayList<Anh>all();
}
