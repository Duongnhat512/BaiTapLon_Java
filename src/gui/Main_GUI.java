package gui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import connectDB.ConnectDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Main_GUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	
	
	private NhaCungCap_GUI ncc_UI;
	private HoaDon_GUI hoaDon_UI;
	private KhachHang_GUI kh_UI;
	private NhanVien_GUI nv_UI;
	
	private JPanel pHoaDon;
	private JPanel pTrangChu;
	private JPanel pNhaCC;
	private JPanel pKhachHang;
	private JPanel pNhanVien;
	private JPanel pSanPham;
	
	private String currentUI;
	
	private JButton btnNhaCC;
	private JButton btnHoaDon;
	private JButton currentButton;
	private Color colorButton;
	private JButton btnSanPham;
	private JButton btnNhanVien;
	private JButton btnTrangChu;
	private JButton btnThoat;
	private JButton btnKhachHang;
	private JLabel lblTenTK;


	private SanPham_GUI sp_UI;


	private JButton btnDangXuat;


	protected static Main_GUI frame;


	/**
	 * Mở main UI.
	 */
	public static void open_MainUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main_GUI();
					frame.moHoaDonKhiKhoiDong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	/**
	 * Đóng main UI
	 */
	public static void close_MainUI() {
		Main_GUI.frame.setVisible(false);
	}
	
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Main_GUI() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		JPanel pWest = new JPanel();
		pWest.setBounds(10, 10, 120, 623);
		contentPane.add(pWest);
		pWest.setLayout(null);
		
		int r = 210, g = 210, b = 210;
		colorButton = new Color(r, g, b);
		
		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setBounds(0, 210, 120, 65);
		btnHoaDon.setBackground(colorButton);
		pWest.add(btnHoaDon);
		
		btnNhaCC = new JButton("Nhà cung cấp");
		btnNhaCC.setBounds(0, 275, 120, 65);
		btnNhaCC.setBackground(colorButton);
		pWest.add(btnNhaCC);
		
		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setBackground(new Color(210, 210, 210));
		btnSanPham.setBounds(0, 340, 120, 65);
		pWest.add(btnSanPham);
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBackground(new Color(210, 210, 210));
		btnNhanVien.setBounds(0, 145, 120, 65);
		pWest.add(btnNhanVien);
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setBackground(new Color(210, 210, 210));
		btnTrangChu.setBounds(0, 80, 120, 65);
		pWest.add(btnTrangChu);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(0, 573, 120, 50);
		btnThoat.setBackground(Color.WHITE);
		pWest.add(btnThoat);

		btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setBackground(new Color(210, 210, 210));
		btnKhachHang.setBounds(0, 405, 120, 65);
		pWest.add(btnKhachHang);
		
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(Color.WHITE);
		btnDangXuat.setBounds(0, 498, 120, 65);
		pWest.add(btnDangXuat);
		
		lblTenTK = new JLabel(Login_GUI.getTaiKhoanDuocDangNhap());
		lblTenTK.setFont(new Font("Arial", Font.BOLD, 15));
		lblTenTK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenTK.setBounds(0, 27, 120, 43);
		pWest.add(lblTenTK);
		
		//Đăng ký sự kiện
		btnHoaDon.addActionListener(this);
		btnNhaCC.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnSanPham.addActionListener(this);
		btnTrangChu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnDangXuat.addActionListener(this);
	}
	
	private void moHoaDonKhiKhoiDong() throws ClassNotFoundException {
		currentButton = btnHoaDon;
		hoaDon_UI = new HoaDon_GUI();
		pHoaDon = hoaDon_UI.getHoaDonPanel();
		contentPane.add(pHoaDon);
		btnHoaDon.setBackground(Color.WHITE);
	}

	
	/*
	 * Mở panel khi nhấn vào nút
	 */
	private void openPanel(JButton btn) throws ClassNotFoundException, SQLException {
		if(btn.equals(btnHoaDon)) {
			hoaDon_UI = new HoaDon_GUI();
			pHoaDon = hoaDon_UI.getHoaDonPanel();
			contentPane.add(pHoaDon);
		}
		if(btn.equals(btnNhaCC)) {
			ncc_UI = new NhaCungCap_GUI();
			pNhaCC = ncc_UI.getNCCPanel();
			contentPane.add(pNhaCC);
		}
		if(btn.equals(btnKhachHang)) {
			kh_UI = new KhachHang_GUI();
			pKhachHang = kh_UI.getKhachHangPanel();
			contentPane.add(pKhachHang);
		}
		if(btn.equals(btnNhanVien)) {
			nv_UI = new NhanVien_GUI();
			pNhanVien = nv_UI.getNhanVienPanel();
			contentPane.add(pNhanVien);
		}
		if(btn.equals(btnTrangChu)) {
			pTrangChu = new JPanel();
			contentPane.add(pTrangChu);
		}
		if(btn.equals(btnSanPham)) {
			sp_UI = new SanPham_GUI();
			pSanPham = sp_UI.getSanPhamPanel();
			contentPane.add(pSanPham);
		}
		this.revalidate();
		this.repaint();	
	}
	
	/*
	 * Trả về JPanel hiện tại đang được hiện
	 */
	private JPanel getCurrentUI() {
		if(currentButton.equals(btnTrangChu))
			return pTrangChu;
		if(currentButton.equals(btnNhaCC))
			return pNhaCC;
		if(currentButton.equals(btnHoaDon))
			return pHoaDon;
		if(currentButton.equals(btnKhachHang))
			return pKhachHang;
		if(currentButton.equals(btnNhanVien))
			return pNhanVien;
		if(currentButton.equals(btnSanPham))
			return pSanPham;
		return null;
	}
	
	
	/*
	 * Thay đổi màu của JButton khi nhấn vào
	 */
	private void changeColorButton(JButton btn) {
		if(btn == null) return;
		btn.setBackground(colorButton);
	}
	
	/*
	 * Thay đổi JPanel đang hiển thị thành JPanel được chọn
	 */
	private void updatePanel(JButton btn) {
		changeColorButton(currentButton);
		contentPane.remove(getCurrentUI());
		try {
			openPanel(btn);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		currentButton = btn;
		btn.setBackground(Color.WHITE);
	}
	
	/**
	 * Đăng xuất tài khoản đã đăng nhập
	 */
	private void dangXuat() {
		if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đăng xuất không?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			Login_GUI.open_LoginUI();
			close_MainUI();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNhaCC)) {
			updatePanel(btnNhaCC);
		}
		if(o.equals(btnHoaDon)) {
			updatePanel(btnHoaDon);
		}
		if(o.equals(btnKhachHang)) {
			updatePanel(btnKhachHang);
		}
		if(o.equals(btnThoat)) {
			if(JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình không?", "Hỏi nhắc", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		if(o.equals(btnNhanVien)) {
			updatePanel(btnNhanVien);
		}
		if (o.equals(btnTrangChu)) {
			updatePanel(btnTrangChu);
		}
		if (o.equals(btnSanPham)) {
			updatePanel(btnSanPham);
		}
		if (o.equals(btnDangXuat)) {
			dangXuat();
		}
	}
}