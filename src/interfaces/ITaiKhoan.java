package interfaces;

import java.util.ArrayList;

import entities.TaiKhoan;

public interface ITaiKhoan {
	public ArrayList<TaiKhoan> getListTaiKhoan();
	public TaiKhoan getTaiKhoanTheoTenTaiKhoan(String tenTaiKhoan);
	
	public boolean themTaiKhoan(TaiKhoan tk);
}
