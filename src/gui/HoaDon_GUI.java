package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class HoaDon_GUI extends JFrame {

	private JPanel contentPane;
	private final JPanel pWest = new JPanel();
	private JTable tableHoaDon;
	private JTable tableChiTietHD;
	private JTextField txtMaHD;
	private JTextField txtTenKH;
	private JTextField txtNgayLap;
	private JTextField txtNgayGiao;
	private JTextField txtNoiNhan;
	private JTextField textField;
	private JTextField txtMaChiTietHD;
	private JTextField txtMaHD_1;
	private JTextField txtsoLuong;
	private JTextField txtGiaBan;
	private JPanel pCenter;

	/**
	 * Launch the application.
	 */
	public static void openUI_HoaDon() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon_GUI frame = new HoaDon_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		openUI_HoaDon();
	}
	
	public JPanel getHoaDonPanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 */
	public HoaDon_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hóa đơn");
		setBounds(100, 100, 1200, 680);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		pWest.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pWest.setBounds(10, 10, 123, 623);
		contentPane.add(pWest);
		pWest.setLayout(null);
		
		pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pCenter.setBounds(130, 10, 1046, 623);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pHoaDon = new JPanel();
		pHoaDon.setBounds(10, 24, 675, 302);
		pCenter.add(pHoaDon);
		pHoaDon.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHoaDon = new JLabel("BẢNG HÓA ĐƠN");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Arial", Font.BOLD, 23));
		pHoaDon.add(lblHoaDon, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		pHoaDon.add(scrollPane, BorderLayout.CENTER);
		
		tableHoaDon = new JTable();
		tableHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "ID Khách hàng", "ID Nhân viên", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "Ng\u00E0y giao", "N\u01A1i nh\u1EADn h\u00E0ng", "T\u1ED5ng ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class, Object.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableHoaDon);
		
		JPanel pChiTietHD = new JPanel();
		pChiTietHD.setBounds(10, 354, 675, 259);
		pCenter.add(pChiTietHD);
		pChiTietHD.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChiTietHD = new JLabel("BẢNG CHI TIẾT HÓA ĐƠN");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Arial", Font.BOLD, 23));
		pChiTietHD.add(lblChiTietHD, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pChiTietHD.add(scrollPane_1, BorderLayout.CENTER);
		
		tableChiTietHD = new JTable();
		tableChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 chi ti\u1EBFt h\u00F3a \u0111\u01A1n", "M\u00E3 h\u00F3a \u0111\u01A1n", "S\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n", "T\u1ED5ng ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(tableChiTietHD);
		
		JPanel pTacVuHD = new JPanel();
		pTacVuHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTacVuHD.setBounds(695, 116, 341, 240);
		pCenter.add(pTacVuHD);
		pTacVuHD.setLayout(null);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn:");
		lblMaHD.setBounds(6, 17, 150, 21);
		pTacVuHD.add(lblMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setEditable(false);
		txtMaHD.setBounds(156, 17, 150, 21);
		pTacVuHD.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		JLabel lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setBounds(6, 48, 150, 21);
		lblTenKH.setHorizontalAlignment(SwingConstants.LEFT);
		pTacVuHD.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(156, 48, 150, 21);
		pTacVuHD.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Nhân viên bán: ");
		lblTenNV.setBounds(6, 79, 150, 21);
		pTacVuHD.add(lblTenNV);
		
		JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn");
		lblNgayLapHD.setBounds(6, 110, 150, 21);
		pTacVuHD.add(lblNgayLapHD);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setBounds(156, 110, 150, 21);
		pTacVuHD.add(txtNgayLap);
		txtNgayLap.setColumns(10);
		
		JLabel lblNgayGiao = new JLabel("Ngày giao");
		lblNgayGiao.setBounds(6, 141, 150, 21);
		pTacVuHD.add(lblNgayGiao);
		
		txtNgayGiao = new JTextField();
		txtNgayGiao.setBounds(156, 141, 150, 21);
		pTacVuHD.add(txtNgayGiao);
		txtNgayGiao.setColumns(10);
		
		JLabel lblNoiNhan = new JLabel("Nơi nhận");
		lblNoiNhan.setBounds(6, 172, 150, 21);
		pTacVuHD.add(lblNoiNhan);
		
		txtNoiNhan = new JTextField();
		txtNoiNhan.setBounds(156, 172, 150, 21);
		txtNoiNhan.setText("");
		pTacVuHD.add(txtNoiNhan);
		txtNoiNhan.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(6, 211, 81, 21);
		pTacVuHD.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(97, 211, 59, 21);
		pTacVuHD.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(166, 211, 58, 21);
		pTacVuHD.add(btnSua);
		
		JComboBox cboNhanVien = new JComboBox();
		cboNhanVien.setEditable(true);
		cboNhanVien.setBounds(156, 79, 150, 21);
		pTacVuHD.add(cboNhanVien);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(234, 211, 93, 21);
		pTacVuHD.add(btnXoaTrang);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm h\u00F3a \u0111\u01A1n theo m\u00E3", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(695, 24, 341, 82);
		pCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblTimHD = new JLabel("Nhập mã hóa đơn: ");
		lblTimHD.setBounds(10, 10, 116, 38);
		panel.add(lblTimHD);
		
		textField = new JTextField();
		textField.setBounds(125, 20, 176, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(173, 53, 88, 19);
		panel.add(btnTim);
		
		JPanel pTacVuCTHD = new JPanel();
		pTacVuCTHD.setLayout(null);
		pTacVuCTHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTacVuCTHD.setBounds(695, 383, 341, 230);
		pCenter.add(pTacVuCTHD);
		
		JLabel lblMaCTHD = new JLabel("Mã chi tiết HD:");
		lblMaCTHD.setBounds(6, 17, 150, 21);
		pTacVuCTHD.add(lblMaCTHD);
		
		txtMaChiTietHD = new JTextField();
		txtMaChiTietHD.setEditable(false);
		txtMaChiTietHD.setColumns(10);
		txtMaChiTietHD.setBounds(156, 17, 150, 21);
		pTacVuCTHD.add(txtMaChiTietHD);
		
		JLabel lblMaHD_1 = new JLabel("Mã hóa đơn");
		lblMaHD_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaHD_1.setBounds(6, 48, 150, 21);
		pTacVuCTHD.add(lblMaHD_1);
		
		txtMaHD_1 = new JTextField();
		txtMaHD_1.setEditable(false);
		txtMaHD_1.setColumns(10);
		txtMaHD_1.setBounds(156, 48, 150, 21);
		pTacVuCTHD.add(txtMaHD_1);
		
		JLabel lblLoai = new JLabel("Loại sản phẩm");
		lblLoai.setBounds(6, 79, 150, 21);
		pTacVuCTHD.add(lblLoai);
		
		JLabel lblSanPham = new JLabel("Sản phẩm");
		lblSanPham.setBounds(6, 110, 150, 21);
		pTacVuCTHD.add(lblSanPham);
		
		JLabel lblSoLuong = new JLabel("Ngày giao");
		lblSoLuong.setBounds(6, 141, 150, 21);
		pTacVuCTHD.add(lblSoLuong);
		
		txtsoLuong = new JTextField();
		txtsoLuong.setColumns(10);
		txtsoLuong.setBounds(156, 141, 150, 21);
		pTacVuCTHD.add(txtsoLuong);
		
		JLabel lblGiaBan = new JLabel("Nơi nhận");
		lblGiaBan.setBounds(6, 172, 150, 21);
		pTacVuCTHD.add(lblGiaBan);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setText("");
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(156, 172, 150, 21);
		pTacVuCTHD.add(txtGiaBan);
		
		JButton btnThemCT = new JButton("Thêm");
		btnThemCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemCT.setBounds(6, 203, 80, 21);
		pTacVuCTHD.add(btnThemCT);
		
		JButton btnXoaCT = new JButton("Xóa");
		btnXoaCT.setBounds(96, 203, 60, 21);
		pTacVuCTHD.add(btnXoaCT);
		
		JButton btnSuaCT = new JButton("Sửa");
		btnSuaCT.setBounds(166, 203, 59, 21);
		pTacVuCTHD.add(btnSuaCT);
		
		JComboBox cboLoai = new JComboBox();
		cboLoai.setEditable(true);
		cboLoai.setBounds(156, 79, 150, 21);
		pTacVuCTHD.add(cboLoai);
		
		JComboBox cboSanPham = new JComboBox();
		cboSanPham.setEditable(true);
		cboSanPham.setBounds(156, 110, 150, 21);
		pTacVuCTHD.add(cboSanPham);
		
		JButton btnXoaTrangCT = new JButton("Xóa trắng");
		btnXoaTrangCT.setBounds(235, 203, 88, 21);
		pTacVuCTHD.add(btnXoaTrangCT);
	}
}
