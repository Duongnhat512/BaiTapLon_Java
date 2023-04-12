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
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class NhaCungCap extends JFrame {

	private JPanel contentPane;
	private JTable tableNCC;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtEmail;
	private JTextField txtTimNCC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhaCungCap frame = new NhaCungCap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NhaCungCap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Nhà cung cấp");
		setBounds(100, 100, 1200, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pWest = new JPanel();
		pWest.setBounds(10, 10, 110, 670);
		contentPane.add(pWest);
		
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
		pCenter.setBounds(130, 10, 1046, 670);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pNhaCungCap = new JPanel();
		pNhaCungCap.setBounds(10, 6, 637, 654);
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
		pTacVu.setBounds(657, 10, 379, 402);
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
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(34, 255, 120, 36);
		pTacVu.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(218, 255, 120, 36);
		pTacVu.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(34, 332, 120, 36);
		pTacVu.add(btnSua);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setBounds(218, 332, 120, 36);
		pTacVu.add(btnXoaTrang);
		
		JPanel pTimKiem = new JPanel();
		pTimKiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pTimKiem.setBounds(657, 441, 379, 219);
		pCenter.add(pTimKiem);
		pTimKiem.setLayout(null);
		
		JLabel lblTim = new JLabel("Nhập tên nhà cung cấp cần tìm:");
		lblTim.setBounds(10, 35, 224, 35);
		pTimKiem.add(lblTim);
		
		txtTimNCC = new JTextField();
		txtTimNCC.setBounds(20, 88, 334, 35);
		pTimKiem.add(txtTimNCC);
		txtTimNCC.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.setBounds(54, 152, 112, 44);
		pTimKiem.add(btnTim);
		
		JButton btnXoaTrangTim = new JButton("Xóa trắng");
		btnXoaTrangTim.setBounds(221, 152, 112, 44);
		pTimKiem.add(btnXoaTrangTim);
	}
}
