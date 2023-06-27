package com.service.impl;

import com.repositories.impl.ThongKeRepostiory;
import com.service.IFthongkeService;
import com.viewmodel.ThongKeViewModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongkeService implements IFthongkeService {

    private ThongKeRepostiory tkr = new ThongKeRepostiory();

    public ArrayList<ThongKeViewModel> getAll() {
        return tkr.getAll();
    }

    public ArrayList<ThongKeViewModel> sapxepsldaban() {
        return tkr.sapxepsldaban();
    }

    public ArrayList<ThongKeViewModel> sreach(String ngaymin, String ngayMax) {
        return tkr.sreach(ngaymin, ngayMax);
    }

    @Override
    public ArrayList<ThongKeViewModel> sapxepslton() {
        return tkr.sapxepslton();
    }

    @Override
    public ArrayList<ThongKeViewModel> baoCao(LocalDate date) {
        return tkr.baoCao(date);
    }

    @Override
    public ArrayList<ThongKeViewModel> countSanPham() {
        return tkr.countSanPham();
    }

    @Override
    public ArrayList<ThongKeViewModel> doanhThu() {
        return tkr.doanhThu();
    }

    @Override
    public ArrayList<ThongKeViewModel> top5SanPham() {
        return tkr.top5SanPham();
    }

    @Override
    public ArrayList<ThongKeViewModel> searchKhoangNgayDoanhThu(Date dateMin, Date dateMax) {
        return tkr.searchKhoangNgayDoanhThu(dateMin, dateMax);
    }

    @Override
    public ArrayList<ThongKeViewModel> searchKhoangNgaySanPham(Date dateMin, Date dateMax) {
        return tkr.searchKhoangNgaySanPham(dateMin, dateMax);
    }

}
