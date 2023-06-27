package com.service.impl;

import com.model.User;
import com.repositories.IUserRepository;
import com.repositories.impl.UserRepository;
import com.service.IChucVuService;
import com.service.IUserService;
import com.viewmodel.QLChucVuViewModel;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public User user(String username, String pass) {
        return iUserRepository.user(username, pass);
    }

}
