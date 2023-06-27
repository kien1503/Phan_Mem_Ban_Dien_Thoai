package com.service;

import com.model.Chipse;
import com.viewmodel.QLChipSE;
import java.util.ArrayList;

public interface IChipService {

    ArrayList<QLChipSE> getList();
    
    void insert(Chipse chipse);
    
    void update(Chipse chipse, String id);
    
    void delete(String id);
}
