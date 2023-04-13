package ui;

import java.sql.SQLException;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;

public class Test_GUI {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Kết nối với database 
		ConnectDB.getInstance().connect();
		
		
		//Mở GUI Nhà cung cấp
		NhaCungCap_GUI.openUI_NhaCungCap();
	}
}
