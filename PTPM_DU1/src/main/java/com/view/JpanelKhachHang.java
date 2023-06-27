package com.view;

import com.model.KhachHang;
import com.service.IKhachHangService;
import com.service.impl.KhachHangService;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

public class JpanelKhachHang extends javax.swing.JFrame {

    private IKhachHangService iKhachHangService = new KhachHangService();
    public static KhachHang khachHang;

    public JpanelKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
////        loadTableKhachHang(iKhachHangService.listKhachHang());
//        System.out.println(HoaDonJpanel.sdt);
//        if (HoaDonJpanel.sdt == null) {
//            txtSoDienThoai.setText("");
//
//        } else {
//            txtSoDienThoai.setText(HoaDonJpanel.sdt);
//        }
    }

//    private void loadTableKhachHang(ArrayList<KhachHang> list) {
//        DefaultTableModel dtm = (DefaultTableModel) this.tblKhachHang.getModel();
//        dtm.setRowCount(0);
//        int stt = 1;
//        for (KhachHang kh : list) {
//            Object[] rowData = {
//                stt,
//                kh.getTen(),
//                kh.getSdt(),
//                kh.getGioiTinh() == 0 ? "Nữ" : "Nam",
//                kh.getNgaySinh(),
//                kh.getDiaChi(),
//                kh.getGhiChu(),
//                kh.getSoLanMua()
//            };
//            dtm.addRow(rowData);
//            stt++;
//        }
//    }

    private KhachHang getValidate() {
        KhachHang khachHang = new KhachHang();
        String sdtKh = "";
        String tenKh = this.txtTenKhachHang.getText();
        if (HoaDonJpanel.sdt == null) {
            sdtKh = this.txtSoDienThoai.getText();
        } else {
            sdtKh = HoaDonJpanel.sdt;
        }
        String diaChi = this.txtDiaChi.getText();
        String ngaySinh = this.txtNgaySinh.getText();
        String ghiChu = this.txtGhiChu.getText();

        if (rdoNam.isSelected()) {
            khachHang.setGioiTinh(1);
        } else {
            khachHang.setGioiTinh(0);
        }

        int rand = ((int) Math.random() * 9999 + 1);

        khachHang.setMa("KH" + rand);
        khachHang.setTen(tenKh);
        khachHang.setSdt(sdtKh);
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setDiaChi(diaChi);
        khachHang.setGhiChu(ghiChu);

        return khachHang;
    }

//    private String getSelectedRow() {
//        int row = this.tblKhachHang.getSelectedRow();
//
//        if (row == -1) {
//            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi su dung chuc nang");
//            return null;
//        }
//
//        ArrayList<KhachHang> listKh = iKhachHangService.listKhachHang();
//        KhachHang kh = listKh.get(row);
//
//        String tenKh = this.tblKhachHang.getValueAt(row, 1).toString();
//        String sdt = this.tblKhachHang.getValueAt(row, 2).toString();
//        String diaChi = this.tblKhachHang.getValueAt(row, 5).toString();
//        String ghiChu = this.tblKhachHang.getValueAt(row, 6).toString();
//        String ngaySinh = this.tblKhachHang.getValueAt(row, 4).toString();
//        String gioiTinh = this.tblKhachHang.getValueAt(row, 3).toString();
//
//        txtTenKhachHang.setText(tenKh);
//        txtSoDienThoai.setText(sdt);
//        if (gioiTinh.equals("Nam")) {
//            rdoNam.setSelected(true);
//        } else {
//            rdoNu.setSelected(true);
//        }
//        txtDiaChi.setText(diaChi);
//        txtGhiChu.setText(ghiChu);
//        txtNgaySinh.setText(ngaySinh);
//
//        return kh.getId();
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên khách hàng:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Ghi chú:");

        txtTenKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtSoDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(23, 35, 51));
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setForeground(new java.awt.Color(23, 35, 51));
        rdoNu.setText("Nữ");

        btnThem.setBackground(new java.awt.Color(23, 35, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(23, 35, 51));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(txtTenKhachHang)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(72, 72, 72)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                    .addComponent(txtGhiChu)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang kh = getValidate();

        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Loi null");
            return;
        }

        iKhachHangService.add(kh);
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        khachHang = kh;
//        loadTableKhachHang(iKhachHangService.listKhachHang());
        this.setVisible(false);
    }//GEN-LAST:event_btnThemActionPerformed

    private void setData() {
        txtTenKhachHang.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        txtGhiChu.setText("");
        txtNgaySinh.setText("");
        buttonGroup1.clearSelection();

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JpanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JpanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JpanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JpanelKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JpanelKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
