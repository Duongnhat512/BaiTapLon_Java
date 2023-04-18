package dao;

import java.sql.Connection;
import java.util.ArrayList;import com.microsoft.sqlserver.jdbc.SQLServerXAConnection;

import connectDB.ConnectDB;
import entities.NhaCungCap;
import interfaces.INhaCungCap;
import java.sql.*;

public class NhaCungCap_DAO implements INhaCungCap{

	@Override
	public ArrayList<NhaCungCap> getListNhaCC() {
		ArrayList<NhaCungCap> listNCC = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhaCungCap";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				String email = rs.getString(5);
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai, email);
				listNCC.add(ncc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listNCC;
	}

	@Override
	public NhaCungCap getNhaCCTheoMa(String maNCC) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/*
	 * Thêm nhà cung cấpn
	 */
	public boolean themNhaCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into NhaCungCap values(?, ?, ?, ?, ?)");
			stm.setString(1, ncc.getNhaCCID());
			stm.setString(2, ncc.getTenNCC());
			stm.setString(3, ncc.getDiaChi());
			stm.setString(4, ncc.getSoDienThoai());
			stm.setString(5, ncc.getEmail());
			n = stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				stm.close();
			} catch (SQLException  e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	@Override
	/*
	 * Xóa nhà cung cấp them mã
	 * 
	 */
	public boolean xoaNhaCC(String maNCC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from NhaCungCap where maNCC = ?");
			stm.setString(1, maNCC);
			n = stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException  e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	@Override
	public boolean capNhatNhaCC(NhaCungCap ncc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update NhaCungCap set tenNCC = ?, diaChi = ?, soDT = ?, email = ? where maNCC = ?");
			stm.setString(1, ncc.getTenNCC());
			stm.setString(2, ncc.getDiaChi());
			stm.setString(3, ncc.getSoDienThoai());
			stm.setString(4, ncc.getEmail());
			stm.setString(5, ncc.getNhaCCID());
			n = stm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException  e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

}
