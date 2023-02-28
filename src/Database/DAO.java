package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import Model.SinhVien;

public class DAO {
	private Connection cn;
	public DAO() {
		cn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QLHSSV;"
					+ "username=sa;password=hieu12345;encrypt=false");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void closeConnection() {
		try {
			if(cn!=null)
				cn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int addSV(SinhVien sv) {
		int check =0;
		try {		
			String sql = "insert into HSSV (maSV, hoVaTen, gioiTinh, ngaySinh, danToc, CMND, queQuan, nganhDT)"
					+ "VALUES(?,?,?,?,?,?,?,?)";
			
			Calendar cal ;
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.setString(1, sv.getMSV());
			ps.setString(2, sv.getHoTen());
			ps.setString(3, sv.getGioiTinh());
			ps.setString(4,sv.getNgaySinh());
			
			ps.setString(5, sv.getDanToc());
			ps.setString(6, sv.getCMND());
			ps.setString(7, sv.getQueQuan());
			ps.setString(8, sv.getNganhDaoTao());
			check = ps.executeUpdate();
			;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public boolean login(String userName,String passWord) {
		String sql = "select * from TaiKhoan where userName like '"+userName
				+"' and passWord like '"+passWord+"'";
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public void updateAcc(String userName,String passWord) {
		String sql="UPDATE TaiKhoan SET passWord = '"+passWord 
				+"' WHERE userName like '" + userName +"'"; 
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ArrayList<SinhVien> getList(String sql) {
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMSV(rs.getString("maSV"));
				sv.setHoTen(rs.getString("hoVaTen"));
				sv.setGioiTinh(rs.getString("gioiTinh"));
				sv.setCMND(rs.getString("CMND"));
				sv.setDanToc(rs.getString("danToc"));
				sv.setQueQuan(rs.getString("queQuan"));
				sv.setNganhDaoTao(rs.getString("nganhDT"));
				sv.setNgaySinh( rs.getDate("ngaySinh").toString());
				list.add(sv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	public void deleteData(String sql) {
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ps.executeUpdate();
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SinhVien getHSSVUpdate(String sql) {
		SinhVien sv = new SinhVien();
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();		
			if(rs.next()) {
				sv.setMSV(rs.getString("maSV"));
				sv.setHoTen(rs.getString("hoVaTen"));
				sv.setGioiTinh(rs.getString("gioiTinh"));
				sv.setCMND(rs.getString("CMND"));
				sv.setDanToc(rs.getString("danToc"));
				sv.setQueQuan(rs.getString("queQuan"));
				sv.setNganhDaoTao(rs.getString("nganhDT"));
				sv.setNgaySinh( rs.getDate("ngaySinh").toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sv;
		
	}
	public int UpdateHSSV(String sql) {
		int check=0;
		try {
			PreparedStatement ps = cn.prepareStatement(sql);
			check=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public String getListText() {
		String data="";
		try {
			PreparedStatement ps = cn.prepareStatement("select * from HSSV");
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMSV(rs.getString("maSV"));
				sv.setHoTen(rs.getString("hoVaTen"));
				sv.setGioiTinh(rs.getString("gioiTinh"));
				sv.setCMND(rs.getString("CMND"));
				sv.setDanToc(rs.getString("danToc"));
				sv.setQueQuan(rs.getString("queQuan"));
				sv.setNganhDaoTao(rs.getString("nganhDT"));
				sv.setNgaySinh( rs.getDate("ngaySinh").toString());
				data=data+sv.toString()+"\n";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
