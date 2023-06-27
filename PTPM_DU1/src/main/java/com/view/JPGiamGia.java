package com.view;

import com.model.GiamGia;
import com.model.GiamGiaChiTiet;
import com.service.impl.GiamGiaChiTietService;
import com.service.impl.GiamGiaService;
import com.service.impl.SanPhamServiceDAT;
import com.viewmodel.QLGiamGia;
import com.viewmodel.QLGiamGiaChiTiet;
import com.viewmodel.QLSanPhamDAT;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPGiamGia extends javax.swing.JPanel {

    GiamGiaService giamGiaService;
    SanPhamServiceDAT sanPhamService;
    GiamGiaChiTietService giamGiaChiTietService;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    ArrayList<String> arr = new ArrayList<>();
    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private ArrayList<String> arr1 = new ArrayList<>();
    private String idGiamGia = "";

    public JPGiamGia() {
        initComponents();
        this.giamGiaService = new GiamGiaService();
        this.sanPhamService = new SanPhamServiceDAT();
        this.giamGiaChiTietService = new GiamGiaChiTietService();
        loadForm(giamGiaService.getDanhSach());
        loadSP(sanPhamService.getList());
        giamGiaService.updateDate();
        txtMa.disable();
        checkSelected();
    }

    public String getTenSP(String id) {
        for (QLSanPhamDAT x : sanPhamService.getList()) {
            if (x.getId().equals(id)) {
                return x.getTenSP();
            }
        }
        return null;
    }

    public int getTT(String trangThai) {
        if (trangThai.equals("Đang diễn ra")) {
            return 0;
        } else if (trangThai.equals("Sắp diễn ra")) {
            return 1;
        } else {
            return 3;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTenCT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNtao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cdBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtTM = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbbLoaiMa = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        chk_SelectAll = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        btn_Voucher = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Giảm Giá");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Mã Giảm Giá");

        txtMa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        txtTenCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel9.setText("TenCT");

        jLabel4.setText("Ngày Tạo");

        txtNtao.setEditable(false);
        txtNtao.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel5.setText("Ngày Bắt Đầu");

        jLabel6.setText("Ngày Kết Thúc");

        jLabel12.setText("Loại Giảm Giá");

        jLabel2.setText("Giảm tiền mặt");

        jLabel7.setText("Trạng Thái");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang diễn ra", "Đã kết thúc", "Sắp diễn ra" }));
        cbbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTrangThaiActionPerformed(evt);
            }
        });

        txtTM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel1.setText("Loại Mã");

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

        cbbLoaiMa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm toàn shop", "Giảm từng sản phẩm" }));
        cbbLoaiMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiMaActionPerformed(evt);
            }
        });

        jLabel13.setText("Giảm tiền mặt");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbLoaiMa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTM, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenCT)
                                .addComponent(txtMa)
                                .addComponent(txtNtao)
                                .addComponent(cdBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(cbKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel13)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnThem)
                        .addGap(36, 36, 36)
                        .addComponent(btnSua)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoa)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNtao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cdBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cbKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbbLoaiMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(35, 35, 35))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Giảm Giá", "Tên CT", "Ngày Tạo", "Ngày Bắt Đầu", "Ngày Kết Thúc", "Số tiền giảm", "Trạng Thái"
            }
        ));
        tblTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTable);

        jLabel8.setText("Tìm");

        jButton1.setBackground(new java.awt.Color(23, 35, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chk_SelectAll.setText("Select All");
        chk_SelectAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chk_SelectAllMouseClicked(evt);
            }
        });
        chk_SelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_SelectAllActionPerformed(evt);
            }
        });

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSP);

        btn_Voucher.setBackground(new java.awt.Color(23, 35, 51));
        btn_Voucher.setForeground(new java.awt.Color(255, 255, 255));
        btn_Voucher.setText("Save");
        btn_Voucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_VoucherActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Đang diễn ra");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Đã kết thúc");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Tất cả");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chk_SelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jRadioButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(61, 61, 61))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Voucher)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chk_SelectAll)
                    .addComponent(jLabel8)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Voucher)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loadForm(List<QLGiamGia> ds) {
        DefaultTableModel dtm = (DefaultTableModel) tblTable.getModel();
        dtm.setRowCount(0);
        for (QLGiamGia x : ds) {
            Object[] data
                    = {x.getMa(),
                        x.getTenCT(),
                        x.getNgayTao(),
                        x.getNgayBatDau(),
                        x.getNgayKetThuc(),
                        x.getGiamGiaTienMat(),
                        x.getTrangThai() == 0 ? "Đang diễn ra" : x.getTrangThai() == 1 ? "Sắp diễn ra" : "Đã kết thúc"
                    };
            dtm.addRow(data);

        }
    }

    private void loadSP(List<QLSanPhamDAT> dsSP) {
        DefaultTableModel dtm = (DefaultTableModel) tblSP.getModel();
        dtm.setRowCount(0);
        for (QLSanPhamDAT x : dsSP) {
            Object[] daTa
                    = {x.getMaSP(), getTenSP(x.getId())};
            dtm.addRow(daTa);
        }
    }

    public String getidSP(String ten) {
        for (QLSanPhamDAT x : sanPhamService.getList()) {
            if (x.getMaSP().equals(ten)) {
                return x.getId();
            }
        }
        return "";
    }

    public String getidGiamGia(String ma) {
        for (QLGiamGia x : giamGiaService.getDanhSach()) {
            if (x.getMa().equals(ma)) {
                return x.getId();
            }
        }
        return "aa";
    }

    public Long getGia(String ten) {
        for (QLSanPhamDAT x : sanPhamService.getList()) {
            if (x.getId().equals(ten)) {
                return x.getGiaBan();
            }
        }
        return 10l;
    }

    private void checkSelected() {
        for (int i = 0; i < tblSP.getSelectedRow(); i++) {
            tblSP.setValueAt(true, i, 2);
        }
    }

    private void cbbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbTrangThaiActionPerformed

    public GiamGia getData() throws ParseException {
        int random = (int) (Math.random() * 99999);
        String ma = "VOUCHER" + random;
        String tenCT = this.txtTenCT.getText().trim();
        Date ngayBatDau = this.cdBatDau.getDate();
        Date ngayKetThuc = this.cbKetThuc.getDate();
        int loaiGiamGia = cbbLoaiMa.getSelectedIndex();
        String tienMat = this.txtTM.getText().trim();
        String trangThai = cbbTrangThai.getSelectedItem().toString();
        GiamGia giaGiam = new GiamGia();

        giaGiam.setMa(ma);
        giaGiam.setTenCT(tenCT);

        giaGiam.setNgayBatDau(ngayBatDau);
        giaGiam.setNgayKetThuc(ngayKetThuc);
        giaGiam.setGiamGiaTienMat(Long.valueOf(tienMat));
        giaGiam.setLoaiGiamGia(loaiGiamGia);
        giaGiam.setTrangThai(getTT(trangThai));
        return giaGiam;
    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            GiamGia giamGia = getData();
            if (giamGia == null) {
                return;
            }
            System.out.println(giamGia.toString());
            if (giamGiaService.insert(giamGia) != null) {
                loadForm(giamGiaService.getDanhSach());
                JOptionPane.showMessageDialog(this, "Them thanh cong");
            } else {
                JOptionPane.showMessageDialog(this, "Them that bai");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        try {
            int row = tblTable.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chon dong can sua");
                return;
            }
            String ma = tblTable.getValueAt(row, 0).toString();
            GiamGia giamGia = getData();
            giamGiaService.update(ma, giamGia);
            loadForm(giamGiaService.getDanhSach());
            JOptionPane.showMessageDialog(this, "Sua thanh cong");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
        }
        String ma = tblTable.getValueAt(row, 0).toString();
        int chose = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa", "delete", JOptionPane.YES_NO_OPTION);
        if (chose == JOptionPane.YES_OPTION) {
            giamGiaService.delete(ma);
            loadForm(giamGiaService.getDanhSach());
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbbLoaiMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiMaActionPerformed

    private void btn_VoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_VoucherActionPerformed
        int row = tblSP.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi them");
            return;
        }

        try {
            QLGiamGiaChiTiet x = new QLGiamGiaChiTiet();
            int rowGG = tblTable.getSelectedRow();
            String idGiamGia = tblTable.getValueAt(rowGG, 0).toString();
            Long giaGiam = (Long) tblTable.getValueAt(rowGG, 5);

            Long thanhTien = 0l;

            x.setIdGiamGia(getidGiamGia(idGiamGia));
            for (int i = 0; i < arr.size(); i++) {
                thanhTien = getGia(arr.get(i)) - giaGiam;
                x.setIdChiTietSP(arr.get(i));
                x.setSoTienConLai(thanhTien);
                if (giamGiaChiTietService.check(arr.get(i)) == false) {
                    JOptionPane.showMessageDialog(this, "San pham da duoc app ma");
                    return;
                } else {
                    //                    arr1.add(arr.get(i));
                    //                    map.put(idGiamGia, arr);
                }

                giamGiaChiTietService.insert(x);
            }
            JOptionPane.showMessageDialog(this, "Them thanh cong");
            loadForm(giamGiaService.getDanhSach());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_VoucherActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        int row = tblSP.getSelectedRow();
        try {
            Boolean bool = Boolean.valueOf(tblSP.getValueAt(row, 2).toString());
            if (bool) {
                String id = getidSP(tblSP.getValueAt(row, 0).toString());
                arr.add(id);
                System.out.println("1");
            } else {
                String id = getidSP(tblSP.getValueAt(row, 0).toString());
                arr.remove(id);
                System.out.println("2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void chk_SelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_SelectAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_SelectAllActionPerformed

    private void chk_SelectAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_SelectAllMouseClicked
        if (chk_SelectAll.isSelected()) {
            for (int i = 0; i < tblSP.getRowCount(); i++) {
                tblSP.setValueAt(true, i, 2);
                arr.add(getidSP(tblSP.getValueAt(i, 0).toString()));
            }
        } else {
            for (int i = 0; i < tblSP.getRowCount(); i++) {
                tblSP.setValueAt(false, i, 2);
                arr.clear();
            }
        }
    }//GEN-LAST:event_chk_SelectAllMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableMouseClicked
        try {
            int row = tblTable.getSelectedRow();
            if (row == -1) {
                return;
            }

            QLGiamGia gg = giamGiaService.getDanhSach().get(row);

            idGiamGia = gg.getId();

            String ma = tblTable.getValueAt(row, 0).toString();
            String tenCT = tblTable.getValueAt(row, 1).toString();
            String ngayTao = tblTable.getValueAt(row, 2).toString();
            String ngayBatDau = tblTable.getValueAt(row, 3).toString();
            String ngayKetThuc = tblTable.getValueAt(row, 4).toString();
            String soTienGiam = tblTable.getValueAt(row, 5).toString();
            String trangThai = tblTable.getValueAt(row, 6).toString();
            txtMa.setText(ma);
            txtTenCT.setText(tenCT);
            txtNtao.setText(ngayTao);
            cdBatDau.setDate(sdf.parse(ngayBatDau));
            cbKetThuc.setDate(sdf.parse(ngayKetThuc));
            txtTM.setText(soTienGiam);

            cbbTrangThai.setSelectedItem(trangThai);

            ArrayList<QLSanPhamDAT> ds = sanPhamService.getOne(ma);
            for (int i = 0; i < tblSP.getRowCount(); i++) {
                tblSP.setValueAt(false, i, 2);
                String masp = tblSP.getValueAt(i, 0).toString();
                for (int j = 0; j < ds.size(); j++) {
                    if (masp.equals(ds.get(j).getMaSP())) {
                        System.out.println("da vao if");
                        tblSP.setValueAt(true, i, 2);
                    } else {
                        System.out.println("da vao else");
                        tblSP.setValueAt(false, tblSP.getRowCount() - 1, 2);
                        arr1.add(ds.get(j).getId());
                        map.put(idGiamGia, arr1);
                    }
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tblTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_Voucher;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser cbKetThuc;
    private javax.swing.JComboBox<String> cbbLoaiMa;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser cdBatDau;
    private javax.swing.JCheckBox chk_SelectAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSP;
    private javax.swing.JTable tblTable;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNtao;
    private javax.swing.JTextField txtTM;
    private javax.swing.JTextField txtTenCT;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
