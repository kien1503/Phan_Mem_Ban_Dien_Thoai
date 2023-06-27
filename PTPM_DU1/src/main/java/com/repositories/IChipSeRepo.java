package com.repositories;

import com.model.Chipse;
import java.util.ArrayList;


public interface IChipSeRepo {
    void insert(Chipse chip);
    void update(Chipse chip, String maChip);
    void delete(String maChip);
    ArrayList<Chipse>all();
}
