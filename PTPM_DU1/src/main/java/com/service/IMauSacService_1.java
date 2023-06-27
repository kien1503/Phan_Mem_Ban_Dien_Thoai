package com.service;

import com.model.MauSac;
import com.viewmodel.QLMauSac;
import java.util.ArrayList;

public interface IMauSacService_1 {

    MauSac insert(MauSac x);
    void update(MauSac x, String maMau);
    void delete(String maMau);
    ArrayList<QLMauSac> getList();
}
