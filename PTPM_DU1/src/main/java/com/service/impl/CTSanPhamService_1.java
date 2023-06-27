package com.service.impl;

import java.util.ArrayList;
import com.repositories.ICTSanPhamRepo;
import com.repositories.ICTSanPhamRepo_1;
import com.repositories.impl.CtSanPhamRepo;
import com.service.ICTSanPhamService_1;
import com.viewmodel.QLCTSanPham;

public class CTSanPhamService_1 implements ICTSanPhamService_1 {

    private ICTSanPhamRepo_1 ctspService;

    public CTSanPhamService_1() {
        ctspService =  new com.repositories.impl.CtSanPhamRepo_1();
    }

    @Override
    public ArrayList<QLCTSanPham> seachSP(String tenSP) {
       return ctspService.seachSP(tenSP);
    }
    @Override
    public ArrayList<QLCTSanPham> getList() {
       return ctspService.all();
    }

    
}
