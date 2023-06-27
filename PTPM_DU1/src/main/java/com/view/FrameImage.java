package com.view;

import com.model.Anh;
import com.service.IAnhService_1;
import com.service.impl.AnhService_1;
import com.viewmodel.QLAnh;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameImage extends javax.swing.JFrame {

    private IAnhService_1 imgService;

    public FrameImage() {
        initComponents();
        this.setLocationRelativeTo(null);
        imgService = new AnhService_1();
        loadFormImage();
        clearFrom();
    }

    private void loadFormImage() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_Image.getModel();
        dtm.setRowCount(0);
        for (QLAnh x : imgService.getList()) {
            Object[] data = {
                x.getAnh()
            };
            dtm.addRow(data);
        }
    }

    private void clearFrom() {
        txt_duongDan.setText("");
    }

    private Anh getFormData() {

        String ten = txt_duongDan.getText().trim();

        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        Anh qlImg = new Anh();
        qlImg.setDuongDanAnh(ten);
        return qlImg;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_duongDan = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Image = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Đường Dẫn Ảnh");

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

        tbl_Image.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Đường Dẫn Ảnh"
            }
        ));
        tbl_Image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ImageMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Image);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(txt_duongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_duongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xoa)
                            .addComponent(btn_them)
                            .addComponent(btn_sua))))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ImageMouseClicked
        // TODO add your handling code here:
        int row = tbl_Image.getSelectedRow();
        if (row == -1) {
            return;
        }
        String tenStr = tbl_Image.getValueAt(row, 1).toString();

        txt_duongDan.setText(tenStr);
    }//GEN-LAST:event_tbl_ImageMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        try {
            Anh img = getFormData();
            if (img == null) {
                return;
            }
            System.out.println(img.toString());
            imgService.insert(img) ;
            loadFormImage();
            clearFrom();
            JOptionPane.showMessageDialog(this, "Thêm thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int row = tbl_Image.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        String maStr = tbl_Image.getValueAt(row, 0).toString();
        Anh img = getFormData();
        imgService.update(img, maStr);
        loadFormImage();
        clearFrom();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_Image.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
        }
        String maStr = tbl_Image.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Co chac chan xoa");
        if (chose == JOptionPane.YES_OPTION) {
            imgService.delete(maStr);
            loadFormImage();
            clearFrom();
            JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
        } else {
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
            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameImage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FrameImage().setVisible(true);
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
    private javax.swing.JTable tbl_Image;
    private javax.swing.JTextField txt_duongDan;
    // End of variables declaration//GEN-END:variables
}
