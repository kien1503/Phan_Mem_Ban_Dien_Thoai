package com.view;

import com.model.DongSP;
import com.service.IDongSpService_1;
import com.service.impl.DongSPService_1;
import com.viewmodel.QLDongSp;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrameDongSP extends javax.swing.JFrame {

    private IDongSpService_1 dongSpService;
    public FrameDongSP() {
        initComponents();
        this.setLocationRelativeTo(null);
        dongSpService = new DongSPService_1();
        loadFormDongSP();
        clearFrom();
    }
     private void loadFormDongSP() {
         DefaultTableModel dtm = (DefaultTableModel) tbl_DongSP.getModel();
        dtm.setRowCount(0);
        for (QLDongSp x : dongSpService.getList()) {
            Object[] data = {
                x.getMaDongSP(),
                x.getTenDongSP()
            };
            dtm.addRow(data);
        }
    }private DongSP getFormData() {

        String ma = txt_maDongSP.getText().trim();
        String ten = txt_dongsp.getText().trim();

        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        DongSP qlDongSP = new DongSP();
        qlDongSP.setMa(ma);
        qlDongSP.setTen(ten);
        return qlDongSP;
    }

    private void clearFrom() {
        txt_maDongSP.setText("");
        txt_dongsp.setText("");
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_maDongSP = new javax.swing.JTextField();
        txt_dongsp = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DongSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã");

        jLabel2.setText("Dòng SP");

        txt_dongsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dongspActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        tbl_DongSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã DongSP", "Tên DongSP"
            }
        ));
        tbl_DongSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DongSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DongSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btn_them))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xoa))
                    .addComponent(txt_maDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_dongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoa)
                            .addComponent(btn_them)
                            .addComponent(btn_sua))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_dongspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dongspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dongspActionPerformed

    private void tbl_DongSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DongSPMouseClicked
        // TODO add your handling code here:
        int row = tbl_DongSP.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maStr = tbl_DongSP.getValueAt(row, 0).toString();
        String tenStr = tbl_DongSP.getValueAt(row, 1).toString();

        txt_maDongSP.setText(maStr);
        txt_dongsp.setText(tenStr);
    }//GEN-LAST:event_tbl_DongSPMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        try {
            DongSP dongSp = getFormData();
            if (dongSp == null) {
                return;
            }
            System.out.println(dongSp.toString());
            if (dongSpService.insert(dongSp) != null) {
                loadFormDongSP();
                clearFrom();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
           int row = tbl_DongSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        String maStr = tbl_DongSP.getValueAt(row, 0).toString();
        DongSP dongSP = getFormData();
        dongSpService.update(dongSP, maStr);
        loadFormDongSP();
        clearFrom();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_DongSP.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
        }
        String maStr = tbl_DongSP.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Co chac chan xoa");
        if (chose == JOptionPane.YES_OPTION) {
            dongSpService.delete(maStr);
            loadFormDongSP();
            clearFrom();
            JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
        }
        else{
            JOptionPane.showMessageDialog(this, "Xoa that bai");
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(FrameDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameDongSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameDongSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_DongSP;
    private javax.swing.JTextField txt_dongsp;
    private javax.swing.JTextField txt_maDongSP;
    // End of variables declaration//GEN-END:variables
}
