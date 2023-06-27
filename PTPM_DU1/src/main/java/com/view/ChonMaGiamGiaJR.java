package com.view;

import com.repositories.IChiTietSPRepository;
import com.repositories.impl.ChiTietSPRepository;
import com.viewmodel.GiamGiaSanPhamView;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ChonMaGiamGiaJR extends javax.swing.JFrame {

    public static IChiTietSPRepository iChiTietSPRepository = new ChiTietSPRepository();
    public static Long ccb = 0l;

    public ChonMaGiamGiaJR() {
        initComponents();
        this.setTitle("Chọn mã voucher giảm giá");
        setLocationRelativeTo(null);
        loadCbbGiamGia(HoaDonJpanel.idChiTietSP);
    }

    public static void loadCbbGiamGia(String id) {
        DefaultComboBoxModel defaultComboBoxModel = (DefaultComboBoxModel) cbbVoucher.getModel();
        ArrayList<GiamGiaSanPhamView> list = iChiTietSPRepository.getListGiamGia(id);

        if (list.isEmpty()) {
            list = new ArrayList<>();
        } else {
            for (GiamGiaSanPhamView giamGiaSanPhamView : list) {
                if (giamGiaSanPhamView.getSoPhanTram() == 0) {
                    defaultComboBoxModel.addElement(giamGiaSanPhamView.getSoTienGiam());
                } else {
                    defaultComboBoxModel.addElement(giamGiaSanPhamView.getSoPhanTram());
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbbVoucher = new javax.swing.JComboBox<>();
        btnOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(cbbVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOK)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addContainerGap(27, Short.MAX_VALUE))
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

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        ccb = Long.valueOf(cbbVoucher.getSelectedItem().toString());
        System.out.println("FrameGiamGia:" + ccb);
        HoaDonJpanel.loadTableGioHang(HoaDonJpanel.listGioHangChiTiet);
        this.dispose();

    }//GEN-LAST:event_btnOKActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChonMaGiamGiaJR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private static javax.swing.JComboBox<String> cbbVoucher;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
