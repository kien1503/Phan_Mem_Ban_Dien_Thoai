package com.repositories;

import com.model.Chipse;
import java.util.ArrayList;

public interface IChipSeRepo_1 {

    Chipse insert(Chipse chip);

    void update(Chipse chip, String maChip);

    void delete(String maChip);

    ArrayList<Chipse> all();
}
