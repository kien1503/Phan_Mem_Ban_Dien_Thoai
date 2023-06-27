package com.view;

import com.model.KhachHang;
import com.service.IKhachHangService;
import com.service.impl.KhachHangService;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPKhachHang extends javax.swing.JPanel {

    private IKhachHangService iKhachHangService = new KhachHangService();
    public static KhachHang khachHang;

    public JPKhachHang() {
        initComponents();
        loadTableKhachHang(iKhachHangService.listKhachHang());
    }

    private void loadTableKhachHang(ArrayList<KhachHang> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblKhachHang.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (KhachHang kh : list) {
            Object[] rowData = {
                stt,
                kh.getTen(),
                kh.getSdt(),
                kh.getGioiTinh() == 0 ? "Nữ" : "Nam",
                kh.getNgaySinh(),
                kh.getDiaChi(),
                kh.getGhiChu(),
                kh.getSoLanMua()
            };
            dtm.addRow(rowData);
            stt++;
        }
    }

    private KhachHang getValidate() {
        KhachHang khachHang = new KhachHang();
        String sdtKh = "";
        String tenKh = this.txtTenKhachHang.getText();
        if (HoaDonJpanel.sdt == null) {
            sdtKh = this.txtSoDienThoai.getText();
        } else {
            sdtKh = HoaDonJpanel.sdt;
        }
        String diaChi = this.txtDiaChi.getText();
        String ngaySinh = this.txtNgaySinh.getText();
        String ghiChu = this.txtGhiChu.getText();

        if (rdoNam.isSelected()) {
            khachHang.setGioiTinh(1);
        } else {
            khachHang.setGioiTinh(0);
        }

        int rand = ((int) Math.random() * 9999 + 1);

        khachHang.setMa("KH" + rand);
        khachHang.setTen(tenKh);
        khachHang.setSdt(sdtKh);
        khachHang.setNgaySinh(ngaySinh);
        khachHang.setDiaChi(diaChi);
        khachHang.setGhiChu(ghiChu);

        return khachHang;
    }

    private String getSelectedRow() {
        int row = this.tblKhachHang.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi su dung chuc nang");
            return null;
        }

        ArrayList<KhachHang> listKh = iKhachHangService.listKhachHang();
        KhachHang kh = listKh.get(row);

        String tenKh = this.tblKhachHang.getValueAt(row, 1).toString();
        String sdt = this.tblKhachHang.getValueAt(row, 2).toString();
        String diaChi = this.tblKhachHang.getValueAt(row, 5).toString();
        String ghiChu = this.tblKhachHang.getValueAt(row, 6).toString();
        String ngaySinh = this.tblKhachHang.getValueAt(row, 4).toString();
        String gioiTinh = this.tblKhachHang.getValueAt(row, 3).toString();

        txtTenKhachHang.setText(tenKh);
        txtSoDienThoai.setText(sdt);
        if (gioiTinh.equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChi.setText(diaChi);
        txtGhiChu.setText(ghiChu);
        txtNgaySinh.setText(ngaySinh);

        return kh.getId();
    }

    private void setData() {
        txtTenKhachHang.setText("");
        txtSoDienThoai.setText("");
        txtDiaChi.setText("");
        txtGhiChu.setText("");
        txtNgaySinh.setText("");
        buttonGroup1.clearSelection();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClearForm = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên khách hàng", "SDT", "Giới tính", "Ngày sinh", "Địa chỉ", "Ghi chú", "Số lần mua hàng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Tên khách hàng:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Số điện thoại:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Giới tính:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Ghi chú:");

        txtTenKhachHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtSoDienThoai.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtNgaySinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

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

        btnClearForm.setBackground(new java.awt.Color(23, 35, 51));
        btnClearForm.setForeground(new java.awt.Color(255, 255, 255));
        btnClearForm.setText("Clear form");
        btnClearForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(23, 35, 51));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(43, 43, 43)
                        .addComponent(btnSua)
                        .addGap(38, 38, 38)
                        .addComponent(btnXoa)
                        .addGap(31, 31, 31)
                        .addComponent(btnClearForm)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(72, 72, 72)
                                .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenKhachHang)
                                    .addComponent(txtSoDienThoai))
                                .addGap(93, 93, 93)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(txtDiaChi)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClearForm)
                    .addComponent(btnExit))
                .addGap(18, 18, 18))
        );

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        getSelectedRow();
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        KhachHang kh = getValidate();

        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Loi null");
            return;
        }

        iKhachHangService.add(kh);
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        khachHang = kh;
        loadTableKhachHang(iKhachHangService.listKhachHang());
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblKhachHang.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi su dung chuc nang");
            return;
        }
        KhachHang kh = getValidate();

        if (kh == null) {
            JOptionPane.showMessageDialog(this, "Nhap du lieu moi truoc khi sua");
            return;
        }

        iKhachHangService.update(kh, getSelectedRow());
        JOptionPane.showMessageDialog(this, "Sua thanh cong");
        loadTableKhachHang(iKhachHangService.listKhachHang());
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblKhachHang.getSelectedRow();

        getSelectedRow();

        iKhachHangService.delete(getSelectedRow());
        JOptionPane.showMessageDialog(this, "Xoa thanh cong");
        loadTableKhachHang(iKhachHangService.listKhachHang());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnClearFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormActionPerformed
        setData();
    }//GEN-LAST:event_btnClearFormActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearForm;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
