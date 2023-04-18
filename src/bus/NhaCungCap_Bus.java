package bus;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_Bus implements INhaCungCap{
	
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();
	private int ma;

	@Override
	public ArrayList<NhaCungCap> getListNhaCC() {
		return ncc_Dao.getListNhaCC();
	}

	@Override
	public NhaCungCap getNhaCCTheoMa(String maNCC) {
		for(NhaCungCap ncc : getListNhaCC()) {
			if(maNCC.trim().equalsIgnoreCase(ncc.getNhaCCID())) {
				return ncc;
			}
		}
		return null;
	}

	@Override
	public boolean themNhaCC(NhaCungCap ncc) {
		ma = ncc_Dao.getListNhaCC().size() + 1;
		String maNCC = "NCC" + String.format("%03d", ma);
		while (getListNhaCC().contains(new NhaCungCap(maNCC))) {
			ma++;
			maNCC = "NCC" + String.format("%03d", ma);
		}
		ncc.setNhaCCID(maNCC);
		if(ncc_Dao.themNhaCC(ncc)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean xoaNhaCC(String maNCC) {
		boolean result = true;
		try {
			result = ncc_Dao.xoaNhaCC(maNCC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
		return result;
	}

	@Override
	public boolean capNhatNhaCC(NhaCungCap ncc) {
		if(ncc_Dao.capNhatNhaCC(ncc)) {
			return true;
		}
		return false;
	}

}
