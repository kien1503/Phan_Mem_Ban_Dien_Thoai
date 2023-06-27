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
import com.model.HoaDon;
import com.model.HoaDonChiTiet;
import com.model.ImeiDaBan;
import com.model.KhachHang;
import com.service.IChiTietHdService;
import com.service.IChiTietSPService;
import com.service.IHoaDonService;
import com.service.IImeiDaBanService;
import com.service.IImeiService;
import com.service.IKhachHangService;
import com.service.impl.ChiTietHdService;
import com.service.impl.ChiTietSpService;
import com.service.impl.HoaDonService;
import com.service.impl.ImeiDaBanService;
import com.service.impl.ImeiService;
import com.service.impl.KhachHangService;
import com.viewmodel.ChiTietSpViewModel;
import com.viewmodel.GioHangChiTiet;
import com.viewmodel.HoaDonView;
import com.viewmodel.ImeiSanPhamView;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonJpanel extends javax.swing.JPanel implements Runnable, ThreadFactory {

    private IHoaDonService iHoaDonService = new HoaDonService();
    private IChiTietSPService iChiTietSPService = new ChiTietSpService();
    private IChiTietHdService iChiTietHdService = new ChiTietHdService();
    private IKhachHangService iKhachHangService = new KhachHangService();
    private IImeiDaBanService imeiDaBanService = new ImeiDaBanService();
    private IImeiService imeiService = new ImeiService();

    public static ArrayList<GioHangChiTiet> listGioHangChiTiet = new ArrayList<>();
    private ArrayList<GioHangChiTiet> listGHCTRong = new ArrayList<>();
    public static Map<String, ArrayList<GioHangChiTiet>> map = new HashMap<>();
    public static HashMap<String, ArrayList<Long>> hashMap = ChonImeiChoMay.hashMap;
    private HashMap<String, ArrayList<Long>> hMap = new HashMap<>();
    private HashMap<String, HashMap<String, ArrayList<Long>>> hMapHd = new HashMap<>();

    public static ArrayList<Long> listLong = new ArrayList<>();
    private ArrayList<ImeiSanPhamView> listImei = new ArrayList<>();
    private HashMap<String, ArrayList<ImeiSanPhamView>> hm1 = new HashMap<>();
    public static ArrayList<GioHangChiTiet> list11 = new ArrayList<>();

    public static int soLuong = 0;
    private int soLanMuaHang = 0;
    private Long imei = 0l;

    public static String idHoaDon = "";
    private static String idKh = "";
    private static String idGiamGia = "";
    public static String sdt = "";
    public static String idChiTietSP = "";

    private DecimalFormat df = new DecimalFormat("###,###,###");

    public HoaDonJpanel() {
        initComponents();

        loadTableHoaDon(iHoaDonService.listHoaDonView());
        btnThanhToan.setEnabled(false);
        initWebcam();
    }

    private void loadTableHoaDon(ArrayList<HoaDonView> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblHoaDon.getModel();
        dtm.setRowCount(0);
        int stt = 1;
        for (HoaDonView h : list) {
            Object[] rowData = {
                stt,
                h.getMaHd(),
                h.getMaNv(),
                h.getNgayTao(),
                h.checkTinhTrang(h.getTinhTrang())
            };
            dtm.addRow(rowData);
            stt++;
        }
    }

    public static void loadTableGioHang(ArrayList<GioHangChiTiet> list) {
        DefaultTableModel dtm = (DefaultTableModel) tblGioHang.getModel();
        dtm.setRowCount(0);
        Long tongTien = 0l;
        int stt = 1;
        Long giamGia = 0l;
        if (list == null) {
            list = new ArrayList<>();
        } else {
            for (GioHangChiTiet g : list) {
                Object[] rowData = {
                    stt,
                    g.getTenSp(),
                    g.getSoLuong(),
                    g.getDonGia(),
                    g.getGiamGia() * g.getSoLuong() == 0 ? 0 : g.getGiamGia() * g.getSoLuong(),
                    (g.getSoLuong() * g.getDonGia()) - g.getGiamGia(),};
                dtm.addRow(rowData);
                tongTien += (g.getSoLuong() * g.getDonGia());
                giamGia += g.getGiamGia() * g.getSoLuong();
                lblTongTien.setText(tongTien + "");
                lblGiamGia.setText(giamGia + "");
                lblTienSauGiam.setText(tongTien - giamGia + "");
                stt++;
            }
        }
    }

    private HoaDon getValidate() {
        HoaDon h = new HoaDon();

        int rand = (int) (Math.random() * 9999) + 1;

        h.setMa("HD" + rand);
        h.setIdNhanVien("36eb5d9d-00ee-4e89-b3d2-ad87a3e9b2f9");
        h.setTenKh("");
        h.setNgayTao(new Date());
        h.setTinhTrang(0);

        return h;
    }

    private String idHoaDon() {
        int row = this.tblHoaDon.getSelectedRow();

        ArrayList<HoaDonView> listHD = iHoaDonService.listHoaDonView();
        HoaDonView hdView = listHD.get(row);

        return hdView.getId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnClearGioHang = new javax.swing.JButton();
        btnDeleteChiTietSP = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnNewKhachHang = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblMaHd = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoTienMat = new javax.swing.JRadioButton();
        rdoBanking = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        txtHuy = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtGhiChu = new javax.swing.JTextField();
        lblKhachHang = new javax.swing.JLabel();
        txtSdtKh = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtMaGiaoDich = new javax.swing.JTextField();
        rdoCa2 = new javax.swing.JRadioButton();
        lblGiamGia = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lblTienSauGiam = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Bán Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Hóa đơn bán hàng");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Tên nhân viên", "Ngày tạo", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        btnTaoHoaDon.setBackground(new java.awt.Color(23, 35, 51));
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTaoHoaDon)
                .addGap(14, 14, 14))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHoaDon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Giỏ hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên sản phẩm", "Số lượng", "Đơn giá", "Giảm giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        tblGioHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblGioHangKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblGioHang);

        btnClearGioHang.setBackground(new java.awt.Color(23, 35, 51));
        btnClearGioHang.setForeground(new java.awt.Color(255, 255, 255));
        btnClearGioHang.setText("Clear All");
        btnClearGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearGioHangActionPerformed(evt);
            }
        });

        btnDeleteChiTietSP.setBackground(new java.awt.Color(23, 35, 51));
        btnDeleteChiTietSP.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteChiTietSP.setText("Xóa sản phẩm");
        btnDeleteChiTietSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteChiTietSPActionPerformed(evt);
            }
        });

        txtSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        btnSearch.setBackground(new java.awt.Color(23, 35, 51));
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeleteChiTietSP, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearGioHang)
                    .addComponent(btnDeleteChiTietSP)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(23, 35, 51));
        jLabel5.setText("Nhân viên");

        lblNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        lblNhanVien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblNhanVien.setText("-");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 35, 51));
        jLabel7.setText("Khách hàng:");

        btnNewKhachHang.setBackground(new java.awt.Color(23, 35, 51));
        btnNewKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        btnNewKhachHang.setText("OK");
        btnNewKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewKhachHangActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 35, 51));
        jLabel8.setText("Mã hóa đơn");

        lblMaHd.setBackground(new java.awt.Color(255, 255, 255));
        lblMaHd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblMaHd.setText("-");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(23, 35, 51));
        jLabel10.setText("Hìnhthức thanh toán");

        buttonGroup1.add(rdoTienMat);
        rdoTienMat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoTienMat.setForeground(new java.awt.Color(23, 35, 51));
        rdoTienMat.setText("Tiền mặt");
        rdoTienMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoTienMatActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoBanking);
        rdoBanking.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoBanking.setForeground(new java.awt.Color(23, 35, 51));
        rdoBanking.setText("Banking");
        rdoBanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoBankingActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(23, 35, 51));
        jLabel16.setText("Tổng tiền");

        lblTongTien.setBackground(new java.awt.Color(255, 255, 255));
        lblTongTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTongTien.setText("-");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(23, 35, 51));
        jLabel18.setText("Giảm giá");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(23, 35, 51));
        jLabel21.setText("Thành tiền");

        lblThanhTien.setBackground(new java.awt.Color(255, 255, 255));
        lblThanhTien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblThanhTien.setText("-");

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(23, 35, 51));
        jLabel23.setText("Khách trả");

        txtTienKhachTra.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtTienKhachTra.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachTraCaretUpdate(evt);
            }
        });
        txtTienKhachTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachTraActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(23, 35, 51));
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtHuy.setBackground(new java.awt.Color(23, 35, 51));
        txtHuy.setForeground(new java.awt.Color(255, 255, 255));
        txtHuy.setText("Hủy");
        txtHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHuyActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(23, 35, 51));
        jLabel24.setText("Ghi chú:");

        txtGhiChu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        lblKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        lblKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblKhachHang.setText("-");

        txtSdtKh.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(23, 35, 51));
        jLabel27.setText("Mã giao dịch");

        txtMaGiaoDich.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(rdoCa2);
        rdoCa2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rdoCa2.setForeground(new java.awt.Color(23, 35, 51));
        rdoCa2.setText("Cả 2");
        rdoCa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoCa2ActionPerformed(evt);
            }
        });

        lblGiamGia.setBackground(new java.awt.Color(255, 255, 255));
        lblGiamGia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblGiamGia.setText("-");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(23, 35, 51));
        jLabel22.setText("Tiền sau khi giảm");

        lblTienSauGiam.setBackground(new java.awt.Color(255, 255, 255));
        lblTienSauGiam.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblTienSauGiam.setText("-");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel24)
                                    .addGap(78, 78, 78)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGap(142, 142, 142)
                                    .addComponent(txtMaGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel27)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel16))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTienSauGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(34, 34, 34)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoTienMat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoBanking)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoCa2))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(51, 51, 51)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblMaHd, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(20, 20, 20))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(txtSdtKh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnNewKhachHang)))
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(btnNewKhachHang)
                    .addComponent(txtSdtKh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblMaHd))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdoTienMat)
                    .addComponent(rdoBanking)
                    .addComponent(rdoCa2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtMaGiaoDich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lblTongTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lblGiamGia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTienSauGiam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(lblThanhTien))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHuy)
                    .addComponent(btnThanhToan))
                .addGap(55, 55, 55))
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Hóa đơn");

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(384, 384, 384)))
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        HoaDon h = getValidate();

        if (h == null) {
            JOptionPane.showMessageDialog(this, "Null");
            return;
        }

        iHoaDonService.add(h);
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        loadTableHoaDon(iHoaDonService.listHoaDonView());
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int row = this.tblHoaDon.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi su dung chuc nang");
            return;
        }
//        listGioHangChiTiet = new ArrayList<>();

        ArrayList<HoaDonView> list = iHoaDonService.listHoaDonView();
        HoaDonView hd = list.get(row);

        idHoaDon = hd.getId();

        this.lblMaHd.setText(this.tblHoaDon.getValueAt(row, 1).toString());
        this.lblNhanVien.setText(this.tblHoaDon.getValueAt(row, 2).toString());

        if (this.tblHoaDon.getValueAt(row, 3).toString() != null) {
            this.lblKhachHang.setText(this.tblHoaDon.getValueAt(row, 3).toString());
        } else {
            this.lblKhachHang.setText("-");
        }
        Long tongTien = 0l;
        ArrayList<GioHangChiTiet> listLoad = map.get(idHoaDon);

        if (listLoad == null) {
            loadTableGioHang(listGHCTRong);
            lblTongTien.setText(tongTien + "");
        } else {
            loadTableGioHang(listLoad);
            for (GioHangChiTiet gioHangChiTiet : listLoad) {
                tongTien += gioHangChiTiet.getDonGia() * gioHangChiTiet.getSoLuong();
                lblTongTien.setText(tongTien + "");
            }
        }
//        loadTableGioHang(map);
//        loadTableGioHang(listGioHangChiTiet);

    }//GEN-LAST:event_tblHoaDonMouseClicked


    private void tblGioHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblGioHangKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblGioHangKeyPressed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int row = this.tblGioHang.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi su dung chuc nang");
            return;
        }
        GioHangChiTiet ghct = listGioHangChiTiet.get(row);
        idChiTietSP = ghct.getIdChiTietSp();

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnClearGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearGioHangActionPerformed
        int soLuong = 0;
        ArrayList<GioHangChiTiet> listGioHang = map.get(idHoaDon);

        map.remove(idHoaDon);
        System.out.println("Truoc khi clear hashMap: " + hashMap);
        hashMap.clear();
        System.out.println("sau khi clear hashMap: " + hashMap);
        loadTableGioHang(listGHCTRong);
    }//GEN-LAST:event_btnClearGioHangActionPerformed

    private void rdoBankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoBankingActionPerformed
        txtMaGiaoDich.setEditable(true);
    }//GEN-LAST:event_rdoBankingActionPerformed

    private void btnNewKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewKhachHangActionPerformed
        sdt = this.txtSdtKh.getText();
        JpanelKhachHang khView = new JpanelKhachHang();
        KhachHang kh = iKhachHangService.getKhToSdt(sdt);

        if (kh == null) {
            khView.setVisible(true);
            if (khView.isVisible() == false) {
                KhachHang kh1 = JpanelKhachHang.khachHang;
                idKh = kh1.getId();
                soLanMuaHang = kh1.getSoLanMua();
                lblKhachHang.setText(kh1.getTen());
            }
        } else {
            idKh = kh.getId();
            lblKhachHang.setText(kh.getTen());
        }
    }//GEN-LAST:event_btnNewKhachHangActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        HoaDon hd = hd();
        ImeiDaBan imeiDaBan = new ImeiDaBan();
        String idChiTietSp = "";
        String idHoaDonCT = "";
        if (hd == null) {
            JOptionPane.showMessageDialog(this, "Thanh toan that bai");
            return;
        }

        int soLuong = 0;
        int soLuongTon = 0;
        Boolean check = iHoaDonService.update(hd, idHoaDon);

        if (check == false) {
            System.out.println("Thanh toán thất bại");
            return;
        }

        if (listGioHangChiTiet == null) {
            System.out.println("Thanh toán thất bại");
            return;
        }
        ArrayList<HoaDonChiTiet> listHdct = new ArrayList<>();
        for (GioHangChiTiet gioHangChiTiet : listGioHangChiTiet) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();

            ChiTietSpViewModel ctView = iChiTietSPService.getSoLuong(gioHangChiTiet.getIdChiTietSp());
            soLuongTon = ctView.getSoLuong();
            soLuong = soLuongTon - gioHangChiTiet.getSoLuong();
            iChiTietSPService.update(soLuong, gioHangChiTiet.getIdChiTietSp());

            hdct.setIdHoaDon(idHoaDon);
            hdct.setIdChiTietSP(gioHangChiTiet.getIdChiTietSp());
            hdct.setSoLuong(gioHangChiTiet.getSoLuong());
            hdct.setDonGia(gioHangChiTiet.getDonGia());
            hdct.setTrangThai(0);

            System.out.println("idChiTietSP: " + gioHangChiTiet.getIdChiTietSp());

            listHdct.add(hdct);
            System.out.println("1");
        }

        for (HoaDonChiTiet hoaDonChiTiet : listHdct) {
            iChiTietHdService.add(hoaDonChiTiet);
            idHoaDon = hoaDonChiTiet.getIdHoaDon();
            idChiTietSp = hoaDonChiTiet.getIdChiTietSP();
            idHoaDonCT = iChiTietHdService.idHdct(idHoaDon, idChiTietSp);
            if (listImei == null) {
                JOptionPane.showMessageDialog(this, "Danh sach imei khong ton tai");
                return;
            } else {
                for (ImeiSanPhamView long1 : listImei) {
                    System.out.println("listImei: " + long1);
                    if (long1.getIdHoaDon().equals(idHoaDon)
                            && long1.getIdChiTietSp().equals(idChiTietSp)) {
                        imeiDaBan.setMaImei(long1.getImei());
                        imeiService.updateTrangThai(1, long1.getImei());
                        imeiDaBan.setIdHoaDonCT(idHoaDonCT);
                        imeiDaBan.setTrangThai(1);
                        imeiDaBanService.add(imeiDaBan);
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Thanh toan thanh cong");
        loadTableGioHang(listGioHangChiTiet);
        loadTableHoaDon(iHoaDonService.listHoaDonView());
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachTraCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachTraCaretUpdate
        String tienKhachTra1 = this.txtTienKhachTra.getText();
        Long tienKhachTra = 0l;
        if (tienKhachTra1 == null || tienKhachTra1.equals("")) {
            tienKhachTra = 0l;
        } else {
            tienKhachTra = Long.valueOf(tienKhachTra1);
            Long tongTien = Long.valueOf(lblTienSauGiam.getText());
            Long tienThuaKhongGiamGia = 0l;
            if (tienKhachTra == 0l) {
                tienKhachTra = 0l;
            } else {
                tienThuaKhongGiamGia = tienKhachTra - tongTien;
            }
            lblThanhTien.setText(tienThuaKhongGiamGia + "");

            if (tienThuaKhongGiamGia > 0) {
                btnThanhToan.setEnabled(false);
            } else {
                btnThanhToan.setEnabled(true);
            }
        }
    }//GEN-LAST:event_txtTienKhachTraCaretUpdate

    private void txtTienKhachTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienKhachTraActionPerformed

    private void btnDeleteChiTietSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteChiTietSPActionPerformed
        int row = this.tblGioHang.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon 1 dong truoc khi xoa");
            return;
        }

        GioHangChiTiet ghct = listGioHangChiTiet.get(row);

        hashMap.clear();
        map.remove(ghct.getIdHoaDon());
        listGioHangChiTiet.remove(row);
        loadTableGioHang(listGioHangChiTiet);
    }//GEN-LAST:event_btnDeleteChiTietSPActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        Long imei1 = Long.valueOf(txtSearch.getText());
        checkMay(imei1);

    }//GEN-LAST:event_btnSearchActionPerformed

    private void rdoCa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoCa2ActionPerformed
        txtMaGiaoDich.setEditable(true);
    }//GEN-LAST:event_rdoCa2ActionPerformed

    private void rdoTienMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoTienMatActionPerformed
        txtMaGiaoDich.setEditable(false);
    }//GEN-LAST:event_rdoTienMatActionPerformed

    private void txtHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHuyActionPerformed

    }//GEN-LAST:event_txtHuyActionPerformed

    private HoaDon hd() {
        HoaDon h = new HoaDon();
        String idKh1 = idKh;
        String tenKh = this.lblKhachHang.getText();
        String maGiaoDich = this.txtMaGiaoDich.getText();
        String ghiChu = this.txtGhiChu.getText();

        if (idKh1 == null) {
            h.setIdKh(null);
        } else {
            h.setIdKh(idKh);
        }

        if (tenKh == null) {
            h.setTenKh("");
        } else {
            h.setTenKh(tenKh);
        }

        h.setNgayThanhToan(new Date());
        h.setNgayShip(null);
        h.setNgayNhan(null);
        h.setTienCoc(0l);
        h.setTienShip(0l);
        h.setSdtNguoiShip("<trống>");
        h.setMaVanChuyen("<trống>");
        h.setDiaChiNhanHang("<trống>");
        if (rdoBanking.isSelected()) {
            h.setHinhThucThanhToan(1);
            h.setMaGiaoDich(maGiaoDich);
        } else if (rdoTienMat.isSelected()) {
            h.setHinhThucThanhToan(0);
            h.setMaGiaoDich("<trống>");
        } else {
            h.setHinhThucThanhToan(2);
            h.setMaGiaoDich(maGiaoDich);
        }
        h.setGhiChu(ghiChu);
        h.setTinhTrang(1);

        return h;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearGioHang;
    private javax.swing.JButton btnDeleteChiTietSP;
    private javax.swing.JButton btnNewKhachHang;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblMaHd;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblThanhTien;
    private static javax.swing.JLabel lblTienSauGiam;
    private static javax.swing.JLabel lblTongTien;
    private javax.swing.JRadioButton rdoBanking;
    private javax.swing.JRadioButton rdoCa2;
    private javax.swing.JRadioButton rdoTienMat;
    public static javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JButton txtHuy;
    private javax.swing.JTextField txtMaGiaoDich;
    private javax.swing.JTextField txtSdtKh;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTienKhachTra;
    // End of variables declaration//GEN-END:variables

    private WebcamPanel panel = null;
    public static Webcam webcam = null;

    private final long barCode = 523698745123652522l;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    private void initWebcam() {

        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel6.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 220, 260));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1000);
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
                imei = Long.valueOf(result.getText());
                checkMay(imei);
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    private void checkMay(Long imei1) {
        boolean check = true;
        if (idHoaDon.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long chon hoa don muon giao dich");
            return;
        }
        GioHangChiTiet ghct = iChiTietHdService.ghct(imei1);
        if (ghct.getTenSp() == null || ghct.getDonGia() == 0l) {
            JOptionPane.showMessageDialog(this, "Khong tim thay san pham");
            return;
        } else {
            listGioHangChiTiet = map.get(idHoaDon);
            Long giamGia = iChiTietSPService.giamGia(ghct.getIdChiTietSp());
            ghct.setSoLuong(1);
            ghct.setIdHoaDon(idHoaDon);
            ghct.setGiamGia(giamGia);

            ImeiSanPhamView imeiSP = new ImeiSanPhamView();
            imeiSP.setIdHoaDon(idHoaDon);
            imeiSP.setImei(imei1);
            imeiSP.setIdChiTietSp(ghct.getIdChiTietSp());

            if (listImei.isEmpty()) {
                listImei.add(imeiSP);
                listLong.add(imei1);
                hMap.put(ghct.getIdChiTietSp(), listLong);
                hMapHd.put(idHoaDon, hMap);
            } else {
                for (ImeiSanPhamView imeiSanPhamView : listImei) {
                    if (imeiSanPhamView.getImei().equals(imei1)) {
                        JOptionPane.showMessageDialog(this, "So imei nay da duoc them vao gio hang\n"
                                + "Vui su dung imei khac");
                        return;
                    }
                }
                listImei.add(imeiSP);
            }

            if (listGioHangChiTiet == null) {
                listGioHangChiTiet = new ArrayList<>();
                listGioHangChiTiet.add(ghct);
                map.put(idHoaDon, listGioHangChiTiet);
            } else {
                for (int i = 0; i < listGioHangChiTiet.size(); i++) {
                    if (listGioHangChiTiet.get(i).getIdChiTietSp().equals(ghct.getIdChiTietSp())) {
                        int soLuong = listGioHangChiTiet.get(i).getSoLuong();
                        ghct.setSoLuong(soLuong + 1);
                        listGioHangChiTiet.set(i, ghct);
                        map.put(idHoaDon, listGioHangChiTiet);
                        loadTableGioHang(listGioHangChiTiet);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    listGioHangChiTiet.add(ghct);
                    map.put(idHoaDon, listGioHangChiTiet);
                    loadTableGioHang(listGioHangChiTiet);
                }
            }
            System.out.println("listImei1: " + listImei);
            JOptionPane.showMessageDialog(this, "Da tim thay san pham " + ghct.getTenSp());
            loadTableGioHang(listGioHangChiTiet);
        }
    }
}
