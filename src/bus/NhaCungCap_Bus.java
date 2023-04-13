package bus;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import entities.NhaCungCap;
import interfaces.INhaCungCap;

public class NhaCungCap_Bus implements INhaCungCap{
	
	private NhaCungCap_DAO ncc_Dao = new NhaCungCap_DAO();
	private int ma = 5;

	@Override
	public ArrayList<NhaCungCap> getListNhaCC() {
		return ncc_Dao.getListNhaCC();
	}

	@Override
	public NhaCungCap getNhaCCTheoMa(String maNCC) {
		for(NhaCungCap ncc : getListNhaCC()) {
			if(maNCC.trim().equals(ncc.getMaNCC())) {
				return ncc;
			}
		}
		return null;
	}

	@Override
	public boolean themNhaCC(NhaCungCap ncc) {
		ma++;
		String maNCC = "NCC" + String.format("%03d", ma);
		ncc.setMaNCC(maNCC);
		if(ncc_Dao.themNhaCC(ncc)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean xoaNhaCC(String maNCC) {
		if(ncc_Dao.xoaNhaCC(maNCC)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean capNhatNhaCC(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return false;
	}

}
