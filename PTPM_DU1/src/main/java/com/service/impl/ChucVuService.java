/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.repositories.IChucVuRepository;
import com.repositories.impl.ChucVuRepository;
import com.service.IChucVuService;
import com.viewmodel.QLChucVuViewModel;
import java.util.List;

public class ChucVuService implements IChucVuService {

    private IChucVuRepository cv;

    public ChucVuService() {
        cv = new ChucVuRepository();
    }

    @Override
    public List<QLChucVuViewModel> getAll() {
        return cv.getAll();
    }

    public static void main(String[] args) {
        ChucVuService cv =new ChucVuService();
        cv.getAll().forEach(s -> System.out.println(s.toString()));
    }
}
