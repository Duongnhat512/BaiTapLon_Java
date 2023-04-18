package entities;

import java.io.Serializable;
import java.util.Objects;



public class NhanVien {
    private String nhanVienID;
    private String tenNV;
    private PhongBan pBan;
    private String soDT;
    private double luong;
    private boolean phai;

    public NhanVien(String maNV, String tenNV,  PhongBan pBan, String soDT, double luong, boolean phai) {
    	super();
        this.nhanVienID = maNV;
        this.tenNV = tenNV;
        this.pBan = pBan;
        this.soDT = soDT;
        this.luong = luong;
        this.phai = phai;
    }

    public String getMaNV() {
        return nhanVienID;
    }

    public void setMaNV(String maNV) {
        this.nhanVienID = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    public PhongBan getPhong() {
        return pBan;
    }

    public void setPhong(PhongBan pBan) {
        this.pBan = pBan;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    
    public boolean getPhai() {
        return phai;
    }

    public void setPhai(boolean phai) {
        this.phai = phai;
    }

    
	public int hashCode() {
		return Objects.hash(nhanVienID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		NhanVien other = (NhanVien) obj;
		return Objects.equals(nhanVienID, other.nhanVienID);
	}

	@Override
	public String toString() {
		return "NhavVien [maNV=" + nhanVienID + ", tenNV=" + tenNV + ", pBan=" + pBan + ", soDT=" + soDT + ", luong=" + luong
				+ ", phai=" + phai + "]";
	}
	
}
