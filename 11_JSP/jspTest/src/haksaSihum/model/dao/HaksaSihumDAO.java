package haksaSihum.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import haksaSihum.model.dto.HaksaSihumDTO;

public class HaksaSihumDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private String tableName_1 = "haksaSihum";
	
	public ArrayList<HaksaSihumDTO> getSelectAll() {
		ArrayList<HaksaSihumDTO> sihumList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableName_1 +" ORDER BY regiDate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HaksaSihumDTO sihumDto = new HaksaSihumDTO();
				sihumDto.setSihumNo(rs.getInt("sihumNo"));
				sihumDto.setSihumName(rs.getString("sihumName"));
				sihumDto.setSihumDate(rs.getDate("sihumDate"));
				sihumDto.setRegiDate(rs.getDate("regiDate"));
				sihumList.add(sihumDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sihumList;
	}//getSelectAll
	
	public HaksaSihumDTO getSelectOne(HaksaSihumDTO paramDto) {
		HaksaSihumDTO sihumDto = new HaksaSihumDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableName_1 +" WHERE sihumNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSihumNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sihumDto.setSihumNo(rs.getInt("sihumNo"));
				sihumDto.setSihumName(rs.getString("sihumName"));
				sihumDto.setSihumDate(rs.getDate("sihumDate"));
				sihumDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sihumDto;
	}//getSelectOne
	
	public int setInsert(HaksaSihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_haksaSihum.NEXTVAL, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSihumName());
			pstmt.setDate(2, paramDto.getSihumDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(HaksaSihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableName_1 +" SET sihumName = ?, sihumDate = ? WHERE sihumNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSihumName());
			pstmt.setDate(2, paramDto.getSihumDate());
			pstmt.setInt(3, paramDto.getSihumNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(HaksaSihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableName_1 +" WHERE sihumNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSihumNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//HaksaSihumDAO
