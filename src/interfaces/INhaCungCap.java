package interfaces;

import java.util.ArrayList;

import entities.NhaCungCap;

public interface INhaCungCap {
	public ArrayList<NhaCungCap> getListNhaCC();
	public NhaCungCap getNhaCCTheoMa(String maNCC);
	
	public boolean themNhaCC(NhaCungCap ncc);
	public boolean xoaNhaCC(String maNCC);
	public boolean capNhatNhaCC(NhaCungCap ncc);
}
