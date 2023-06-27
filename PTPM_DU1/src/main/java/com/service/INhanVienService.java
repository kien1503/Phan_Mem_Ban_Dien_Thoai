/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.viewmodel.QLNhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface INhanVienService {
    List<QLNhanVien> getAll();

    void insert(QLNhanVien nv);

    void update(String id, QLNhanVien nv);

    void delete(String id);

    List<QLNhanVien> search(String string);
}
