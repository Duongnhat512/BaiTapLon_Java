package bus;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.NhanVien_DAO;
import entities.NhanVien;

public class NhanVien_Bus {
	private NhanVien_DAO nv_Dao = new NhanVien_DAO();
	
	public ArrayList<NhanVien> getalltbNhanVien() throws ClassNotFoundException{
		return nv_Dao.getalltbNhanVien();
	}
	public NhanVien getNhanVienTheoMaNV(String id){
		return nv_Dao.getNhanVienTheoMaNV(id);
	}
	public ArrayList<NhanVien> getNhanVienTheoTen(String ten) {
		return nv_Dao.getNhanVienTheoTen(ten);
	}
	public NhanVien getNhanVienTheoPhongBan(String phongBan){
		return nv_Dao.getNhanVienTheoMaNV(phongBan);
	}
	public boolean create(NhanVien nv) throws ClassNotFoundException, SQLException{
		nv_Dao.create(nv);
		return true;
	}
	public boolean update(NhanVien nv) throws ClassNotFoundException, SQLException{
		nv_Dao.update(nv);
		return true;
	}
	public boolean  delete (String ma) {
		nv_Dao.delete(ma);
		return true;
	}
}
