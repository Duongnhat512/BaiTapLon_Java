package entities;


import java.util.Objects;

public class PhongBan  {
    private String phongID;
    private String tenPhong;

    public PhongBan(String maPhong, String tenPhong) {
		super();
		this.phongID = maPhong;
		this.tenPhong = tenPhong;
	}
    public PhongBan(String maPhong) {
    	this.phongID = maPhong;
	}
    

	public PhongBan() {
		super();
	}
	public String getMaPhongBan() {
        return phongID;
    }

    public void setMaPhongBan(String maPhong) {
        this.phongID = maPhong;
    }

    public String getTenPhongBan() {
        return tenPhong;
    }

    public void setTenPhongBan(String tenPhong) {
        this.tenPhong = tenPhong;
    }

	@Override
	public String toString() {
		return "PhongBan [maPhong=" + phongID + ", tenPhong=" + tenPhong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(phongID, tenPhong);
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
		PhongBan other = (PhongBan) obj;
		return Objects.equals(phongID, other.phongID) && Objects.equals(tenPhong, other.tenPhong);
	}

}
