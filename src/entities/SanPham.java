package entities;

import java.util.Objects;

public class SanPham {
	protected String spID;
	protected String tenSP;
	protected String hang;
	protected String loai;
	protected double giaNhap;
	protected double giaBan;
	protected int slTon;
	protected NhaCungCap ncc;
	protected int thoiGianBaoHanh;
	public String getSpID() {
		return spID;
	}
	public void setSpID(String spID) {
		this.spID = spID;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getHang() {
		return hang;
	}
	public void setHang(String hang) {
		this.hang = hang;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public int getSlTon() {
		return slTon;
	}
	public void setSlTon(int slTon) {
		this.slTon = slTon;
	}
	public NhaCungCap getNcc() {
		return ncc;
	}
	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}
	public int getThoiGianBaoHanh() {
		return thoiGianBaoHanh;
	}
	public void setThoiGianBaoHanh(int thoiGianBaoHanh) {
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public SanPham(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh) {
		super();
		this.spID = spID;
		this.tenSP = tenSP;
		this.hang = hang;
		this.loai = loai;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.slTon = slTon;
		this.ncc = ncc;
		this.thoiGianBaoHanh = thoiGianBaoHanh;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SanPham [spID=" + spID + ", tenSP=" + tenSP + ", hang=" + hang + ", loai=" + loai + ", giaNhap="
				+ giaNhap + ", giaBan=" + giaBan + ", slTon=" + slTon + ", ncc=" + ncc + ", thoiGianBaoHanh="
				+ thoiGianBaoHanh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(spID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Objects.equals(spID, other.spID);
	}
	
	
	
}
