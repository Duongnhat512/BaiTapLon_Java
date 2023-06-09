package bus;

import java.util.ArrayList;

import dao.PhongBan_DAO;
import entities.PhongBan;

public class PhongBan_Bus {
	private PhongBan_DAO pb_Dao = new PhongBan_DAO();
	
	public ArrayList<PhongBan> getalltbPhongBan(){
		return pb_Dao.getalltbPhongBan();
	}
	public boolean themPhongBan(String tenPB) {
		int n = getalltbPhongBan().size();
		String maPB = String.format("%d", n);
		while(!pb_Dao.themPhongBan(new PhongBan(maPB, tenPB))) {
			n++;
			maPB = String.format("%d", n);
		}
		return true;
	}
	public PhongBan getPhongBanTheoMa(String ma) {
		return pb_Dao.getPhongBanTheoMa(ma);
	}
	
	public boolean themPhongBan(PhongBan pb) {
		return pb_Dao.themPhongBan(pb);
	}
}
