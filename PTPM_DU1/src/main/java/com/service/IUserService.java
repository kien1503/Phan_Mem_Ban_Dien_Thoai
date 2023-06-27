package com.service;

import com.model.User;
import java.util.ArrayList;

public interface IUserService {
    
    User user(String username, String pass);
}
