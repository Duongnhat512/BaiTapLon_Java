package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.ChiTietHoaDon;
import entities.HoaDon;
import entities.KhachHang;
import interfaces.IHoaDon;

public class HoaDon_DAO implements IHoaDon{

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
//				KhachHang
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public HoaDon getHoaDonTheoMa(String maHD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean themHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean suaHoaDon(HoaDon hd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xoaHoaDon(String maHD) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
