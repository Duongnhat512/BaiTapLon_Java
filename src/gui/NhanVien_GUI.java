package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.UUID;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.NhanVien_Bus;
import bus.PhongBan_Bus;
import connectDB.ConnectDB;
import entities.NhanVien;
import entities.PhongBan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class NhanVien_GUI extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtSoDT;
	private JTextField txtLuong;
	private JTextField txtTim;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JButton btnTim;
	private JCheckBox chkNu;
	private JComboBox<String> cboPhongBan;
	private JLabel lblPhongBan;
	private JLabel lblTenNV;
	private JRadioButton rdbtnTimMa;
	private JRadioButton rdbtnTimTen;
	private JButton btnXem;

	private PhongBan_Bus pb_Bus = new PhongBan_Bus();
	private NhanVien_Bus nv_Bus = new NhanVien_Bus();
	private JPanel pCenter;

	/**
	 * Launch the application.
	 */
	public static void open_NhanVienGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien_GUI frame = new NhanVien_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JPanel getNhanVienPanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ClassNotFoundException
	 */
	public NhanVien_GUI() throws ClassNotFoundException {

		setResizable(false); // không cho phép chỉnh sửa kích thước bố cục
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680); // chỉnh kích thước
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // chỉnh border

		setContentPane(contentPane);
		contentPane.setLayout(null);

		pCenter = new JPanel();
		pCenter.setLayout(null);
		pCenter.setBounds(130, 10, 1046, 623);
		contentPane.add(pCenter);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 1026, 281);
		pCenter.add(scrollPane);

		String[] colHeader = { "Mã NV", "Tên NV", "Phòng Ban", "Số DT", "Lương", "Giới Tính" };
		modelNhanVien = new DefaultTableModel(colHeader, 0);

		tableNhanVien = new JTable(modelNhanVien); // tạo table
		scrollPane.setViewportView(tableNhanVien);

		JLabel lblMaNVl = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblMaNVl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNVl.setFont(new Font("Arial", Font.BOLD, 20));
		lblMaNVl.setBounds(10, 10, 1026, 50);
		pCenter.add(lblMaNVl);

		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(38, 389, 120, 25);
		pCenter.add(lblNewLabel_1);

		lblTenNV = new JLabel("Tên Nhân Viên :");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenNV.setBounds(38, 424, 120, 25);
		pCenter.add(lblTenNV);

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setBounds(188, 394, 156, 20);
		pCenter.add(txtMaNV);
		txtMaNV.setColumns(10);

		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(188, 429, 156, 20);
		pCenter.add(txtTenNV);

		lblPhongBan = new JLabel("Phòng Ban :");
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhongBan.setBounds(38, 459, 120, 25);
		pCenter.add(lblPhongBan);

		cboPhongBan = new JComboBox<String>();
		cboPhongBan.setBounds(188, 463, 156, 22);
		pCenter.add(cboPhongBan);
		cboPhongBan.setEditable(true);
		ArrayList<PhongBan> listPB = pb_Bus.getalltbPhongBan();
		for (PhongBan p : listPB) {
			cboPhongBan.addItem(p.getMaPhongBan());
		}
		// tạo combox phòng ban rồi đưa dữ liệu từ sql lên

		JLabel lblSoDT = new JLabel("Số Điện Thoại :");
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDT.setBounds(38, 494, 120, 25);
		pCenter.add(lblSoDT);

		txtSoDT = new JTextField();
		txtSoDT.setColumns(10);
		txtSoDT.setBounds(188, 499, 156, 20);
		pCenter.add(txtSoDT);

		JLabel lblLuong = new JLabel("Lương :");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLuong.setBounds(38, 529, 120, 25);
		pCenter.add(lblLuong);

		JLabel lblGioiTinh = new JLabel("Giới Tính :");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioiTinh.setBounds(38, 568, 120, 25);
		pCenter.add(lblGioiTinh);

		txtLuong = new JTextField();
		txtLuong.setColumns(10);
		txtLuong.setBounds(188, 534, 156, 20);
		pCenter.add(txtLuong);

		chkNu = new JCheckBox("Nữ");
		chkNu.setBounds(188, 571, 97, 23);
		pCenter.add(chkNu);

		DocDuLieuDatabaseVaoTable(); // đưa dữ liệu từ sql lên bảng

		btnThem = new JButton("Thêm");
		btnThem.setBounds(439, 373, 104, 40);
		pCenter.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(439, 420, 104, 40);
		pCenter.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(439, 466, 104, 40);
		pCenter.add(btnXoa);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(439, 512, 104, 40);
		pCenter.add(btnXoaTrang);

		JLabel lblNewLabel_3 = new JLabel("Tìm Kiếm");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(636, 386, 329, 30);
		pCenter.add(lblNewLabel_3);

		txtTim = new JTextField();
		txtTim.setBounds(774, 450, 233, 36);
		pCenter.add(txtTim);
		txtTim.setColumns(10);

		rdbtnTimMa = new JRadioButton("Theo mã nhân viên"); // thêm nút chọn tìm theo mã
		rdbtnTimMa.setSelected(true);
		buttonGroup.add(rdbtnTimMa);
		rdbtnTimMa.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnTimMa.setBounds(638, 515, 156, 23);
		pCenter.add(rdbtnTimMa);

		rdbtnTimTen = new JRadioButton("Theo tên nhân viên"); // thêm nút chọn tìm theo tên
		buttonGroup.add(rdbtnTimTen);
		rdbtnTimTen.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnTimTen.setBounds(816, 515, 154, 23);
		pCenter.add(rdbtnTimTen);

		btnTim = new JButton("Tìm");
		btnTim.setBounds(634, 450, 89, 36);
		pCenter.add(btnTim);

		btnXem = new JButton("Xem Lại Danh Sách Nhân Viên");
		btnXem.setBounds(700, 557, 217, 37);
		pCenter.add(btnXem);
		
		kiemTraTaiKhoanDuocDangNhap();

		btnXem.addActionListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
	//	btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tableNhanVien.addMouseListener(this);
		// thêm sự kiện vào các nút
	}

	@Override
	public void mouseClicked(MouseEvent e) { // đưa dữ liệu từ hàng đang chọn lên các jtextfield
		// TODO Auto-generated method stub
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtTenNV.setText(modelNhanVien.getValueAt(row, 1).toString());
		cboPhongBan.setSelectedItem(modelNhanVien.getValueAt(row, 2).toString());
		txtSoDT.setText(modelNhanVien.getValueAt(row, 3).toString());
		txtLuong.setText(modelNhanVien.getValueAt(row, 4).toString());
		chkNu.setSelected(modelNhanVien.getValueAt(row, 5).toString() == "Nữ" ? true : false);

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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {	// xóa trắng dữ liệu trên jtextfield
			txtTenNV.setText("");
			txtMaNV.setText("");
			txtSoDT.setText("");
			txtLuong.setText("");
			txtMaNV.requestFocus();
		}
		if (o.equals(btnThem))  {	// thêm dữ liệu
			List<NhanVien> list = new ArrayList<NhanVien>();
			try {
				int k=1;
				list = nv_Bus.getalltbNhanVien();
				String ma = generateEmployeeID(k);
				while (list.contains(nv_Bus.getNhanVienTheoMaNV(ma))) {
					k++;
					ma = generateEmployeeID(k);
				}
				String ten = txtTenNV.getText();
				String phongban = cboPhongBan.getSelectedItem().toString();
				String soDT = txtSoDT.getText();
				double luong = Double.parseDouble(txtLuong.getText());
				boolean phai = chkNu.isSelected();
				PhongBan phban = new PhongBan(phongban);
				
				NhanVien nv = new NhanVien(ma, ten, phban, soDT, luong, phai);
			
				if(checkValue()) {
					try {
						nv_Bus.create(nv);
						
						modelNhanVien.addRow(new Object[] {nv.getNhanVienID(),nv.getTenNV(),nv.getPhong().getTenPhongBan(),nv.getSoDT(),nv.getLuong(),nv.getPhai()?"Nữ":"Nam"});
						DocDuLieuDatabaseVaoTable();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} catch (Exception e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(this, "Trùng");	// thông báo nếu bị trùng
					}
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if (o.equals(btnSua)) {		// sửa dữ liệu dòng đang chọn
			int row =tableNhanVien.getSelectedRow();
			if(row != -1) {
				NhanVien nv = reverSPFromTextFile();
				boolean n = true;
				try {
					n = nv_Bus.update(nv);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(n) {
					tableNhanVien.setValueAt(txtTenNV.getText(), row, 1);
					tableNhanVien.setValueAt(cboPhongBan.getSelectedItem().toString(), row, 2);
					tableNhanVien.setValueAt(txtSoDT.getText(), row, 3);
					tableNhanVien.setValueAt(txtLuong.getText(), row, 4);
					tableNhanVien.setValueAt(chkNu.isSelected()?"Nữ":"Nam", row, 5);
					JOptionPane.showMessageDialog(this, "Sửa thành công");
				}

			}
		}
		if (rdbtnTimMa.isSelected()){		//kiểm tra nếu chọn tìm theo mã thì thực hiện
			if (o.equals(btnTim)) {
				NhanVien s = nv_Bus.getNhanVienTheoMaNV(txtTim.getText());
				if (txtTim.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Nhập mã cần tìm");
				}else if (s == null) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy");
				}
				else {
					xoaHetDuLieuTable();
					String [] rowdata = {s.getNhanVienID(),s.getTenNV(),s.getPhong().getMaPhongBan()+"",s.getSoDT(),String.format("%.0f", s.getLuong())+"",s.getPhai()?"Nu":"Nam"};
					modelNhanVien.addRow(rowdata);
				}
			}
		}
		if (rdbtnTimTen.isSelected()){		//kiểm tra nếu chọn tìm theo tên thì thực hiện
			if (o.equals(btnTim)) {
				List<NhanVien> list = nv_Bus.getNhanVienTheoTen(txtTim.getText());
				if (txtTim.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Nhập mã cần tìm");
				}else if (list.size()==0) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy");
				}
				else {
					xoaHetDuLieuTable();
					for (NhanVien s: list) {
						String [] rowdata = {s.getNhanVienID(),s.getTenNV(),s.getPhong().getMaPhongBan()+"",s.getSoDT(),s.getLuong()+"",s.getPhai()?"Nu":"Nam"};
						modelNhanVien.addRow(rowdata);
					}
				}
			}}
		if(o.equals(btnXem)) {	// xem ds nhân viên
			try {
				xoaHetDuLieuTable();
				DocDuLieuDatabaseVaoTable();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (o.equals(btnXoa)) {
			int r = tableNhanVien.getSelectedRow();
			if (r>=0) {
				String maNV =  tableNhanVien.getValueAt(r, 0).toString();
				if(JOptionPane.showConfirmDialog(this,"Có chắc chắn muốn xóa","Cảnh báo !",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				if(nv_Bus.delete(maNV)) {
					modelNhanVien.removeRow(r);
					txtTenNV.setText("");
					txtMaNV.setText("");
					txtSoDT.setText("");
					txtLuong.setText("");
					txtMaNV.requestFocus();
					JOptionPane.showMessageDialog(this, "Xóa thành công");
				}}
			}
		}
	}

	private void xoaHetDuLieuTable() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
	}

	/*
	 * Đọc dữ liệu từ database vào table
	 */
	public void DocDuLieuDatabaseVaoTable() throws ClassNotFoundException { // lấy dữ liệu từ sql lên bảng
		xoaHetDuLieuTable();
		ArrayList<NhanVien> list = nv_Bus.getalltbNhanVien();
		for (NhanVien nv : list) {
			modelNhanVien.addRow(new Object[] { nv.getNhanVienID(), nv.getTenNV(), nv.getPhong().getMaPhongBan(),
					nv.getSoDT(), String.format("%.0f", nv.getLuong()), nv.getPhai() ? "Nữ" : "Nam" });
		}
	}

	private NhanVien reverSPFromTextFile() {
		String maNV = txtMaNV.getText().toString();
		String tenNV = txtTenNV.getText().toString();
		String phban = cboPhongBan.getSelectedItem().toString();
		String soDT = txtSoDT.getText().toString();
		double luong = Double.parseDouble(txtLuong.getText());
		boolean phai = chkNu.isSelected();
		// kiểm tra dữ liệu
		return new NhanVien(maNV, tenNV, new PhongBan(phban), soDT, luong, phai);
	}

	public boolean checkValue() {
		String ten = txtTenNV.getText().trim();
//		String ma = txtMaNV.getText().trim();
		String sdt = txtSoDT.getText().trim();
		String luong = txtLuong.getText().trim();

		if (ten.length() == 0) {
			JOptionPane.showMessageDialog(null, "Tên ko được rỗng");
			return false;
		}
		if (sdt.length() == 0) {
			JOptionPane.showMessageDialog(null, "Số điện thoại ko được rỗng");
			return false;
		}
		if (luong.length() == 0) {
			JOptionPane.showMessageDialog(null, "Lương ko được rỗng");
			return false;
		}

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

		String a3 = "^\\d+(\\.\\d+)?$";
		Pattern p3 = Pattern.compile(a3);
		Matcher m3 = p3.matcher(luong);
		if (!m3.matches()) {
			JOptionPane.showMessageDialog(null, "Lương phải là 1 số");
			return false;
		}

		return true;
	}

	public String generateEmployeeID(int index) {
		String employeeID = "NV" + String.format("%03d", index); // Tạo mã NV + số thứ tự với độ dài 3 ký tự
		return employeeID;
	}
	
	public void kiemTraTaiKhoanDuocDangNhap() {
		String loai = Login_GUI.getLoaiTaiKhoanDuocDangNhap();
		if(!(loai.equals("admin") || loai.equals("ns"))) {
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
		}
	}

}
