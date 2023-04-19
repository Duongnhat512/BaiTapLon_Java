package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.KhachHang_Bus;
import connectDB.ConnectDB;

import entities.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class KhachHang_GUI extends JFrame implements ActionListener,MouseListener{


	/**
	 * Launch the application.
	 */
	public static void open_KhachHangUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachHang_GUI frame = new KhachHang_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private DefaultTableModel dftable;
	private JTextField txtMa;
	private JTextField txtTen;
	private JRadioButton rdNu;
	private JRadioButton rdNam;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JTextField txtGmail;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnReset;
	private JTextField txtTimKiem;
	private JButton btnTim;
	private JTextField txtLoai;
	private JComboBox cbbLoc;
	private JButton btnLoc;
	private JButton btnTrang;
	private KhachHang_Bus kh_Bus;
	private JTable table;
	private JPanel pCenter;
	
	
	public JPanel getKhachHangPanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public KhachHang_GUI() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(2);
		}

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
		pCenter.setBounds(130, 10, 1043, 623);
		contentPane.add(pCenter);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 1019, 253);
		pCenter.add(scrollPane);
		
		table = new JTable();
		table.setModel(dftable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 Kh\u00E1ch H\u00E0ng", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Lo\u1EA1i Kh\u00E1ch H\u00E0ng", "Gi\u1EDBi T\u00EDnh", "\u0110\u1ECBa Ch\u1EC9", "S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i", "Gmail"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 313, 1019, 300);
		pCenter.add(panel);
		
		
		
		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setForeground(new Color(0, 0, 0));
		lblKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblKhachHang.setBounds(442, 10, 116, 30);
		pCenter.add(lblKhachHang);
		panel.setLayout(null);
		
		JLabel lblMa = new JLabel("Mã KH");
		lblMa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMa.setBounds(15, 30, 63, 30);
		panel.add(lblMa);
		
		txtMa = new JTextField();
		txtMa.setEditable(false);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMa.setBounds(118, 31, 250, 30);
		panel.add(txtMa);
		txtMa.setColumns(10);
		
		JLabel lblTen = new JLabel("Tên KH");
		lblTen.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTen.setBounds(15, 78, 67, 30);
		panel.add(lblTen);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTen.setBounds(118, 78, 250, 30);
		panel.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblGioiTinh = new JLabel("Giới Tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGioiTinh.setBounds(15, 126, 63, 30);
		panel.add(lblGioiTinh);
		
		ButtonGroup group = new ButtonGroup();
		
		rdNu = new JRadioButton("Nữ");
		rdNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdNu.setBounds(118, 126, 67, 30);
		panel.add(rdNu);
		rdNam = new JRadioButton("Nam");
		rdNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdNam.setBounds(224, 126, 70, 35);
		panel.add(rdNam);
		group.add(rdNu);
		group.add(rdNam);
//		panel.add(group);
		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(15, 174, 63, 30);
		panel.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(118, 174, 250, 30);
		panel.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lbSDT = new JLabel("Số Điện Thoại");
		lbSDT.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbSDT.setBounds(409, 31, 106, 30);
		panel.add(lbSDT);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSDT.setBounds(512, 31, 250, 30);
		panel.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGmail.setBounds(409, 78, 85, 30);
		panel.add(lblGmail);
		
		txtGmail = new JTextField();
		txtGmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtGmail.setBounds(512, 78, 250, 30);
		panel.add(txtGmail);
		txtGmail.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBounds(819, 31, 192, 30);
		panel.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(819, 78, 192, 30);
		panel.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBounds(819, 126, 192, 30);
		panel.add(btnSua);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBounds(819, 174, 192, 30);
		panel.add(btnReset);
		
		JLabel lblTimKiem = new JLabel("Tìm kiếm theo tên ");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTimKiem.setBounds(15, 213, 124, 29);
		panel.add(lblTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(140, 213, 228, 30);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTim.setBounds(184, 253, 90, 35);
		panel.add(btnTim);
		
		JLabel lblLoai = new JLabel("Loại KH");
		lblLoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoai.setBounds(409, 126, 85, 30);
		panel.add(lblLoai);
		
		txtLoai = new JTextField();
		txtLoai.setEditable(false);
		txtLoai.setBounds(512, 126, 250, 30);
		panel.add(txtLoai);
		
		JLabel lblLoc = new JLabel("Lọc theo loại KH");
		lblLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoc.setBounds(409, 212, 106, 30);
		panel.add(lblLoc);
		
		cbbLoc = new JComboBox();
		cbbLoc.setBounds(543, 213, 217, 30);
		panel.add(cbbLoc);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLoc.setBounds(605, 253, 90, 35);
		panel.add(btnLoc);
		
		btnTrang = new JButton("Xóa Trắng");
		btnTrang.setFont(new Font("Dialog", Font.BOLD, 12));
		btnTrang.setBounds(819, 213, 190, 30);
		panel.add(btnTrang);
		
		pCenter.setLayout(null);
		
		loadDataKH();
		
		btnThem.addActionListener(this);
		btnLoc.addActionListener(this);
		btnReset.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnTrang.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
	}
	
	public void loadDataKH() {
		kh_Bus = new KhachHang_Bus();
		docDulieuVaoTable();
		updateCBB();
	}
	
	public void xoaTable() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	public void docDulieuVaoTable() {
		xoaTable();
		ArrayList<KhachHang> ds = new ArrayList<>();
		ds = kh_Bus.getAllTableKhachHang();
		int stt = 1;
		for (KhachHang khachHang : ds) {
			String s="";
			if(khachHang.isGioiTinh()) {
				s+="Nam";
			}else {
				s+="Nữ";
			}
			dftable.addRow(new Object[] {
					stt, khachHang.getIdKH(), khachHang.getTenKH(), khachHang.getLoaiKhachHang(), s, khachHang.getDiaChi(),
					khachHang.getSoDienThoai(), khachHang.getGmail()
			});
			stt++;
		}
		
	}
	public void updateCBB() {
		ArrayList<KhachHang> ds = kh_Bus.getAllTableKhachHang();
		Set<String> uniqueTypes = new HashSet<String>();
		for (KhachHang kh : ds) {
		   uniqueTypes.add(kh.getLoaiKhachHang());
		}
		String[] loai = uniqueTypes.toArray(new String[uniqueTypes.size()]);

		cbbLoc.setModel(new DefaultComboBoxModel<>(loai));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj =e.getSource();
		if(obj.equals(btnThem)) {
			KhachHang k = layData();
			
			try {
				if(kh_Bus.them(k)) {
					JOptionPane.showMessageDialog(null, "Thành công");
					docDulieuVaoTable();
					updateCBB();
					reSet();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Lỗi dữ liệu");
				e1.printStackTrace();
			}
		}
		if(obj.equals(btnReset)) {
			docDulieuVaoTable();
			reSet();
		}
		if(obj.equals(btnXoa)) {
			int r = table.getSelectedRow();
			if(r!=-1) {
				String ma = (String) table.getValueAt(r, 1);
				KhachHang k =new KhachHang(ma);
				try {
					if(JOptionPane.showConfirmDialog(this,"Có chắc chắn muốn xóa","Cảnh báo !",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
						kh_Bus.xoa(k);
						JOptionPane.showMessageDialog(null, "Thành công");
						updateCBB();
						docDulieuVaoTable();
						reSet();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi dữ liệu");
				}
			}
		}
		if(obj.equals(btnTrang)) {
			reSet();
		}
		if(obj.equals(btnTim)) {
			String ten = txtTimKiem.getText();
			try {
				ArrayList<KhachHang> dsks =  kh_Bus.getKhachHangTheoTen(ten);
				thayTable(dsks);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Không tìm thấy");
			}
		}
		if(obj.equals(btnLoc)) {
			String loai = (String) cbbLoc.getSelectedItem(); 
			try {
				ArrayList<KhachHang> ds = kh_Bus.getKhachHangTheoLoai(loai);
				thayTable(ds);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi dữ liệu");
			}
			
		}
		if(obj.equals(btnSua)) {
			int r = table.getSelectedRow() ;
			String ma = txtMa.getText().trim();
			String ten = txtTen.getText().trim();
			boolean gioiTinh;
			if (rdNam.isSelected()) {
				gioiTinh = true;
			} else {
				gioiTinh = false;
			}
			String diaChi = txtDiaChi.getText().trim();
			String sdt = txtSDT.getText().trim();
			String gmail =txtGmail.getText().trim();
			String loai = txtLoai.getText().trim();
			KhachHang k =new KhachHang(ma, ten, gioiTinh, diaChi, sdt, gmail, loai);
			if(checkValue()) {
				try {
					kh_Bus.sua(k);
					JOptionPane.showMessageDialog(null, "Thành công");
					updateCBB();
					docDulieuVaoTable();
					
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Không tìm thấy");
					
					e1.printStackTrace();
				}				
			}
		}
	}
	
	public boolean checkValue() {
		String ten = txtTen.getText().trim();
		boolean gioiTinh;
		if (rdNam.isSelected()) {
			gioiTinh = true;
		} else if (rdNu.isSelected()) {
			gioiTinh = false;
		} else {
			JOptionPane.showMessageDialog(null, "Hãy lựa chọn giới tính");
			return false;
		}
		String diaChi = txtDiaChi.getText().trim();
		String sdt = txtSDT.getText().trim();
		String gmail = txtGmail.getText().trim();
		if (ten.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên ko được rỗng");
			return false;
		}
		if (diaChi.length() == 0) {
			JOptionPane.showMessageDialog(null, "Địa chỉ ko được rỗng");
			return false;
		}
		if (gmail.length() == 0) {
			JOptionPane.showMessageDialog(null, "Gmail ko được rỗng");
			return false;
		}
		if (sdt.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại ko được rỗng");
			return false;
		}

//		String a = "([A-Z][a-z]*\\s*)+([A-Z][a-z]*)*";
		String a = "[\\p{Lu}][\\p{L}]+([\\s]+[\\p{Lu}][\\p{L}]+)+";
		Pattern p = Pattern.compile(a);
		Matcher m = p.matcher(ten);
		if (!m.matches()) {
			JOptionPane.showMessageDialog(null, "Tên phải bắt đầu là chữ hoa và không có ký tự số");
			return false;
		}

		String a1 = "^0[1-9][0-9]{8}$";
		Pattern p1 = Pattern.compile(a1);
		Matcher m1 = p1.matcher(sdt);
		if (!m1.matches()) {
			JOptionPane.showMessageDialog(null, "Số điện thoại gồm 10 số bắt đầu là số 0 ");
			return false;
		}

		String a3 = "[a-zA-Z0-9_.]+\\@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}";
		Pattern p3 = Pattern.compile(a3);
		Matcher m3 = p3.matcher(gmail);
		if (!m3.matches()) {
			JOptionPane.showMessageDialog(null, "Gmail là 1 chuỗi có thể có ký tự số chữ và ký tự đặc biệt");
			return false;
		}
		return true;
	}

	public void thayTable(ArrayList<KhachHang> ds) {
		xoaTable();
		int stt=0;
		for (KhachHang khachHang : ds) {
			String s="";
			if(khachHang.isGioiTinh()) {
				s+="Nam";
			}else {
				s+="Nữ";
			}
			dftable.addRow(new Object[] {
					stt,khachHang.getIdKH(),khachHang.getTenKH(),khachHang.getLoaiKhachHang(),s,khachHang.getDiaChi(),
					khachHang.getSoDienThoai(),khachHang.getGmail()
			});
			stt++;
		}
	}
	
	/*
	 * Lấy dữ liệu Khách hàng
	 */
	public KhachHang layData() {
		String ma = txtMa.getText();
		String ten =  txtTen.getText();
		boolean gioiTinh ;
		if(rdNam.isSelected()) {
			gioiTinh = true;
		}else {
			gioiTinh = false;
		}
		String diaChi =  txtDiaChi.getText();
		String sdt =  txtSDT.getText();
		String gmail = txtGmail.getText();
		String loai =  txtLoai.getText();
		KhachHang k = new KhachHang(ma,ten,gioiTinh,diaChi,sdt,gmail,loai);
		return k;
	}
	
	/*
	 * Xóa trắng
	 */
	public void reSet() {
		txtMa.setText("");
		txtTen.setText("");
		rdNam.setSelected(false);
		rdNu.setSelected(false);
		txtDiaChi.setText("");
		txtSDT.setText("");
		txtGmail.setText("");
		txtLoai.setText("");
		txtMa.requestFocus();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		txtMa.setText((String) table.getValueAt(r, 1));
		txtTen.setText((String) table.getValueAt(r, 2));
		if(table.getValueAt(r, 4).equals("Nam")) {
			rdNam.setSelected(true);
		}else {
			rdNu.setSelected(true);
		}
		txtDiaChi.setText((String) table.getValueAt(r, 5));
		txtSDT.setText((String) table.getValueAt(r, 6));
		txtGmail.setText((String) table.getValueAt(r, 7));
		txtLoai.setText((String) table.getValueAt(r, 3));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		
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
}
