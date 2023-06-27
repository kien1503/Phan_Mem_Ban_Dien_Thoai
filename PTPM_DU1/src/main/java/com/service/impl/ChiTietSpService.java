package com.service.impl;

import com.repositories.IChiTietSPRepository;
import com.repositories.impl.ChiTietSPRepository;
import com.service.IChiTietSPService;
import com.viewmodel.ChiTietSpViewModel;
import java.util.ArrayList;

public class ChiTietSpService implements IChiTietSPService {

    private IChiTietSPRepository iChiTietSPRepository = new ChiTietSPRepository();

    @Override
    public ArrayList<ChiTietSpViewModel> listChiTietSP() {

        return iChiTietSPRepository.getListChiTietSp();
    }

    @Override
    public ChiTietSpViewModel getSoLuong(String id) {
        return iChiTietSPRepository.getSoLuong(id);
    }

    public static void main(String[] args) {
        ChiTietSpService c = new ChiTietSpService();

        System.out.println(c.listChiTietSP());
//        System.out.println(c.list());
    }

    @Override
    public Boolean update(int soLuong, String id) {
        return iChiTietSPRepository.update(soLuong, id);
    }

    @Override
    public ArrayList<ChiTietSpViewModel> listChiTietSPToNameorMa(String tenOrMa) {
        return iChiTietSPRepository.listChiTietSpToNameOrMa(tenOrMa);
    }

    @Override
    public Long giamGia(String idChiTietSP) {
        return iChiTietSPRepository.giamGia(idChiTietSP);
    }

}
