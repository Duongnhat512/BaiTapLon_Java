package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bus.TaiKhoan_Bus;
import connectDB.ConnectDB;
import entities.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
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
	private static TaiKhoan_Bus taiKhoan_Bus;
	private JTextField txtMess;
	private JCheckBox chkLuu;
	private static String tenTaiKhoan;
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
					frame.dangNhapTuDong();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void open_LoginUI() {
		try {
			new Login_GUI().setVisible(true);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Login_GUI() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 426);
		setLocationRelativeTo(null);
		setTitle("Đăng nhập");
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
		
		JLabel lblTitle = new JLabel("Phần mềm quản lý bán linh kiện điện tử");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setBounds(103, 40, 503, 93);
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
		txtMess.setBounds(243, 233, 341, 34);
		contentPane.add(txtMess);
		txtMess.setColumns(10);
		txtMess.setBorder(null);
		
		chkLuu = new JCheckBox("Lưu mật khẩu");
		chkLuu.setFont(new Font("Arial", Font.PLAIN, 12));
		chkLuu.setBounds(437, 273, 127, 23);
		contentPane.add(chkLuu);
		
		chkLuu.setSelected(true);
		//Kết nối tới SQL Server
		ConnectDB.getInstance().connect();
		//
		taiKhoan_Bus = new TaiKhoan_Bus();
		
		//Đăng ký sự kiện
		btnDangNhap.addActionListener(this);
		btnQuenMatKhau.addActionListener(this);
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
		if (o.equals(btnQuenMatKhau)) {
			TaiKhoan tk = taiKhoan_Bus.getTaiKhoanTheoTenTaiKhoan(txtTaiKhoan.getText());
			if(tk != null) {
				JOptionPane.showMessageDialog(this, "Mật khẩu của tài khoản " + tk.getTaiKhoan() + " là: " + tk.getMatKhau());
			}
			else {
				txtMess.setText("Tài khoản hoặc mật khẩu không tồn tại.");
			}
		}
	}
	
	/*
	 * Lưu lại tài khoản đã đăng nhập
	 */
	private void luuDangNhap(String taiKhoan) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("data/LuuDangNhap.txt"));
			writer.write(taiKhoan);
			writer.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * Tự động điền tài khoản và mật khẩu khi tích vào checkbox của lần đăng nhập trước đó
	 */
	private void dangNhapTuDong() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("data/LuuDangNhap.txt"));
			String tmp = reader.readLine();
			if(tmp == null) return;
			String[] s = tmp.split(";");
			txtTaiKhoan.setText(s[0]);
			txtMatKhau.setText(s[1]);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/*
	 * Kiểm tra thông tin tài khoản và mật khẩu được nhập vào
	 */
	private boolean kiemTra(){
		txtMess.setText("");
		String taiKhoan = txtTaiKhoan.getText();
		String matKhau = new String(txtMatKhau.getPassword());
		TaiKhoan tk = taiKhoan_Bus.getTaiKhoanTheoTenTaiKhoan(taiKhoan);
		if(tk != null) {
			if(matKhau.equals(tk.getMatKhau())) {
				String s = "";
				if(chkLuu.isSelected()) {
					s = txtTaiKhoan.getText() + ";" + new String(txtMatKhau.getPassword());
					luuDangNhap(s);
				}
				else {
					luuDangNhap(s);
				}
				Main_GUI.open_MainUI();
				Login_GUI.frame.setVisible(false);
				setTaiKhoanDuocDangNhap();
				return true;
			}
			else {
				txtMess.setText("Mật khẩu không chính xác.");
				txtMatKhau.selectAll();
				txtMatKhau.requestFocus();
				return false;
			}
		}
		txtMess.setText("Tài khoản không tồn tại.");
		txtTaiKhoan.selectAll();
		txtTaiKhoan.requestFocus();
		return false;
	}
	
	
	/**
	 * Trả về tài khoản đã đăng nhập
	 * @return
	 */
	public static String getTaiKhoanDuocDangNhap() {
		return tenTaiKhoan;
	}
	
	public void setTaiKhoanDuocDangNhap() {
		tenTaiKhoan = txtTaiKhoan.getText();
	}
	
	public static String getLoaiTaiKhoanDuocDangNhap() {
		TaiKhoan tk = taiKhoan_Bus.getTaiKhoanTheoTenTaiKhoan(tenTaiKhoan);
		return tk.getLoaiTK();
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
