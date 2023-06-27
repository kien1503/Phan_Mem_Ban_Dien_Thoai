package com.service;

import com.model.Anh;
import com.viewmodel.QLAnh;
import java.util.ArrayList;

public interface IAnhService_1 {

    void insert(Anh img);

    void update(Anh img, String id);

    void delete(String idImg);

    ArrayList<QLAnh> getList();
}
