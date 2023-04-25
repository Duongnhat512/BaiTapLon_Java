package dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.KhachHang;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllTableKhachHang(){
		ArrayList<KhachHang> dskh = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from KhachHang";
		try {
			Statement st = con.createStatement();
			ResultSet r = st.executeQuery(sql);
			while(r.next()) {
				String ma = r.getString(1);
				String ten = r.getString(2);
				boolean gioiTinh = r.getBoolean(3);
				String diaChi = r.getString(4);
				String sdt = r.getString(5);
				String gmail = r.getString(6);
				String loai = r.getString(7);
				KhachHang k = new KhachHang(ma,ten,gioiTinh,diaChi,sdt,gmail,loai);
				dskh.add(k);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dskh;
	}
	public KhachHang getKhachHangTheoMa(String ma) throws SQLException{
		KhachHang kh  = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from KhachHang where maKH = ?";
		PreparedStatement st = null;
		st = con.prepareStatement(sql);
		st.setString(1, ma);
		ResultSet r = st.executeQuery();
		while(r.next()) {
			String maKH = r.getString(1);
			String ten1 = r.getString(2);
			boolean gioiTinh = r.getBoolean(3);
			String diaChi = r.getString(4);
			String sdt = r.getString(5);
			String gmail = r.getString(6);
			String loai = r.getString(7);
			kh = new KhachHang(maKH,ten1,gioiTinh,diaChi,sdt,gmail,loai);
		}
		return kh;
	}
	public ArrayList<KhachHang> getKhachHangTheoTen(String ten) throws SQLException{
		ArrayList<KhachHang> dskh = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from KhachHang where tenKH = ?";
		PreparedStatement st = null;
		st = con.prepareStatement(sql);
		st.setString(1, ten);
		ResultSet r = st.executeQuery();
		while(r.next()) {
			String ma = r.getString(1);
			String ten1 = r.getString(2);
			boolean gioiTinh = r.getBoolean(3);
			String diaChi = r.getString(4);
			String sdt = r.getString(5);
			String gmail = r.getString(6);
			String loai = r.getString(7);
			KhachHang k = new KhachHang(ma,ten1,gioiTinh,diaChi,sdt,gmail,loai);
			dskh.add(k);
		}
		return dskh;
	}
	public ArrayList<KhachHang> getKhachHangTheoLoai(String loai) throws SQLException{
		ArrayList<KhachHang> dskh = new ArrayList<>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from KhachHang where loaiKH = ?";
		PreparedStatement st = null;
		st = con.prepareStatement(sql);
		st.setString(1, loai);
		ResultSet r = st.executeQuery();
		while(r.next()) {
			String ma = r.getString(1);
			String ten = r.getString(2);
			boolean gioiTinh = r.getBoolean(3);
			String diaChi = r.getString(4);
			String sdt = r.getString(5);
			String gmail = r.getString(6);
			String loai1 = r.getString(7);
			KhachHang k = new KhachHang(ma,ten,gioiTinh,diaChi,sdt,gmail,loai1);
			dskh.add(k);
		}
		return dskh;
	}
	public boolean them(KhachHang k) throws SQLException {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql = "insert into KhachHang values(?,?,?,?,?,?,?)";
		PreparedStatement st =con.prepareStatement(sql);
		st.setString(1,k.getIdKH());
		st.setString(2, k.getTenKH());
		st.setBoolean(3, k.isGioiTinh());
		st.setString(4, k.getDiaChi());
		st.setString(5, k.getSoDienThoai());
		st.setString(6, k.getGmail());
		st.setString(7, k.getLoaiKhachHang());
		int r = st.executeUpdate();
		
		return r>0;
	}
	public boolean xoa(KhachHang k) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "delete from KhachHang where maKH= ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,k.getIdKH());
		int r = st.executeUpdate();
		return r>0;
	}
	public boolean sua(KhachHang k) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "update KhachHang set tenKH = ? , gioiTinh = ? , diaChi = ? , soDienThoai = ? ,gmail = ? where maKH = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, k.getTenKH());
		st.setBoolean(2, k.isGioiTinh());
		st.setString(3, k.getDiaChi());
		st.setString(4, k.getSoDienThoai());
		st.setString(5, k.getGmail());
		st.setString(6, k.getIdKH());
		int r = st.executeUpdate();
		return r>0;
	}
	
	public boolean updateLoaiKH(KhachHang k) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		String sql = "exec capNhapLoai ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, k.getIdKH());
		int r = st.executeUpdate();
		return r>0;
	}

}
