package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bus.NhaCungCap_Bus;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import entities.NhaCungCap;

import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class NhaCungCap_GUI extends JFrame implements MouseListener, ActionListener{

	private JPanel contentPane;
	private JTable tableNCC;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTextField txtTimNCC;
	
	private NhaCungCap_Bus nccBus;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnTim;
	private JButton btnXoaTrangTim;
	private JTextField txtMess;
	private JTextField txtMessTim;
	private JPanel pCenter;

	/**
	 * Launch the application.
	 */
	public static void openUI_NhaCungCap() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap_GUI frame = new NhaCungCap_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JPanel getNCCPanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public NhaCungCap_GUI() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nhà cung cấp");
		setBounds(100, 100, 1200, 680);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
		pCenter.setBounds(130, 10, 1046, 623);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pNhaCungCap = new JPanel();
		pNhaCungCap.setBounds(10, 6, 637, 607);
		pCenter.add(pNhaCungCap);
		pNhaCungCap.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitleNCC = new JLabel("NHÀ CUNG CẤP");
		lblTitleNCC.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleNCC.setFont(new Font("Arial", Font.BOLD, 23));
		pNhaCungCap.add(lblTitleNCC, BorderLayout.NORTH);
		lblTitleNCC.setPreferredSize(new Dimension(0, 30));
		
		JScrollPane scrollPane = new JScrollPane();
		pNhaCungCap.add(scrollPane, BorderLayout.CENTER);
		
		tableNCC = new JTable();
		tableNCC.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 nh\u00E0 cung c\u1EA5p", "T\u00EAn nh\u00E0 cung c\u1EA5p", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Email"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableNCC.setFont(new Font("Arial", Font.BOLD, 10));
		scrollPane.setViewportView(tableNCC);
		
		JPanel pTacVu = new JPanel();
		pTacVu.setBorder(new TitledBorder(null, "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTacVu.setBounds(657, 10, 379, 379);
		pCenter.add(pTacVu);
		pTacVu.setLayout(null);
		
		JPanel pThongTin = new JPanel();
		pThongTin.setBounds(10, 35, 359, 192);
		pTacVu.add(pThongTin);
		pThongTin.setLayout(null);
		
		JLabel lblMaNCC = new JLabel("Mã nhà cung cấp: ");
		lblMaNCC.setBounds(0, 1, 107, 30);
		pThongTin.add(lblMaNCC);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setEditable(false);
		txtMaNCC.setBounds(106, 1, 252, 30);
		txtMaNCC.setText("");
		pThongTin.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		JLabel lblTenNCC = new JLabel("Tên nhà cung cấp:");
		lblTenNCC.setBounds(0, 41, 107, 30);
		pThongTin.add(lblTenNCC);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(106, 41, 252, 30);
		pThongTin.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setBounds(0, 81, 107, 30);
		pThongTin.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(106, 81, 252, 30);
		pThongTin.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
		lblSoDienThoai.setBounds(0, 121, 107, 30);
		pThongTin.add(lblSoDienThoai);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(106, 121, 252, 30);
		txtSoDienThoai.setText("");
		pThongTin.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(0, 161, 107, 30);
		pThongTin.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(106, 161, 252, 30);
		pThongTin.add(txtEmail);
		txtEmail.setColumns(10);
		
		btnThem = new JButton("Thêm");
		btnThem.setBounds(34, 283, 120, 28);
		pTacVu.add(btnThem);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(218, 283, 120, 28);
		pTacVu.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBounds(34, 329, 120, 28);
		pTacVu.add(btnSua);
		
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(218, 329, 120, 28);
		pTacVu.add(btnXoaTrang);
		
		txtMess = new JTextField();
		txtMess.setForeground(new Color(255, 0, 0));
		txtMess.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		txtMess.setEditable(false);
		txtMess.setBounds(10, 237, 359, 39);
		pTacVu.add(txtMess);
		txtMess.setColumns(10);
		txtMess.setBorder(null);
		
		JPanel pTimKiem = new JPanel();
		pTimKiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTimKiem.setBounds(657, 411, 379, 202);
		pCenter.add(pTimKiem);
		pTimKiem.setLayout(null);
		
		JLabel lblTim = new JLabel("Nhập tên nhà cung cấp cần tìm:");
		lblTim.setBounds(10, 35, 224, 35);
		pTimKiem.add(lblTim);
		
		txtTimNCC = new JTextField();
		txtTimNCC.setBounds(20, 67, 334, 35);
		pTimKiem.add(txtTimNCC);
		txtTimNCC.setColumns(10);
		
		btnTim = new JButton("Tìm");
		btnTim.setBounds(55, 152, 105, 28);
		pTimKiem.add(btnTim);
		
		btnXoaTrangTim = new JButton("Xóa trắng");
		btnXoaTrangTim.setBounds(219, 152, 105, 28);
		pTimKiem.add(btnXoaTrangTim);
		
		txtMessTim = new JTextField();
		txtMessTim.setForeground(Color.RED);
		txtMessTim.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		txtMessTim.setEditable(false);
		txtMessTim.setColumns(10);
		txtMessTim.setBorder(null);
		txtMessTim.setBounds(30, 112, 324, 35);
		pTimKiem.add(txtMessTim);
		
		//Đăng ký sự kiện
		tableNCC.addMouseListener(this);
		btnXoaTrang.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrangTim.addActionListener(this);
		btnTim.addActionListener(this);
	}
	
	public void loadDataNCC() {
		nccBus = new NhaCungCap_Bus();
		capNhatBangNhaCC();
	}
	
	/*
	 * Cập nhật dữ liệu lên bảng
	 */
	private void capNhatBangNhaCC() {
		DefaultTableModel dm = (DefaultTableModel) tableNCC.getModel();
		for(NhaCungCap ncc : nccBus.getListNhaCC()) {
			dm.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getSoDienThoai(), ncc.getEmail()});
		}
		tableNCC.setModel(dm);
	}
	
	/*
	 * Đưa dữ liệu từ table lên text box
	 */
	private void duaDuLieuLenTextBox(int row) {
		txtMaNCC.setText(tableNCC.getValueAt(row, 0).toString());
		txtTenNCC.setText(tableNCC.getValueAt(row, 1).toString());
		txtDiaChi.setText(tableNCC.getValueAt(row,2).toString());
		txtSoDienThoai.setText(tableNCC.getValueAt(row, 3).toString());
		txtEmail.setText(tableNCC.getValueAt(row, 4).toString());
	}
	
	/*
	 * 
	 */
	private void xoaHetDuLieuTable() {
		DefaultTableModel dm = (DefaultTableModel) tableNCC.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	/*
	 * Xóa trắng text field
	 */
	private void xoaTrang() {
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		txtEmail.setText("");
		tableNCC.clearSelection();
	}
	
	/*
	 * Tìm nhà cung cấp theo mã
	 */
	private void timNhaCungCapTheoMa() {
		if(txtTimNCC.getText().trim().length() == 0) {
			xoaHetDuLieuTable();
			capNhatBangNhaCC();
			return;
		}
		NhaCungCap ncc = nccBus.getNhaCCTheoMa(txtTimNCC.getText());
		if(ncc == null) {
			txtMessTim.setText("Không tìm thấy nhân viên có mã: " + txtTimNCC.getText());
			return;
		}
		xoaHetDuLieuTable();
		xoaTrang();
		DefaultTableModel dm = (DefaultTableModel) tableNCC.getModel();
		dm.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getSoDienThoai(), ncc.getEmail()});
		tableNCC.setModel(dm);
	}

	/*
	 * Thêm nhà cung cấp
	 */
	private void themNhaCungCap() {
		NhaCungCap ncc = new NhaCungCap();
		ncc.setTenNCC(txtTenNCC.getText());
		ncc.setSoDienThoai(txtSoDienThoai.getText());
		ncc.setDiaChi(txtDiaChi.getText());
		ncc.setEmail(txtEmail.getText());
		if(nccBus.themNhaCC(ncc)) {
			txtMess.setText("Thêm thành công nhà cung cấp.");
			DefaultTableModel dm = (DefaultTableModel) tableNCC.getModel();
			dm.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getSoDienThoai(), ncc.getEmail()});
		}
		else {
			txtMess.setText("Thêm không thành công nhà cung cấp.");
		}
	}
	
	private void xoaNhaCungCap() {
		txtMess.setText("");
		if(JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa nhà cung cấp này không?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			String maNCC = tableNCC.getValueAt(tableNCC.getSelectedRow(), 0).toString();
			if(nccBus.xoaNhaCC(maNCC)) {
				txtMess.setText("Xóa thành công nhà cung cấp.");
				DefaultTableModel dm = (DefaultTableModel) tableNCC.getModel();
				dm.removeRow(tableNCC.getSelectedRow());
				xoaTrang();
			}
			else {
				txtMess.setText("Xóa không thành công.");
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(tableNCC.getSelectedRow() != -1) {
			duaDuLieuLenTextBox(tableNCC.getSelectedRow());
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
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btnTim)) {
			timNhaCungCapTheoMa();
		}
		if(o.equals(btnXoaTrangTim)) {
			txtTimNCC.setText("");
		}
		if(o.equals(btnThem)) {
			themNhaCungCap();
		}
		if(o.equals(btnXoa)) {
			xoaNhaCungCap();
		}
	}
}
