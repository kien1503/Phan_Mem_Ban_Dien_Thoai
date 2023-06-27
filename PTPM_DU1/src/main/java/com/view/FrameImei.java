package com.view;

import com.service.IImeiService_1;
import com.service.impl.ImeiService_1;
import com.viewmodel.QLImeil;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrameImei extends javax.swing.JFrame {

    private IImeiService_1 imeiService;

    public FrameImei() {
        initComponents();
        this.setLocationRelativeTo(null);
        imeiService = new ImeiService_1();

    }

    private void loadFormImei(ArrayList<QLImeil> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tbl_Imei.getModel();
        dtm.setRowCount(0);
        for (QLImeil x : ds) {
            Object[] data = {
                x.getMaImei(),
                x.getSoImei(),
                x.getTrangThai() == 0 ? "Chưa Bán" : "Đã Bán",
                x.getIdChiTietSP()
            };
            dtm.addRow(data);
        }
    }

    private void clearForm() {
        txt_maImei.setText("");
        txt_soImei.setText("");
        txt_idCTSP.setText("");
        rdo_daBan.setSelected(true);
    }

//    private Imei getFormData() {
//        String ma = txt_maImei.getText().trim();
//        String soImei = txt_soImei.getText().trim();
//        String idCTSanPham = txt_idCTSP.getText().trim();
//        
//        
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Imei = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_maImei = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_soImei = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdo_chuaBan = new javax.swing.JRadioButton();
        rdo_daBan = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txt_idCTSP = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_Imei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Imei", "Số Imei", "Trạng Thái", "IdCT Sản Phẩm"
            }
        ));
        jScrollPane1.setViewportView(tbl_Imei);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã Imei");

        txt_maImei.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txt_maImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maImeiActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số Imei");

        txt_soImei.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txt_soImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soImeiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Trạng Thái");

        buttonGroup1.add(rdo_chuaBan);
        rdo_chuaBan.setForeground(new java.awt.Color(23, 35, 51));
        rdo_chuaBan.setText("Chưa Bán");

        buttonGroup1.add(rdo_daBan);
        rdo_daBan.setForeground(new java.awt.Color(23, 35, 51));
        rdo_daBan.setText("Đã Bán");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("IDCT Sản Phẩm");

        txt_idCTSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txt_idCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCTSPActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(23, 35, 51));
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm");

        btn_sua.setBackground(new java.awt.Color(23, 35, 51));
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Sửa");

        btn_xoa.setBackground(new java.awt.Color(23, 35, 51));
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_them)
                        .addGap(32, 32, 32)
                        .addComponent(btn_sua)
                        .addGap(33, 33, 33)
                        .addComponent(btn_xoa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdo_chuaBan)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdo_daBan))
                                    .addComponent(txt_soImei)
                                    .addComponent(txt_maImei)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_idCTSP)))
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdo_chuaBan)
                            .addComponent(rdo_daBan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_idCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))))
                .addGap(114, 114, 114))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_maImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maImeiActionPerformed

    private void txt_soImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soImeiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soImeiActionPerformed

    private void txt_idCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCTSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCTSPActionPerformed

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
            java.util.logging.Logger.getLogger(FrameImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameImei.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameImei().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_chuaBan;
    private javax.swing.JRadioButton rdo_daBan;
    private javax.swing.JTable tbl_Imei;
    private javax.swing.JTextField txt_idCTSP;
    private javax.swing.JTextField txt_maImei;
    private javax.swing.JTextField txt_soImei;
    // End of variables declaration//GEN-END:variables
}
