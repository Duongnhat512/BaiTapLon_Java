package ui;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import connectDB.ConnectDB;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Main_GUI extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JPanel pNhaCC;
	
	
	private NhaCungCap_GUI ncc_UI;
	private HoaDon_GUI hoaDon_UI;
	
	private JPanel pHoaDon;
	private JPanel pTrangChu;
	
	private String currentUI;
	private String nextUI;
	
	private JButton btnNhaCC;
	private JButton btnHoaDon;
	private JButton currentButton;
	private Color colorButton;
	private JButton btnSanPham;
	private JButton btnNhanVien;
	private JButton btnTrangChu;
	private JButton btnThoat;
	/**
	 * Launch the application.
	 */
	public static void open_MainUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_GUI frame = new Main_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
//		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().add(contentPane);
		
		JPanel pWest = new JPanel();
		pWest.setBounds(10, 10, 120, 623);
		contentPane.add(pWest);
		pWest.setLayout(null);
		
		int r = 210, g = 210, b = 210;
		colorButton = new Color(r, g, b);
		
		btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setBounds(0, 268, 120, 70);
		btnHoaDon.setBackground(colorButton);
		pWest.add(btnHoaDon);
		
		btnNhaCC = new JButton("Nhà cung cấp");
		btnNhaCC.setBounds(0, 334, 120, 70);
		btnNhaCC.setBackground(colorButton);
		pWest.add(btnNhaCC);
		
		btnSanPham = new JButton("Sản phẩm");
		btnSanPham.setBackground(new Color(210, 210, 210));
		btnSanPham.setBounds(0, 403, 120, 70);
		pWest.add(btnSanPham);
		
		btnNhanVien = new JButton("Nhân viên");
		btnNhanVien.setBackground(new Color(210, 210, 210));
		btnNhanVien.setBounds(0, 199, 120, 70);
		pWest.add(btnNhanVien);
		
		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.setBackground(new Color(210, 210, 210));
		btnTrangChu.setBounds(0, 130, 120, 70);
		pWest.add(btnTrangChu);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(0, 523, 120, 70);
		btnThoat.setBackground(Color.WHITE);
		pWest.add(btnThoat);
		
		pTrangChu = new JPanel();
		contentPane.add(pTrangChu);
		currentUI = "Trang chủ";		
		
		btnHoaDon.addActionListener(this);
		btnNhaCC.addActionListener(this);
	}
	
	private void openUI(JButton btn) throws ClassNotFoundException, SQLException {
		if(btn.equals(btnHoaDon)) {
			hoaDon_UI = new HoaDon_GUI();
			pHoaDon = hoaDon_UI.getHoaDonPanel();
			contentPane.add(pHoaDon);
		}
		if(btn.equals(btnNhaCC)) {
			ncc_UI = new NhaCungCap_GUI();
			pNhaCC = ncc_UI.getNCCPanel();
			contentPane.add(pNhaCC);
			ncc_UI.loadDataNCC();
		}
		this.revalidate();
		this.repaint();	
	}
	
	private JPanel getCurrentUI() {
		if(currentUI.equals("Trang chủ")) {
			return pTrangChu;
		}
		if(currentUI.equals("Nhà cung cấp"))
			return pNhaCC;
		if(currentUI.equals("Hóa đơn"))
			return pHoaDon;
		return null;
	}
	
	private void changeColorButton(JButton btn) {
		if(btn == null) return;
		btn.setBackground(colorButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnNhaCC)) {
			changeColorButton(currentButton);
			contentPane.remove(getCurrentUI());
			try {
				openUI(btnNhaCC);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			currentUI = "Nhà cung cấp";
			currentButton = btnNhaCC;
			btnNhaCC.setBackground(Color.WHITE);
		}
		if(o.equals(btnHoaDon)) {
			changeColorButton(currentButton);
			contentPane.remove(getCurrentUI());
			try {
				openUI(btnHoaDon);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			currentUI = "Hóa đơn";
			currentButton = btnHoaDon;
			btnHoaDon.setBackground(Color.WHITE);
		}
		
	}
}
