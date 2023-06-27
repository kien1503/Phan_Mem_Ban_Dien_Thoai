package com.view;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.model.Imei;
import com.service.IImeiService;
import com.service.impl.ImeiService;
import com.viewmodel.QLImeil;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Iterator;
import javax.swing.JFileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ImeiFrame extends javax.swing.JFrame {
    
    private IImeiService imeiService = new ImeiService();
//    private String file = "";
    String idChiTietSp = FromCTSanPham.idChiTietSP;
    private String duongDan = "D:\\Nhom 1\\Imei";
    
    public ImeiFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void loadTableImei(ArrayList<Imei> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblImei.getModel();
        dtm.setRowCount(0);
        int stt = 0;
        for (Imei imei : list) {
            Object[] rowData = {
                imei.getSoImei()
            };
            dtm.addRow(rowData);
            stt++;
            
        }
        lblImei.setText(stt + "");
    }
    
    private Imei getValidate() {
        Imei imei = new Imei();
        
        Long soImei = Long.valueOf(this.txtImei.getText());
        
        int rand = (int) (Math.random() * 999999) + 1;
        imei.setSoImei(soImei);
        imei.setTrangThai(0);
        imei.setIdChiTietSP(idChiTietSp);
        
        return imei;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtImei = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblImei = new javax.swing.JLabel();
        btnExcel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imei"
            }
        ));
        jScrollPane1.setViewportView(tblImei);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Thêm Imei");

        btnThem.setBackground(new java.awt.Color(23, 35, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Tìm kiếm");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Tổng");

        lblImei.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblImei.setText("-");

        btnExcel.setBackground(new java.awt.Color(23, 35, 51));
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("EXCEL");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        btnOK.setBackground(new java.awt.Color(23, 35, 51));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(23, 35, 51));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(btnThem))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnOK)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnExit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblImei, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcel)
                        .addGap(28, 28, 28))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblImei, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcel)
                    .addComponent(btnOK)
                    .addComponent(btnExit))
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtImei))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        Imei imei = new Imei();
        
        int rand = (int) (Math.random() * 999999) + 1;
        imei.setTrangThai(0);
        imei.setIdChiTietSP(idChiTietSp);
        try {
            JFileChooser f = new JFileChooser("D:\\Nhom 1\\Imei");
            f.setDialogTitle("Mo file");
            f.showOpenDialog(null);
            File fTenAnh = f.getSelectedFile();
            duongDan = fTenAnh.getAbsolutePath();
            if (duongDan != null) {
                FileInputStream file = new FileInputStream(new File(duongDan));
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                XSSFSheet sheet = workbook.getSheetAt(0);
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        switch (cell.getCellType()) {
                            case NUMERIC:
                                Long imei1 = Long.valueOf(cell.getStringCellValue());
                                System.out.println(imei1);
                                break;
                            case STRING:
                                imei1 = Long.valueOf(cell.getStringCellValue());
                                System.out.println(imei1);
                                imei.setSoImei(imei1);
                                imeiService.add(imei);
                                String path = "D:\\Nhom 1\\ImeiBarcode\\" + imei1 + ".png";
                                
                                Code128Writer writer = new Code128Writer();
                                BitMatrix matrix = writer.encode(String.valueOf(imei1), BarcodeFormat.CODE_128, 500, 300);
                                MatrixToImageWriter.writeToPath(matrix, "png", Paths.get(path));
                                loadTableImei(imeiService.getList(idChiTietSp));
                                break;
                        }
                    }
                    System.out.println("");
                }
                
                file.close();
            } else {
                JOptionPane.showMessageDialog(this, "Chua chon file");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Da vao catch");
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        Imei imei = getValidate();
        if (imei == null) {
            JOptionPane.showMessageDialog(this, "Null");
            return;
        }
        imeiService.add(imei);
        
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        loadTableImei(imeiService.getList(idChiTietSp));
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        FromCTSanPham.loadCBBImei(imeiService.getList(idChiTietSp));
        FromCTSanPham.setSoLuong(Integer.valueOf(lblImei.getText()));
        this.setVisible(false);
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImeiFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImei;
    private javax.swing.JTable tblImei;
    private javax.swing.JTextField txtImei;
    // End of variables declaration//GEN-END:variables
}
