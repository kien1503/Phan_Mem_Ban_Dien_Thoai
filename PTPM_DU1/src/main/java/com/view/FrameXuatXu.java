
package com.view;

import com.model.XuatXu;
import com.service.IXuatXuService_1;
import com.service.impl.XuatXuService_1;
import com.viewmodel.QLXuatXu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrameXuatXu extends javax.swing.JFrame {

    private IXuatXuService_1 xuatXuSer;
    public FrameXuatXu() {
        initComponents();
        this.setLocationRelativeTo(null);
        xuatXuSer = new XuatXuService_1();
        loadFormXuatXu();
        clearFrom();
    }

    private void loadFormXuatXu() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_XuatXu.getModel();
        dtm.setRowCount(0);
        for (QLXuatXu x : xuatXuSer.getList()) {
            Object[] data = {
                x.getMaXuatXu(),
                x.getTenXuatXu()
            };
            dtm.addRow(data);
        }
    }
    private void clearFrom() {
        txt_ma.setText("");
        txt_xuatXu.setText("");
    }
    
    private XuatXu getFormData() {

        String ma = txt_ma.getText().trim();
        String ten = txt_xuatXu.getText().trim();

        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        XuatXu qlXx = new XuatXu();
        qlXx.setMa(ma);
        qlXx.setTen(ten);
        return qlXx;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_xuatXu = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_XuatXu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã");

        jLabel2.setText("Xuất Xứ");

        txt_ma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txt_xuatXu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        btn_them.setBackground(new java.awt.Color(23, 35, 51));
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(23, 35, 51));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(23, 35, 51));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        tbl_XuatXu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Xuất Xứ", "Xuất Xứ"
            }
        ));
        tbl_XuatXu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_XuatXuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_XuatXu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_xuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_xoa)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_them)
                                .addComponent(btn_sua))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_XuatXuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_XuatXuMouseClicked
        // TODO add your handling code here:
        int row = tbl_XuatXu.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maStr = tbl_XuatXu.getValueAt(row, 0).toString();
        String tenStr = tbl_XuatXu.getValueAt(row, 1).toString();

        txt_ma.setText(maStr);
        txt_xuatXu.setText(tenStr);
    }//GEN-LAST:event_tbl_XuatXuMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
         try {
            XuatXu x = getFormData();
            if (x == null) {
                return;
            }
            System.out.println(x.toString());
            if (xuatXuSer.insert(x) != null) {
                loadFormXuatXu();
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
        int row = tbl_XuatXu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        String maStr = tbl_XuatXu.getValueAt(row, 0).toString();
        XuatXu x = getFormData();
        xuatXuSer.update(x, maStr);
        loadFormXuatXu();
        clearFrom();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_XuatXu.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
        }
        String maStr = tbl_XuatXu.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Co chac chan xoa");
        if (chose == JOptionPane.YES_OPTION) {
            xuatXuSer.delete(maStr);
            loadFormXuatXu();
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
            java.util.logging.Logger.getLogger(FrameXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameXuatXu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameXuatXu().setVisible(true);
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
    private javax.swing.JTable tbl_XuatXu;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_xuatXu;
    // End of variables declaration//GEN-END:variables
}
