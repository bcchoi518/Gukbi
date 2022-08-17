package haksaMember.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import haksaMember.model.dto.HaksaMemberDTO;

public class HaksaMemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private String tableName_1 = "haksaMember";
	
	public ArrayList<HaksaMemberDTO> getSelectAll() {
		ArrayList<HaksaMemberDTO> memberList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableName_1 +" ORDER BY regiDate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HaksaMemberDTO memberDto = new HaksaMemberDTO();
				memberDto.setHakbun(rs.getInt("hakbun"));
				memberDto.setName(rs.getString("name"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setParentPhone(rs.getString("parentPhone"));
				memberDto.setAddr1(rs.getString("addr1"));
				memberDto.setAddr2(rs.getString("addr2"));
				memberDto.setAddr3(rs.getString("addr3"));
				memberDto.setAddr4(rs.getString("addr4"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
				memberList.add(memberDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberList;
	}//getSelectAll
	
	public HaksaMemberDTO getSelectOne(HaksaMemberDTO paramDto) {
		HaksaMemberDTO memberDto = new HaksaMemberDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableName_1 +" WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getHakbun());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setHakbun(rs.getInt("hakbun"));
				memberDto.setName(rs.getString("name"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setParentPhone(rs.getString("parentPhone"));
				memberDto.setAddr1(rs.getString("addr1"));
				memberDto.setAddr2(rs.getString("addr2"));
				memberDto.setAddr3(rs.getString("addr3"));
				memberDto.setAddr4(rs.getString("addr4"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberDto;
	}//getSelectOne
	
	public int setInsert(HaksaMemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_haksaMember.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getPhone());
			pstmt.setString(3, paramDto.getParentPhone());
			pstmt.setString(4, paramDto.getAddr1());
			pstmt.setString(5, paramDto.getAddr2());
			pstmt.setString(6, paramDto.getAddr3());
			pstmt.setString(7, paramDto.getAddr4());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(HaksaMemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableName_1 +" SET phone = ?, parentPhone = ?, addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ? WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPhone());
			pstmt.setString(2, paramDto.getParentPhone());
			pstmt.setString(3, paramDto.getAddr1());
			pstmt.setString(4, paramDto.getAddr2());
			pstmt.setString(5, paramDto.getAddr3());
			pstmt.setString(6, paramDto.getAddr4());
			pstmt.setInt(7, paramDto.getHakbun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(HaksaMemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableName_1 +" WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getHakbun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//HaksaMemberDAO
