package _test.factory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.factory.model.dto.PositionDTO;

public class PositionDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<PositionDTO> getSelectAll() {
		ArrayList<PositionDTO> positionList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM position ORDER BY positionNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PositionDTO positionDto = new PositionDTO();
				positionDto.setPositionNo(rs.getInt("positionNo"));
				positionDto.setPositionName(rs.getString("positionName"));
				positionDto.setRegiDate(rs.getDate("regiDate"));
				positionList.add(positionDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return positionList;
	}//getSelectAll
	
	public PositionDTO getSelectOne(PositionDTO paramDto) {
		PositionDTO positionDto = new PositionDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM position WHERE positionNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getPositionNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				positionDto.setPositionNo(rs.getInt("positionNo"));
				positionDto.setPositionName(rs.getString("positionName"));
				positionDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return positionDto;
	}//getSelectOne
	
	public int setInsert(PositionDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO position VALUES (seq_position.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPositionName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(PositionDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE position SET positionName = ? WHERE positionNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPositionName());
			pstmt.setInt(2, paramDto.getPositionNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(PositionDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM position WHERE positionNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getPositionNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//PositionDAO
