package com.repositories;

import com.model.Anh;
import java.util.ArrayList;


public interface IAnhRepo_1 {
    Anh insert(Anh img);
    void update(Anh img, String idImg);
    void delete(String idImg);
    ArrayList<Anh>all();
}
