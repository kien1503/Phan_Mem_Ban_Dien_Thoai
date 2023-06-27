package com.service.impl;

import com.model.ImeiDaBan;
import com.repositories.IImeiDaBanRepository;
import com.repositories.impl.ImeiDaBanRepository;
import com.service.IImeiDaBanService;

public class ImeiDaBanService implements IImeiDaBanService {

    private IImeiDaBanRepository imeiDaBanRepo = new ImeiDaBanRepository();

    @Override
    public Boolean add(ImeiDaBan imei) {
        return imeiDaBanRepo.add(imei);
    }

}
