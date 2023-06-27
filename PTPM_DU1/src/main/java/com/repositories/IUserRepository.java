package com.repositories;

import com.model.User;
import java.util.ArrayList;

public interface IUserRepository {
    
    User user(String username, String pass);
}
