package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bus.TaiKhoan_Bus;
import connectDB.ConnectDB;
import entities.RoundedBorder;
import entities.TaiKhoan;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;

public class Login_GUI extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnQuenMatKhau;
	private TaiKhoan_Bus taiKhoan_Bus;
	private JTextField txtMess;
	protected static Login_GUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login_GUI();
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
	public Login_GUI() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 469);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("Tài khoản: ");
		lblTaiKhoan.setFont(new Font("Arial", Font.BOLD, 15));
		lblTaiKhoan.setBounds(103, 143, 141, 34);
		contentPane.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Arial", Font.PLAIN, 15));
		txtTaiKhoan.setBounds(243, 145, 341, 34);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu: ");
		lblMatKhau.setFont(new Font("Arial", Font.BOLD, 15));
		lblMatKhau.setBounds(103, 200, 141, 34);
		contentPane.add(lblMatKhau);
		
		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Arial", Font.PLAIN, 15));
		txtMatKhau.setColumns(10);
		txtMatKhau.setBounds(243, 200, 341, 34);
		contentPane.add(txtMatKhau);
		
		JLabel lblTitle = new JLabel("Phần mềm quản lý bán linh kiện");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setBounds(103, 40, 503, 56);
		contentPane.add(lblTitle);
		
		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Arial", Font.PLAIN, 15));
		btnDangNhap.setBounds(241, 313, 141, 46);
		contentPane.add(btnDangNhap);
		
		btnQuenMatKhau = new JButton("Quên mật khẩu");
		btnQuenMatKhau.setFont(new Font("Arial", Font.PLAIN, 15));
		btnQuenMatKhau.setBounds(437, 313, 141, 46);
		contentPane.add(btnQuenMatKhau);
		
		txtMess = new JTextField();
		txtMess.setForeground(new Color(255, 0, 0));
		txtMess.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txtMess.setEditable(false);
		txtMess.setBounds(243, 255, 341, 34);
		contentPane.add(txtMess);
		txtMess.setColumns(10);
		txtMess.setBorder(null);
		
		//Kết nối tới SQL Server
		ConnectDB.getInstance().connect();
		//
		taiKhoan_Bus = new TaiKhoan_Bus();
		
		//Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		txtTaiKhoan.addKeyListener(this);
		txtMatKhau.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDangNhap)) {
				kiemTra();
		}
		
	}

	private boolean kiemTra(){
		txtMess.setText("");
		String taiKhoan = txtTaiKhoan.getText();
		@SuppressWarnings("deprecation")
		String matKhau = txtMatKhau.getText();
		TaiKhoan tk = taiKhoan_Bus.getTaiKhoanTheoTenTaiKhoan(taiKhoan);
		if(tk != null) {
			if(matKhau.equals(tk.getMatKhau())) {
				if(tk.getLoaiTK().trim().equals("admin")) {
					Main_GUI.open_MainUI();
					Login_GUI.frame.setVisible(false);
					return true;
				}
			}
			else {
				txtMess.setText("Thông tin tài khoản hoặc mật khẩu không chính xác.");
				return false;
			}
		}
		else {
			txtMess.setText("Thông tin tài khoản hoặc mật khẩu không chính xác.");
			return false;
		}
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			kiemTra();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
