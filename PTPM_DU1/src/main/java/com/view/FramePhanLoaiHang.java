package com.view;

import com.model.PhanLoaiHang;
import com.service.IPhanLoaiHangService_1;
import com.service.impl.PhanLoaiHangService_1;
import com.viewmodel.QLPhanLoaiHang;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FramePhanLoaiHang extends javax.swing.JFrame {

    private IPhanLoaiHangService_1 plhService;
    public FramePhanLoaiHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        plhService = new PhanLoaiHangService_1();
        loadFormMauSac();
        clearFrom();
        
    }

    
    private void loadFormMauSac() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_PhanLoai.getModel();
        dtm.setRowCount(0);
        for (QLPhanLoaiHang x : plhService.getList()) {
            Object[] data = {
                x.getMa(),
                x.getTenLoai()
            };
            dtm.addRow(data);
        }
    }
    private void clearFrom() {
        txt_maPhanLoai.setText("");
        txt_PhanLoai.setText("");
    }
    
    private PhanLoaiHang getFormData() {

        String ma = txt_maPhanLoai.getText().trim();
        String ten = txt_PhanLoai.getText().trim();

        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        PhanLoaiHang qlPhanLoai = new PhanLoaiHang();
        qlPhanLoai.setMa(ma);
        qlPhanLoai.setTen(ten);
        return qlPhanLoai;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_maPhanLoai = new javax.swing.JTextField();
        txt_PhanLoai = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_PhanLoai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã");

        jLabel2.setText("Tên Loại");

        txt_maPhanLoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txt_PhanLoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

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

        tbl_PhanLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Loại", "Phân Loại"
            }
        ));
        tbl_PhanLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PhanLoaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_PhanLoai);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_PhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xoa)))
                .addGap(20, 20, 20))
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
                            .addComponent(txt_maPhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_PhanLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_PhanLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PhanLoaiMouseClicked
        // TODO add your handling code here:
        int row = tbl_PhanLoai.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maStr = tbl_PhanLoai.getValueAt(row, 0).toString();
        String tenStr = tbl_PhanLoai.getValueAt(row, 1).toString();

        txt_maPhanLoai.setText(maStr);
        txt_PhanLoai.setText(tenStr);
    }//GEN-LAST:event_tbl_PhanLoaiMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:
        try {
            PhanLoaiHang x = getFormData();
            if (x == null) {
                return;
            }
            System.out.println(x.toString());
            if (plhService.insert(x) != null) {
                loadFormMauSac();
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
        int row = tbl_PhanLoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        String maStr = tbl_PhanLoai.getValueAt(row, 0).toString();
        PhanLoaiHang x = getFormData();
        plhService.update(x, maStr);
        loadFormMauSac();
        clearFrom();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_PhanLoai.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
        }
        String maStr = tbl_PhanLoai.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Co chac chan xoa");
        if (chose == JOptionPane.YES_OPTION) {
            plhService.delete(maStr);
            loadFormMauSac();
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
            java.util.logging.Logger.getLogger(FramePhanLoaiHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePhanLoaiHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePhanLoaiHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePhanLoaiHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FramePhanLoaiHang().setVisible(true);
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
    private javax.swing.JTable tbl_PhanLoai;
    private javax.swing.JTextField txt_PhanLoai;
    private javax.swing.JTextField txt_maPhanLoai;
    // End of variables declaration//GEN-END:variables
}
