package entities;

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

public class HoaDon extends JFrame {

	private JPanel contentPane;
	private final JPanel pWest = new JPanel();
	private JTable tableChiTietHD;
	private JTable table;
	private JTable table_1;

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
		setBounds(100, 100, 1380, 730);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		pWest.setBounds(0, 0, 120, 694);
		contentPane.add(pWest);
		pWest.setLayout(null);
		
		JPanel pCenter = new JPanel();
		pCenter.setBounds(130, 0, 1247, 694);
		contentPane.add(pCenter);
		pCenter.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("Bảng hóa đơn");
		lblHoaDon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoaDon.setFont(new Font("Arial", Font.BOLD, 23));
		lblHoaDon.setBounds(10, 24, 868, 28);
		pCenter.add(lblHoaDon);
		
		String[] header = "Mã hóa đơn;Khách hàng;Nhân viên;Ngày lập hóa đơn;Tổng tiền hóa đơn;".split(";");
		DefaultTableModel modelHD = new DefaultTableModel(header, 0);
		
//		String[] header1 = "Mã hóa đơn;Khách hàng;Nhân viên;Ngày lập hóa đơn;Tổng tiền hóa đơn;".split(";");
//		DefaultTableModel modelCTHD = new DefaultTableModel(header1, 0);
//		tableChiTietHD = new JTable();
//		tableChiTietHD.setBounds(10, 387, 868, 271);
//		pCenter.add(tableChiTietHD);
		
		JLabel lblChiTietHD = new JLabel("Bảng chi tiết hóa đơn");
		lblChiTietHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietHD.setFont(new Font("Arial", Font.BOLD, 23));
		lblChiTietHD.setBounds(10, 362, 868, 28);
		pCenter.add(lblChiTietHD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 868, 290);
		pCenter.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n"
			}
		));
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 400, 868, 284);
		pCenter.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
	}
}
