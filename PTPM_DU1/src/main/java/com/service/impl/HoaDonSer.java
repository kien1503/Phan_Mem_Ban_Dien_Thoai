/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.repositories.IHoaDonCTRepositoryHD;
import com.repositories.IHoaDonRepositoryHD;
import com.repositories.impl.HoaDonRepositoryHD;
import com.service.IHoaDonSer;
import com.viewmodel.HoaDonViewModel;
import com.viewmodel.HoaDonViewModelTuan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonSer implements IHoaDonSer {

    private IHoaDonRepositoryHD hdr = new HoaDonRepositoryHD();

    @Override
    public List<HoaDonViewModelTuan> getAll() {
        return hdr.getAll();
    }

    @Override
    public List<HoaDonViewModelTuan> search(String string) {
        return hdr.search(string);
    }

    @Override
    public void update(String id, HoaDonViewModel hd) {
        hdr.update(id, hd);
    }

    @Override
    public List<HoaDonViewModelTuan> sortPayDate() {
        return hdr.sortPayDate();
    }

    @Override
    public List<HoaDonViewModelTuan> sortName() {
        return hdr.sortName();
    }

}
