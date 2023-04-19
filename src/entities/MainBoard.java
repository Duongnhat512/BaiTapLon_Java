package entities;

public class MainBoard extends SanPham{
	private String chipSet;
	private String kheLuuTru;
	private String kheMoRong;
	public String getChipSet() {
		return chipSet;
	}
	public void setChipSet(String chipSet) {
		this.chipSet = chipSet;
	}
	public String getKheLuuTru() {
		return kheLuuTru;
	}
	public void setKheLuuTru(String kheLuuTru) {
		this.kheLuuTru = kheLuuTru;
	}
	public String getKheMoRong() {
		return kheMoRong;
	}
	public void setKheMoRong(String kheMoRong) {
		this.kheMoRong = kheMoRong;
	}
	public MainBoard(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh, String chipSet, String kheLuuTru, String kheMoRong) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		this.chipSet = chipSet;
		this.kheLuuTru = kheLuuTru;
		this.kheMoRong = kheMoRong;
	}
	public MainBoard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MainBoard(String spID, String tenSP, String hang, String loai, double giaNhap, double giaBan, int slTon,
			NhaCungCap ncc, int thoiGianBaoHanh) {
		super(spID, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBaoHanh);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MainBoard [chipSet=" + chipSet + ", kheLuuTru=" + kheLuuTru + ", kheMoRong=" + kheMoRong + ", spID="
				+ spID + ", tenSP=" + tenSP + ", hang=" + hang + ", loai=" + loai + ", giaNhap=" + giaNhap + ", giaBan="
				+ giaBan + ", slTon=" + slTon + ", ncc=" + ncc + ", thoiGianBaoHanh=" + thoiGianBaoHanh + "]";
	}
	
	
	
	
}
