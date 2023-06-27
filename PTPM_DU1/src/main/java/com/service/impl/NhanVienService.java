/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.repositories.INhanVienRepository;
import com.repositories.impl.NhanVienRepository;
import com.service.INhanVienService;
import com.viewmodel.QLNhanVien;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienService implements INhanVienService {
    
    private INhanVienRepository nvr;
    
    public NhanVienService() {
        nvr = new NhanVienRepository();
    }
    
    @Override
    public List<QLNhanVien> getAll() {
        return nvr.getAll();
    }
    
    @Override
    public void insert(QLNhanVien nv) {
        nvr.insert(nv);
    }
    
    @Override
    public void update(String id, QLNhanVien nv) {
        nvr.update(id, nv);
    }
    
    @Override
    public void delete(String id) {
        nvr.delete(id);
    }
    
    @Override
    public List<QLNhanVien> search(String string) {
       return nvr.search(string);
    }
    
}
