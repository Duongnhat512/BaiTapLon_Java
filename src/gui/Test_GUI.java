package gui;

import java.sql.SQLException;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;

public class Test_GUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Kết nối với database 
		ConnectDB.getInstance().connect();
		
		
		//Mở GUI Nhà cung cấp
//		NhaCungCap_GUI.openUI_NhaCungCap();
		
//		HoaDon_GUI.openUI_HoaDon();
		
		//Biểu thức chính quy kiểm tra tên Tiếng Việt có dấu và phải viết hoa đầu mỗi từ
//		String ten = "Nguyễn Nhất Dương";
//		System.out.println(ten.matches("[\\p{Lu}][\\p{L}]+([\\s]+[\\p{Lu}][\\p{L}]+)+"));
		
//		double a = 1000000;
//		System.out.println(String.format("%,.0f", a));
		
//		Main_GUI.open_MainUI();
		
		KhachHang_GUI.open_KhachHangUI();
	}
}
