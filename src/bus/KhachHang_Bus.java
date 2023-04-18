package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.KhachHang_DAO;
import entities.KhachHang;

public class KhachHang_Bus {
	KhachHang_DAO kh_Dao = new KhachHang_DAO();
	
	public ArrayList<KhachHang> getAllTableKhachHang(){
		return kh_Dao.getAllTableKhachHang();
	}
	
	public ArrayList<KhachHang> getKhachHangTheoTen(String ten) throws SQLException{
		return kh_Dao.getKhachHangTheoTen(ten);
	}
	
	public ArrayList<KhachHang> getKhachHangTheoLoai(String loai) throws SQLException{
		return kh_Dao.getKhachHangTheoLoai(loai);
	}
	
	public boolean them(KhachHang k) throws SQLException{
		return kh_Dao.them(k);
	}
	
	public boolean xoa(KhachHang k) throws SQLException{
		return kh_Dao.xoa(k);
	}
	public boolean sua(KhachHang k) throws SQLException{
		return kh_Dao.sua(k);
	}
}
