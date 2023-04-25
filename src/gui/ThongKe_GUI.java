package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ThongKe_GUI extends JFrame {

	private JPanel contentPane;
	private JPanel pCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe_GUI frame = new ThongKe_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JPanel getThongKePanel() {
		return pCenter;
	}

	/**
	 * Create the frame.
	 */
	public ThongKe_GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		pCenter = new JPanel();
		pCenter.setBounds(130, 10, 1043, 623);
		contentPane.add(pCenter);
	}

}
