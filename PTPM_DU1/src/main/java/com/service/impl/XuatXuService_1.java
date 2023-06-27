package com.service.impl;

import com.model.XuatXu;
import com.repositories.impl.XuatXuRepo;
import com.repositories.impl.XuatXuRepo_1;
import com.service.IXuatXuService_1;
import com.viewmodel.QLXuatXu;
import java.util.ArrayList;

public class XuatXuService_1 implements IXuatXuService_1 {

    private XuatXuRepo_1 xuatXuRp;
    private ArrayList<QLXuatXu> listXuatXu;

    public XuatXuService_1() {
        xuatXuRp = new XuatXuRepo_1();
        listXuatXu = new ArrayList<>();
    }

    @Override
    public XuatXu insert(XuatXu x) {
        return this.xuatXuRp.insert(x);
    }

    @Override
    public void update(XuatXu x, String maXuatXu) {
        this.xuatXuRp.update(x, maXuatXu);
    }

    @Override
    public void delete(String maXuatXu) {
        this.xuatXuRp.delete(maXuatXu);
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
