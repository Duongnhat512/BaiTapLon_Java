package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class NhanVien_GUI extends JFrame implements ActionListener , MouseListener {

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
	private JTextField txtMess;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVien_GUI frame = new NhanVien_GUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public JPanel getNhanVienPanel() {
		return pCenter;
	}
	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public NhanVien_GUI() throws ClassNotFoundException {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

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
		
		
		tableNhanVien = new JTable(modelNhanVien);
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
			cboPhongBan.addItem(p.getTenPhongBan());
		}
		
		
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
		
		
		DocDuLieuDatabaseVaoTable();
		
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(441, 414, 104, 40);
		pCenter.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(441, 461, 104, 40);
		pCenter.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(441, 507, 104, 40);
		pCenter.add(btnXoa);
		
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(441, 553, 104, 40);
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
		
		rdbtnTimMa = new JRadioButton("Theo mã nhân viên");
		rdbtnTimMa.setSelected(true);
		buttonGroup.add(rdbtnTimMa);
		rdbtnTimMa.setFont(new Font("Arial", Font.PLAIN, 12));
		rdbtnTimMa.setBounds(638, 515, 156, 23);
		pCenter.add(rdbtnTimMa);
		
		rdbtnTimTen = new JRadioButton("Theo tên nhân viên");
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
		
		txtMess = new JTextField();
		txtMess.setEditable(false);
		txtMess.setForeground(new Color(255, 0, 0));
		txtMess.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		txtMess.setBounds(38, 361, 507, 19);
		pCenter.add(txtMess);
		txtMess.setBorder(null);
		txtMess.setColumns(10);
		
		btnXem.addActionListener(this);
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tableNhanVien.addMouseListener(this);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
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
		if (o.equals(btnXoaTrang)) {
			txtTenNV.setText("");
			txtMaNV.setText("");
			txtSoDT.setText("");
			txtLuong.setText("");
			txtMaNV.requestFocus();
		}
		if (o.equals(btnThem)) {
			String ma = txtMaNV.getText();
			String ten = txtTenNV.getText();
			String phongban = cboPhongBan.getSelectedItem().toString();
			String soDT = txtSoDT.getText();
			double luong = Double.parseDouble(txtLuong.getText());
			boolean phai = chkNu.isSelected();
			PhongBan phban = new PhongBan(phongban);
			
			NhanVien nv = new NhanVien(ma, ten, phban, soDT, luong, phai);
			try {
				nv_Bus.create(nv);
				modelNhanVien.addRow(new Object[] {nv.getNhanVienID(),nv.getTenNV(),nv.getPhong().getMaPhongBan(),nv.getSoDT(),nv.getLuong(),nv.getPhai()?"Nữ":"Nam"});
			} catch (Exception e1) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Trùng");
			}
		}
		
		if (o.equals(btnSua)) {
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
				}
				txtMess.setText("Sửa thành công.");
			}
			else {
				txtMess.setText("Bạn cần chọn dòng để sửa.");
			}
		}
		if (o.equals(btnXoa)) {
			int r = tableNhanVien.getSelectedRow();
			if(r != -1) {
				if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa dòng này không?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					nv_Bus.delete(modelNhanVien.getValueAt(r, 0).toString());
					txtMess.setText("Xóa thành công.");
				}
			}
			else {
				txtMess.setText("Bạn cần chọn dòng để xóa.");
			}
		}
		if (rdbtnTimMa.isSelected()){
			if (o.equals(btnTim)) {
				NhanVien nv = nv_Bus.getNhanVienTheoMaNV(txtTim.getText());
				if (txtTim.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "Nhập mã cần tìm");
				}else if (nv == null) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy");
				}
				else {
					xoaHetDuLieuTable();
					String [] rowdata = {nv.getNhanVienID(),nv.getTenNV(),nv.getPhong().getMaPhongBan()+"",nv.getSoDT(),String.format("%.0f", nv.getLuong())+"",nv.getPhai()?"Nu":"Nam"};
					modelNhanVien.addRow(rowdata);
				}
			}
		}
		if (rdbtnTimTen.isSelected()){
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
		if(o.equals(btnXem)) {
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
				if(nv_Bus.delete(maNV)) {
					modelNhanVien.removeRow(r);
					txtTenNV.setText("");
					txtMaNV.setText("");
					txtSoDT.setText("");
					txtLuong.setText("");
					txtMaNV.requestFocus();
				}
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
	public void DocDuLieuDatabaseVaoTable() throws ClassNotFoundException{
		ArrayList<NhanVien> list = nv_Bus.getalltbNhanVien();
		for (NhanVien nv : list) {
			modelNhanVien.addRow(new Object[] { nv.getNhanVienID() ,nv.getTenNV(),nv.getPhong().getMaPhongBan(),nv.getSoDT(),String.format("%.0f", nv.getLuong()),nv.getPhai()?"Nữ":"Nam"});
		}
	}
	private NhanVien reverSPFromTextFile() {
		String maNV = txtMaNV.getText().toString();
		String tenNV = txtTenNV.getText().toString();
		String phban = cboPhongBan.getSelectedItem().toString();
		String soDT = txtSoDT.getText().toString();
		double luong = Double.parseDouble(txtLuong.getText());
		boolean phai = chkNu.isSelected();
		return new NhanVien(maNV, tenNV,new PhongBan(phban), soDT, luong, phai);
	}
}
