package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.ChiTietHoaDon_Bus;
import bus.HoaDon_Bus;
import bus.KhachHang_Bus;
import bus.SanPham_Bus;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.SanPham;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThongKe_GUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel pCenter;
	private JTable tableThongKe;
	private JComboBox cboNam;
	private JComboBox cboThang;
	private JLabel lblTongKH;
	private JLabel lblTongHoaDon;
	private JButton btnXemTatCa;
	
	private HoaDon_Bus hd_Bus;
	private SanPham_Bus sp_Bus;
	private KhachHang_Bus kh_Bus;
	private ChiTietHoaDon_Bus ctHD_Bus;
	private JLabel lblDoanhThu;
	private DefaultComboBoxModel dfthang;
	private JButton btnLoc;
	

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ThongKe_GUI frame = new ThongKe_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public JPanel getThongKePanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 */
	public ThongKe_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);
		
		pCenter = new JPanel();
		pCenter.setBounds(130, 10, 1043, 623);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pDoanhThu = new JPanel();
		pDoanhThu.setBackground(new Color(255, 255, 128));
		pDoanhThu.setBounds(90, 10, 210, 100);
		pCenter.add(pDoanhThu);
		pDoanhThu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doanh thu");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 190, 36);
		pDoanhThu.add(lblNewLabel);
		
		lblDoanhThu = new JLabel("");
		lblDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoanhThu.setFont(new Font("Arial", Font.BOLD, 18));
		lblDoanhThu.setBounds(10, 46, 190, 44);
		pDoanhThu.add(lblDoanhThu);
		
		JPanel pTongHoaDon = new JPanel();
		pTongHoaDon.setBackground(new Color(255, 255, 128));
		pTongHoaDon.setBounds(422, 10, 210, 100);
		pCenter.add(pTongHoaDon);
		pTongHoaDon.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng hóa đơn");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 190, 36);
		pTongHoaDon.add(lblNewLabel_1);
		
		lblTongHoaDon = new JLabel("");
		lblTongHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongHoaDon.setFont(new Font("Arial", Font.BOLD, 18));
		lblTongHoaDon.setBounds(10, 46, 190, 44);
		pTongHoaDon.add(lblTongHoaDon);
		
		JPanel pSoKhachHang = new JPanel();
		pSoKhachHang.setBackground(new Color(255, 255, 128));
		pSoKhachHang.setBounds(755, 10, 210, 100);
		pCenter.add(pSoKhachHang);
		pSoKhachHang.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tổng khách hàng");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 10, 190, 36);
		pSoKhachHang.add(lblNewLabel_2);
		
		lblTongKH = new JLabel("");
		lblTongKH.setHorizontalAlignment(SwingConstants.CENTER);
		lblTongKH.setFont(new Font("Arial", Font.BOLD, 18));
		lblTongKH.setBounds(10, 46, 190, 44);
		pSoKhachHang.add(lblTongKH);
		
		cboNam = new JComboBox();
		cboNam.setFont(new Font("Arial", Font.PLAIN, 12));
		cboNam.setBorder(new TitledBorder("Năm"));
		cboNam.setBounds(90, 123, 243, 42);
		pCenter.add(cboNam);
		
		cboThang = new JComboBox();
		cboThang.setModel(dfthang = new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		cboThang.setFont(new Font("Arial", Font.PLAIN, 12));
		cboThang.setBorder(new TitledBorder("Tháng"));
		cboThang.setBounds(422, 123, 243, 42);
		pCenter.add(cboThang);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 186, 1023, 427);
		pCenter.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tableThongKe = new JTable();
		tableThongKe.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 b\u00E1n", "T\u1ED5ng ti\u1EC1n thu \u0111\u01B0\u1EE3c", "Ghi chú"
			}
		));
		tableThongKe.getColumnModel().getColumn(1).setPreferredWidth(98);
		tableThongKe.getColumnModel().getColumn(2).setPreferredWidth(112);
		tableThongKe.getColumnModel().getColumn(3).setPreferredWidth(105);
		scrollPane.setViewportView(tableThongKe);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setBounds(743, 130, 104, 36);
		pCenter.add(btnLoc);
		
		btnXemTatCa = new JButton("Xem tất cả");
		btnXemTatCa.setBounds(891, 130, 104, 36);
		pCenter.add(btnXemTatCa);
		
		kh_Bus = new KhachHang_Bus();
		sp_Bus = new SanPham_Bus();
		hd_Bus = new HoaDon_Bus();
		ctHD_Bus = new ChiTietHoaDon_Bus();
		
		hienThiSoLieuThongKe();
		docDuLieuLenTable();
		updateCBBNam();
		
		btnLoc.addActionListener(this);
		btnXemTatCa.addActionListener(this);
		
	}
	
	/**
	 * Hiển thị tổng tiền thu được, số lượng đơn hàng và số lượng khách hàng đã mua hàng
	 */
	private void hienThiSoLieuThongKe() {
		double tongTienHD = 0;
		ArrayList<HoaDon> listHD = hd_Bus.getListHoaDon();
		int tongSoHD = listHD.size();
		for(HoaDon hd : listHD) {
			tongTienHD += hd.getTongTien();
		}
		lblDoanhThu.setText(String.format("%,.0f", tongTienHD));
		lblTongHoaDon.setText(tongSoHD + "");
		ArrayList<KhachHang> listKH = kh_Bus.getAllTableKhachHang();
		int tongKH = listKH.size();
		lblTongKH.setText(tongKH + "");
	}
	
	/**
	 * Đọc dữ liệu lên table
	 */
	private void docDuLieuLenTable() {
		xoaHetTable();
		DefaultTableModel dm = (DefaultTableModel) tableThongKe.getModel();
		ArrayList<SanPham> listSP = sp_Bus.getAllTbSP();
		for (SanPham sanPham : listSP) {
			int soLuongDaBan = ctHD_Bus.laySoLuongSPDaBan(sanPham.getSpID());
			String tongTien = String.format("%.0f", ctHD_Bus.layTongTienTheoMaSP(sanPham.getSpID()));
			String ghiChu = "";
			if(soLuongDaBan > sanPham.getSlTon()) {
				ghiChu = "Best seller";
			}
			dm.addRow(new Object[] {sanPham.getSpID(), sanPham.getTenSP(), soLuongDaBan, tongTien, ghiChu});
		}
		tableThongKe.setModel(dm);
	}
	
	/**
	 * Cập nhật các năm đã bán hàng lên combobox
	 */
	public void updateCBBNam() {
		ArrayList<HoaDon> listHD = hd_Bus.getListHoaDon();
		Set<String> uniqueTypes = new HashSet<String>();
		for (HoaDon hoaDon : listHD) {
			uniqueTypes.add(hoaDon.getNgayLapHD().getYear() + "");
		}
		String[] nam = uniqueTypes.toArray(new String[uniqueTypes.size()]);
		cboNam.setModel(new DefaultComboBoxModel<>(nam));
	}
	
	/**
	 * Xóa hết dữ liệu table
	 */
	private void xoaHetTable() {
		DefaultTableModel dm = (DefaultTableModel) tableThongKe.getModel();
		dm.setRowCount(0);
	}
	
	/**
	 * Lọc dữ liệu theo năm và tháng đã chọn
	 */
	private void locDuLieuTheoNamThang() {
		xoaHetTable();
		int nam = Integer.parseInt(cboNam.getSelectedItem().toString());
		int thang = Integer.parseInt(cboThang.getSelectedItem().toString());
		int soLuongDaBan = 0;
		double tongTien = 0;
		String ghiChu = "";
		DefaultTableModel dm = (DefaultTableModel) tableThongKe.getModel();
		LocalDate date = null;
		ArrayList<ChiTietHoaDon> listCTHD = ctHD_Bus.getListChiTietHD();
		
		for (ChiTietHoaDon ct : listCTHD) {
			SanPham sanPham = sp_Bus.getSPTheoMa(ct.getSanPham().getSpID());
			HoaDon hDon = ct.getHoaDon();
			date = hDon.getNgayLapHD();
			if(date.getYear() == nam && date.getMonthValue() == thang) {
				soLuongDaBan = ctHD_Bus.laySoLuongTheoNamThang(ct.getSanPham().getSpID(), thang, nam);
				tongTien = ctHD_Bus.layTongTienSPTheoNamThang(sanPham.getSpID(), thang, nam);
				dm.addRow(new Object[] {sanPham.getSpID(), sanPham.getTenSP(), soLuongDaBan, String.format("%.0f", tongTien), ghiChu});
			}
		}
		tableThongKe.setModel(dm);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnLoc)) {
			locDuLieuTheoNamThang();
		}
		if (o.equals(btnXemTatCa)) {
			docDuLieuLenTable();
		}
		
	}
}
