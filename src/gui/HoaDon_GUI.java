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

import bus.ChiTietHoaDon_Bus;
import bus.HoaDon_Bus;
import bus.KhachHang_Bus;
import bus.NhanVien_Bus;
import bus.SanPham_Bus;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import entities.SanPham;

import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class HoaDon_GUI extends JFrame implements ActionListener, MouseListener, FocusListener{

	private JPanel contentPane;
	private JTable tableHoaDon;
	private JTable tableChiTietHD;
	private JTextField txtMaHD;
	private JTextField txtIDKH;
	private JTextField txtNgayLap;
	private JTextField txtNgayGiao;
	private JTextField txtNoiNhan;
	private JTextField txtMaChiTietHD;
	private JPanel pCenter;
	private JButton btnThemCT;
	private JButton btnXoaCT;
	private JButton btnSuaCT;
	private JButton btnXoaTrangCT;
	
	private HoaDon_Bus hd_Bus;
	private NhanVien_Bus nv_Bus;
	private KhachHang_Bus kh_Bus;
	private ChiTietHoaDon_Bus ctHD_Bus;
	private SanPham_Bus sp_Bus;
	private JButton btnXoaTrang;
	private JComboBox cboNhanVien;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnThem;
	private JTextField txtMess;
	private JTextField txtSoLuong;
	private JTextField txtGiaBan;
	private JTextField txtTongTienCTHD;
	private JTextField txtTongTienHD;
	private JTextField txtMessCTHD;
	private DefaultTableModel modelCTHD;
	private JTextField txtMaSp;
	private ArrayList<ChiTietHoaDon> listCTHD;
	private JTextField txtTim;
	private JTextField txtMessTim;
	private JButton btnTim;

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
	
//	public static void main(String[] args) {
//		openUI_HoaDon();
//	}
	
	public JPanel getHoaDonPanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public HoaDon_GUI() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hóa đơn");
		setBounds(100, 100, 1200, 680);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pCenter = new JPanel();
		pCenter.setBounds(130, 10, 1046, 623);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pHoaDon = new JPanel();
		pHoaDon.setBounds(10, 24, 675, 302);
		pCenter.add(pHoaDon);
		pHoaDon.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHoaDon = new JLabel("BẢNG HÓA ĐƠN");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Arial", Font.BOLD, 20));
		pHoaDon.add(lblHoaDon, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		pHoaDon.add(scrollPane, BorderLayout.CENTER);
		
		tableHoaDon = new JTable();
		tableHoaDon.setModel(new DefaultTableModel(new Object[]{"Mã hóa đơn", "ID Khách hàng", "Nhân viên", "Ngày lập hóa đơn", "Ngày giao", "Nơi nhận hàng", "Tổng tiền"}, 0));
		scrollPane.setViewportView(tableHoaDon);
		
		JPanel pChiTietHD = new JPanel();
		pChiTietHD.setBounds(10, 354, 675, 259);
		pCenter.add(pChiTietHD);
		pChiTietHD.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChiTietHD = new JLabel("BẢNG CHI TIẾT HÓA ĐƠN");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Arial", Font.BOLD, 20));
		pChiTietHD.add(lblChiTietHD, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pChiTietHD.add(scrollPane_1, BorderLayout.CENTER);
		
		tableChiTietHD = new JTable();
		modelCTHD = new DefaultTableModel(new Object[] {"Mã chi tiết hóa đơn", "Mã hóa đơn", "Mã sản phẩm", "Sản phẩm", "Số lượng", "Giá bán", "Tổng tiền"}, 0);
		tableChiTietHD.setModel(modelCTHD);
		scrollPane_1.setViewportView(tableChiTietHD);
		
		JPanel pTacVuHD = new JPanel();
		pTacVuHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTacVuHD.setBounds(695, 10, 341, 341);
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
		
		JLabel lblKH = new JLabel("Mã khách hàng:");
		lblKH.setBounds(6, 48, 150, 21);
		lblKH.setHorizontalAlignment(SwingConstants.LEFT);
		pTacVuHD.add(lblKH);
		
		txtIDKH = new JTextField();
		txtIDKH.setBounds(156, 48, 150, 21);
		pTacVuHD.add(txtIDKH);
		txtIDKH.setColumns(10);
		
		JLabel lblNV = new JLabel("Nhân viên bán: ");
		lblNV.setBounds(6, 79, 150, 21);
		pTacVuHD.add(lblNV);
		
		JLabel lblNgayLapHD = new JLabel("Ngày lập hóa đơn:");
		lblNgayLapHD.setBounds(6, 110, 150, 21);
		pTacVuHD.add(lblNgayLapHD);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setEditable(false);
		txtNgayLap.setBounds(156, 110, 150, 21);
		pTacVuHD.add(txtNgayLap);
		txtNgayLap.setColumns(10);
		
		JLabel lblNgayGiao = new JLabel("Ngày giao:");
		lblNgayGiao.setBounds(6, 141, 150, 21);
		pTacVuHD.add(lblNgayGiao);
		
		txtNgayGiao = new JTextField();
		txtNgayGiao.setBounds(156, 141, 150, 21);
		pTacVuHD.add(txtNgayGiao);
		txtNgayGiao.setColumns(10);
		
		JLabel lblNoiNhan = new JLabel("Nơi nhận:");
		lblNoiNhan.setBounds(6, 172, 150, 21);
		pTacVuHD.add(lblNoiNhan);
		
		txtNoiNhan = new JTextField();
		txtNoiNhan.setBounds(156, 172, 150, 21);
		txtNoiNhan.setText("");
		pTacVuHD.add(txtNoiNhan);
		txtNoiNhan.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(6, 254, 81, 21);
		pTacVuHD.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(97, 254, 59, 21);
		pTacVuHD.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(166, 254, 58, 21);
		pTacVuHD.add(btnSua);
		
		cboNhanVien = new JComboBox();
		cboNhanVien.setBounds(156, 79, 150, 21);
		pTacVuHD.add(cboNhanVien);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(234, 254, 93, 21);
		pTacVuHD.add(btnXoaTrang);
		
		txtMess = new JTextField();
		txtMess.setForeground(new Color(255, 0, 0));
		txtMess.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txtMess.setEditable(false);
		txtMess.setBounds(6, 225, 321, 29);
		txtMess.setBorder(null);
		pTacVuHD.add(txtMess);
		txtMess.setColumns(10);
		
		JLabel lblTongTienHD = new JLabel("Tổng tiền hóa đơn:");
		lblTongTienHD.setBounds(6, 204, 150, 21);
		pTacVuHD.add(lblTongTienHD);
		
		txtTongTienHD = new JTextField();
		txtTongTienHD.setEditable(false);
		txtTongTienHD.setText("");
		txtTongTienHD.setColumns(10);
		txtTongTienHD.setBounds(156, 204, 150, 21);
		pTacVuHD.add(txtTongTienHD);
		
		JLabel lblTimHD = new JLabel("Nhập mã hóa đơn: ");
		lblTimHD.setBounds(6, 285, 117, 29);
		pTacVuHD.add(lblTimHD);
		
		txtTim = new JTextField();
		txtTim.setColumns(10);
		txtTim.setBounds(121, 290, 127, 19);
		pTacVuHD.add(txtTim);
		
		btnTim = new JButton("Tìm");
		btnTim.setBounds(258, 290, 69, 19);
		pTacVuHD.add(btnTim);
		
		txtMessTim = new JTextField();
		txtMessTim.setForeground(Color.RED);
		txtMessTim.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txtMessTim.setEditable(false);
		txtMessTim.setColumns(10);
		txtMessTim.setBorder(null);
		txtMessTim.setBounds(6, 312, 321, 19);
		pTacVuHD.add(txtMessTim);
		
		JPanel pTacVuCTHD = new JPanel();
		pTacVuCTHD.setLayout(null);
		pTacVuCTHD.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pTacVuCTHD.setBounds(695, 354, 341, 230);
		pCenter.add(pTacVuCTHD);
		
		JLabel lblMaCTHD = new JLabel("Mã chi tiết HD:");
		lblMaCTHD.setBounds(6, 17, 150, 21);
		pTacVuCTHD.add(lblMaCTHD);
		
		txtMaChiTietHD = new JTextField();
		txtMaChiTietHD.setEditable(false);
		txtMaChiTietHD.setColumns(10);
		txtMaChiTietHD.setBounds(156, 17, 150, 21);
		pTacVuCTHD.add(txtMaChiTietHD);
		
		JLabel lblSanPhamID = new JLabel("Mã sản phẩm");
		lblSanPhamID.setBounds(6, 48, 150, 21);
		pTacVuCTHD.add(lblSanPhamID);
		
		btnThemCT = new JButton("Thêm");
		btnThemCT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemCT.setBounds(6, 199, 80, 21);
		pTacVuCTHD.add(btnThemCT);
		
		btnXoaCT = new JButton("Xóa");
		btnXoaCT.setBounds(96, 199, 60, 21);
		pTacVuCTHD.add(btnXoaCT);
		
		btnSuaCT = new JButton("Sửa");
		btnSuaCT.setBounds(166, 199, 59, 21);
		pTacVuCTHD.add(btnSuaCT);
		
		btnXoaTrangCT = new JButton("Xóa trắng");
		btnXoaTrangCT.setBounds(235, 199, 88, 21);
		pTacVuCTHD.add(btnXoaTrangCT);
		
		JLabel lblSoLuong = new JLabel("Số lượng:");
		lblSoLuong.setBounds(6, 79, 150, 21);
		pTacVuCTHD.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setEditable(false);
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(156, 79, 150, 21);
		pTacVuCTHD.add(txtSoLuong);
		
		JLabel lblGiBn = new JLabel("Giá bán:");
		lblGiBn.setBounds(6, 114, 150, 21);
		pTacVuCTHD.add(lblGiBn);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setEditable(false);
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(156, 114, 150, 21);
		pTacVuCTHD.add(txtGiaBan);
		
		txtTongTienCTHD = new JTextField();
		txtTongTienCTHD.setEditable(false);
		txtTongTienCTHD.setColumns(10);
		txtTongTienCTHD.setBounds(156, 145, 150, 21);
		pTacVuCTHD.add(txtTongTienCTHD);
		
		JLabel lblTongTienCTHD = new JLabel("Tổng tiền:");
		lblTongTienCTHD.setBounds(6, 145, 150, 21);
		pTacVuCTHD.add(lblTongTienCTHD);
		
		txtMessCTHD = new JTextField();
		txtMessCTHD.setForeground(Color.RED);
		txtMessCTHD.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txtMessCTHD.setEditable(false);
		txtMessCTHD.setColumns(10);
		txtMessCTHD.setBorder(null);
		txtMessCTHD.setBounds(6, 176, 321, 19);
		pTacVuCTHD.add(txtMessCTHD);
		
		txtMaSp = new JTextField();
		txtMaSp.setEditable(false);
		txtMaSp.setColumns(10);
		txtMaSp.setBounds(156, 49, 150, 21);
		pTacVuCTHD.add(txtMaSp);
		
		JButton btnInBienLai = new JButton("In biên lai");
		btnInBienLai.setBounds(790, 592, 166, 21);
		pCenter.add(btnInBienLai);
		
		hd_Bus = new HoaDon_Bus();
		nv_Bus = new NhanVien_Bus();
		kh_Bus = new KhachHang_Bus();
		ctHD_Bus = new ChiTietHoaDon_Bus();
		sp_Bus = new SanPham_Bus();
		
		docDuLieuLenTableHD();
		docNhanVienLenComboBox();
		
		//Đăng ký sự kiện
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSuaCT.addActionListener(this);
		btnThemCT.addActionListener(this);
		btnXoaCT.addActionListener(this);
		btnXoaTrangCT.addActionListener(this);
		btnTim.addActionListener(this);
		
		txtMaSp.addFocusListener(this);
		txtSoLuong.addFocusListener(this);
		
		tableHoaDon.addMouseListener(this);
		tableChiTietHD.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int rowCTHD = tableChiTietHD.getSelectedRow();
				if(rowCTHD != -1) {
					txtMaChiTietHD.setText(tableChiTietHD.getValueAt(rowCTHD, 0).toString());
					txtMaSp.setText(tableChiTietHD.getValueAt(rowCTHD, 2).toString());
					txtSoLuong.setText(tableChiTietHD.getValueAt(rowCTHD, 4).toString());
					txtGiaBan.setText(tableChiTietHD.getValueAt(rowCTHD, 5).toString());
					txtTongTienCTHD.setText(tableChiTietHD.getValueAt(rowCTHD, 6).toString());
				}
				else {
					tableChiTietHD.clearSelection();
				}
			}
		});
	}
	
	/*
	 * Đọc dữ liệu lên table hóa đơn
	 */
	private void docDuLieuLenTableHD() {
		xoaHetDuLieuTable(tableHoaDon);
		DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
		ArrayList<HoaDon> listHD  = hd_Bus.getListHoaDon();
		for(HoaDon hd : listHD) {
			String noiNhan = hd.getNoiNhan();
			dm.addRow(new Object[] {hd.getIdHD(), hd.getKhachHang().getIdKH(), hd.getNhanVien().getTenNV(), hd.getNgayLapHD(), hd.getNgayGiao(), noiNhan, String.format("%.0f", hd.getTongTien())});
		}
		tableHoaDon.setModel(dm);
	}
	
	private void xoaHetDuLieuTable(JTable tb) {
		DefaultTableModel dm = (DefaultTableModel) tb.getModel();
		dm.setRowCount(0);
	}
	
//	private void
	
	/*
	 * Thêm hóa đơn
	 */
	private void themHoaDon() throws ClassNotFoundException, SQLException {
		if(kiemTraDuLieuHD()) {
			HoaDon hd = getHoaDonData(); 
			hd_Bus.themHoaDon(hd);
			txtMess.setText("Thêm thành công.");
			xoaHetDuLieuTable(tableChiTietHD);
			xoaHetDuLieuTable(tableHoaDon);
			docDuLieuLenTableHD();
		}
	}
	
	/**
	 * Lấy dữ liệu hóa đơn trên textfield
	 * @return
	 */
	private HoaDon getHoaDonData(){
		String maHD = txtMaHD.getText();
		KhachHang kh = null;
		try {
			kh = kh_Bus.getKhachHangTheoMa(txtIDKH.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NhanVien nv = null;
		try {
			nv = nv_Bus.getalltbNhanVien().get(cboNhanVien.getSelectedIndex());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LocalDate ngayLap = LocalDate.now();
		LocalDate ngayGiao = LocalDate.parse(txtNgayGiao.getText());
		String noiNhan = txtNoiNhan.getText();
		HoaDon hd = new HoaDon(maHD, kh, nv, ngayLap, ngayGiao, noiNhan);
		return hd;
	}
	
	/**
	 * Xóa hóa đơn
	 */
	private void xoaHoaDon() {
		int row = tableHoaDon.getSelectedRow();
		if(row != -1) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa hóa đơn này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				String hoaDonID = txtMaHD.getText().trim();
				xoaHetDuLieuTable(tableChiTietHD);
				hd_Bus.xoaHoaDon(hoaDonID);
				txtMess.setText("Xóa thành công.");
				DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
				dm.removeRow(row);
				xoaTrangHoaDon();
				xoaTrangCTHD();
			}
		}
		else {
			txtMess.setText("Bạn cần chọn dòng để xóa");
		}
	}
	/*
	 * Kiểm tra dữ liệu nhập vào Hóa đơn
	 */
	private boolean kiemTraDuLieuHD() throws SQLException {
		String maKH = txtIDKH.getText().trim();
		String ngayGiao = txtNgayGiao.getText().trim();
		String noiNhan = txtNoiNhan.getText();
		
		if(maKH.length() > 0) {
			if(!maKH.matches("KH[\\d]{3}")) {
				txtMess.setText("Mã khách hàng: KHXXX với X là số từ 0-9");
				txtIDKH.selectAll();
				txtIDKH.requestFocus();
				return false;
			}
			KhachHang kh = kh_Bus.getKhachHangTheoMa(maKH);
			if(kh == null) {
				txtMess.setText("Mã khách hàng không tồn tại.");
				txtIDKH.selectAll();
				txtIDKH.requestFocus();
				return false;
			}
		}
		else {
			txtMess.setText("Vui lòng nhập mã khách hàng.");
			txtIDKH.requestFocus();
			return false;
		}
		
		if(ngayGiao.length() > 0) {
			if(!ngayGiao.matches("\\d{4}-\\d{2}-\\d{2}")) {
				txtMess.setText("Ngày giao phải theo định dạng yyyy-MM-dd.");
				txtNgayGiao.selectAll();
				txtNgayGiao.requestFocus();
				return false;
			}
			if(LocalDate.parse(ngayGiao).isBefore(LocalDate.now())) {
				txtMess.setText("Ngày giao phải sau ngày lập hóa đơn.");
				txtNgayGiao.selectAll();
				txtNgayGiao.requestFocus();
				return false;
			}
		}
		else {
			txtMess.setText("Vui lòng nhập ngày giao.");
			txtNgayGiao.requestFocus();
			return false;
		}
		
		if(noiNhan.trim().length() > 0) {
			if(!noiNhan.matches("[\\p{L}]+ ([\\s+\\p{L}]+)*")) {
				txtMess.setText("Nơi nhận có thể có nhiều từ và không chứa ký tự đặc biệt.");
				txtNoiNhan.selectAll();
				txtNoiNhan.requestFocus();
				return false;
			}
		}
		else {
			txtMess.setText("Vui lòng nhập nơi nhận hàng.");
			txtNoiNhan.requestFocus();
			return false;
		}
		return true;
	}
	
	/**
	 * Kiểm tra dữ liệu nhập vào khi thêm chi tiết hóa đơn
	 * @return
	 */
	private boolean kiemTraDuLieuCTHD() {
		String sanPhamID = txtMaSp.getText().trim();
		String soLuong = txtSoLuong.getText().trim();
		
		if (sanPhamID.length() > 0) {
			if(!sanPhamID.matches("(HD|SP|RAM|MB|CPU)[\\d]{3}")) {
				txtMessCTHD.setText("Mã sản phẩm: (HD|SP|RAM|MB|CPU)XXX với X là số.");
				txtMaSp.selectAll();
				return false;
			}
			txtGiaBan.setText(sp_Bus.getSPTheoMa(txtMaSp.getText().trim()).getGiaBan()+"");
			txtMessCTHD.setText("");
		}
		else {
			txtMessCTHD.setText("Vui lòng nhập mã sản phẩm.");
			txtGiaBan.setText("");
			return false;
		}
		if(soLuong.length() > 0) {
			try {
				int n = Integer.parseInt(soLuong);
				if (n > 0) {
					double tongTien = sp_Bus.getSPTheoMa(txtMaSp.getText().trim()).getGiaBan()*n;
					txtTongTienCTHD.setText(String.format("%.1f", tongTien));
				}
				else {
					txtMessCTHD.setText("Số lượng phải là số nguyên dương.");
					txtSoLuong.selectAll();
					txtSoLuong.requestFocus();
					return false;
				}
			} catch (NumberFormatException e2) {
				// TODO: handle exception
				txtMess.setText("Số lượng phải là số nguyên dương.");
				txtSoLuong.selectAll();
				txtSoLuong.requestFocus();
				return false;
			}
		}
		else {
			txtMessCTHD.setText("");
			txtTongTienCTHD.setText("");
			return false;
		}
		
		return true;
	}
	
	/**
	 * Lấy dữ liệu khi thêm mới một chi tiết hóa đơn
	 * @return
	 */
	private ChiTietHoaDon layDuLieuCTHD() {
		String chiTietHDID = txtMaChiTietHD.getText().trim();
		SanPham sp = sp_Bus.getSPTheoMa(txtMaSp.getText().trim());
		HoaDon hd = hd_Bus.getHoaDonTheoMa(txtMaHD.getText());
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		double giaBan = sp.getGiaBan();
		double tongTien = sp.getGiaBan()*soLuong;
		return new ChiTietHoaDon(chiTietHDID, sp, hd, soLuong, giaBan, tongTien);
	}
	
	/**
	 * Thêm chi tiết hóa đơn
	 */
	private void themChiTietHoaDon() {
		if(kiemTraDuLieuCTHD()) {
			if(ctHD_Bus.themChiTietHD(layDuLieuCTHD())) {
				txtMessCTHD.setText("Thêm thành công.");
				hd_Bus.capNhatTongTienHDThemMaHD(txtMaHD.getText());
				int row = tableHoaDon.getSelectedRow();
				docDuLieuCTHDLenTable();
				docDuLieuLenTableHD();
				tableHoaDon.setRowSelectionInterval(row, row);
			}
		}
	}
	
	/**
	 * Xóa chi tiết hóa đơn
	 */
	private void xoaChiTietHoaDon() {
		if(tableChiTietHD.getSelectedRow() != -1) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa chi tiết hóa đơn này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				ctHD_Bus.xoaChiTietHD(txtMaChiTietHD.getText());
				modelCTHD.removeRow(tableChiTietHD.getSelectedRow());
				txtMessCTHD.setText("Xóa thành công.");
				hd_Bus.capNhatTongTienHDThemMaHD(txtMaHD.getText());
				int n = tableHoaDon.getSelectedRow();
				docDuLieuLenTableHD();
				xoaTrangCTHD();
				tableHoaDon.setRowSelectionInterval(n, n);
			}
		}
		else {
			txtMessCTHD.setText("Oops! Bạn cần chọn chi tiết hóa đơn để xóa.");
		}
	}
	/*
	 * Đưa tất cả nhân viên lên combobox	
	 */
	private void docNhanVienLenComboBox() throws ClassNotFoundException {
		ArrayList<NhanVien> listNV = nv_Bus.getalltbNhanVien();
		String[] item = new String[listNV.size()];
		int i = 0;
		for(NhanVien nv : listNV) {
			item[i] = nv.getTenNV();
			i++;
		}
		cboNhanVien.setModel(new DefaultComboBoxModel<String>(item));
	}
	
	/*
	 * Đưa dữ liệu chi tiết hóa đơn lên table Chi tiết hóa đơn khi nhấn chuột vào hóa đơn cụ thể
	 */
	private void docDuLieuCTHDLenTable() {
		xoaHetDuLieuTable(tableChiTietHD);
		listCTHD  = ctHD_Bus.getChiTietHDTheoMaHD(txtMaHD.getText());
		if(listCTHD.size() > 0) {
			DefaultTableModel dm = (DefaultTableModel) tableChiTietHD.getModel();
			for(ChiTietHoaDon ctHD : listCTHD) {
				dm.addRow(new Object[] {ctHD.getChiTietHoaDonID(), ctHD.getHoaDon().getIdHD(), ctHD.getSanPham().getSpID(), ctHD.getSanPham().getTenSP(), ctHD.getSoLuong(), String.format("%.0f", ctHD.getGiaBan()), String.format("%.0f", ctHD.getTongTien())});
			}
			tableChiTietHD.setModel(dm);
		}
	}
	
	/*
	 * Xóa trắng text field Hóa đơn
	 */
	private void xoaTrangHoaDon() {
		txtMaHD.setText("");
		txtIDKH.setText("");
		txtNgayLap.setText("");
		txtNgayGiao.setText("");
		txtNoiNhan.setText("");
		txtTongTienHD.setText("");
		cboNhanVien.setSelectedIndex(0);
		tableHoaDon.clearSelection();
		xoaHetDuLieuTable(tableChiTietHD);
		txtSoLuong.setEditable(false);
		txtMaSp.setEditable(false);
		txtMess.setText("");
		txtMessTim.setText("");
	}
	
	/**
	 * Xóa trắng text field Chi tiết hóa đơn
	 */
	private void xoaTrangCTHD() {
		txtMaChiTietHD.setText("");
		txtMaSp.setText("");
		txtSoLuong.setText("");
		txtGiaBan.setText("");
		txtTongTienCTHD.setText("");
		tableChiTietHD.clearSelection();
		txtMessCTHD.setText("");
	}
	
	/**
	 * Sửa hóa đơn
	 * @throws SQLException 
	 * @throws NumberFormatException 
	 */
	private void suaHoaDon() throws NumberFormatException, SQLException {
		int row = tableHoaDon.getSelectedRow();
		if(row != -1 ) {
			if (kiemTraDuLieuHD()) {
				HoaDon hd = getHoaDonData();
				hd.setTongTien(Double.parseDouble(tableHoaDon.getValueAt(row, 6).toString()));
				hd_Bus.suaHoaDon(hd);
				txtMess.setText("Sửa thành công.");
				docDuLieuLenTableHD();
				tableHoaDon.setRowSelectionInterval(row, row);
			}
		}
		else {
			txtMess.setText("Oops! Hình như bạn chưa chọn dòng để sửa.");
		}
	}
	
	/**
	 * Sửa chi tiết hóa đơn
	 */
	private void suaChiTietHoaDon() {
		int n = tableHoaDon.getSelectedRow();
		int row = tableChiTietHD.getSelectedRow();
		if(row != -1) {
			if (kiemTraDuLieuCTHD()) {
				ctHD_Bus.suaChiTietHD(layDuLieuCTHD());
				txtMessCTHD.setText("Sửa thành công.");
				docDuLieuCTHDLenTable();
				hd_Bus.capNhatTongTienHDThemMaHD(txtMaHD.getText());
				docDuLieuLenTableHD();
				tableHoaDon.setRowSelectionInterval(n, n);
				tableChiTietHD.setRowSelectionInterval(row, row);
			}
		}
		else {
			txtMessCTHD.setText("Oops! Bạn chưa chọn dòng để sửa.");
		}
	}
	
	/**
	 * Tìm hóa đơn theo mã hóa đơn
	 */
	private void timHoaDon() {
		String id = txtTim.getText().trim();
		if (id.length() > 0) {
			HoaDon hd = hd_Bus.getHoaDonTheoMa(id);
			if(hd == null) {
				txtMessTim.setText("Không tìm thấy.");
				return;
			}
			xoaHetDuLieuTable(tableChiTietHD);
			xoaHetDuLieuTable(tableHoaDon);
			DefaultTableModel dm = (DefaultTableModel) tableHoaDon.getModel();
			dm.addRow(new Object[] {hd.getIdHD(), hd.getKhachHang().getIdKH(), hd.getNhanVien().getTenNV(), hd.getNgayLapHD(), hd.getNgayGiao(), hd.getNoiNhan(), String.format("%.0f", hd.getTongTien())});
		}
		else {
			xoaHetDuLieuTable(tableChiTietHD);
			docDuLieuLenTableHD();
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			try {
				themHoaDon();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrangHoaDon();
		}
		if(o.equals(btnXoa)) {
			xoaHoaDon();
		}
		if (o.equals(btnThemCT)) {
			themChiTietHoaDon();
		}
		if(o.equals(btnXoaCT)) {
			xoaChiTietHoaDon();
		}
		if(o.equals(btnXoaTrangCT)) {
			xoaTrangCTHD();
		}
		if(o.equals(btnSua)) {
			try {
				suaHoaDon();
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnSuaCT)) {
			suaChiTietHoaDon();
		}
		if (o.equals(btnTim)) {
			timHoaDon();
		}
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int rowHD = tableHoaDon.getSelectedRow();
		if(rowHD != -1) {
			txtMaHD.setText(tableHoaDon.getValueAt(rowHD, 0).toString());
			txtIDKH.setText(tableHoaDon.getValueAt(rowHD, 1).toString());
			cboNhanVien.setSelectedItem(tableHoaDon.getValueAt(rowHD, 2).toString());
			txtNgayLap.setText(tableHoaDon.getValueAt(rowHD, 3).toString());
			txtNgayGiao.setText(tableHoaDon.getValueAt(rowHD, 4).toString());
			txtNoiNhan.setText(tableHoaDon.getValueAt(rowHD, 5).toString());
			txtTongTienHD.setText(tableHoaDon.getValueAt(rowHD, 6).toString());
			txtMaSp.setEditable(true);
			txtSoLuong.setEditable(true);
			docDuLieuCTHDLenTable();
			tableChiTietHD.clearSelection();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		kiemTraDuLieuCTHD();
		
	}
}
