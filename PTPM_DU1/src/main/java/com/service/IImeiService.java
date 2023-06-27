package com.service;

import com.model.Imei;
import com.viewmodel.QLImeil;
import java.util.ArrayList;


public interface IImeiService {
   ArrayList<Imei> getList(String idChiTietSP); 
   
   Boolean add(Imei imei);
   
   int count(String imei);
   
   Boolean updateTrangThai(int trangThai, Long maImei);
   
   Long searchImei(Long imei, String idChiTietSP, int i);
}
