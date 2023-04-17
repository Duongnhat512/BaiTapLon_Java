package entities;

import java.util.Objects;

public class KhachHang {
	private String idKH;
	private String tenKH;
	private boolean gioiTinh;
	private String diaChi;
	private String soDienThoai;
	private String gmail;
	private String loaiKhachHang;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHang(String idKH, String tenKH, boolean gioiTinh, String diaChi, String soDienThoai, String gmail,
			String loaiKhachHang) {
		super();
		this.idKH = idKH;
		this.tenKH = tenKH;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.gmail = gmail;
		this.loaiKhachHang = loaiKhachHang;
	}
	public KhachHang(String idKH) {
		super();
		this.idKH = idKH;
	}
	public String getIdKH() {
		return idKH;
	}
	public void setIdKH(String idKH) {
		this.idKH = idKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getLoaiKhachHang() {
		return loaiKhachHang;
	}
	public void setLoaiKhachHang(String loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idKH);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(idKH, other.idKH);
	}
	
}
