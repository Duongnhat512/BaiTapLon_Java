package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.TaiKhoan;
import interfaces.ITaiKhoan;

public class TaiKhoan_DAO implements ITaiKhoan{
	public ArrayList<TaiKhoan> getListTaiKhoan(){
		ArrayList<TaiKhoan> list = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from TaiKhoan");
			while(rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				String loai = rs.getString(3);
				list.add(new TaiKhoan(taiKhoan, matKhau, loai));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public TaiKhoan getTaiKhoanTheoTenTaiKhoan(String tenTaiKhoan) {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			String sql = "select * from TaiKhoan where TaiKhoan = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, tenTaiKhoan);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String taiKhoan = rs.getString(1);
				String matKhau = rs.getString(2);
				String loai = rs.getString(3);
				tk = new TaiKhoan(taiKhoan, matKhau, loai);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return tk;
	}
}
