package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entities.CPU;
import entities.HardDisk;
import entities.MainBoard;
import entities.NhaCungCap;
import entities.Ram;
import entities.SanPham;


public class SanPham_DAO {
	
	public ArrayList<SanPham> getAllTbSP(){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham";
			Statement statement = con.createStatement();
			
			ResultSet sr = statement.executeQuery(sql);
			
			while(sr.next()) {
				String maSP = sr.getString(1);
				String tenSP = sr.getString(2);
				String hang = sr.getString(3);
				String loai = sr.getString(4);
				double giaNhap = sr.getDouble(5);
				double giaBan = sr.getDouble(6);
				int slTon = sr.getInt(7);
				String nCC = sr.getString(8);
				NhaCungCap ncc = new NhaCungCap(nCC);
				int thoiGianBH = sr.getInt(9);
				if(loai.equals("CPU")) {
					int nhan = sr.getInt(13);
					int luong = sr.getInt(14);
					int cache = sr.getInt(15);
					SanPham s = new CPU(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBH, nhan, luong, cache);
					dsSP.add(s);
				}
				else if(loai.equalsIgnoreCase("MainBoard")) {
					String chipSet = sr.getString(10);
					String kheLuuTru = sr.getString(11);
					String kheMoRong = sr.getString(12);
					SanPham s = new MainBoard(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBH, chipSet, kheLuuTru, kheMoRong);
					dsSP.add(s);
				}
				else if(loai.equalsIgnoreCase("Ram")) {
					String loaiRam = sr.getString(19);
					int dungLuong = sr.getInt(20);
					int tocDo = sr.getInt(21);
					SanPham s = new Ram(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBH, loaiRam, dungLuong, tocDo);
					dsSP.add(s);
				}
				else if(loai.equals("HardDisk")) {
					int dungLuong = sr.getInt(16);
					String DDR= sr.getString(17);
					float tuoiTho = sr.getFloat(18);
					SanPham s = new HardDisk(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc, thoiGianBH, dungLuong, DDR, tuoiTho);
					dsSP.add(s);
				}			
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSP;
	}
	public SanPham getSPTheoMa(String id){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement statement = null;
		try {	
			String sql = "Select * from SanPham where maSP = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,id);
			ResultSet sr = statement.executeQuery();
			
			while(sr.next()) {
				String maSP = sr.getString(1);
				String tenSP = sr.getString(2);
				String hang = sr.getString(3);
				String loai = sr.getString(4);
				Double giaNhap = sr.getDouble(5);
				Double giaBan = sr.getDouble(6);
				Integer slTon = sr.getInt(7);
				String maNCC = sr.getString(8);
				NhaCungCap ncc = new NhaCungCap(maNCC);
				int tgBH = sr.getInt(9);
				if(loai.equalsIgnoreCase("MainBoard"))
				{	
					String chipSet = sr.getString(10);
					String kheLuuTru = sr.getString(11);
					String kheMoRong = sr.getString(12);
					SanPham p = new MainBoard(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc,tgBH, chipSet, kheLuuTru, kheMoRong);
					return p;
				}
				else if(loai.equals("CPU"))
				{
					Integer nhan = sr.getInt(13);
					Integer luong = sr.getInt(14);
					Integer Cache = sr.getInt(15);
					SanPham p = new CPU(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc,tgBH, nhan, luong, Cache);
					return p;
				}
				else if(loai.equals("HardDisk"))
				{
					Integer dungLuongHD = sr.getInt(16);
					String cacheDDR = sr.getString(17);
					Float tuoiThoTB = sr.getFloat(18);
					SanPham p = new HardDisk(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc,tgBH, dungLuongHD, cacheDDR, tuoiThoTB);
					return p;
				}
				else if(loai.equalsIgnoreCase("Ram"))
				{
					String loaiR = sr.getString(19);
					Integer dungLuongR = sr.getInt(20);
					Integer tocDoR = sr.getInt(21);
					SanPham p = new Ram(maSP, tenSP, hang, loai, giaNhap, giaBan, slTon, ncc,tgBH, loaiR, dungLuongR, tocDoR);
					return p;
				}
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<SanPham> getSPTheoLoai(String loai){
		ArrayList<SanPham> dsSP = new ArrayList<SanPham>();
		
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			PreparedStatement	statement = null;
			
		
		
		try {	
			String sql = "Select * from SanPham where loai = ?";	
			statement = con.prepareStatement(sql);
			statement.setString(1,loai);
			ResultSet sr = statement.executeQuery();
			if(loai.equals("MainBoard")) {
				while(sr.next()) {
					String maSP = sr.getString(1);
					String tenSP = sr.getString(2);
					String hang = sr.getString(3);
					String loaiSP = sr.getString(4);
					Double giaBan = sr.getDouble(5);
					Double giaNhap = sr.getDouble(6);
					int slt = sr.getInt(7);
					String maNcc = sr.getString(8);
					NhaCungCap ncc = new NhaCungCap(maNcc);
					int tgBH = sr.getInt(9);
					String chipSet = sr.getString(10);
					String kheLuuTru = sr.getString(11);
					String kheMoRong = sr.getString(12);
					SanPham p = new MainBoard(maSP, tenSP, hang, loaiSP, giaNhap, giaBan, slt, ncc,tgBH, chipSet, kheLuuTru, kheMoRong);

					dsSP.add(p);
				}
			}
			else if(loai.equals("CPU")) {
				while(sr.next()) {
					String maSP = sr.getString(1);
					String tenSP = sr.getString(2);
					String hang = sr.getString(3);
					String loaiSP = sr.getString(4);
					Double giaBan = sr.getDouble(5);
					Double giaNhap = sr.getDouble(6);
					int slt = sr.getInt(7);
					String maNcc = sr.getString(8);
					NhaCungCap ncc = new NhaCungCap(maNcc);
					int tgBH = sr.getInt(9);
					String chipSet = sr.getString(10);
					String kheLuuTru = sr.getString(11);
					String kheMoRong = sr.getString(12);
					SanPham s = new MainBoard(maSP, tenSP, hang, loaiSP, giaNhap, giaBan, slt, ncc, tgBH, chipSet, kheLuuTru, kheMoRong);
					dsSP.add(s);
				}
			}
			else if(loai.equals("Ram")) {
				while(sr.next()) {
					String maSP = sr.getString(1);
					String tenSP = sr.getString(2);
					String hang = sr.getString(3);
					String loaiSP = sr.getString(4);
					Double giaBan = sr.getDouble(5);
					Double giaNhap = sr.getDouble(6);
					int slt = sr.getInt(7);
					String maNcc = sr.getString(8);
					NhaCungCap ncc = new NhaCungCap(maNcc);
					int tgBH = sr.getInt(9);
					String loaiRam = sr.getString(19);
					int dungLuong = sr.getInt(20);
					int tocDo = sr.getInt(21);
					SanPham s = new Ram(maSP, tenSP, hang, loaiSP, giaNhap, giaBan, slt, ncc, tgBH, loaiRam, dungLuong, tocDo);
					dsSP.add(s);
				}
				
			}
			else if(loai.equals("HardDisk")) {
				while(sr.next()) {
					String maSP = sr.getString(1);
					String tenSP = sr.getString(2);
					String hang = sr.getString(3);
					String loaiSP = sr.getString(4);
					Double giaBan = sr.getDouble(5);
					Double giaNhap = sr.getDouble(6);
					int slt = sr.getInt(7);
					String maNcc = sr.getString(8);
					NhaCungCap ncc = new NhaCungCap(maNcc);
					int tgBH = sr.getInt(9);
					int dungLuong = sr.getInt(16);
					String DDR= sr.getString(17);
					float tuoiTho = sr.getFloat(18);
					SanPham s = new HardDisk(maSP, tenSP, hang, loaiSP, giaNhap, giaBan, slt, ncc, tgBH, dungLuong, DDR, tuoiTho);
					dsSP.add(s);
				}
				
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSP;
	}
	public boolean 	create(SanPham s) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("insert into"+" SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1, s.getSpID());
			stmt.setString(2, s.getTenSP());
			stmt.setString(3, s.getHang());
			stmt.setString(4, s.getLoai());
			stmt.setDouble(5, s.getGiaNhap());
			stmt.setDouble(6, s.getGiaBan());
			stmt.setInt(7, s.getSlTon());
			stmt.setString(8, s.getNcc().getNhaCCID());
			stmt.setInt(9,s.getThoiGianBaoHanh());
			stmt.setString(10, null);
			stmt.setString(11, null);
			stmt.setString(12, null);
			stmt.setString(13, null);
			stmt.setString(14, null);
			stmt.setString(15, null);
			stmt.setString(16, null);
			stmt.setString(17,null);
			stmt.setString(18, null);
			stmt.setString(19, null);
			stmt.setString(20, null);
			stmt.setString(21, null);
			if(s.getLoai().equals("MainBoard"))
			{	
				MainBoard mb = (MainBoard) s;
				stmt.setString(10, mb.getChipSet());
				stmt.setString(11, mb.getKheLuuTru());
				stmt.setString(12, mb.getKheMoRong());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("CPU")) {
				CPU cpu = (CPU) s;
				stmt.setInt(13, cpu.getNhan());
				stmt.setInt(14, cpu.getLuong());
				stmt.setInt(15, cpu.getCache());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("HardDisk")) {
				HardDisk hd = (HardDisk) s;
				stmt.setInt(16, hd.getDungLuong());
				stmt.setString(17,	hd.getCacheDDR());
				stmt.setFloat(18, hd.getTuoiThoTB());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("Ram")) {
				Ram r = (Ram) s;
				stmt.setString(19, r.getLoaiRam());
				stmt.setInt(20, r.getDungLuongRam());
				stmt.setInt(21, r.getTocDo());
				n = stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean 	update(SanPham s) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			stmt =con.prepareStatement("update SanPham set tenSP = ?, hang = ?, "
					+ "giaNhap = ?, giaBan = ?, slTon = ?,maNCC = ?,thoiGianBH = ?, "
					+ "chipSet = ?, kheLuuTru =?, kheMoRong = ?, "
					+ "nhan =?, luong = ?, cache = ?, "
					+ "dungLuongODia = ?, cacheDDR = ?, tuoiThoTB =?, "
					+ "loaiRam = ?, dungLuongRam = ?, tocDoRam = ? where maSP = ?");
			
			
			stmt.setString(1, s.getTenSP());
			stmt.setString(2, s.getHang());
			stmt.setDouble(3, s.getGiaNhap());
			stmt.setDouble(4, s.getGiaBan());
			stmt.setInt(5, s.getSlTon());
			stmt.setString(6,s.getNcc().getNhaCCID());
			stmt.setInt(7,s.getThoiGianBaoHanh());
			stmt.setString(8, null);
			stmt.setString(9, null);
			stmt.setString(10, null);
			stmt.setString(11, null);
			stmt.setString(12, null);
			stmt.setString(13, null);
			stmt.setString(14, null);
			stmt.setString(15, null);
			stmt.setString(16, null);
			stmt.setString(17, null);
			stmt.setString(18, null);
			stmt.setString(19, null);
			stmt.setString(20, s.getSpID());
			if(s.getLoai().equals("MainBoard"))
			{	
				MainBoard s1 = (MainBoard) s;
				stmt.setString(8, s1.getChipSet());
				stmt.setString(9, s1.getKheLuuTru());
				stmt.setString(10, s1.getKheMoRong());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("CPU"))
			{	
				CPU s1 = (CPU) s;
				stmt.setInt(11, s1.getNhan());
				stmt.setInt(12, s1.getLuong());
				stmt.setInt(13, s1.getCache());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("HardDisk"))
			{	
				HardDisk s1 = (HardDisk) s;
				stmt.setInt(14, s1. getDungLuong());
				stmt.setString(15, s1.getCacheDDR());
				stmt.setFloat(16, s1.getTuoiThoTB());
				n = stmt.executeUpdate();
			}
			else if(s.getLoai().equals("Ram"))
			{	
				Ram s1 = (Ram) s;
				stmt.setString(17, s1.getLoaiRam());
				stmt.setInt(18, s1.getDungLuongRam());
				stmt.setInt(19, s1.getTocDo());
				n = stmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	public boolean 	delete(String maSP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n= 0;
		try {
			
			String sql = "delete from SanPham where maSP = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1,maSP);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
}
