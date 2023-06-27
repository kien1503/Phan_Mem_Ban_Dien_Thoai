package com.repositories;

import com.viewmodel.QLCTSanPham;
import java.util.ArrayList;

public interface ICTSanPhamRepo_1 {

    ArrayList<QLCTSanPham> seachSP(String tenSP);

    ArrayList<QLCTSanPham> all();
}
