package com.service.impl;

import com.model.Camera;
import com.repositories.impl.CameraRepo_1;
import com.service.ICamService_1;
import com.viewmodel.QLCamera;
import java.util.ArrayList;

public class CameraService_1 implements ICamService_1{

    private CameraRepo_1 camRp;
    private ArrayList<QLCamera> listC;

    public CameraService_1() {
        camRp = new CameraRepo_1();
        listC = new ArrayList<>();
    }
    @Override
    public Camera insert(Camera cam){
        return camRp.insert(cam);
    }
    @Override
    public void update(Camera cam, String maCam){
        this.camRp.update(cam, maCam);
    }
    @Override
    public void delete(String maCam){
        this.camRp.delete(maCam);
    }

    @Override
    public ArrayList<QLCamera> getList() {
        var cam = camRp.all();
        for (Camera x : cam) {
            listC.add(new QLCamera(x.getId(), x.getMa(), x.getTen()));
        }
        return listC;
    }
}
