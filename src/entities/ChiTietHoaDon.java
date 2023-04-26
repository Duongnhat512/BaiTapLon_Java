package entities;

import java.util.Objects;

public class ChiTietHoaDon {
	private String chiTietHoaDonID;
	private SanPham sanPham;
	private HoaDon hoaDon;
	private int soLuong;
	private double giaBan;
	private double tongTien;
	public ChiTietHoaDon(String chiTietHoaDonID, SanPham sanPham, HoaDon hoaDon, int soLuong, double giaBan,
			double tongTien) {
		super();
		this.chiTietHoaDonID = chiTietHoaDonID;
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
		this.tongTien = tongTien;
	}
	
	public ChiTietHoaDon(String chiTietHoaDonID, SanPham sanPham, HoaDon hoaDon, int soLuong, double giaBan) {
		super();
		this.chiTietHoaDonID = chiTietHoaDonID;
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
		this.soLuong = soLuong;
		this.giaBan = giaBan;
	}

	public ChiTietHoaDon() {
		super();
	}
	public ChiTietHoaDon(String chiTietHoaDonID) {
		super();
		this.chiTietHoaDonID = chiTietHoaDonID;
	}
	public String getChiTietHoaDonID() {
		return chiTietHoaDonID;
	}
	public void setChiTietHoaDonID(String chiTietHoaDonID) {
		this.chiTietHoaDonID = chiTietHoaDonID;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public void tinhTongTien() {
		this.tongTien = getSoLuong() * getGiaBan();
	}
	@Override
	public int hashCode() {
		return Objects.hash(chiTietHoaDonID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(chiTietHoaDonID, other.chiTietHoaDonID);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
