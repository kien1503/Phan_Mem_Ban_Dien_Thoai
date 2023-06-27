/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.service;

import com.viewmodel.QLTaiKhoan;

/**
 *
 * @author ADMIN
 */
public interface ILoginService {
    QLTaiKhoan checkAccount(String sdt, String mk);
}
