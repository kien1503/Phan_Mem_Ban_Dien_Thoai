package com.service;

import com.model.XuatXu;
import com.viewmodel.QLXuatXu;
import java.util.ArrayList;

public interface IXuatXuService_1 {

    XuatXu insert(XuatXu x);

    void update(XuatXu x, String maXuatXu);

    void delete(String maXuatXu);

    ArrayList<QLXuatXu> getList();
}
