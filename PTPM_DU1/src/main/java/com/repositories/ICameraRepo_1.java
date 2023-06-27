package com.repositories;

import com.model.Camera;
import java.util.ArrayList;


public interface ICameraRepo_1 {
    Camera insert(Camera cam);
    void update(Camera cam, String maCam);
    void delete(String maCam);
    ArrayList<Camera>all();
}
