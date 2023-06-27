package com.service;

import com.model.Camera;
import com.viewmodel.QLCamera;
import java.util.ArrayList;

public interface ICamService_1 {

    Camera insert(Camera cam);

    void update(Camera cam, String maCam);

    void delete(String maCam);

    ArrayList<QLCamera> getList();
}
