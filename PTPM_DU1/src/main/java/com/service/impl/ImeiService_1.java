package com.service.impl;

import com.model.Imei;
import com.repositories.impl.ImeiRepo_1;
import com.service.IImeiService_1;
import com.viewmodel.QLImeil;
import java.util.ArrayList;

public class ImeiService_1 implements IImeiService_1{

    private ImeiRepo_1 imeiRp;
    private ArrayList<QLImeil> listIm;

    public ImeiService_1() {
        imeiRp = new ImeiRepo_1();
        listIm = new ArrayList<>();
    }
     @Override
    public Imei insert(Imei x){
       return this.imeiRp.insert(x);
    }
    @Override
    public void update(Imei x, String maImei){
        this.imeiRp.update(x, maImei);
    }
    @Override
    public void delete(String maImei){
        this.imeiRp.delete(maImei);
    }
    @Override
    public ArrayList<QLImeil> getList() {
        var imei = imeiRp.all();
//        for (Imei x : imei) {
//            listIm.add(new QLImeil(x.getMa(),x.getSoImei(),x.getTrangThai(),x.getIdChiTietSP()));
//        }
        return listIm;
    }
}
