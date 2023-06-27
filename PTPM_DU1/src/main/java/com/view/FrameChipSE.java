package com.view;

import com.model.Chipse;
import com.service.IChipService;
import com.service.impl.ChipSeService;
import com.viewmodel.QLChipSE;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrameChipSE extends javax.swing.JFrame {

    private IChipService chipService;
    public FrameChipSE() {
        initComponents();
        this.setLocationRelativeTo(null);
        chipService = new ChipSeService();
        loadFormChip();
        clearFrom();
    }

    private void loadFormChip() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_ChipSE.getModel();
        dtm.setRowCount(0);
        for (QLChipSE x : chipService.getList()) {
            Object[] data = {
                x.getMa(),
                x.getChip()
            };
            dtm.addRow(data);
        }
    }
    private void clearFrom() {
        txt_ma.setText("");
        txt_chip.setText("");
    }
    
    private Chipse getFormData() {

        String ma = txt_ma.getText().trim();
        String ten = txt_chip.getText().trim();

        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống");
        }
        Chipse qlChip = new Chipse();
        qlChip.setMa(ma);
        qlChip.setTen(ten);
        return qlChip;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        txt_chip = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ChipSE = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mã");

        jLabel2.setText("Chíp");

        txt_ma.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txt_chip.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        btnThem.setBackground(new java.awt.Color(23, 35, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(23, 35, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(23, 35, 51));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        tbl_ChipSE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã Chíp", "Tên Chíp"
            }
        ));
        tbl_ChipSE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ChipSEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_ChipSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_chip, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa)))
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
                            .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_chip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_ChipSEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ChipSEMouseClicked
        // TODO add your handling code here:
        int row = tbl_ChipSE.getSelectedRow();
        if (row == -1) {
            return;
        }
        String maStr = tbl_ChipSE.getValueAt(row, 0).toString();
        String tenStr = tbl_ChipSE.getValueAt(row, 1).toString();

        txt_ma.setText(maStr);
        txt_chip.setText(tenStr);
    }//GEN-LAST:event_tbl_ChipSEMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            Chipse chip = getFormData();
            if (chip == null) {
                return;
            }
            if (chip != null) {
                chipService.insert(chip);
                loadFormChip();
                clearFrom();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tbl_ChipSE.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
            return;
        }
        String maStr = tbl_ChipSE.getValueAt(row, 0).toString();
        Chipse chip = getFormData();
        chipService.update(chip, maStr);
        loadFormChip();
        clearFrom();
        JOptionPane.showMessageDialog(this, "Sua thanh cong");

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_ChipSE.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon dong can xoa");
        }
        String maStr = tbl_ChipSE.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Co chac chan xoa");
        if (chose == JOptionPane.YES_OPTION) {
            chipService.delete(maStr);
            loadFormChip();
            clearFrom();
            JOptionPane.showMessageDialog(this, "Xoa Thanh Cong");
        }
        else{
            JOptionPane.showMessageDialog(this, "Xoa that bai");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

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
            java.util.logging.Logger.getLogger(FrameChipSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameChipSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameChipSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameChipSE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new FrameChipSE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_ChipSE;
    private javax.swing.JTextField txt_chip;
    private javax.swing.JTextField txt_ma;
    // End of variables declaration//GEN-END:variables
}
