package interfaces;

import java.util.ArrayList;

import entities.ChiTietHoaDon;

public interface IChiTietHoaDon {
	public ArrayList<ChiTietHoaDon> getListChiTietHD();
	public ArrayList<ChiTietHoaDon> getChiTietHDTheoMaHD(String maHD);
	
	public boolean themChiTietHD(ChiTietHoaDon ctHD);
	public boolean xoaChiTietHD(String chiTietHDID);
	public boolean suaChiTietHD(ChiTietHoaDon ctHD);
	public boolean xoaCTHDTheoMaHD(String id);
}
