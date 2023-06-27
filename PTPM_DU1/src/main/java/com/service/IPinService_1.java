package com.service;

import com.model.Pin;
import com.viewmodel.QLPIN;
import java.util.ArrayList;


public interface IPinService_1 {
    Pin insert(Pin x);
    void update(Pin x, String maPin);
    void delete(String maPin);
   ArrayList<QLPIN> getList(); 
}
