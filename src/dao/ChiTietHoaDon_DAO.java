package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.SanPham;
import interfaces.IChiTietHoaDon;

public class ChiTietHoaDon_DAO implements IChiTietHoaDon{
	private SanPham_DAO sp_Dao = new SanPham_DAO();
	private HoaDon_DAO hd_Dao = new HoaDon_DAO();
	@Override
	public ArrayList<ChiTietHoaDon> getListChiTietHD() {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			String sql = "Select * from ChiTietHoaDon";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String maCTHD = rs.getString(1);
				HoaDon hd = hd_Dao.getHoaDonTheoMa(rs.getString(2));
				SanPham sp = sp_Dao.getSPTheoMa(rs.getString(3));
				int soLuong = rs.getInt(4);
				double giaBan = rs.getDouble(5);
				double tongTien = rs.getDouble(6);
				list.add(new ChiTietHoaDon(maCTHD, sp, hd, soLuong, giaBan, tongTien));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ArrayList<ChiTietHoaDon> getChiTietHDTheoMaHD(String maHD) {
		ArrayList<ChiTietHoaDon> list = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		HoaDon hd = hd_Dao.getHoaDonTheoMa(maHD);
		try {
			stm = con.prepareStatement("select * from ChiTietHoaDon where maHD = ?");
			stm.setString(1, maHD);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String maCTHD = rs.getString(1);
				SanPham sp = sp_Dao.getSPTheoMa(rs.getString(3));
				int soLuong = rs.getInt(4);
				double giaBan = rs.getDouble(5);
				double tongTien = rs.getDouble(6);
				list.add(new ChiTietHoaDon(maCTHD, sp, hd, soLuong, giaBan, tongTien));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean themChiTietHD(ChiTietHoaDon ctHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("insert into ChiTietHoaDon values(?, ?, ?, ?, ?, ?)");
			stm.setString(1, ctHD.getChiTietHoaDonID());
			stm.setString(2, ctHD.getHoaDon().getIdHD());
			stm.setString(3, ctHD.getSanPham().getSpID());
			stm.setInt(4, ctHD.getSoLuong());
			stm.setDouble(5, ctHD.getGiaBan());
			stm.setDouble(6, ctHD.getTongTien());
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

	@Override
	public boolean xoaChiTietHD(String maChiTietHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from ChiTietHoaDon where maChiTietHD = ?");
			stm.setString(1, maChiTietHD);
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

	@Override
	public boolean suaChiTietHD(ChiTietHoaDon ctHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update ChiTietHoaDon set maSP = ?, soLuong = ?, giaBan = ?, tongTien = ? where maChiTietHD = ?");
			stm.setString(1, ctHD.getSanPham().getSpID());
			stm.setInt(2, ctHD.getSoLuong());
			stm.setDouble(3, ctHD.getGiaBan());
			stm.setDouble(4, ctHD.getTongTien());
			stm.setString(5, ctHD.getChiTietHoaDonID());
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	@Override
	public boolean xoaCTHDTheoMaHD(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("Delete from ChiTietHoaDon where maHD = ?");
			stm.setString(1, id);
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
