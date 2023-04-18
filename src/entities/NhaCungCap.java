package entities;

import java.util.Objects;

public class NhaCungCap {
	private String nhaCCID;
	private String tenNCC;
	private String diaChi;
	private String soDienThoai;
	private String email;
	public NhaCungCap(String nhaCCID, String tenNCC, String diaChi, String soDienThoai, String email) {
		super();
		this.nhaCCID = nhaCCID;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.email = email;
	}
	public NhaCungCap(String maNCC) {
		super();
		this.nhaCCID = maNCC;
	}
	public NhaCungCap() {
		super();
	}
	public String getMaNCC() {
		return nhaCCID;
	}
	public void setMaNCC(String maNCC) {
		this.nhaCCID = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nhaCCID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(nhaCCID, other.nhaCCID);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
