package bus;

import java.util.ArrayList;

import dao.ChiTietHoaDon_DAO;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import interfaces.IChiTietHoaDon;

public class ChiTietHoaDon_Bus implements IChiTietHoaDon{
	private ChiTietHoaDon_DAO ctHD_Dao = new ChiTietHoaDon_DAO();
	@Override
	public ArrayList<ChiTietHoaDon> getListChiTietHD() {
		// TODO Auto-generated method stub
		return ctHD_Dao.getListChiTietHD();
	}

	@Override
	public ArrayList<ChiTietHoaDon> getChiTietHDTheoMaHD(String maHD) {
		// TODO Auto-generated method stub
		return ctHD_Dao.getChiTietHDTheoMaHD(maHD);
	}

	@Override
	public boolean themChiTietHD(ChiTietHoaDon ctHD) {
		int n = ctHD_Dao.getListChiTietHD().size();
		String id = "CTHD" + String.format("%03d", n);
		while(getListChiTietHD().contains(new ChiTietHoaDon(id))) {
			n++;
			id = "CTHD" + String.format("%03d", n);
		}
		ctHD.setChiTietHoaDonID(id);
		return ctHD_Dao.themChiTietHD(ctHD);
	}

	@Override
	public boolean xoaChiTietHD(String maChiTietHD) {
		// TODO Auto-generated method stub
		return ctHD_Dao.xoaChiTietHD(maChiTietHD);
	}

	@Override
	public boolean suaChiTietHD(ChiTietHoaDon ctHD) {
		// TODO Auto-generated method stub
		return ctHD_Dao.suaChiTietHD(ctHD);
	}

	@Override
	public boolean xoaCTHDTheoMaHD(String id) {
		// TODO Auto-generated method stub
		return ctHD_Dao.xoaCTHDTheoMaHD(id);
	}

	@Override
	public double layTongTienTheoMaSP(String idSP) {
		// TODO Auto-generated method stub
		return ctHD_Dao.layTongTienTheoMaSP(idSP);
	}

	@Override
	public int laySoLuongSPDaBan(String idSP) {
		// TODO Auto-generated method stub
		return ctHD_Dao.laySoLuongSPDaBan(idSP);
	}

	@Override
	public int laySoLuongTheoNamThang(String spID, int thang, int nam) {
		// TODO Auto-generated method stub
		return ctHD_Dao.laySoLuongTheoNamThang(spID, thang, nam);
	}
	@Override
	public double layTongTienSPTheoNamThang(String spID, int thang, int nam) {
		// TODO Auto-generated method stub
		return ctHD_Dao.layTongTienSPTheoNamThang(spID, thang, nam);
	}

}
