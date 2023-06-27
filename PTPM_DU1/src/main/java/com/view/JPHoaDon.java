/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view;

import com.model.HoaDonChiTiet;
import com.service.IHoaDonCTSer;
import com.service.IHoaDonSer;
import com.service.impl.HoaDonCTSer;
import com.service.impl.HoaDonSer;
import com.viewmodel.HoaDonChiTietViewModel;
import com.viewmodel.HoaDonChiTietViewModelTuan;
import com.viewmodel.HoaDonViewModel;
import com.viewmodel.HoaDonViewModelTuan;
import com.viewmodel.ImeiDaBanView;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.HdrDocument;

/**
 *
 * @author ADMIN
 */
public class JPHoaDon extends javax.swing.JPanel {

    private IHoaDonSer hoaDon;
    private IHoaDonCTSer hoaDonCT;
    private DecimalFormat df;

    private List<HoaDonChiTietViewModelTuan> list;

    public JPHoaDon() {
        initComponents();
        hoaDon = new HoaDonSer();
        hoaDonCT = new HoaDonCTSer();
        loadHoaDon(hoaDon.getAll());
        df = new DecimalFormat("###,###,###");
    }

    private void loadHoaDon(List<HoaDonViewModelTuan> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDonViewModelTuan x : ds) {
            Object[] data = {
                x.getId(),
                x.getTenKH(),
                x.getTenNV(),
                x.getNgayTao(),
                x.getNgayThanhToan(),
                x.checkHinhThucThanhToan(x.getHinhThucThanhToan()),
                x.getTinhTrang() == 1 ? "Da thanh toan" : "Chua thanh toan",
                x.getGhiChu()
            };
            dtm.addRow(data);
        }
    }

    private void loadHoaDonCT(List<HoaDonChiTietViewModelTuan> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tblHoaDonCT.getModel();
        dtm.setRowCount(0);
        for (HoaDonChiTietViewModelTuan x : ds) {
            Object[] data = {
                x.getTenSP(),
                x.getSoLuong(),
                df.format(x.getDonGia()) + "VND",
                df.format(x.getSale() * x.getSoLuong()) == null ? 0 : df.format(x.getSale() * x.getSoLuong()) + "VND",
                df.format(x.getDonGia() - (x.getSale() * x.getSoLuong())) + "VND"
            };
            dtm.addRow(data);
        }
    }

    private void loadTableImei(List<ImeiDaBanView> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tblImei.getModel();
        dtm.setRowCount(0);
        for (ImeiDaBanView x : ds) {
            Object[] data = {
                x.getTenSp(),
                x.getImei()
            };
            dtm.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonCT = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_Export = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();
        cbbSort = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hoa Don");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa don"));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ma", "Khach hang", "Ten NV", "Ngay tao", "Ngay thanh toan", "Hinh thuc thanh toan", "Trang thai", "Ghi chu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hoa don chi tiet"));

        tblHoaDonCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ten SP", "So luong", "Don gia", "Sale", "Thanh tien"
            }
        ));
        tblHoaDonCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDonCT);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );

        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Search");

        btn_Export.setBackground(new java.awt.Color(23, 35, 51));
        btn_Export.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Export.setForeground(new java.awt.Color(255, 255, 255));
        btn_Export.setText("Export excel");
        btn_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExportActionPerformed(evt);
            }
        });

        btn_Update.setBackground(new java.awt.Color(23, 35, 51));
        btn_Update.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Update.setForeground(new java.awt.Color(255, 255, 255));
        btn_Update.setText("Sua");
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });

        cbbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên", "Theo ngày thanh toán" }));
        cbbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbSortActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Sort");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Imei"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblImei);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btn_Export)
                .addGap(18, 18, 18)
                .addComponent(btn_Update)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Export, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = tblHoaDon.getSelectedRow();

        if (row == -1) {
            return;
        }

        list = new ArrayList<>();

        List<HoaDonViewModelTuan> listHd = hoaDon.getAll();
        HoaDonViewModelTuan hd = listHd.get(row);

        List<HoaDonChiTietViewModelTuan> listHDCT = hoaDonCT.listNoGiamGia(hd.getId());

        for (HoaDonChiTietViewModelTuan hoaDonChiTiet : listHDCT) {
            HoaDonChiTietViewModelTuan hdct = new HoaDonChiTietViewModelTuan();
            if (hoaDonCT.soTienGiam(hoaDonChiTiet.getIdChiTietSP()) == null) {
                hdct.setSale(0l);
            } else {
                hdct.setSale(hoaDonCT.soTienGiam(hoaDonChiTiet.getIdChiTietSP()));
            }

            hdct.setTenSP(hoaDonChiTiet.getTenSP());
            hdct.setSoLuong(hoaDonChiTiet.getSoLuong());
            hdct.setDonGia(hoaDonChiTiet.getDonGia());
            hdct.setId(hoaDonChiTiet.getId());
            list.add(hdct);
        }

        loadHoaDonCT(list);

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        loadHoaDon(hoaDon.search(txtSearch.getText()));
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void btn_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExportActionPerformed
        List<HoaDonViewModelTuan> ls = hoaDon.getAll();
        try {
            XSSFWorkbook wordkbook = new XSSFWorkbook();
            XSSFSheet sheet = wordkbook.createSheet("danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(2);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("DANH SACH GIA SACH");

            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Id");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Khach hang");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Sdt KH");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Ten NV");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Ngay tao");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Ngay thanh toan");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Hinh thuc thanh toan");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Trang thai");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Ghi chu");

            for (int i = 0; i < ls.size(); i++) {
                //Modelbook book =arr.get(i);
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(ls.get(i).getId());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(ls.get(i).getTenKH());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(ls.get(i).getSdtKH());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(ls.get(i).getTenNV());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(ls.get(i).getNgayTao());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(ls.get(i).getNgayThanhToan());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(ls.get(i).getHinhThucThanhToan());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(ls.get(i).getTinhTrang() == 1 ? "Da thanh toan" : "Chua thanh toan");

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(ls.get(i).getGhiChu());

            }

            JFileChooser fc = new JFileChooser(new File("T:\\DuAn1"));
            fc.setDialogTitle("Luu");

            int x = fc.showSaveDialog(null);
            if (x == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                try {
                    FileOutputStream fos = new FileOutputStream(f.getPath() + ".xlsx");
                    wordkbook.write(fos);
                    fos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            }

            JOptionPane.showMessageDialog(this, "in thanh cong D:\\danhsach");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Loi mo file");
        }
    }//GEN-LAST:event_btn_ExportActionPerformed

    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon dong can sua");
            return;
        }
        String id = tblHoaDon.getValueAt(row, 0).toString();
        String ngTao = tblHoaDon.getValueAt(row, 4).toString();
        String ngThanhToan = tblHoaDon.getValueAt(row, 5).toString();
        String trangThai = tblHoaDon.getValueAt(row, 7).toString();
        String ghiChu = tblHoaDon.getValueAt(row, 8).toString();

        int tt = -1;
        if (trangThai.equals("Da thanh toan")) {
            tt = 1;
        } else {
            tt = 0;
        }

        HoaDonViewModel hd = new HoaDonViewModel();
        hd.setNgayTao(ngTao);
        hd.setNgayThanhToan(ngThanhToan);
        hd.setTinhTrang(tt);
        hd.setGhiChu(ghiChu);

        hoaDon.update(id, hd);
        loadHoaDon(hoaDon.getAll());
        JOptionPane.showMessageDialog(this, "Cap nhat thanh cong");
    }//GEN-LAST:event_btn_UpdateActionPerformed

    private void cbbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbSortActionPerformed
        if (cbbSort.getSelectedIndex() == 0) {
            loadHoaDon(hoaDon.sortName());
        } else {
            loadHoaDon(hoaDon.sortPayDate());
        }
    }//GEN-LAST:event_cbbSortActionPerformed

    private void tblHoaDonCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonCTMouseClicked
        int row = this.tblHoaDonCT.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon 1 dong");
            return;
        }
        HoaDonChiTietViewModelTuan hdct = list.get(row);

        List<ImeiDaBanView> list1 = hoaDonCT.listImei(hdct.getId());
        loadTableImei(list1);
    }//GEN-LAST:event_tblHoaDonCTMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Export;
    private javax.swing.JButton btn_Update;
    private javax.swing.JComboBox<String> cbbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonCT;
    private javax.swing.JTable tblImei;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
