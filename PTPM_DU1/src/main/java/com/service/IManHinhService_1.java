package com.service;

import com.model.ManHinh;
import com.viewmodel.QLManHinh;
import java.util.ArrayList;

public interface IManHinhService_1 {

    ManHinh insert(ManHinh x);

    void update(ManHinh x, String maMH);

    void delete(String maMH);

    ArrayList<QLManHinh> getList();
}
