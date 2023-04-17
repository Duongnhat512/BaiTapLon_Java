package interfaces;

import java.util.ArrayList;

import entities.ChiTietHoaDon;

public interface IChiTietHoaDon {
	public ArrayList<ChiTietHoaDon> getListChiTietHD();
	public ChiTietHoaDon getChiTietHDTheoMaHD();
	
	public boolean themChiTietHD(ChiTietHoaDon ctHD);
	public boolean xoaChiTietHD(String maChiTietHD);
	public boolean suaChiTietHD(ChiTietHoaDon ctHD);
}
