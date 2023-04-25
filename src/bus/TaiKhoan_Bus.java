package bus;

import java.util.ArrayList;

import dao.TaiKhoan_DAO;
import entities.TaiKhoan;
import interfaces.ITaiKhoan;

public class TaiKhoan_Bus implements ITaiKhoan{
	private TaiKhoan_DAO tk_Dao = new TaiKhoan_DAO();

	@Override
	public ArrayList<TaiKhoan> getListTaiKhoan() {
		// TODO Auto-generated method stub
		return tk_Dao.getListTaiKhoan();
	}

	@Override
	public TaiKhoan getTaiKhoanTheoTenTaiKhoan(String tenTaiKhoan) {
		// TODO Auto-generated method stub
		return tk_Dao.getTaiKhoanTheoTenTaiKhoan(tenTaiKhoan);
	}

	@Override
	public boolean themTaiKhoan(TaiKhoan tk) {
		// TODO Auto-generated method stub
		return tk_Dao.themTaiKhoan(tk);
	}
	
}
