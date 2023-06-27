package com.service.impl;

import com.repositories.impl.XuatXuRepo;
import com.service.IXuatXuService;
import com.viewmodel.QLXuatXu;
import com.model.XuatXu;
import java.util.ArrayList;

public class XuatXuService implements IXuatXuService {

    private XuatXuRepo xuatXuRp;
    private ArrayList<QLXuatXu> listXuatXu;

    public XuatXuService() {
        xuatXuRp = new XuatXuRepo();
        listXuatXu = new ArrayList<>();
    }

    @Override
    public ArrayList<QLXuatXu> getList() {
        var xx = xuatXuRp.all();
        for (XuatXu x : xx) {
            listXuatXu.add(new QLXuatXu(x.getId(), x.getMa(), x.getTen()));
        }
        return listXuatXu;
    }
}
