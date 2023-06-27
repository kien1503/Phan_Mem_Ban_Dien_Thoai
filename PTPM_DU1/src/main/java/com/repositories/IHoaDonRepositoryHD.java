package com.repositories;

import com.viewmodel.HoaDonViewModel;
import com.viewmodel.HoaDonViewModelTuan;
import java.util.List;

public interface IHoaDonRepositoryHD {

    List<HoaDonViewModelTuan> getAll();

    List<HoaDonViewModelTuan> search(String string);
    
    void update(String id, HoaDonViewModel hd);
    
    List<HoaDonViewModelTuan> sortPayDate();
    
    List<HoaDonViewModelTuan> sortName();
}
