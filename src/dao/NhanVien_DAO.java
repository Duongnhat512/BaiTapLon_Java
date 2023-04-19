package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.NhanVien;
import entities.PhongBan;

public class NhanVien_DAO {
	public NhanVien_DAO() {
	}
	public ArrayList<NhanVien> getalltbNhanVien() throws ClassNotFoundException{
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance().connect();
			Connection con = ConnectDB.getConnection() ;
			String sql = "Select * from nhanvien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				PhongBan pBan = new PhongBan(rs.getString(3));
				String soDT = rs.getString(4);
				double luong = rs.getDouble(5);
				boolean phai = rs.getBoolean(6);
	
				NhanVien nv = new NhanVien(maNV,tenNV,pBan,soDT,luong,phai);
				dsnv.add(nv);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsnv;
	}
	public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where manv = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				PhongBan pBan = new PhongBan(rs.getString(3));
				String soDT = rs.getString(4);
				double luong = rs.getDouble(5);
				boolean phai = rs.getBoolean(6);
				
				NhanVien nv = new NhanVien(maNV,tenNV,pBan,soDT,luong,phai);
				dsnv.add(nv);
			}
		} catch (SQLException e) {e.printStackTrace(); }
		finally {
			try {
				statement.close();
			} catch (SQLException e) { e.printStackTrace();
				// TODO: handle exception
			}
		}return dsnv;
	}
	
	public ArrayList<NhanVien> getNhanVienTheoTen(String ten) {
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where tenNV = ?";
			statement = con.prepareStatement(sql);
			statement.setString(1, ten);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				PhongBan pBan = new PhongBan(rs.getString(3));
				String soDT = rs.getString(4);
				double luong = rs.getDouble(5);
				boolean phai = rs.getBoolean(6);
				
				NhanVien nv = new NhanVien(maNV,tenNV,pBan,soDT,luong,phai);
				dsnv.add(nv);
			}
		} catch (SQLException e) {e.printStackTrace(); }
		finally {
			try {
				statement.close();
			} catch (SQLException e) { e.printStackTrace();
				// TODO: handle exception
			}
		}return dsnv;
			// TODO: handle exception
	}
	
	public ArrayList<NhanVien> getNhanVienTheoPhongBan(String phongBan) throws SQLException, ClassNotFoundException{
		ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
		ConnectDB.getInstance().connect();;
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {
			String sql = "Select * from nhanvien where phongBan = ?";
		    statement = con.prepareStatement(sql);
		    statement.setString(1, phongBan);
		    ResultSet rs = statement.executeQuery(sql);
		    while (rs.next()) {
		    	String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				PhongBan pBan = new PhongBan(rs.getString(3));
				String soDT = rs.getString(4);
				double luong = rs.getDouble(5);
				boolean phai = rs.getBoolean(6);
				
				NhanVien nv = new NhanVien(maNV,tenNV,pBan,soDT,luong,phai);
				dsnv.add(nv);
		    }
		} catch (SQLException e) { e.printStackTrace();// TODO: handle exception
		}
		finally {
			try {
				statement.close();
			} catch (SQLException e) { e.printStackTrace();
				// TODO: handle exception
			}
		}
		return dsnv;
	}
	public boolean create(NhanVien nv) throws SQLException, ClassNotFoundException {
		ConnectDB.getInstance().connect();;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into"+" NhanVien values(?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setString(3, nv.getPhong().getMaPhongBan());
			stmt.setString(4, nv.getSoDT());
			stmt.setDouble(5, nv.getLuong());
			stmt.setBoolean(6, nv.getPhai());
		
			n = stmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {e.printStackTrace();
				// TODO: handle exception
			}
		}
		return n>0;
	}
	public boolean update(NhanVien nv) throws SQLException, ClassNotFoundException {
		ConnectDB.getInstance().connect();;
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set ten=?,maPhong=?,soDT=?,luong=?,phai=? where maNV=?");
		
			stmt.setString(1, nv.getTenNV());
			stmt.setString(2, nv.getPhong().getMaPhongBan());
			stmt.setString(3, nv.getSoDT());
			stmt.setDouble(4, nv.getLuong());
			stmt.setBoolean(5, nv.getPhai());
			stmt.setString(6, nv.getMaNV());
			
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e) {e.printStackTrace();
				// TODO: handle exception
			}
		}
		return n>0;
	}
	
	public boolean delete(String maNV) {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("delete from NhanVien where maNV = ?");
			stmt.setString(1, maNV);
			n = stmt.executeUpdate();
		} catch (SQLException e) {	e.printStackTrace();
			// TODO: handle exception
		}
		return n>0;
	}
}
