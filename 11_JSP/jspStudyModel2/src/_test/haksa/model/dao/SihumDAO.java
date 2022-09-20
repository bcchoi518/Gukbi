package _test.haksa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.haksa.model.dto.SihumDTO;

public class SihumDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<SihumDTO> getSelectAll() {
		ArrayList<SihumDTO> sihumList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM haksaSihum ORDER BY sihumNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SihumDTO sihumDto = new SihumDTO();
				sihumDto.setSihumNo(rs.getInt("sihumNo"));
				sihumDto.setSihumName(rs.getString("sihumName"));
				sihumDto.setSihumDate(rs.getDate("sihumDate"));
				sihumDto.setRegiDate(rs.getDate("regiDate"));
				sihumList.add(sihumDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sihumList;
	}//getSelectAll
	
	public SihumDTO getSelectOne(SihumDTO paramDto) {
		SihumDTO sihumDto = new SihumDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM haksaSihum WHERE sihumNo = ?";
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
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sihumDto;
	}//getSelectOne
	
	public int setInsert(SihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO haksaSihum VALUES (seq_haksaSihum.NEXTVAL, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSihumName());
			pstmt.setDate(2, paramDto.getSihumDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(SihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE haksaSihum SET sihumName = ?, sihumDate = ? WHERE sihumNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSihumName());
			pstmt.setDate(2, paramDto.getSihumDate());
			pstmt.setInt(3, paramDto.getSihumNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(SihumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM haksaSihum WHERE sihumNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSihumNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//SihumDAO