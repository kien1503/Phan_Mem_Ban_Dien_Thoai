package com.view;

import com.service.impl.ThongkeService;
import com.viewmodel.ThongKeViewModel;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class JPThongke extends javax.swing.JPanel {

    private ThongkeService tks = new ThongkeService();

    private int i = 0;

    public JPThongke() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSreach = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdateMin = new com.toedter.calendar.JDateChooser();
        jdateMax = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        container = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnThongKeDoanhThu = new javax.swing.JButton();
        btnThongKeSanPham = new javax.swing.JButton();
        btnBaoCao = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        btnTop5SP = new javax.swing.JButton();

        setForeground(new java.awt.Color(255, 255, 255));

        btnSreach.setBackground(new java.awt.Color(41, 57, 80));
        btnSreach.setForeground(new java.awt.Color(255, 255, 255));
        btnSreach.setText("Search");
        btnSreach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSreach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSreachActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("THỐNG KÊ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jLabel6.setText("Theo Ngày");

        jLabel2.setText("Đến");

        container.setBackground(new java.awt.Color(153, 255, 255));
        container.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(23, 35, 51));

        btnThongKeDoanhThu.setBackground(new java.awt.Color(41, 57, 80));
        btnThongKeDoanhThu.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKeDoanhThu.setText("Thống kê doanh thu");
        btnThongKeDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeDoanhThuActionPerformed(evt);
            }
        });

        btnThongKeSanPham.setBackground(new java.awt.Color(41, 57, 80));
        btnThongKeSanPham.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKeSanPham.setText("Thống kê sản phẩm");
        btnThongKeSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeSanPhamActionPerformed(evt);
            }
        });

        btnBaoCao.setBackground(new java.awt.Color(41, 57, 80));
        btnBaoCao.setForeground(new java.awt.Color(255, 255, 255));
        btnBaoCao.setText("Báo cáo");
        btnBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaoCaoActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(41, 57, 80));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file excel");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThongKeDoanhThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnThongKeSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnBaoCao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btnThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThongKeSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBaoCao, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );

        btnTop5SP.setBackground(new java.awt.Color(41, 57, 80));
        btnTop5SP.setForeground(new java.awt.Color(255, 255, 255));
        btnTop5SP.setText("Top 5 sản phẩm bán chạy");
        btnTop5SP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTop5SPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jdateMin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdateMax, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(btnSreach, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTop5SP, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdateMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdateMax, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSreach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnTop5SP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private CategoryDataset createDatasetDoanhThu() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeViewModel> listThongKe = tks.doanhThu();

        for (ThongKeViewModel thongKeViewModel : listThongKe) {
            dataset.addValue(thongKeViewModel.getTongTien(),
                    "Doanh thu", thongKeViewModel.getNgay());
        }

        return dataset;
    }

    private JFreeChart createChartDoanhThu() {
        JFreeChart barChart = ChartFactory.createBarChart("Thống kê doanh thu trong tháng", "Ngày", "Doanh thu",
                createDatasetDoanhThu(), PlotOrientation.VERTICAL, false, false, false);

        return barChart;
    }

    private CategoryDataset createDatasetDoanhThuToDate() {
        Date min = jdateMin.getDate();
        Date max = jdateMax.getDate();

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeViewModel> listThongKe = tks.searchKhoangNgayDoanhThu(min, max);

        for (ThongKeViewModel thongKeViewModel : listThongKe) {
            dataset.addValue(thongKeViewModel.getTongTien(),
                    "Doanh thu", thongKeViewModel.getNgay());
        }

        return dataset;
    }

    private JFreeChart createChartDoanhThuToDate() {
        Date min = jdateMin.getDate();
        Date max = jdateMax.getDate();

        String ngay = "Thống kê doanh thu từ ngày " + min.getDay() + "/" + min.getMonth() + "/" + min.getYear()
                + "Đến " + max.getDay() + "/" + max.getMonth() + "/" + max.getYear();

        JFreeChart barChart = ChartFactory.createBarChart(ngay, "Ngày", "Doanh thu",
                createDatasetDoanhThuToDate(), PlotOrientation.VERTICAL, false, false, false);

        return barChart;
    }

    private CategoryDataset createDatasetSanPhamToDate() {
        Date min = jdateMin.getDate();
        Date max = jdateMax.getDate();
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeViewModel> listThongKe = tks.searchKhoangNgaySanPham(min, max);

        for (ThongKeViewModel thongKeViewModel : listThongKe) {
            dataset.addValue(thongKeViewModel.getSldaban(),
                    "Số lượng", thongKeViewModel.getNgay());
        }

        return dataset;
    }

    private JFreeChart createChartSanPhamToDate() {
        Date min = jdateMin.getDate();
        Date max = jdateMax.getDate();

        String ngay = "Thống kê số lượng sản phẩm từ ngày " + min.getDay() + "/" + min.getMonth() + "/" + min.getYear()
                + "Đến " + max.getDay() + "/" + max.getMonth() + "/" + max.getYear();
        
        JFreeChart barChart = ChartFactory.createBarChart(ngay, "Ngày", "Số lượng",
                createDatasetSanPhamToDate(), PlotOrientation.VERTICAL, false, false, false);

        return barChart;
    }

    private CategoryDataset createDatasetSanPham() {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ArrayList<ThongKeViewModel> listThongKe = tks.countSanPham();

        for (ThongKeViewModel thongKeViewModel : listThongKe) {
            dataset.addValue(thongKeViewModel.getSldaban(),
                    "Số lượng", thongKeViewModel.getNgay());
        }

        return dataset;
    }

    private JFreeChart createChartSanPham() {
        JFreeChart barChart = ChartFactory.createBarChart("Thống kê số lượng sản phẩm bán được trong tháng", "Ngày", "Số lượng",
                createDatasetSanPham(), PlotOrientation.VERTICAL, false, false, false);

        return barChart;
    }

    private JFreeChart createChartTron(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Top 5 sản phẩm bán chạy", dataset, true, true, true);
        return chart;
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        ArrayList<ThongKeViewModel> listTop5 = tks.top5SanPham();

        for (ThongKeViewModel thongKeViewModel : listTop5) {
            dataset.setValue(thongKeViewModel.getTensp(), thongKeViewModel.getSldaban());
        }
        return dataset;
    }

    private void btnSreachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSreachActionPerformed

        if (i == 1) {
            ChartPanel chartPanel = new ChartPanel(createChartDoanhThuToDate());
            container.removeAll();
            container.add(chartPanel);
            container.validate();
        } else if (i == 2) {
            ChartPanel chartPanel = new ChartPanel(createChartSanPhamToDate());
            container.removeAll();
            container.add(chartPanel);
            container.validate();
        }


    }//GEN-LAST:event_btnSreachActionPerformed

    private void btnThongKeDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeDoanhThuActionPerformed
        i = 1;
        ChartPanel chartPanel = new ChartPanel(createChartDoanhThu());
        container.removeAll();
        container.add(chartPanel);
        container.validate();
    }//GEN-LAST:event_btnThongKeDoanhThuActionPerformed

    private void btnThongKeSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeSanPhamActionPerformed
        i = 2;
        ChartPanel chartPanel = new ChartPanel(createChartSanPham());
        container.removeAll();
        container.add(chartPanel);
        container.validate();
    }//GEN-LAST:event_btnThongKeSanPhamActionPerformed

    private void btnBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaoCaoActionPerformed
        final String username = "toindph26899@fpt.edu.vn";
        final String password = "oobfdgqtgajypsvv";
        Long tongTien = 0l;
        DecimalFormat df = new DecimalFormat("###,###,###");

        ArrayList<ThongKeViewModel> listThongKe = tks.baoCao(java.time.LocalDate.now());

        for (ThongKeViewModel thongKeViewModel : listThongKe) {
            tongTien += thongKeViewModel.getDongia() * thongKeViewModel.getSldaban();

        }

        String tenEmail = JOptionPane.showInputDialog(this, "Nhap ten email: ");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("toindph26899@fpt.edu.vn"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(tenEmail)
            );
            message.setSubject("NhanVien Pham Anh Tuan Gui Bao Cao");
            message.setText("Ngay hom nay ban duoc " + df.format(tongTien));

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBaoCaoActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danhsach");
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("MÃ Hoá Đơn");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ngày thống kê");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Mã sản phẩm");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Tên sản phẩm");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Số lượng đã bán");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("đơn giá");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Số lượng tồn");

            ArrayList<ThongKeViewModel> arr = (ArrayList<ThongKeViewModel>) tks.getAll();
            int count = 0;
            for (int i = 0; i < arr.size(); i++) {
                row = sheet.createRow(i + 7);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(arr.get(i).getMahd());
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(arr.get(i).getNgay());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(arr.get(i).getMasp());
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(arr.get(i).getTensp());
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(arr.get(i).getSldaban());
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(arr.get(i).getDongia());
                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(arr.get(i).getSlton());
                count += arr.get(i).getDongia();
                cell.setCellValue(count);
            }

            JFileChooser fc = new JFileChooser(new File("D:\\"));
            fc.setDialogTitle("Luu");
            int x = fc.showSaveDialog(null);
            if (x == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                try {
                    FileOutputStream fos = new FileOutputStream(f + ".xlsx");
                    workbook.write(fos);
                    fos.close();
                    JOptionPane.showMessageDialog(this, "Export thanh cong");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void btnTop5SPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTop5SPActionPerformed
        JFreeChart piechart = createChartTron(createDataset());
        ChartPanel chartPanel = new ChartPanel(piechart);
        container.removeAll();
        container.add(chartPanel);
        container.validate();
    }//GEN-LAST:event_btnTop5SPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaoCao;
    private javax.swing.JButton btnSreach;
    private javax.swing.JButton btnThongKeDoanhThu;
    private javax.swing.JButton btnThongKeSanPham;
    private javax.swing.JButton btnTop5SP;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JDateChooser jdateMax;
    private com.toedter.calendar.JDateChooser jdateMin;
    // End of variables declaration//GEN-END:variables

}
