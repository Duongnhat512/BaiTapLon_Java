package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import entities.NhanVien;
import interfaces.IHoaDon;

public class HoaDon_DAO implements IHoaDon{
	
	KhachHang_DAO kh_Dao = new KhachHang_DAO();
	NhanVien_DAO nv_Dao = new NhanVien_DAO();
	
	/*
	 * Lấy toàn bộ danh sách hóa đơn
	 */
	@Override
	public ArrayList<HoaDon> getListHoaDon() {
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from HoaDon");
			while(rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = kh_Dao.getKhachHangTheoMa(rs.getString(2));
				NhanVien nv = nv_Dao.getNhanVienTheoMaNV(rs.getString(3));
				LocalDate ngayLapHD = LocalDate.parse(rs.getString(4));
				LocalDate ngayGiao = LocalDate.parse(rs.getString(5));
				String noiNhan = new String(rs.getString(6));
				double tongTien = rs.getDouble(7);
				HoaDon hd = new HoaDon(maHD, kh, nv, ngayLapHD, ngayGiao, noiNhan, tongTien);
				dsHD.add(hd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsHD;
	}
	
	/**
	 * Lấy hóa đơn theo mã hóa đơn
	 */
	@Override
	public HoaDon getHoaDonTheoMa(String maHD) {
		HoaDon hd = new HoaDon();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		try {
			stm = con.prepareStatement("select * from HoaDon where maHD = ?");
			stm.setString(1, maHD);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				String ma = rs.getString(1);
				KhachHang kh = kh_Dao.getKhachHangTheoMa(rs.getString(2));
				NhanVien nv = nv_Dao.getNhanVienTheoMaNV(rs.getString(3));
				LocalDate ngayLapHD = LocalDate.parse(rs.getString(4));
				LocalDate ngayGiao = LocalDate.parse(rs.getString(5));
				String noiNhan = new String(rs.getString(6));
				double tongTien = rs.getDouble(7);
				hd = new HoaDon(ma, kh, nv, ngayLapHD, ngayGiao, noiNhan, tongTien);
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
		return hd;
	}
	/*
	 * Thêm hóa đơn
	 */
	@Override
	public boolean themHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con =ConnectDB.getConnection();
		String sql = "insert into HoaDon values(?,?,?,?,?,?,?)";
		PreparedStatement stm = null;
		int r = 0;
		try {
			stm = con.prepareStatement(sql);
			stm.setString(1, hd.getIdHD());
			stm.setString(2, hd.getKhachHang().getIdKH());
			stm.setString(3, hd.getNhanVien().getNhanVienID());
			stm.setString(4, hd.getNgayLapHD().toString());
			stm.setString(5, hd.getNgayGiao().toString());
			stm.setString(6, hd.getNoiNhan());
			stm.setDouble(7, hd.getTongTien());
			r = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r>0;
	}
	
	/**
	 * Sửa hóa đơn
	 */
	@Override
	public boolean suaHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update HoaDon set maKH = ?, maNV = ?, ngayLapHD = ?, ngayGiao = ?, noiNhanHang = ?, tongTien = ? where maHD = ?");
			stm.setString(1, hd.getKhachHang().getIdKH());
			stm.setString(2, hd.getNhanVien().getNhanVienID());
			stm.setString(3, hd.getNgayLapHD().toString());
			stm.setString(4, hd.getNgayGiao().toString());
			stm.setString(5, hd.getNoiNhan());
			stm.setDouble(6, hd.getTongTien());
			stm.setString(7, hd.getIdHD());
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
	
	/**
	 * Xóa hóa đơn
	 */
	@Override
	public boolean xoaHoaDon(String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("delete from HoaDon where maHD = ?");
			stm.setString(1, maHD);
			n = stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	/**
	 * Cập nhật tổng tiền
	 */
	@Override
	public boolean capNhatTongTien() {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update HoaDon set tongTien = (select sum(tongTien) from ChiTietHoaDon where maHD = HoaDon.maHD)");
			n = stm.executeUpdate();
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
		return n > 0;
	}
	
	/*
	 * Cập nhật tổng tiền theo mã hóa đơn
	 */
	@Override
	public boolean capNhatTongTienHDThemMaHD(String id) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stm = null;
		int n = 0;
		try {
			stm = con.prepareStatement("update HoaDon set tongTien = (select sum(tongTien) from ChiTietHoaDon where maHD = HoaDon.maHD) where maHD = ?");
			stm.setString(1, id);
			n = stm.executeUpdate();
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
		return n > 0;
	}
	
}
