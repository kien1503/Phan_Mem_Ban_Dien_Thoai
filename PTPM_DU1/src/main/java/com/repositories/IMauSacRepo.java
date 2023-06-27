package com.repositories;

import com.model.MauSac;
import java.util.ArrayList;


public interface IMauSacRepo {
    void insert(MauSac mauSac);
    void update(MauSac mauSac, String maMau);
    void delete(String maMau);
    ArrayList<MauSac>all();
}
