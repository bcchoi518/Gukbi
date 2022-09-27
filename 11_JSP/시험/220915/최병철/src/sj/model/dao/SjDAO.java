package sj.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.Db;
import member.model.dto.DTO;
import sj.model.dto.SjDTO;

public class SjDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int setInsert(SjDTO paramDto) {
		int result = 0;
		conn = Db.getDbConnection();
		try {
			String sql = "INSERT INTO sj VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getsName());
			pstmt.setInt(3, paramDto.getMun_1());
			pstmt.setInt(4, paramDto.getMun_2());
			pstmt.setInt(5, paramDto.getMun_3());
			pstmt.setInt(6, paramDto.getMun_4());
			pstmt.setInt(7, paramDto.getMun_5());
			pstmt.setString(8, paramDto.getMun_ox_1());
			pstmt.setString(9, paramDto.getMun_ox_2());
			pstmt.setString(10, paramDto.getMun_ox_3());
			pstmt.setString(11, paramDto.getMun_ox_4());
			pstmt.setString(12, paramDto.getMun_ox_5());
			pstmt.setInt(13, paramDto.getJumsu());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Db.dbClose(conn, pstmt, rs);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public ArrayList<SjDTO> getSelectAll() {
		ArrayList<SjDTO> sjList = new ArrayList<>();
		conn = Db.getDbConnection();
		try {
			String sql = "SELECT * FROM sj ORDER BY name ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SjDTO sjDto = new SjDTO();
				sjDto.setName(rs.getString("name"));
				sjDto.setsName(rs.getString("sName"));
				sjDto.setMun_1(rs.getInt("mun_1"));
				sjDto.setMun_2(rs.getInt("mun_2"));
				sjDto.setMun_3(rs.getInt("mun_3"));
				sjDto.setMun_4(rs.getInt("mun_4"));
				sjDto.setMun_5(rs.getInt("mun_5"));
				sjDto.setMun_ox_1(rs.getString("mun_ox_1"));
				sjDto.setMun_ox_2(rs.getString("mun_ox_2"));
				sjDto.setMun_ox_3(rs.getString("mun_ox_3"));
				sjDto.setMun_ox_4(rs.getString("mun_ox_4"));
				sjDto.setMun_ox_5(rs.getString("mun_ox_5"));
				sjDto.setJumsu(rs.getInt("jumsu"));
				sjList.add(sjDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Db.dbClose(conn, pstmt, rs);
		}//try-catch-finally
		return sjList;
	}//getSelectAll
}//SjDAO
