package com.repositories;

import com.model.Pin;
import java.util.ArrayList;


public interface IPinRepo_1 {
    Pin insert(Pin pin);
    void update(Pin pin, String maPin);
    void delete(String maPin);
    ArrayList<Pin>all();
}
