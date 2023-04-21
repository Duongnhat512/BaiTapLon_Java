package bus;

import java.util.ArrayList;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entities.HoaDon;
import interfaces.IHoaDon;

public class HoaDon_Bus implements IHoaDon{
	private HoaDon_DAO hd_Dao = new HoaDon_DAO();
	private ChiTietHoaDon_DAO cthd_Dao = new ChiTietHoaDon_DAO();
	
	@Override
	public ArrayList<HoaDon> getListHoaDon() {
		// TODO Auto-generated method stub
		return hd_Dao.getListHoaDon();
	}

	@Override
	public HoaDon getHoaDonTheoMa(String maHD) {
		// TODO Auto-generated method stub
		return hd_Dao.getHoaDonTheoMa(maHD);
	}

	@Override
	public boolean themHoaDon(HoaDon hd) {
		int n = getListHoaDon().size();
		String maHD = "HD" + String.format("%03d", n);
		while(getListHoaDon().contains(new HoaDon(maHD))) {
			n++;
			maHD = "HD" + String.format("%03d", n);
		}
		hd.setIdHD(maHD);
		return hd_Dao.themHoaDon(hd);
	}

	@Override
	public boolean suaHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		return hd_Dao.suaHoaDon(hd);
	}

	@Override
	public boolean xoaHoaDon(String maHD) {
		cthd_Dao.xoaCTHDTheoMaHD(maHD);
		return hd_Dao.xoaHoaDon(maHD);
	}

	@Override
	public boolean capNhatTongTien() {
		// TODO Auto-generated method stub
		return hd_Dao.capNhatTongTien();
	}

	@Override
	public boolean capNhatTongTienHDThemMaHD(String id) {
		// TODO Auto-generated method stub
		return hd_Dao.capNhatTongTienHDThemMaHD(id);
	}

}
