package com.repositories;

import com.model.XuatXu;
import java.util.ArrayList;


public interface IXuatXuRepo_1 {
    XuatXu insert(XuatXu xuatXu);
    void update(XuatXu xuatXu, String maXuatXu);
    void delete(String maXuatXu);
    ArrayList<XuatXu>all();
}
