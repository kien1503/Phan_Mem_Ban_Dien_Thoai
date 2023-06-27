/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.model.HoaDonChiTiet;
import com.repositories.IHoaDonCTRepositoryHD;
import com.repositories.impl.HoaDonCTRepositoryHD;
import com.service.IHoaDonCTSer;
import com.viewmodel.HoaDonChiTietViewModelTuan;
import com.viewmodel.ImeiDaBanView;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonCTSer implements IHoaDonCTSer {

    private IHoaDonCTRepositoryHD hd = new HoaDonCTRepositoryHD();

    @Override
    public List<HoaDonChiTietViewModelTuan> getAll() {
        return hd.getAll();
    }

    public static void main(String[] args) {
        HoaDonCTSer hd = new HoaDonCTSer();
        hd.getAll().forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public List<HoaDonChiTietViewModelTuan> getOne(String id) {
        return hd.getOne(id);
    }

    @Override
    public List<ImeiDaBanView> listImei(String id) {
        return hd.getOneHDct(id);
    }

    @Override
    public List<HoaDonChiTietViewModelTuan> listNoGiamGia(String id) {
        return hd.listNoGiamGia(id);
    }

    @Override
    public Long soTienGiam(String id) {
        return hd.soTienGiam(id);
    }

}
