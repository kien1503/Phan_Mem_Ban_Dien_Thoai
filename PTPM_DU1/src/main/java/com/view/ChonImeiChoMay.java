package com.view;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.service.IImeiService;
import com.service.impl.ImeiService;
import static com.view.HoaDonJpanel.loadTableGioHang;
import com.viewmodel.GioHangChiTiet;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;

public class ChonImeiChoMay extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private IImeiService imeiService = new ImeiService();
    private String idCTSP = HoaDonJpanel.idChiTietSP;
    public static HashMap<String, ArrayList<Long>> hashMap = new HashMap<>();
    private ArrayList<Long> listImei = new ArrayList<>();
    private int dem = 0;
    ArrayList<GioHangChiTiet> list = new ArrayList<>();

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long barCode = 523698745123652522l;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ChonImeiChoMay() {
        initComponents();
        setLocationRelativeTo(null);
        if (dem <= 0) {
            btnXacNhan.setEnabled(false);
        }
        initWebcam();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaGhiCuh = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        txtNhapSoImei = new javax.swing.JTextField();
        btnCheck = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnEXIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Chọn Imei Máy");

        txaGhiCuh.setColumns(20);
        txaGhiCuh.setRows(5);
        jScrollPane1.setViewportView(txaGhiCuh);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Ghi chú");

        btnXacNhan.setBackground(new java.awt.Color(23, 35, 51));
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        txtNhapSoImei.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        btnCheck.setBackground(new java.awt.Color(23, 35, 51));
        btnCheck.setForeground(new java.awt.Color(255, 255, 255));
        btnCheck.setText("+");
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 230));

        btnEXIT.setBackground(new java.awt.Color(23, 35, 51));
        btnEXIT.setForeground(new java.awt.Color(255, 255, 255));
        btnEXIT.setText("EXIT");
        btnEXIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnEXIT)
                        .addGap(319, 319, 319))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnXacNhan))
                                    .addComponent(txtNhapSoImei))
                                .addGap(18, 18, 18)
                                .addComponent(btnCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, Short.MAX_VALUE)))))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnXacNhan))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNhapSoImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCheck))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEXIT)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (dem == HoaDonJpanel.soLuong) {
            hashMap.put(idCTSP, listImei);
            this.setVisible(false);
            webcam.close();
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        Long soImei = Long.valueOf(this.txtNhapSoImei.getText());
        Long imei = imeiService.searchImei(soImei, idCTSP, 0);

        if (HoaDonJpanel.listLong == null) {
            if (imei == 0) {
                JOptionPane.showMessageDialog(this, "Khong ton tai");
                return;
            } else {
                if (listImei != null) {
                    for (Long long1 : listImei) {
                        if (long1.equals(imei)) {
                            JOptionPane.showMessageDialog(this, "So imei nay da su dung");
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                System.out.println(imei);
                listImei.add(imei);
                ++dem;
                if (dem == HoaDonJpanel.soLuong) {
                    btnXacNhan.setEnabled(true);
                    btnCheck.setEnabled(false);
                }
            }
            System.out.println(dem);
        } else {
            ArrayList<Long> list = HoaDonJpanel.listLong;
            for (Long long1 : list) {
                if (long1.equals(imei)) {
                    JOptionPane.showMessageDialog(this, "Imei nay da ton tai tren 1 may khac");
                    return;
                }
            }
            if (imei == 0) {
                JOptionPane.showMessageDialog(this, "Khong ton tai");
                return;
            } else {
                if (listImei != null) {
                    for (Long long1 : listImei) {
                        if (long1.equals(imei)) {
                            JOptionPane.showMessageDialog(this, "So imei nay da su dung");
                            return;
                        }
                    }
                }
                JOptionPane.showMessageDialog(this, "Them thanh cong");
                System.out.println(imei);
                listImei.add(imei);
                ++dem;
                if (dem == HoaDonJpanel.soLuong) {
                    btnXacNhan.setEnabled(true);
                    btnCheck.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_btnCheckActionPerformed

    private void btnEXITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXITActionPerformed
//        ArrayList<GioHangChiTiet> list = HoaDonJpanel.listGioHangChiTiet;
//        for (GioHangChiTiet gioHangChiTiet : list) {
//            if (gioHangChiTiet.getIdChiTietSp().equals(idCTSP)) {
//                list.remove(gioHangChiTiet);
//            }
//        }
        ArrayList<GioHangChiTiet> listGioHang = HoaDonJpanel.listGioHangChiTiet;

        if (listGioHang == null) {
            listGioHang = new ArrayList<>();
        } else {
            for (int i = 0; i < listGioHang.size(); i++) {
                if (listGioHang.get(i).getIdChiTietSp().equals(idCTSP)) {
                    listGioHang.remove(listGioHang.get(i));
                }
            }
        }

        HoaDonJpanel.loadTableGioHang(listGioHang);
        this.dispose();
        webcam.close();
    }//GEN-LAST:event_btnEXITActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChonImeiChoMay().setVisible(true);
            }
        });
    }

    private void initWebcam() {

        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel1.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 320, 230));

        executor.execute(this);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.JButton btnEXIT;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaGhiCuh;
    private javax.swing.JTextField txtNhapSoImei;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (Exception e) {
                // no result
            }
            if (result != null) {
                txtNhapSoImei.setText(result.getText());
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
