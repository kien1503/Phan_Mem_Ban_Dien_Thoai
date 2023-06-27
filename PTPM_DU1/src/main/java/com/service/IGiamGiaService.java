/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.model.GiamGia;
import com.model.GiamGiaChiTiet;
import com.viewmodel.QLGiamGia;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface IGiamGiaService {

    GiamGia insert(GiamGia giamGia);

    void update(String id, GiamGia giamGia);

    void delete(String ma);

    List<QLGiamGia> getDanhSach();

    void updateDate();

    GiamGiaChiTiet ggct(String idGiamGia);
}
