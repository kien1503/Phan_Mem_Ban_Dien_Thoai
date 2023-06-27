/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.repositories.ISanPhamRepository;
import com.repositories.impl.SanPhamRepositoryDAT;
import com.viewmodel.QLSanPhamDAT;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SanPhamServiceDAT {

    private ISanPhamRepository sanPhamRepository = new SanPhamRepositoryDAT();

    public ArrayList<QLSanPhamDAT> getList() {
        return sanPhamRepository.listSP();
    }
    
     public ArrayList<QLSanPhamDAT> getOne(String name) {
        return sanPhamRepository.getOne(name);
    }
}
