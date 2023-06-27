package com.view;

import com.model.ChiTietSanPham;
import com.model.Imei;
import com.service.ICamService;
import com.service.IChipService;
import com.service.IDongSpService;
import com.service.IImeiService;
import com.service.IManHinhService;
import com.service.IMauSacService;
import com.service.IPhanLoaiHangService;
import com.service.IPinService;
import com.service.IRamService;
import com.service.IRomService;
import com.service.ISanPhamService;
import com.service.IXuatXuService;
import com.service.impl.CTSanPhamService;
import com.service.impl.CameraService;
import com.service.impl.ChipSeService;
import com.service.impl.DongSPService;
import com.service.impl.ImeiService;
import com.service.impl.ManHinhService;
import com.service.impl.MauSacService;
import com.service.impl.PhanLoaiHangService;
import com.service.impl.PinService;
import com.service.impl.RamService;
import com.service.impl.RomService;
import com.service.impl.SanPhamService;
import com.service.impl.XuatXuService;
import com.viewmodel.QLCTSanPham;
import com.viewmodel.QLCamera;
import com.viewmodel.QLChipSE;
import com.viewmodel.QLDongSp;
import com.viewmodel.QLImeil;
import com.viewmodel.QLManHinh;
import com.viewmodel.QLMauSac;
import com.viewmodel.QLPIN;
import com.viewmodel.QLPhanLoaiHang;
import com.viewmodel.QLRam;
import com.viewmodel.QLRom;
import com.viewmodel.QLSanPham;
import com.viewmodel.QLXuatXu;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FromCTSanPham extends javax.swing.JPanel {

    private CTSanPhamService ctspService;
    private ICamService camService;
    private IChipService chipService;
    private IDongSpService dongService;
    private IImeiService imeiService;
    private IManHinhService manHinhService;
    private IMauSacService mauService;
    private IPinService pinService;
    private IPhanLoaiHangService plService;
    private IRamService ramService;
    private IRomService romService;
    private ISanPhamService spService;
    private IXuatXuService xuatXuService;
    private DefaultComboBoxModel defaultComboBoxModel;
    private String duongDanAnh = "D:\\Anh\\img";
    public static String idChiTietSP = "";
    private ArrayList<Imei> listRong = new ArrayList<>();

    public FromCTSanPham() {
        initComponents();
        ctspService = new CTSanPhamService();
        camService = new CameraService();
        chipService = new ChipSeService();
        dongService = new DongSPService();
        imeiService = new ImeiService();
        manHinhService = new ManHinhService();
        mauService = new MauSacService();
        pinService = new PinService();
        plService = new PhanLoaiHangService();
        ramService = new RamService();
        romService = new RomService();
        spService = new SanPhamService();
        xuatXuService = new XuatXuService();
        loadTable();
        loadCBBCamera();
        loadCBBChip();
        loadCBBDongSp();
        loadCBBManHinh();
        loadCBBMauSac();
        loadCBBPhanLoaiHang();
        loadCBBPin();
        loadCBBRam();
        loadCBBRom();
        loadCBBSanPham();
        loadCBBXuatXu();
    }

    private void loadTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_sanPham.getModel();
        dtm.setRowCount(0);
        for (QLCTSanPham sp : ctspService.getList()) {
            Object[] data = {
                sp.getAnh(),
                sp.getTenSP(),
                sp.getLoai(),
                sp.getRam(),
                sp.getRom(),
                sp.getManhinh(),
                sp.getSoLuong(),
                sp.getGiaBan()
            };
            dtm.addRow(data);
            tbl_sanPham.setRowHeight(50);
        }

    }

    private void loadCBBCamera() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLCamera x : camService.getList()) {
            dcm.addElement(x.getCam());
        }
        cbbCamera.setModel(dcm);
    }

    private void loadCBBChip() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLChipSE x : chipService.getList()) {
            dcm.addElement(x.getChip());
        }
        cbbChipse.setModel(dcm);
    }

    private void loadCBBDongSp() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLDongSp x : dongService.getList()) {
            dcm.addElement(x.getTenDongSP());
        }
        cbbDongSanPham.setModel(dcm);
    }

    public static void loadCBBImei(ArrayList<Imei> list) {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbImei.getModel();
        for (Imei x : list) {
            dcm.addElement(x.getSoImei());
        }
        cbbImei.setModel(dcm);
    }

    private void loadCBBImei1(ArrayList<Imei> list) {
        DefaultComboBoxModel dcm = (DefaultComboBoxModel) cbbImei.getModel();
        dcm.removeAllElements();
        for (Imei x : list) {
            dcm.addElement(x.getSoImei());
        }
    }

    private void loadCBBManHinh() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLManHinh x : manHinhService.getList()) {
            dcm.addElement(x.getTen());
        }
        cbbManHinh.setModel(dcm);
    }

    private void loadCBBMauSac() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLMauSac x : mauService.getList()) {
            dcm.addElement(x.getMau());
        }
        cbbMauSac.setModel(dcm);
    }

    private void loadCBBPhanLoaiHang() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLPhanLoaiHang x : plService.getList()) {
            dcm.addElement(x.getTenLoai());
        }
        cbbPhanLoaiHang.setModel(dcm);
    }

    private void loadCBBPin() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLPIN x : pinService.getList()) {
            dcm.addElement(x.getDungLuong());
        }
        cbbPin.setModel(dcm);
    }

    private void loadCBBRam() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLRam x : ramService.getList()) {
            dcm.addElement(x.getRam());
        }
        cbbRam.setModel(dcm);
    }

    private void loadCBBRom() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLRom x : romService.getList()) {
            dcm.addElement(x.getRom());
        }
        cbbRom.setModel(dcm);
    }

    private void loadCBBSanPham() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLSanPham x : spService.getList()) {
            dcm.addElement(x.getTenSP());
        }
        cbbTenSP.setModel(dcm);
    }

    private void loadCBBXuatXu() {
        DefaultComboBoxModel dcm = new DefaultComboBoxModel();
        for (QLXuatXu x : xuatXuService.getList()) {
            dcm.addElement(x.getTenXuatXu());
        }
        cbbXuatXu.setModel(dcm);
    }

    private String getIdRom() {
        String idRom = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbRom.getModel();
        ArrayList<QLRom> listRom = this.romService.getList();
        for (QLRom qLRom : listRom) {
            if (qLRom.getRom().equals(cbbRom.getSelectedItem())) {
                idRom = qLRom.getId();
            }
        }
        return idRom;
    }

    private String getIdRam() {
        String idRam = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbRam.getModel();
        ArrayList<QLRam> listRam = this.ramService.getList();
        for (QLRam qLRam : listRam) {
            if (qLRam.getRam().equals(cbbRam.getSelectedItem())) {
                idRam = qLRam.getId();
            }
        }
        return idRam;
    }

    private String getIdManHinh() {
        String idManHinh = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbManHinh.getModel();
        ArrayList<QLManHinh> listMh = this.manHinhService.getList();
        for (QLManHinh qlMh : listMh) {
            if (qlMh.getTen().equals(cbbManHinh.getSelectedItem())) {
                idManHinh = qlMh.getId();
            }
        }
        return idManHinh;
    }

    private String getIdChipse() {
        String idChipse = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbChipse.getModel();
        ArrayList<QLChipSE> listChipse = this.chipService.getList();
        for (QLChipSE qlChipse : listChipse) {
            if (qlChipse.getChip().equals(cbbChipse.getSelectedItem())) {
                idChipse = qlChipse.getId();
            }
        }
        return idChipse;
    }

    private String getIdCamera() {
        String idCamera = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbCamera.getModel();
        ArrayList<QLCamera> listCamera = this.camService.getList();
        for (QLCamera qlCamera : listCamera) {
            if (qlCamera.getCam().equals(cbbCamera.getSelectedItem())) {
                idCamera = qlCamera.getId();
            }
        }
        return idCamera;
    }

    private String getIdMauSac() {
        String idMauSac = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbMauSac.getModel();
        ArrayList<QLMauSac> listMauSac = this.mauService.getList();
        for (QLMauSac qlMauSac : listMauSac) {
            if (qlMauSac.getMau().equals(cbbMauSac.getSelectedItem())) {
                idMauSac = qlMauSac.getId();
            }
        }
        return idMauSac;
    }

    private String getIdPhanLoaiHang() {
        String idPhanLoaiHang = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbPhanLoaiHang.getModel();
        ArrayList<QLPhanLoaiHang> listPhanLoai = this.plService.getList();
        for (QLPhanLoaiHang qlPl : listPhanLoai) {
            if (qlPl.getTenLoai().equals(cbbPhanLoaiHang.getSelectedItem())) {
                idPhanLoaiHang = qlPl.getId();
            }
        }
        return idPhanLoaiHang;
    }

    private String getIdDongSP() {
        String idDongSp = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbDongSanPham.getModel();
        ArrayList<QLDongSp> listDongSp = this.dongService.getList();
        for (QLDongSp qlDongSp : listDongSp) {
            if (qlDongSp.getTenDongSP().equals(cbbDongSanPham.getSelectedItem())) {
                idDongSp = qlDongSp.getId();
            }
        }
        return idDongSp;
    }

    private String getIdXuatXu() {
        String idXuatxu = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbXuatXu.getModel();
        ArrayList<QLXuatXu> listXuatXu = this.xuatXuService.getList();
        for (QLXuatXu qlXuatXu : listXuatXu) {
            if (qlXuatXu.getTenXuatXu().equals(cbbXuatXu.getSelectedItem())) {
                idXuatxu = qlXuatXu.getId();
            }
        }
        return idXuatxu;
    }

    private String getIdPin() {
        String idPin = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbPin.getModel();
        ArrayList<QLPIN> listPin = this.pinService.getList();
        for (QLPIN qlPin : listPin) {
            if (qlPin.getDungLuong().equals(cbbPin.getSelectedItem())) {
                idPin = qlPin.getId();
            }
        }
        return idPin;
    }

    private String getIdSanPham() {
        String idSanPham = "";
        defaultComboBoxModel = (DefaultComboBoxModel) this.cbbTenSP.getModel();
        ArrayList<QLSanPham> listSP = this.spService.getList();
        for (QLSanPham qlsp : listSP) {
            if (qlsp.getTenSP().equals(cbbTenSP.getSelectedItem())) {
                idSanPham = qlsp.getId();
            }
        }
        return idSanPham;
    }

    public static void setSoLuong(int soLuong) {
        lblSoLuongTon.setText(soLuong + "");
    }

    private ChiTietSanPham getValidate() {
        ChiTietSanPham ctsp = new ChiTietSanPham();

        ctsp.setIdSP(getIdSanPham());
        ctsp.setIdMauSac(getIdMauSac());
        ctsp.setIdChipse(getIdChipse());
        ctsp.setIdPin(getIdPin());
        ctsp.setIdPhanLoaiHang(getIdPhanLoaiHang());
        ctsp.setIdRam(getIdRam());
        ctsp.setIdRom(getIdRom());
        ctsp.setIdManHinh(getIdManHinh());
        ctsp.setIdCamera(getIdCamera());
        ctsp.setIdXuatXu(getIdXuatXu());
        ctsp.setIdDongSP(getIdDongSP());
        ctsp.setGiaNhap(Long.valueOf(this.txt_giaNhap.getText()));
        ctsp.setGiaBan(Long.valueOf(this.txt_giaBan.getText()));
        ctsp.setNamBH(Integer.valueOf(this.txtNam.getText()));
        ctsp.setMoTa(this.txt_mota.getText());
        ctsp.setSoLuongTon(Integer.valueOf(this.lblSoLuongTon.getText()));
        ctsp.setTrangThai(1);
        ctsp.setAnh(duongDanAnh);

        return ctsp;
    }

    private String getIdChiTietSp() {
        int row = this.tbl_sanPham.getSelectedRow();
        ArrayList<QLCTSanPham> listChiTiet = ctspService.getList();
        QLCTSanPham qlCTSP = listChiTiet.get(row);

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon 1 dong truoc khi su dung chuc nang");
            return null;
        }

        return qlCTSP.getId();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        formSp = new javax.swing.JTabbedPane();
        jpn_sp = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txt_seach = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_ma = new javax.swing.JButton();
        btn_ten = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanPham = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Loại1 = new javax.swing.JLabel();
        Loại2 = new javax.swing.JLabel();
        Loại3 = new javax.swing.JLabel();
        Loại4 = new javax.swing.JLabel();
        Loại5 = new javax.swing.JLabel();
        Loại6 = new javax.swing.JLabel();
        lbl_anh = new javax.swing.JLabel();
        Loại7 = new javax.swing.JLabel();
        cbbTenSP = new javax.swing.JComboBox<>();
        cbbRom = new javax.swing.JComboBox<>();
        cbbManHinh = new javax.swing.JComboBox<>();
        cbbChipse = new javax.swing.JComboBox<>();
        cbbCamera = new javax.swing.JComboBox<>();
        cbbDongSanPham = new javax.swing.JComboBox<>();
        cbbXuatXu = new javax.swing.JComboBox<>();
        cbbPhanLoaiHang = new javax.swing.JComboBox<>();
        cbbRam = new javax.swing.JComboBox<>();
        cbbPin = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbImei = new javax.swing.JComboBox<>();
        Loại8 = new javax.swing.JLabel();
        Loại9 = new javax.swing.JLabel();
        txt_giaNhap = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Loại10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        Loại11 = new javax.swing.JLabel();
        btn_themsp = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btn_bonho = new javax.swing.JButton();
        btn_MANHINH = new javax.swing.JButton();
        btn_CHIPSE = new javax.swing.JButton();
        btn_CAMERA = new javax.swing.JButton();
        btn_MAUSAC = new javax.swing.JButton();
        btnImei = new javax.swing.JButton();
        btn_HDH = new javax.swing.JButton();
        btn_PHANLOAI = new javax.swing.JButton();
        btn_DUNGLUONG = new javax.swing.JButton();
        btn_NSX = new javax.swing.JButton();
        btn_PIN = new javax.swing.JButton();
        lblSoLuongTon = new javax.swing.JLabel();
        btnThemAnh = new javax.swing.JButton();
        Loại12 = new javax.swing.JLabel();
        txtNam = new javax.swing.JTextField();
        formSp1 = new javax.swing.JTabbedPane();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        setLayout(new java.awt.BorderLayout());

        jpn_sp.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(23, 35, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Seach");

        txt_seach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel1.setText("Sắp Xếp Theo");

        btn_ma.setBackground(new java.awt.Color(23, 35, 51));
        btn_ma.setForeground(new java.awt.Color(255, 255, 255));
        btn_ma.setText("Mã");

        btn_ten.setBackground(new java.awt.Color(23, 35, 51));
        btn_ten.setForeground(new java.awt.Color(255, 255, 255));
        btn_ten.setText("Tên");

        tbl_sanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ảnh", "Tên SP", "Loại", "Ram", "Rom", "Màn Hình", "Số Lượng", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_sanPham);

        jLabel2.setText("Bộ Nhớ Trong");

        jLabel3.setText("Màn Hình");

        jLabel4.setText("Pin");

        jLabel5.setText("Màu Sắc");

        jLabel6.setText("Chipse");

        Loại1.setText("Camera");

        Loại2.setText("Xuất Xứ");

        Loại3.setText("Dung Lượng RAM");

        Loại4.setText("Phân Loại Hàng");

        Loại5.setText("Dòng Sản Phẩm");

        Loại6.setForeground(new java.awt.Color(23, 35, 51));
        Loại6.setText("Imei");

        Loại7.setForeground(new java.awt.Color(23, 35, 51));
        Loại7.setText("Tên Sản Phẩm");

        cbbTenSP.setBackground(new java.awt.Color(23, 35, 51));
        cbbTenSP.setForeground(new java.awt.Color(255, 255, 255));

        cbbRom.setBackground(new java.awt.Color(23, 35, 51));
        cbbRom.setForeground(new java.awt.Color(255, 255, 255));

        cbbManHinh.setBackground(new java.awt.Color(23, 35, 51));
        cbbManHinh.setForeground(new java.awt.Color(255, 255, 255));

        cbbChipse.setBackground(new java.awt.Color(23, 35, 51));
        cbbChipse.setForeground(new java.awt.Color(255, 255, 255));

        cbbCamera.setBackground(new java.awt.Color(23, 35, 51));
        cbbCamera.setForeground(new java.awt.Color(255, 255, 255));

        cbbDongSanPham.setBackground(new java.awt.Color(23, 35, 51));
        cbbDongSanPham.setForeground(new java.awt.Color(255, 255, 255));

        cbbXuatXu.setBackground(new java.awt.Color(23, 35, 51));
        cbbXuatXu.setForeground(new java.awt.Color(255, 255, 255));
        cbbXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbXuatXuActionPerformed(evt);
            }
        });

        cbbPhanLoaiHang.setBackground(new java.awt.Color(23, 35, 51));
        cbbPhanLoaiHang.setForeground(new java.awt.Color(255, 255, 255));

        cbbRam.setBackground(new java.awt.Color(23, 35, 51));
        cbbRam.setForeground(new java.awt.Color(255, 255, 255));

        cbbPin.setBackground(new java.awt.Color(23, 35, 51));
        cbbPin.setForeground(new java.awt.Color(255, 255, 255));

        cbbMauSac.setBackground(new java.awt.Color(23, 35, 51));
        cbbMauSac.setForeground(new java.awt.Color(255, 255, 255));

        cbbImei.setBackground(new java.awt.Color(23, 35, 51));
        cbbImei.setForeground(new java.awt.Color(255, 255, 255));
        cbbImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbImeiActionPerformed(evt);
            }
        });

        Loại8.setForeground(new java.awt.Color(23, 35, 51));
        Loại8.setText("Giá Nhập");

        Loại9.setForeground(new java.awt.Color(23, 35, 51));
        Loại9.setText("Giá Bán");

        txt_giaNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel7.setText("VNĐ");

        txt_giaBan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));

        jLabel8.setText("VNĐ");

        Loại10.setText("Số Lượng");

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        Loại11.setText("Mô Tả Sản Phẩm");

        btn_themsp.setBackground(new java.awt.Color(23, 35, 51));
        btn_themsp.setForeground(new java.awt.Color(255, 255, 255));
        btn_themsp.setText("Thêm");
        btn_themsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themspActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(23, 35, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa ");
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

        btn_bonho.setBackground(new java.awt.Color(23, 35, 51));
        btn_bonho.setForeground(new java.awt.Color(255, 255, 255));
        btn_bonho.setText("-");
        btn_bonho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bonhoActionPerformed(evt);
            }
        });

        btn_MANHINH.setBackground(new java.awt.Color(23, 35, 51));
        btn_MANHINH.setForeground(new java.awt.Color(255, 255, 255));
        btn_MANHINH.setText("-");
        btn_MANHINH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MANHINHActionPerformed(evt);
            }
        });

        btn_CHIPSE.setBackground(new java.awt.Color(23, 35, 51));
        btn_CHIPSE.setForeground(new java.awt.Color(255, 255, 255));
        btn_CHIPSE.setText("-");
        btn_CHIPSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CHIPSEActionPerformed(evt);
            }
        });

        btn_CAMERA.setBackground(new java.awt.Color(23, 35, 51));
        btn_CAMERA.setForeground(new java.awt.Color(255, 255, 255));
        btn_CAMERA.setText("-");
        btn_CAMERA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CAMERAActionPerformed(evt);
            }
        });

        btn_MAUSAC.setBackground(new java.awt.Color(23, 35, 51));
        btn_MAUSAC.setForeground(new java.awt.Color(255, 255, 255));
        btn_MAUSAC.setText("-");

        btnImei.setBackground(new java.awt.Color(23, 35, 51));
        btnImei.setForeground(new java.awt.Color(255, 255, 255));
        btnImei.setText("-");
        btnImei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImeiActionPerformed(evt);
            }
        });

        btn_HDH.setBackground(new java.awt.Color(23, 35, 51));
        btn_HDH.setForeground(new java.awt.Color(255, 255, 255));
        btn_HDH.setText("-");

        btn_PHANLOAI.setBackground(new java.awt.Color(23, 35, 51));
        btn_PHANLOAI.setForeground(new java.awt.Color(255, 255, 255));
        btn_PHANLOAI.setText("-");

        btn_DUNGLUONG.setBackground(new java.awt.Color(23, 35, 51));
        btn_DUNGLUONG.setForeground(new java.awt.Color(255, 255, 255));
        btn_DUNGLUONG.setText("-");

        btn_NSX.setBackground(new java.awt.Color(23, 35, 51));
        btn_NSX.setForeground(new java.awt.Color(255, 255, 255));
        btn_NSX.setText("-");

        btn_PIN.setBackground(new java.awt.Color(23, 35, 51));
        btn_PIN.setForeground(new java.awt.Color(255, 255, 255));
        btn_PIN.setText("-");

        lblSoLuongTon.setText("-");

        btnThemAnh.setBackground(new java.awt.Color(23, 35, 51));
        btnThemAnh.setForeground(new java.awt.Color(255, 255, 255));
        btnThemAnh.setText("Thêm ảnh");
        btnThemAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemAnhActionPerformed(evt);
            }
        });

        Loại12.setForeground(new java.awt.Color(23, 35, 51));
        Loại12.setText("Năm bảo hành");

        txtNam.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(23, 35, 51)));
        txtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpn_spLayout = new javax.swing.GroupLayout(jpn_sp);
        jpn_sp.setLayout(jpn_spLayout);
        jpn_spLayout.setHorizontalGroup(
            jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_spLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(63, 63, 63)
                        .addComponent(jLabel3))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addComponent(cbbRom, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_MANHINH)))
                    .addComponent(btn_bonho))
                .addGap(66, 66, 66)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(btn_CHIPSE)
                    .addComponent(cbbChipse, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Loại1)
                    .addComponent(btn_CAMERA)
                    .addComponent(cbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel5))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_MAUSAC)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(130, 130, 130)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Loại6)
                            .addComponent(Loại9))
                        .addGap(9, 9, 9)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addComponent(cbbImei, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnImei)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Loại10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_spLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(cbbTenSP, javax.swing.GroupLayout.Alignment.LEADING, 0, 131, Short.MAX_VALUE)
                                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7)))
                                .addGap(41, 41, 41))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Loại8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Loại7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Loại12, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jpn_spLayout.createSequentialGroup()
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addComponent(txt_seach, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(btn_ma)
                        .addGap(48, 48, 48)
                        .addComponent(btn_ten))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbPhanLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Loại4))
                                        .addGap(128, 128, 128))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addComponent(btn_PHANLOAI)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Loại5)
                                            .addComponent(btn_HDH))))
                                .addGap(66, 66, 66)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Loại3)
                                    .addComponent(btn_PIN))
                                .addGap(45, 45, 45)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Loại2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_DUNGLUONG))
                                .addGap(48, 48, 48)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(cbbPin, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_NSX))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addComponent(btn_themsp)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Loại11))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_spLayout.createSequentialGroup()
                        .addComponent(btnThemAnh)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_spLayout.createSequentialGroup()
                        .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );
        jpn_spLayout.setVerticalGroup(
            jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_spLayout.createSequentialGroup()
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btn_ma)
                            .addComponent(btn_ten)))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_seach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addComponent(lbl_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnThemAnh)))))
                .addGap(42, 42, 42)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(Loại1))
                        .addGap(18, 18, 18)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbRom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbManHinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChipse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbCamera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_bonho)
                            .addComponent(btn_MANHINH)
                            .addComponent(btn_CHIPSE)
                            .addComponent(btn_CAMERA)
                            .addComponent(btn_MAUSAC)))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Loại7)
                                    .addComponent(cbbTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(Loại8))))
                .addGap(12, 12, 12)
                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Loại9)
                            .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(29, 29, 29)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Loại12)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Loại10)
                            .addComponent(lblSoLuongTon)
                            .addComponent(Loại6)
                            .addComponent(cbbImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnImei))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(Loại11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themsp)
                            .addComponent(btnSua)
                            .addComponent(btnXoa))
                        .addGap(77, 77, 77))
                    .addGroup(jpn_spLayout.createSequentialGroup()
                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addComponent(Loại5)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbDongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addComponent(Loại4)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbPhanLoaiHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(Loại3))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbbRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addComponent(Loại2)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpn_spLayout.createSequentialGroup()
                                        .addGap(94, 94, 94)
                                        .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btn_NSX)
                                                .addComponent(btn_PIN))
                                            .addComponent(btn_DUNGLUONG)))))
                            .addGroup(jpn_spLayout.createSequentialGroup()
                                .addGap(191, 191, 191)
                                .addGroup(jpn_spLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_HDH)
                                    .addComponent(btn_PHANLOAI))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        formSp.addTab("Sản Phẩm", jpn_sp);
        formSp.addTab("Chi Tiết SP", formSp1);

        add(formSp, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbImeiActionPerformed

    }//GEN-LAST:event_cbbImeiActionPerformed

    private void cbbXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbXuatXuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbXuatXuActionPerformed

    private void btn_themspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themspActionPerformed
        ChiTietSanPham ctsp = getValidate();

        if (ctsp == null) {
            JOptionPane.showMessageDialog(this, "Them that bai");
            return;
        }

        ctspService.update(ctsp, idChiTietSP);
        JOptionPane.showMessageDialog(this, "Them thanh cong");
        loadTable();

    }//GEN-LAST:event_btn_themspActionPerformed

    private ImageIcon ResizeImage1(String image) {
        ImageIcon myImage = new ImageIcon(image);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(newImg);
        return image1;
    }

    private ImageIcon ResizeImage(String image) {
        ImageIcon myImage = new ImageIcon(image);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(lbl_anh.getWidth(), lbl_anh.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(newImg);
        return image1;
    }

    private void btnThemAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemAnhActionPerformed
        ChiTietSanPham ctsp = new ChiTietSanPham();

        try {
            JFileChooser f = new JFileChooser("D:\\Anh\\img");
            f.setDialogTitle("Mo file");
            f.showOpenDialog(null);
            File fTenAnh = f.getSelectedFile();
            duongDanAnh = fTenAnh.getAbsolutePath();
            if (duongDanAnh != null) {
                ctsp.setAnh(duongDanAnh);
                if (imeiService.count(duongDanAnh) > 0) {
                    JOptionPane.showMessageDialog(this, "San pham da ton tai");
                    return;
                } else {
                    lbl_anh.setIcon(ResizeImage(String.valueOf(duongDanAnh)));
                    JOptionPane.showMessageDialog(this, "them thanh cong");
                    ctspService.add(ctsp);
                    System.out.println(duongDanAnh);
                    for (ChiTietSanPham ctsp1 : ctspService.getAll()) {
                        if (ctsp1.getAnh().equals(duongDanAnh)) {
                            idChiTietSP = ctsp1.getId();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chua chon anh");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Loi");
        }
        loadCBBImei(listRong);
    }//GEN-LAST:event_btnThemAnhActionPerformed

    private void txtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamActionPerformed

    private void btnImeiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImeiActionPerformed
        ImeiFrame imei = new ImeiFrame();
        imei.setVisible(true);
    }//GEN-LAST:event_btnImeiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        ChiTietSanPham ctsp = getValidate();

        if (ctsp == null) {
            JOptionPane.showMessageDialog(this, "Update that bai");
            return;
        }

        int row = this.tbl_sanPham.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi sua");
            return;
        }

        ArrayList<QLCTSanPham> qlsp = ctspService.getList();

        QLCTSanPham ql = qlsp.get(row);

        ctspService.update(ctsp, ql.getId());
        JOptionPane.showMessageDialog(this, "Update thanh cong");
        loadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int row = this.tbl_sanPham.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chon 1 dong truoc khi xoa");
            return;
        }

//        ctspService.
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tbl_sanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamMouseClicked
        int row = this.tbl_sanPham.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "chon 1 dong");
            return;
        }

        ArrayList<QLCTSanPham> qlsp = ctspService.getList();

        QLCTSanPham ql = qlsp.get(row);
        System.out.println(ql.getId());

        lbl_anh.setIcon(ResizeImage(ql.getAnh()));
        loadCBBImei1(imeiService.getList(ql.getId()));
        lblSoLuongTon.setText(ql.getSoLuong() + "");
        txt_giaNhap.setText(ql.getGiaNhap() + "");
        txt_giaBan.setText(ql.getGiaBan() + "");

//        System.out.println(imeiService.getList(ql.getId()));
//        cbbCamera.set

    }//GEN-LAST:event_tbl_sanPhamMouseClicked

    private void btn_bonhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bonhoActionPerformed
        FrameRom rom = new FrameRom();
        rom.setVisible(true);
    }//GEN-LAST:event_btn_bonhoActionPerformed

    private void btn_MANHINHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MANHINHActionPerformed
        FrameManHinh mh = new FrameManHinh();
        mh.setVisible(true);
    }//GEN-LAST:event_btn_MANHINHActionPerformed

    private void btn_CHIPSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CHIPSEActionPerformed
        FrameChipSE chipse = new FrameChipSE();
        chipse.setVisible(true);
    }//GEN-LAST:event_btn_CHIPSEActionPerformed

    private void btn_CAMERAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CAMERAActionPerformed
        FrameCamera camera = new FrameCamera();
        camera.setVisible(true);
    }//GEN-LAST:event_btn_CAMERAActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Loại1;
    private javax.swing.JLabel Loại10;
    private javax.swing.JLabel Loại11;
    private javax.swing.JLabel Loại12;
    private javax.swing.JLabel Loại2;
    private javax.swing.JLabel Loại3;
    private javax.swing.JLabel Loại4;
    private javax.swing.JLabel Loại5;
    private javax.swing.JLabel Loại6;
    private javax.swing.JLabel Loại7;
    private javax.swing.JLabel Loại8;
    private javax.swing.JLabel Loại9;
    private javax.swing.JButton btnImei;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemAnh;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_CAMERA;
    private javax.swing.JButton btn_CHIPSE;
    private javax.swing.JButton btn_DUNGLUONG;
    private javax.swing.JButton btn_HDH;
    private javax.swing.JButton btn_MANHINH;
    private javax.swing.JButton btn_MAUSAC;
    private javax.swing.JButton btn_NSX;
    private javax.swing.JButton btn_PHANLOAI;
    private javax.swing.JButton btn_PIN;
    private javax.swing.JButton btn_bonho;
    private javax.swing.JButton btn_ma;
    private javax.swing.JButton btn_ten;
    private javax.swing.JButton btn_themsp;
    private javax.swing.JComboBox<String> cbbCamera;
    private javax.swing.JComboBox<String> cbbChipse;
    private javax.swing.JComboBox<String> cbbDongSanPham;
    public static javax.swing.JComboBox<String> cbbImei;
    private javax.swing.JComboBox<String> cbbManHinh;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbPhanLoaiHang;
    private javax.swing.JComboBox<String> cbbPin;
    private javax.swing.JComboBox<String> cbbRam;
    private javax.swing.JComboBox<String> cbbRom;
    private javax.swing.JComboBox<String> cbbTenSP;
    private javax.swing.JComboBox<String> cbbXuatXu;
    private javax.swing.JTabbedPane formSp;
    private javax.swing.JTabbedPane formSp1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpn_sp;
    private static javax.swing.JLabel lblSoLuongTon;
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JTable tbl_sanPham;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_seach;
    // End of variables declaration//GEN-END:variables
}
