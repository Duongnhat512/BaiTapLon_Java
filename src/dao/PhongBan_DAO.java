package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;
import entities.PhongBan;

public class PhongBan_DAO {
	public ArrayList<PhongBan> getalltbPhongBan(){
		ArrayList<PhongBan> dsphongban = new ArrayList<PhongBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "Select * from PhongBan";
			Statement statement = con.createStatement();
			
			ResultSet rs = statement.executeQuery(sql);
			
			while (rs.next()) {
				String maPB = rs.getString(1);
				String tenPB = rs.getString(2);
				PhongBan p = new PhongBan(maPB,tenPB);
				dsphongban.add(p);
			}
		} catch (SQLException e) {e.printStackTrace();
			// TODO: handle exception
		}
		return dsphongban;
	}
	public boolean themPhongBan(PhongBan pb) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into PhongBan values(?, ?)");
			stm.setString(1, pb.getMaPhongBan());
			stm.setString(2, pb.getTenPhongBan());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
}
