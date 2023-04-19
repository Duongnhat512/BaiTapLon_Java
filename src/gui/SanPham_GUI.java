package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_DAO;
import dao.SanPham_DAO;
import connectDB.ConnectDB;
import entities.CPU;
import entities.HardDisk;
import entities.MainBoard;
import entities.NhaCungCap;
import entities.Ram;
import entities.SanPham;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class SanPham_GUI extends JFrame  implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTable table;
	private JTextField txtMaSP;
	private JTextField txtTenSP;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtBH;
	private JTextField txtInput1;
	private JTextField txtInput2;
	private JTextField txtInput3;
	private JTextField txtTim;
	private DefaultTableModel model;
	private NhaCungCap_DAO ncc_DAO;
	private SanPham_DAO sp_DAO;
	private JButton btnReset;
	private JButton btnLoc;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThem;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_10;
	private JComboBox<String> cbNcc;
	private JComboBox<String> cbLoai;
	private JButton btnTim;
	private JPanel panel_2;
	private JTextField txtSLTon;
	private JTextField txtHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPham_GUI frame = new SanPham_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ClassNotFoundException 
	 */
	public SanPham_GUI() throws ClassNotFoundException {
		
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ncc_DAO = new NhaCungCap_DAO();
		sp_DAO = new SanPham_DAO();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SanPham");
		setResizable(false);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(130, 45, 1046, 288);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel( model = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 SP", "T\u00EAn SP", "H\u00E3ng", "Lo\u1EA1i", "Gi\u00E1 Nh\u1EADp", "Gi\u00E1 B\u00E1n", "SL T\u1ED3n", "Nh\u00E0 Cung C\u1EA5p", "Th\u1EDDi Gian BH"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(234);
		table.getColumnModel().getColumn(2).setPreferredWidth(58);
		table.getColumnModel().getColumn(3).setPreferredWidth(56);
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(59);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);
		table.getColumnModel().getColumn(7).setPreferredWidth(96);
		scrollPane.setViewportView(table);
		DocDuLieuDatabaseVaoTable();
		JLabel lblNewLabel = new JLabel("THÔNG TIN SẢN PHẨM");
		lblNewLabel.setBounds(597, 20, 142, 13);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		
		JPanel pMenu = new JPanel();
		pMenu.setBounds(0, 0, 120, 680);
		contentPane.add(pMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "S\u1EA3n Ph\u1EA9m: ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(130, 343, 759, 211);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tên SP:");
		lblNewLabel_2.setBounds(21, 65, 71, 13);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Mã SP:");
		lblNewLabel_1.setBounds(21, 30, 71, 13);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Giá Nhập:");
		lblNewLabel_3.setBounds(21, 100, 71, 13);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Giá Bán:");
		lblNewLabel_4.setBounds(21, 135, 71, 13);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hãng:");
		lblNewLabel_5.setBounds(393, 33, 100, 13);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Loại:");
		lblNewLabel_6.setBounds(393, 68, 100, 13);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nhà Cung Cấp:");
		lblNewLabel_7.setBounds(393, 103, 100, 13);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Số Lượng Tồn:");
		lblNewLabel_8.setBounds(393, 138, 100, 13);
		panel_1.add(lblNewLabel_8);
		
		txtMaSP = new JTextField();
		txtMaSP.setBounds(128, 27, 234, 19);
		panel_1.add(txtMaSP);
		txtMaSP.setColumns(10);
		txtMaSP.setEditable(false);
		
		txtTenSP = new JTextField();
		txtTenSP.setBounds(128, 62, 234, 19);
		panel_1.add(txtTenSP);
		txtTenSP.setColumns(10);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setBounds(128, 97, 234, 19);
		panel_1.add(txtGiaNhap);
		txtGiaNhap.setColumns(10);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setBounds(128, 132, 234, 19);
		panel_1.add(txtGiaBan);
		txtGiaBan.setColumns(10);
		
		cbLoai = new JComboBox<String>();
		cbLoai.setBounds(480, 65, 250, 19);
		cbLoai.addItem("MainBoard");
		cbLoai.addItem("CPU");
		cbLoai.addItem("HardDisk");
		cbLoai.addItem("Ram");
		panel_1.add(cbLoai);
		
		cbNcc = new JComboBox<String>();
		cbNcc.setBounds(480, 100, 250, 19);
		panel_1.add(cbNcc);
		
		txtSLTon = new JTextField();
		txtSLTon.setBounds(480, 135, 250, 19);
		panel_1.add(txtSLTon);
		txtSLTon.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Thời Gian BH:");
		lblNewLabel_9.setBounds(21, 170, 100, 13);
		panel_1.add(lblNewLabel_9);
		
		txtBH = new JTextField();
		txtBH.setBounds(128, 167, 234, 19);
		panel_1.add(txtBH);
		txtBH.setColumns(10);
		
		txtHang = new JTextField();
		txtHang.setBounds(480, 27, 250, 19);
		panel_1.add(txtHang);
		txtHang.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Loại Sản Phẩm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(899, 343, 277, 212);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(10, 47, 99, 13);
		panel_2.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(10, 101, 99, 13);
		panel_2.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setBounds(10, 155, 99, 13);
		panel_2.add(lblNewLabel_12);
		txtInput1 = new JTextField();
		txtInput1.setBounds(119, 44, 128, 19);
		panel_2.add(txtInput1);
		txtInput1.setColumns(10);
		
		txtInput2 = new JTextField();
		txtInput2.setBounds(119, 98, 128, 19);
		panel_2.add(txtInput2);
		txtInput2.setColumns(10);
		
		txtInput3 = new JTextField();
		txtInput3.setBounds(119, 152, 128, 19);
		panel_2.add(txtInput3);
		txtInput3.setColumns(10);
		txtInput1.setVisible(false);
		txtInput2.setVisible(false);
		txtInput3.setVisible(false);
		
		
		
		
	
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ch\u1ECDn t\u00E1c v\u1EE5:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(130, 564, 1046, 67);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		ArrayList<NhaCungCap> lisNcc = ncc_DAO.getListNhaCC();
		for (NhaCungCap n : lisNcc) {
			cbNcc.addItem(n.getNhaCCID());
		}
		
		

		btnThem = new JButton("Thêm");
	
	
		btnThem.setBounds(353, 29, 96, 21);
		panel_3.add(btnThem);
		
		btnXoa = new JButton("Xóa");
	
		btnXoa.setBounds(710, 29, 94, 21);
		panel_3.add(btnXoa);
		
		btnXoaTrang = new JButton("Xóa Trắng");
		
	
		btnXoaTrang.setBounds(459, 29, 108, 21);
		panel_3.add(btnXoaTrang);
		
		btnSua = new JButton("Sửa");
		
		
		btnSua.setBounds(814, 29, 93, 21);
		panel_3.add(btnSua);
		
		btnLoc = new JButton("Lọc Theo Loại");
		
		
		btnLoc.setBounds(577, 29, 123, 21);
		panel_3.add(btnLoc);
		
		btnReset = new JButton("Reset");
		
		
		btnReset.setBounds(917, 29, 108, 21);
		panel_3.add(btnReset);
		
		JLabel lblNewLabel_13 = new JLabel("Nhập mã SP cần tìm:");
		lblNewLabel_13.setBounds(10, 33, 135, 13);
		panel_3.add(lblNewLabel_13);
		
		txtTim = new JTextField();
		txtTim.setBounds(155, 30, 96, 19);
		panel_3.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("Tìm");
	
		
		btnTim.setBounds(261, 29, 79, 21);
		panel_3.add(btnTim);
		
		
		cbLoai.addActionListener(this);
		table.addMouseListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLoc.addActionListener(this);
		btnSua.addActionListener(this);
	}
	private void DocDuLieuDatabaseVaoTable() {
		// TODO Auto-generated method stub
		ArrayList<SanPham> listSP  =  sp_DAO.getAllTbSP();
		for (SanPham s : listSP) {
			double a = s.getGiaNhap();
			double b = s.getGiaBan();
			DecimalFormat formatter = new DecimalFormat("###.#");
			String formatted = formatter.format(a);
			String formatted2 = formatter.format(b);
			model.addRow(new Object[] {
					s.getSpID(),
					s.getTenSP(),
					s.getHang(),
					s.getLoai(),
					formatted,
					formatted2,
					s.getSlTon(),
					s.getNcc().getNhaCCID(),
					s.getThoiGianBaoHanh(),
					
			});
		}
	}



	private SanPham laySPTuJtextField() {
		if(validData()) {
			String maSP = txtMaSP.getText();
			String tenSP = txtTenSP.getText();
			String hang = txtHang.getText();
			String loai = cbLoai.getSelectedItem().toString();
			String maNcc = cbNcc.getSelectedItem().toString();
			NhaCungCap ncc = new NhaCungCap(maNcc);
			int slt = Integer.parseInt(txtSLTon.getText());
			int tgBH = Integer.parseInt(txtBH.getText());
			Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
			Double giaBan = Double.parseDouble(txtGiaBan.getText());
			if(loai.equals("MainBoard")) {
				String chipSet = txtInput1.getText();
				String kheLuuTru = txtInput2.getText();
				String kheMoRong = txtInput3.getText();
				SanPham sp = new MainBoard(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc, tgBH, chipSet, kheLuuTru, kheMoRong);
				return sp;
			}
			else if(loai.equals("CPU")) {
				int nhan = Integer.parseInt(txtInput1.getText());
				int luong = Integer.parseInt(txtInput2.getText());
				int cache = Integer.parseInt(txtInput3.getText());
				SanPham sp = new CPU(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc,tgBH, nhan, luong, cache);
				return sp;
			}
			else if(loai.equals("HardDisk")) {
				int dungLuong = Integer.parseInt(txtInput1.getText());
				String cacheDDR = txtInput2.getText();
				Float tuoiThoTB = Float.parseFloat(txtInput3.getText());
				SanPham sp = new HardDisk(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc,tgBH, dungLuong, cacheDDR, tuoiThoTB);
				return sp;
			}
			else if(loai.equals("Ram")) {
				String loaiRam = txtInput1.getText();
				int dungLuongRam = Integer.parseInt(txtInput2.getText());
				int tocDoRam = Integer.parseInt(txtInput3.getText());
				SanPham sp = new Ram(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc, tgBH, loaiRam, dungLuongRam, tocDoRam);
				return sp;
			}
			
		}
		return null;
	}
	private String sinhMaSP() {
		
		if(cbLoai.getSelectedItem().toString().equals("MainBoard")){
			int stt = sp_DAO.getSPTheoLoai("MainBoard").size() + 1;
			String ma="MB" + String.format("%03d",  stt);
			return ma;
		}
		else if(cbLoai.getSelectedItem().toString().equals("CPU")){
			int stt = sp_DAO.getSPTheoLoai("HardDisk").size() + 1;
			String ma="CPU" + String.format("%03d",  stt);
			return ma;
		}
		else if(cbLoai.getSelectedItem().toString().equals("HardDisk")){
			int stt = sp_DAO.getSPTheoLoai("HardDisk").size() + 1;
			String ma="HD" + String.format("%03d",  stt);
			return ma;
		}
		else if(cbLoai.getSelectedItem().toString().equals("Ram")){
			int stt = sp_DAO.getSPTheoLoai("Ram").size() + 1;
			String ma="R" + String.format("%03d",  stt);
			return ma;
		}
		return null;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnSua)) {
			suaSP();
		}
		if(o.equals(btnLoc)) {
			locTheoLoai();
		}
		if(o.equals(cbLoai)) {
				hienThiGiaoDienLoaiSP();  
		}
		if(o.equals(btnXoa)) {
			xoaSP();
		}
		if(o.equals(btnThem))
		{	
			themSP();
		}
		if(o.equals(btnXoaTrang)) {
			clearTextField();
		}
		if(o.equals(btnReset)) {
			DocDuLieuDatabaseVaoTable();
		}
		if(o.equals(btnTim)) {
			timSPTheoMa();
		}
	}
		
		
	private void xoaSP() {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		if(r!= -1) {
			int result = JOptionPane.showConfirmDialog (null, "Bạn có chắc là muốn xóa?","CẢNH BÁO!", JOptionPane.YES_NO_OPTION);
	        if(result == JOptionPane.YES_OPTION) {
	        	String ma = table.getValueAt(r, 0).toString();
	        	model.removeRow(r); 
	        	sp_DAO.delete(ma);
	        	clearTextField();
	        }
	        else {
	        	return;
	        }
		}
		else {
			JOptionPane.showMessageDialog(this, "Chọn 1 hàng để xóa!");
		}
	}

	private void hienThiGiaoDienLoaiSP() {
		// TODO Auto-generated method stub
		String selected = (String) cbLoai.getSelectedItem();
		if(selected.equals("Ram"))
		{
		
			panel_2.setBorder(new TitledBorder(null, "Ram", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			lblNewLabel_10.setText("Loại Ram:");
			lblNewLabel_11.setText("Dung Lượng:");
			lblNewLabel_12.setText("Tốc Độ:");
			txtInput1.setVisible(true);
			txtInput2.setVisible(true);
			txtInput3.setVisible(true);
		}
		else if(selected.equals("HardDisk"))
		{
		
			panel_2.setBorder(new TitledBorder(null, "HardDisk", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			lblNewLabel_10.setText("Dung Lượng:");
			lblNewLabel_11.setText("CacheDDR:");
			lblNewLabel_12.setText("Tuổi thọ:");
			txtInput1.setVisible(true);
			txtInput2.setVisible(true);
			txtInput3.setVisible(true);
		
		}
		else if(selected.equals("CPU"))
		{
	
			panel_2.setBorder(new TitledBorder(null, "CPU", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			lblNewLabel_10.setText("Nhân:");
			lblNewLabel_11.setText("Luồng:");
			lblNewLabel_12.setText("Cache:");
			txtInput1.setVisible(true);
			txtInput2.setVisible(true);
			txtInput3.setVisible(true);
		
		}
		else if(selected.equals("MainBoard"))
		{
			panel_2.setBorder(new TitledBorder(null, "MainBoard", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
			lblNewLabel_10.setText("Chip Set:");
			lblNewLabel_11.setText("Khe Lưu Trữ:");
			lblNewLabel_12.setText("Khe Mở Rộng:");
			txtInput1.setVisible(true);
			txtInput2.setVisible(true);
			txtInput3.setVisible(true);
		
		}
	}

	private void locTheoLoai() {
		// TODO Auto-generated method stub
		String loaiSP = cbLoai.getSelectedItem().toString();
		ArrayList<SanPham> listSP = sp_DAO.getSPTheoLoai(loaiSP);
		model.setRowCount(0);
		for (SanPham s : listSP) {
			double a = s.getGiaNhap();
			double b = s.getGiaBan();
			DecimalFormat formatter = new DecimalFormat("###.#");
			String formatted = formatter.format(a);
			String formatted2 = formatter.format(b);
			model.addRow(new Object[] {
				s.getSpID(),
				s.getTenSP(),
				s.getHang(),
				s.getLoai(),
				formatted,
				formatted2,
				s.getSlTon(),
				s.getNcc().getNhaCCID(),
				s.getThoiGianBaoHanh(),
			});
		}
	}

	private void suaSP() {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		if(r!= -1) {
			SanPham s = sp_DAO.getSPTheoMa(model.getValueAt(r, 0).toString());
			SanPham s1 = laySPTuJtextField();
			if(s1!=null && s1.getLoai().equals(s.getLoai()))
			{	
				sp_DAO.update(s1);
				JOptionPane.showMessageDialog(this, "Sửa thành công!");
				model.setRowCount(0);
				DocDuLieuDatabaseVaoTable();
			}
			else {
				JOptionPane.showMessageDialog(this, "Không sửa được! Loại không được sửa!");
			}

		}
		else {
			JOptionPane.showMessageDialog(this, "Chọn 1 hàng để sửa!");
		}
	}

	private void themSP() {
		// TODO Auto-generated method stub
		if(validData()) {
			String tenSP = txtTenSP.getText();
			String hang = txtHang.getText();
			String loai = cbLoai.getSelectedItem().toString();
			String maNcc = cbNcc.getSelectedItem().toString();
			NhaCungCap ncc = new NhaCungCap(maNcc);
			int slt = Integer.parseInt(txtSLTon.getText());
			int tgBH = Integer.parseInt(txtBH.getText());
			Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
			Double giaBan = Double.parseDouble(txtGiaBan.getText());
			if(loai.equals("MainBoard")) {
				
				String maSP = sinhMaSP();
				String chipSet = txtInput1.getText();
				String kheLuuTru = txtInput2.getText();
				String kheMoRong = txtInput3.getText();
				SanPham s = new MainBoard(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc, tgBH, chipSet, kheLuuTru, kheMoRong);
				if(s!=null) {
					try {
						if(sp_DAO.create(s))
							JOptionPane.showMessageDialog(this,"Thêm thành công!");
							double a = s.getGiaNhap();
							double b = s.getGiaBan();
							DecimalFormat formatter = new DecimalFormat("###.#");
							String formatted = formatter.format(a);
							String formatted2 = formatter.format(b);
							model.addRow(new Object[] {
								s.getSpID(),
								s.getTenSP(),
								s.getHang(),
								s.getLoai(),
								formatted,
								formatted2,
								s.getSlTon(),
								s.getNcc().getNhaCCID(),
								s.getThoiGianBaoHanh(),
								
						});
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
			else if(loai.equals("CPU")) {
				String maSP = sinhMaSP();
				int nhan = Integer.parseInt(txtInput1.getText());
				int luong = Integer.parseInt(txtInput2.getText());
				int cache = Integer.parseInt(txtInput3.getText());
				SanPham s = new CPU(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc,tgBH, nhan, luong, cache);
				if(s!=null) {
					try {
						if(sp_DAO.create(s))
							JOptionPane.showMessageDialog(this,"Thêm thành công!");
							double a = s.getGiaNhap();
							double b = s.getGiaBan();
							DecimalFormat formatter = new DecimalFormat("###.#");
							String formatted = formatter.format(a);
							String formatted2 = formatter.format(b);
							model.addRow(new Object[] {
								s.getSpID(),
								s.getTenSP(),
								s.getHang(),
								s.getLoai(),
								formatted,
								formatted2,
								s.getSlTon(),
								s.getNcc().getNhaCCID(),
								s.getThoiGianBaoHanh(),
								
						});
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
			else if(loai.equals("HardDisk")) {
				String maSP = sinhMaSP();
				int dungLuong = Integer.parseInt(txtInput1.getText());
				String cacheDDR = txtInput2.getText();
				Float tuoiThoTB = Float.parseFloat(txtInput3.getText());
				SanPham s = new HardDisk(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc,tgBH, dungLuong, cacheDDR, tuoiThoTB);
				if(s!=null) {
					try {
						if(sp_DAO.create(s))
							JOptionPane.showMessageDialog(this,"Thêm thành công!");
							double a = s.getGiaNhap();
							double b = s.getGiaBan();
							DecimalFormat formatter = new DecimalFormat("###.#");
							String formatted = formatter.format(a);
							String formatted2 = formatter.format(b);
							model.addRow(new Object[] {
								s.getSpID(),
								s.getTenSP(),
								s.getHang(),
								s.getLoai(),
								formatted,
								formatted2,
								s.getSlTon(),
								s.getNcc().getNhaCCID(),
								s.getThoiGianBaoHanh(),
								
						});
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
			else if(loai.equals("Ram")) {
				String maSP = sinhMaSP();
				String loaiRam = txtInput1.getText();
				int dungLuongRam = Integer.parseInt(txtInput2.getText());
				int tocDoRam = Integer.parseInt(txtInput3.getText());
				SanPham s = new Ram(maSP, tenSP, hang, loai, giaNhap, giaBan, slt, ncc, tgBH, loaiRam, dungLuongRam, tocDoRam);
				if(s!=null) {
					try {
						if(sp_DAO.create(s))
							JOptionPane.showMessageDialog(this,"Thêm thành công!");
							double a = s.getGiaNhap();
							double b = s.getGiaBan();
							DecimalFormat formatter = new DecimalFormat("###.#");
							String formatted = formatter.format(a);
							String formatted2 = formatter.format(b);
							model.addRow(new Object[] {
								s.getSpID(),
								s.getTenSP(),
								s.getHang(),
								s.getLoai(),
								formatted,
								formatted2,
								s.getSlTon(),
								s.getNcc().getNhaCCID(),
								s.getThoiGianBaoHanh(),
								
						});
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
			}
		}
	}

	private boolean validData() {
	
		return true;
	}
	private void timSPTheoMa() {
		String maTim = txtTim.getText();
		SanPham s = sp_DAO.getSPTheoMa(maTim);
		if(s!=null) {
			double a = s.getGiaNhap();
			double b = s.getGiaBan();
			DecimalFormat formatter = new DecimalFormat("###.#");
			String formatted = formatter.format(a);
			String formatted2 = formatter.format(b);
			model.setRowCount(0);
			model.addRow(new Object[] {
					s.getSpID(),
					s.getTenSP(),
					s.getHang(),
					s.getLoai(),
					formatted,
					formatted2,
					s.getSlTon(),
					s.getNcc().getNhaCCID(),
					s.getThoiGianBaoHanh(),
					
			});
		}
		else {
			JOptionPane.showMessageDialog(this,"Không tìm thấy!");
		}
	}
	private void clearTextField() {
		txtMaSP.setText("");
		txtTenSP.setText("");
		txtGiaBan.setText("");
		txtGiaNhap.setText("");
		txtInput1.setText("");
		txtInput2.setText("");
		txtInput3.setText("");
		txtSLTon.setText("");
		txtBH.setText("");
		txtHang.setText("");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int r = table.getSelectedRow();
		txtMaSP.setText(model.getValueAt(r, 0).toString());
		txtTenSP.setText(model.getValueAt(r, 1).toString());
		txtHang.setText(model.getValueAt(r, 2).toString());
		cbLoai.setSelectedItem(model.getValueAt(r, 3).toString());
		txtGiaNhap.setText(model.getValueAt(r, 4).toString());
		txtGiaBan.setText(model.getValueAt(r, 5).toString());
		txtSLTon.setText(model.getValueAt(r, 6).toString());
		cbNcc.setSelectedItem(model.getValueAt(r, 7).toString());
		txtBH.setText(model.getValueAt(r, 8).toString());
		if(model.getValueAt(r, 3).toString().equals("MainBoard"))
		{
			MainBoard p = (MainBoard) sp_DAO.getSPTheoMa(model.getValueAt(r, 0).toString());
			txtInput1.setText(p.getChipSet());
			txtInput2.setText(p.getKheLuuTru());
			txtInput3.setText(p.getKheMoRong());
		}
		else if(model.getValueAt(r, 3).toString().equals("CPU"))
		{
			CPU  p = (CPU) sp_DAO.getSPTheoMa(model.getValueAt(r, 0).toString());
			txtInput1.setText(p.getNhan() + "");
			txtInput2.setText(p.getLuong()+ "");
			txtInput3.setText(p.getCache()+ "");
		}
		else if(model.getValueAt(r, 3).toString().equals("HardDisk"))
		{
			HardDisk p = (HardDisk) sp_DAO.getSPTheoMa(model.getValueAt(r, 0).toString());
			txtInput1.setText(p.getDungLuong()+"");
			txtInput2.setText(p.getCacheDDR());
			txtInput3.setText(p.getTuoiThoTB()+"");
		}
		else if(model.getValueAt(r, 3).toString().equals("Ram"))
		{
			Ram p = (Ram) sp_DAO.getSPTheoMa(model.getValueAt(r, 0).toString());
			txtInput1.setText(p.getLoaiRam());
			txtInput2.setText(p.getDungLuongRam()+"");
			txtInput3.setText(p.getTocDo()+"");
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
}
