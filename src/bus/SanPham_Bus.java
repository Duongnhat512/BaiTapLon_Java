package bus;

import java.util.ArrayList;

import dao.SanPham_DAO;
import entities.SanPham;

public class SanPham_Bus {
	SanPham_DAO sp_Dao = new SanPham_DAO();
	public ArrayList<SanPham> getAllTbSP(){
		return sp_Dao.getAllTbSP();
	}
	public SanPham getSPTheoMa(String id) {
		return sp_Dao.getSPTheoMa(id);
	}
	public ArrayList<SanPham> getSPTheoLoai(String loai){
		return sp_Dao.getSPTheoLoai(loai);
	}
	public boolean 	create(SanPham s) {
		return sp_Dao.create(s);
	}
	public boolean 	update(SanPham s) {
		return sp_Dao.update(s);
	}
	public boolean 	delete(String maSP) {
		return sp_Dao.delete(maSP);
	}
}
