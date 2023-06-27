/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.model.GiamGia;
import com.model.GiamGiaChiTiet;
import com.repositories.impl.GiamGiaChiTietRepository;
import com.repositories.impl.GiamGiaRepository;
import com.service.IGiamGiaService;
import com.viewmodel.QLGiamGia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GiamGiaService implements IGiamGiaService {

    GiamGiaRepository giamGiaRepository;
    List<GiamGia> listGiamGia;

    public GiamGiaService() {
        this.giamGiaRepository = new GiamGiaRepository();
        this.listGiamGia = new ArrayList<>();
    }

    @Override
    public List<QLGiamGia> getDanhSach() {
        return giamGiaRepository.all();
    }

    public GiamGia insert(GiamGia giamGia) {
        return giamGiaRepository.insert(giamGia);
    }

    public void update(String id, GiamGia giamGia) {
        giamGiaRepository.update(id, giamGia);
    }

    public void delete(String ma) {
        this.giamGiaRepository.delete(ma);
    }

    @Override
    public void updateDate() {
        this.giamGiaRepository.updateDate();
    }

    @Override
    public GiamGiaChiTiet ggct(String idGiamGia) {
        return giamGiaRepository.ggct(idGiamGia);
    }
}
