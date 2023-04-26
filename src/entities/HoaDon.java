package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import bus.ChiTietHoaDon_Bus;

public class HoaDon {
	private String idHD;
	private KhachHang khachHang;
	private NhanVien nhanVien;
	private LocalDate ngayLapHD;
	private LocalDate ngayGiao;
	private String noiNhan;
	private double tongTien;
	public HoaDon() {
		super();
	}
	public HoaDon(String idHD) {
		super();
		this.idHD = idHD;
	}
	
	public HoaDon(String idHD, KhachHang khachHang, NhanVien nhanVien, LocalDate ngayLapHD, LocalDate ngayGiao,
			String noiNhan, double tongTien) {
		super();
		this.idHD = idHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHD = ngayLapHD;
		this.ngayGiao = ngayGiao;
		this.noiNhan = noiNhan;
		this.tongTien = tongTien;
	}
	public HoaDon(String idHD, KhachHang khachHang, NhanVien nhanVien, LocalDate ngayLapHD, LocalDate ngayGiao,
			String noiNhan) {
		super();
		this.idHD = idHD;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.ngayLapHD = ngayLapHD;
		this.ngayGiao = ngayGiao;
		this.noiNhan = noiNhan;
	}
	public String getIdHD() {
		return idHD;
	}
	public void setIdHD(String idHD) {
		this.idHD = idHD;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public LocalDate getNgayGiao() {
		return ngayGiao;
	}
	public void setNgayGiao(LocalDate ngayGiao) {
		this.ngayGiao = ngayGiao;
	}
	public String getNoiNhan() {
		return noiNhan;
	}
	public void setNoiNhan(String noiNhan) {
		this.noiNhan = noiNhan;
	}
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public void tinhTongTien() {
		double tongTien = 0;
		ChiTietHoaDon_Bus ctHD = new ChiTietHoaDon_Bus();
		ArrayList<ChiTietHoaDon> list = ctHD.getChiTietHDTheoMaHD(getIdHD());
		for (ChiTietHoaDon chiTietHoaDon : list) {
			chiTietHoaDon.tinhTongTien();
			tongTien += chiTietHoaDon.getTongTien();
		}
		this.tongTien = tongTien;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idHD);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(idHD, other.idHD);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
