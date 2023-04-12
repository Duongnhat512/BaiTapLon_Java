package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private final JPanel pWest = new JPanel();
	private JTable tableHoaDon;
	private JTable tableChiTietHD;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HoaDon frame = new HoaDon();
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
	public HoaDon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 718);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		pWest.setBounds(0, 0, 120, 671);
		contentPane.add(pWest);
		pWest.setLayout(null);
		
		JPanel pCenter = new JPanel();
		pCenter.setBounds(130, 0, 956, 671);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JPanel pHoaDon = new JPanel();
		pHoaDon.setBounds(0, 10, 946, 316);
		pCenter.add(pHoaDon);
		pHoaDon.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHoaDon = new JLabel("BẢNG HÓA ĐƠN");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Arial", Font.BOLD, 23));
		pHoaDon.add(lblHoaDon, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		pHoaDon.add(scrollPane, BorderLayout.CENTER);
		
		tableHoaDon = new JTable();
		tableHoaDon.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 h\u00F3a \u0111\u01A1n", "Kh\u00E1ch h\u00E0ng", "Nh\u00E2n vi\u00EAn", "Ng\u00E0y l\u1EADp h\u00F3a \u0111\u01A1n", "Ng\u00E0y giao d\u1EF1 ki\u1EBFn", " Ng\u00E0y chuy\u1EC3n h\u00E0ng", "Ng\u00E0y chuy\u1EC3n h\u00E0ng", " N\u01A1i nh\u1EADn h\u00E0ng", "T\u1ED5ng ti\u1EC1n h\u00F3a \u0111\u01A1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableHoaDon.getColumnModel().getColumn(3).setPreferredWidth(95);
		tableHoaDon.getColumnModel().getColumn(8).setPreferredWidth(95);
		scrollPane.setViewportView(tableHoaDon);
		
		JPanel pChiTietHD = new JPanel();
		pChiTietHD.setBounds(0, 336, 775, 325);
		pCenter.add(pChiTietHD);
		pChiTietHD.setLayout(new BorderLayout(0, 0));
		
		JLabel lblChiTietHD = new JLabel("BẢNG CHI TIẾT HÓA ĐƠN");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Arial", Font.BOLD, 23));
		pChiTietHD.add(lblChiTietHD, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pChiTietHD.add(scrollPane_1, BorderLayout.CENTER);
		
		tableChiTietHD = new JTable();
		tableChiTietHD.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 chi ti\u1EBFt h\u00F3a \u0111\u01A1n", "M\u00E3 h\u00F3a \u0111\u01A1n", "S\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 b\u00E1n", "T\u1ED5ng ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, String.class, String.class, Double.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(tableChiTietHD);
		
		JPanel panel = new JPanel();
		panel.setBounds(785, 336, 161, 325);
		pCenter.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 141, 30);
		panel.add(lblNewLabel);
	}
}
