package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DB;
import model.dto.Application_testDTO;

public class Application_testDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getCheckChangeDate(Application_testDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT ROUND(MONTHS_BETWEEN(sysdate, changeDate)) changeDate FROM member WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("changeDate");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getCheckChangeDate
	
	public Application_testDTO getLogin(Application_testDTO paramDto) {
		Application_testDTO dto = new Application_testDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) resultCnt, id FROM member WHERE id = ? AND passwd = ? GROUP BY id";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setLoginResult(rs.getInt("resultCnt"));
				dto.setId(rs.getString("id"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return dto;
	}//getLogin
	
	public int setUpdatePasswd(Application_testDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE member SET passwd = ?, changeDate = SYSDATE WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPasswd());
			pstmt.setString(2, paramDto.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdatePasswd
}//Application_testDAO
