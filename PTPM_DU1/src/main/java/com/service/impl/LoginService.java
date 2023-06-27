/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service.impl;

import com.repositories.ILogin;
import com.repositories.impl.LoginRepository;
import com.service.ILoginService;
import com.viewmodel.QLTaiKhoan;

public class LoginService implements ILoginService {

    private ILogin login;

    public LoginService() {
        login = new LoginRepository();
    }

    @Override
    public QLTaiKhoan checkAccount(String sdt, String mk) {
        return login.checkAccount(sdt, mk);
    }

}
