package com.service.impl;

import com.model.ManHinh;
import com.repositories.impl.ManHinhRepo_1;
import com.service.IManHinhService_1;
import com.viewmodel.QLManHinh;
import java.util.ArrayList;

public class ManHinhService_1 implements IManHinhService_1{

    private ManHinhRepo_1 manHinhRp;
    private ArrayList<QLManHinh> listMh;

    public ManHinhService_1() {
        manHinhRp = new ManHinhRepo_1();
        listMh = new ArrayList<>();
    }
    @Override
    public ManHinh insert(ManHinh x){
       return this.manHinhRp.insert(x);
    }
    @Override
    public void update(ManHinh x, String maMH){
        this.manHinhRp.update(x, maMH);
    }
    @Override
    public void delete(String maMH){
        this.manHinhRp.delete(maMH);
    }
    @Override
    public ArrayList<QLManHinh> getList() {
        var mh = manHinhRp.all();
        for (ManHinh x : mh) {
            listMh.add(new QLManHinh(x.getId(), x.getMa(),x.getTen()));
        }
        return listMh;
    }
}
