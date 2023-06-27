/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repositories;

import com.viewmodel.QLSanPhamDAT;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface ISanPhamRepository {

    ArrayList<QLSanPhamDAT> listSP();

    ArrayList<QLSanPhamDAT> getOne(String id);
}
