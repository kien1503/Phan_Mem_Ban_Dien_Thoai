package com.service.impl;

import com.repositories.impl.CameraRepo;
import com.service.ICamService;
import com.viewmodel.QLCamera;
import com.model.Camera;
import java.util.ArrayList;

public class CameraService implements ICamService{

    private CameraRepo camRp;
    private ArrayList<QLCamera> listC;

    public CameraService() {
        camRp = new CameraRepo();
        listC = new ArrayList<>();
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
