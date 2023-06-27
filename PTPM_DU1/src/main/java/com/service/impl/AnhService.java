package com.service.impl;

import com.repositories.impl.AnhRepo;
import com.repositories.IAnhRepo;
import com.service.IAnhService;
import com.viewmodel.QLAnh;
import com.model.Anh;
import java.util.ArrayList;

public class AnhService implements IAnhService{

    private IAnhRepo iAnhRepo;
    private ArrayList<QLAnh> listImg;

    public AnhService() {
        iAnhRepo = new AnhRepo();
        listImg = new ArrayList<>();
    }
    public void insert(QLAnh qlAnh){
//        this.iAnhRepo.insert(qlAnh);
    }
    public void update(Anh img, String id){
        this.iAnhRepo.update(img, id);
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
