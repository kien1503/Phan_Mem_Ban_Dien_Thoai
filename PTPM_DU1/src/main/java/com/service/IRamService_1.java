package com.service;

import com.model.Ram;
import com.viewmodel.QLRam;
import java.util.ArrayList;


public interface IRamService_1 {
   Ram insert(Ram x);
   void update(Ram x, String maRam);
   void delete(String maRam);
   ArrayList<QLRam> getList(); 
}
