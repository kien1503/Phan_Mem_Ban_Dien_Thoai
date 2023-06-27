/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.view;

import com.service.ILoginService;
import com.service.impl.LoginService;
import com.view.FrmChinh;
import com.view.JPNhanVien;
import com.viewmodel.QLTaiKhoan;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class Login extends javax.swing.JFrame {

    private static ILoginService loginService;
    public static QLTaiKhoan x;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        loginService = new LoginService();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_Login = new javax.swing.JButton();
        txt_TK = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_Cancel = new javax.swing.JButton();
        txt_MK = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btn_Login.setBackground(new java.awt.Color(23, 35, 51));
        btn_Login.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Login.setForeground(new java.awt.Color(255, 255, 255));
        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        txt_TK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 35, 51));
        jLabel1.setText("Tai khoan");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 35, 51));
        jLabel2.setText("Mat khau");

        btn_Cancel.setBackground(new java.awt.Color(23, 35, 51));
        btn_Cancel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancel.setText("Cancel");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        txt_MK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_TK)
                    .addComponent(txt_MK, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(304, Short.MAX_VALUE)
                .addComponent(btn_Login)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancel)
                .addGap(86, 86, 86))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_MK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Login)
                    .addComponent(btn_Cancel))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        String tk = txt_TK.getText();
        String mk = new String(txt_MK.getPassword());
        System.out.println(tk + mk);

        x = loginService.checkAccount(tk.trim(), mk.trim());

        if (tk.trim().length() == 0 || mk.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Tai khoan hoac mat khau khong duoc de trong");
        }
        if (x != null) {
            JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
            this.dispose();
            new FrmChinh().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Thong tin mat khau hoac tai koang khong chinh xac");
        }
        if (x.getTenCV().equalsIgnoreCase("nhan vien")) {
            new JPNhanVien().setVisible(false);
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_CancelActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txt_MK;
    private javax.swing.JTextField txt_TK;
    // End of variables declaration//GEN-END:variables
}
