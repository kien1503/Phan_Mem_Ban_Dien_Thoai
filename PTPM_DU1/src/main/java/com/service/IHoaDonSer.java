/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.viewmodel.HoaDonViewModel;
import com.viewmodel.HoaDonViewModelTuan;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface IHoaDonSer {

    List<HoaDonViewModelTuan> getAll();

    List<HoaDonViewModelTuan> search(String string);

    void update(String id, HoaDonViewModel hd);

    List<HoaDonViewModelTuan> sortPayDate();

    List<HoaDonViewModelTuan> sortName();
}
