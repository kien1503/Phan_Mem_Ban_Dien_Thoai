package com.repositories;

import com.model.HinhThucThanhToan;

public interface IHInhThucThanhToanRepository {
    
    Boolean add(HinhThucThanhToan htth);
    
    Boolean update(HinhThucThanhToan htth, String id);
}
