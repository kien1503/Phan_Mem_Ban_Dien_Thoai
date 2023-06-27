package com.service.impl;

import com.model.Anh;
import com.repositories.IAnhRepo;
import com.repositories.impl.AnhRepo;
import com.service.IAnhService_1;
import com.viewmodel.QLAnh;
import java.util.ArrayList;

public class AnhService_1 implements IAnhService_1 {

    private IAnhRepo iAnhRepo;
    private ArrayList<QLAnh> listImg;

    public AnhService_1() {
        iAnhRepo = new AnhRepo();
        listImg = new ArrayList<>();
    }

    @Override
    public void insert(Anh img) {
        this.iAnhRepo.insert(img);
    }

    @Override
    public void update(Anh img, String id) {
        this.iAnhRepo.update(img, id);
    }

    @Override
    public void delete(String idImg) {
        this.iAnhRepo.delete(idImg);
    }

    @Override
    public ArrayList<QLAnh> getList() {
        var img = iAnhRepo.all();
        for (Anh x : img) {
            listImg.add(new QLAnh(x.getId(), x.getDuongDanAnh()));
        }
        return listImg;
    }
}
