package interfaces;

import java.util.ArrayList;

import entities.HoaDon;

public interface IHoaDon {
	public ArrayList<HoaDon> getListHoaDon();
	public HoaDon getHoaDonTheoMa(String maHD);
	
	public boolean themHoaDon(HoaDon hd);
	public boolean suaHoaDon(HoaDon hd);
	public boolean xoaHoaDon(String maHD);
	public boolean capNhatTongTien();
	public boolean capNhatTongTienHDThemMaHD(String id);
}
