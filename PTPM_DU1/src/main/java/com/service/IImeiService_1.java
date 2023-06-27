package com.service;

import com.model.Imei;
import com.viewmodel.QLImeil;
import java.util.ArrayList;

public interface IImeiService_1 {

    Imei insert(Imei x);
    void update(Imei x, String maImei);
    void delete(String maImei);
    ArrayList<QLImeil> getList();
}
