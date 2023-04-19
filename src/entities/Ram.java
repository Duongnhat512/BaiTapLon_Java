package entities;

public class Ram extends SanPham{
	private String loaiRam;
	private int dungLuongRam;
	private int tocDo;
	public String getLoaiRam() {
		return loaiRam;
	}
	public void setLoaiRam(String loaiRam) {
		this.loaiRam = loaiRam;
	}
	public int getDungLuongRam() {
		return dungLuongRam;
	}
	public void setDungLuongRam(int dungLuongRam) {
		this.dungLuongRam = dungLuongRam;
	}
	public int getTocDo() {
		return tocDo;
	}
	public void setTocDo(int tocDo) {
		this.tocDo = tocDo;
	}
	public Ram(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh, String loaiRam, int dungLuongRam, int tocDo) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		this.loaiRam = loaiRam;
		this.dungLuongRam = dungLuongRam;
		this.tocDo = tocDo;
	}
	public Ram() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ram(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Ram [loaiRam=" + loaiRam + ", dungLuongRam=" + dungLuongRam + ", tocDo=" + tocDo + ", spID=" + spID
				+ ", tenSP=" + tenSP + ", hang=" + hang + ", loai=" + loai + ", giaNhap=" + giaNhap + ", giaBan="
				+ giaBan + ", slTon=" + slTon + ", ncc=" + ncc + ", thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}
	

	
}
