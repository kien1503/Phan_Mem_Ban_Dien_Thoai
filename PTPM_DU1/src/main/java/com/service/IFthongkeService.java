/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.service;

import com.viewmodel.ThongKeViewModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public interface IFthongkeService {

    ArrayList<ThongKeViewModel> getAll();

    ArrayList<ThongKeViewModel> sapxepsldaban();

    ArrayList<ThongKeViewModel> sapxepslton();

    ArrayList<ThongKeViewModel> sreach(String ngayMin, String ngayMax);

    ArrayList<ThongKeViewModel> baoCao(LocalDate date);

    ArrayList<ThongKeViewModel> countSanPham();

    ArrayList<ThongKeViewModel> doanhThu();

    ArrayList<ThongKeViewModel> top5SanPham();

    ArrayList<ThongKeViewModel> searchKhoangNgayDoanhThu(Date dateMin, Date dateMax);

    ArrayList<ThongKeViewModel> searchKhoangNgaySanPham(Date dateMin, Date dateMax);
}
