package com.repositories;

import com.model.Imei;
import java.util.ArrayList;


public interface IImeiRepo_1 {
    Imei insert(Imei imei);
    void update(Imei imei, String maImei);
    void delete(String maImei);
    ArrayList<Imei>all();
}
