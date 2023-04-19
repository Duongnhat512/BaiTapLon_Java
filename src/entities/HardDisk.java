package entities;

public class HardDisk extends SanPham{
	private int dungLuongHD;
	private String cacheDDR;
	private float tuoiThoTB;
	public int getDungLuong() {
		return dungLuongHD;
	}
	public void setDungLuong(int dungLuongHD) {
		this.dungLuongHD = dungLuongHD;
	}
	public String getCacheDDR() {
		return cacheDDR;
	}
	public void setCacheDDR(String cacheDDR) {
		this.cacheDDR = cacheDDR;
	}
	public float getTuoiThoTB() {
		return tuoiThoTB;
	}
	public void setTuoiThoTB(float tuoiThoTB) {
		this.tuoiThoTB = tuoiThoTB;
	}
	
	public HardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HardDisk(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh, int dungLuongHD, String cacheDDR, float tuoiThoTB) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		this.dungLuongHD = dungLuongHD;
		this.cacheDDR = cacheDDR;
		this.tuoiThoTB = tuoiThoTB;
	}
	public HardDisk(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HardDisk [dungLuongHD=" + dungLuongHD + ", cacheDDR=" + cacheDDR + ", tuoiThoTB=" + tuoiThoTB
				+ ", spID=" + spID + ", tenSP=" + tenSP + ", hang=" + hang + ", loai=" + loai + ", giaNhap=" + giaNhap
				+ ", giaBan=" + giaBan + ", slTon=" + slTon + ", ncc=" + ncc + ", thoiGianBaoHanh=" + thoiGianBaoHanh
				+ "]";
	}
	
	
	
	
}
