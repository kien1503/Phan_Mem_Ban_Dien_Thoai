/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.view;

import com.service.IChucVuService;
import com.service.INhanVienService;
import com.service.impl.ChucVuService;
import com.service.impl.NhanVienService;
import com.viewmodel.QLChucVuViewModel;
import com.viewmodel.QLNhanVien;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class JPNhanVien extends javax.swing.JPanel {

    private IChucVuService chucVuService;
    private INhanVienService nhanVienService;
    private SimpleDateFormat sdf;

    public JPNhanVien() {
        initComponents();
        chucVuService = new ChucVuService();
        nhanVienService = new NhanVienService();
        loadCBB();
        loadTable(nhanVienService.getAll());
        sdf = new SimpleDateFormat("MM/dd/yyyy");
        clear();
    }

    private void loadCBB() {
        DefaultComboBoxModel cbb = new DefaultComboBoxModel();
        for (QLChucVuViewModel x : chucVuService.getAll()) {
            cbb.addElement(x.getTen());
        }
        cbbCV.setModel(cbb);
    }

    private String getIdCV(String ten) {
        for (QLChucVuViewModel x : chucVuService.getAll()) {
            if (x.getTen().equals(ten)) {
                return x.getId();
            }
        }
        return "";
    }

    private void loadTable(List<QLNhanVien> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tblNV.getModel();
        dtm.setRowCount(0);
        for (QLNhanVien x : ds) {
            Object[] data = {
                x.getId(),
                x.getMa(),
                x.getTen(),
                x.getNgaySinh(),
                x.getDiaChi(),
                x.getSdt(),
                x.getEmail(),
                x.getMatKhau(),
                x.getNgayTao(),
                x.getTrangThai() == 1 ? "Hoat dong" : "Khong hoat dong",
                x.getTenChucVu(),};
            dtm.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgSinh = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        txtmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNgTao = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMK = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbbCV = new javax.swing.JComboBox<>();
        lblId = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdoHD = new javax.swing.JRadioButton();
        rdoKoHD = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNV = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NHAN VIEN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jLabel2.setBackground(new java.awt.Color(23, 35, 51));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(23, 35, 51));
        jLabel2.setText("id");

        txtMa.setEditable(false);
        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel3.setBackground(new java.awt.Color(23, 35, 51));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 35, 51));
        jLabel3.setText("Ma");

        txtTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel4.setBackground(new java.awt.Color(23, 35, 51));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(23, 35, 51));
        jLabel4.setText("Ten");

        jLabel5.setBackground(new java.awt.Color(23, 35, 51));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 35, 51));
        jLabel5.setText("Ngay Sinh");

        txtNgSinh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(23, 35, 51));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(23, 35, 51));
        jLabel6.setText("Dia chi");

        jLabel7.setBackground(new java.awt.Color(23, 35, 51));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 35, 51));
        jLabel7.setText("Sdt");

        txtSdt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel9.setBackground(new java.awt.Color(23, 35, 51));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(23, 35, 51));
        jLabel9.setText("Email");

        jLabel10.setBackground(new java.awt.Color(23, 35, 51));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(23, 35, 51));
        jLabel10.setText("Ngay tao");

        txtNgTao.setEditable(false);
        txtNgTao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel11.setBackground(new java.awt.Color(23, 35, 51));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(23, 35, 51));
        jLabel11.setText("Mat khau");

        txtMK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel12.setBackground(new java.awt.Color(23, 35, 51));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(23, 35, 51));
        jLabel12.setText("Ghi chu");

        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel13.setBackground(new java.awt.Color(23, 35, 51));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(23, 35, 51));
        jLabel13.setText("Chuc vu");

        cbbCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblId.setText("_");

        jLabel8.setBackground(new java.awt.Color(23, 35, 51));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 35, 51));
        jLabel8.setText("Trang thai");

        buttonGroup1.add(rdoHD);
        rdoHD.setText("Hoat dong");

        buttonGroup1.add(rdoKoHD);
        rdoKoHD.setText("Khong hoat dong");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                            .addComponent(txtNgSinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSdt))
                        .addGap(74, 74, 74)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgTao)
                    .addComponent(txtGhiChu)
                    .addComponent(txtmail)
                    .addComponent(txtMK)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbCV, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoHD)
                                .addGap(18, 18, 18)
                                .addComponent(rdoKoHD)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblId))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(rdoHD)
                        .addComponent(rdoKoHD)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(cbbCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        btnThem.setBackground(new java.awt.Color(23, 35, 51));
        btnThem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(23, 35, 51));
        btnSua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(23, 35, 51));
        btnXoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnClear.setBackground(new java.awt.Color(23, 35, 51));
        btnClear.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        tblNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Ma", "Ten", "Ngay sinh", "Dia chi", "Sdt", "Email", "Mat khau", "Ngay tao", "Trang thai", "Chuc Vu"
            }
        ));
        tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNV);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(23, 35, 51));
        jLabel14.setText("Search");

        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txtSearch.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtSearchCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnClear))
                .addGap(36, 36, 36)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private String genMa() {
        Random rd = new Random();
        int x = rd.nextInt(100) + 10;
        return "NV" + x;
    }

    private QLNhanVien getForm() {
        String ten = txtTen.getText();
        String ma = txtMa.getText();
        String ngSinh = txtNgSinh.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSdt.getText();
        String email = txtmail.getText();
        String mk = txtMK.getText();
        String ghiChu = txtGhiChu.getText();
        int trangThai = rdoHD.isSelected() ? 1 : 0;
        String chuVu = cbbCV.getSelectedItem().toString();

        StringBuilder sb = new StringBuilder();
        if (ten.trim().length() == 0) {
            sb.append("Ten khong de tron\n");
        }
        if (ngSinh.trim().length() == 0) {
            sb.append("Ngay sinh khong de trong\n");
        }
        if (diaChi.trim().length() == 0) {
            sb.append("Dia chi khong de trong\n");
        }
        if (sdt.trim().length() == 0) {
            sb.append("Sdt khong de trong\n");
        }
        if (email.trim().length() == 0) {
            sb.append("email khong de trong\n");
        }
        if (mk.trim().length() == 0) {
            sb.append("Mat khau khong de trong\n");
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString());
            return null;
        }

        QLNhanVien x = new QLNhanVien();
        x.setMa(genMa());
        x.setTen(ten);
        x.setNgaySinh(ngSinh);
        x.setDiaChi(diaChi);
        x.setSdt(sdt);
        x.setEmail(email);
        x.setMatKhau(mk);
        x.setGhiChu(ghiChu);
        x.setTrangThai(trangThai);
        x.setTenChucVu(getIdCV(chuVu));
        return x;
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        QLNhanVien x = getForm();
        if (x == null) {
            return;
        }
        nhanVienService.insert(x);
        loadTable(nhanVienService.getAll());
        JOptionPane.showMessageDialog(this, "Them tc");

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = tblNV.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = tblNV.getValueAt(row, 0).toString();
        int choose = JOptionPane.showConfirmDialog(this, "Ban co muon xoa ?", "Thong bao", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            nhanVienService.delete(id);
            loadTable(nhanVienService.getAll());
            JOptionPane.showMessageDialog(this, "Xoa tc");
            clear();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNVMouseClicked
        int row = tblNV.getSelectedRow();
        if (row == -1) {
            return;
        }
        String id = tblNV.getValueAt(row, 0).toString();
        String ma = tblNV.getValueAt(row, 1).toString();
        String ten = tblNV.getValueAt(row, 2).toString();
        String ngSinh = tblNV.getValueAt(row, 3).toString();
        String diaChi = tblNV.getValueAt(row, 4).toString();
        String sdt = tblNV.getValueAt(row, 5).toString();
        String email = tblNV.getValueAt(row, 6).toString();
        String mk = tblNV.getValueAt(row, 7).toString();
        String ngTao = tblNV.getValueAt(row, 8).toString();
        String trangThai = tblNV.getValueAt(row, 9).toString();
        String cv = tblNV.getValueAt(row, 10).toString();

        lblId.setText(id);
        txtMa.setText(ma);
        txtTen.setText(ten);
        txtNgSinh.setText(ngSinh);
        txtDiaChi.setText(diaChi);
        txtSdt.setText(sdt);
        txtmail.setText(email);
        txtMK.setText(mk);
        txtNgTao.setText(ngTao);
        if (trangThai.equals("Hoat dong")) {
            rdoHD.setSelected(true);
        } else {
            rdoKoHD.setSelected(true);
        }
        cbbCV.setSelectedItem(cv);
    }//GEN-LAST:event_tblNVMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        QLNhanVien x = getForm();

        int row = tblNV.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Hay chon dong can cap nhat?");
            return;
        }
        if (x == null) {
            return;
        }

        String id = tblNV.getValueAt(row, 0).toString();
        int choose = JOptionPane.showConfirmDialog(this, "Ban co muong cap nhat?", "Thong bao", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            nhanVienService.update(id, x);
            loadTable(nhanVienService.getAll());
            JOptionPane.showMessageDialog(this, "Cap nhat thành công");
            clear();
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtSearchCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtSearchCaretUpdate
        List<QLNhanVien> ds = nhanVienService.search(txtSearch.getText());
        loadTable(ds);
    }//GEN-LAST:event_txtSearchCaretUpdate

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtNgSinh.setText("");
        txtSdt.setText("");
        txtDiaChi.setText("");
        txtGhiChu.setText("");
        txtMK.setText("");
        txtmail.setText("");
        rdoHD.setSelected(true);
        cbbCV.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbCV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKoHD;
    private javax.swing.JTable tblNV;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgSinh;
    private javax.swing.JTextField txtNgTao;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtmail;
    // End of variables declaration//GEN-END:variables
}
