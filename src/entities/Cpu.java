package entities;

public class CPU extends SanPham{
	private int nhan;
	private int luong;
	private int cache;
	public int getNhan() {
		return nhan;
	}
	public void setNhan(int nhan) {
		this.nhan = nhan;
	}
	public int getLuong() {
		return luong;
	}
	public void setLuong(int luong) {
		this.luong = luong;
	}
	public int getCache() {
		return cache;
	}
	public void setCache(int cache) {
		this.cache = cache;
	}
	public CPU(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh, int nhan, int luong, int cache) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		this.nhan = nhan;
		this.luong = luong;
		this.cache = cache;
	}
	public CPU() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CPU(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CPU [nhan=" + nhan + ", luong=" + luong + ", cache=" + cache + ", spID=" + spID + ", tenSP=" + tenSP
				+ ", hang=" + hang + ", loai=" + loai + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", slTon="
				+ slTon + ", ncc=" + ncc + ", thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}
	
	
	
	
}
