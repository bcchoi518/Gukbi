package _test.factory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.factory.model.dto.BuseoDTO;

public class BuseoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BuseoDTO> getSelectAll() {
		ArrayList<BuseoDTO> buseoList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM buseo ORDER BY buseoNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BuseoDTO buseoDto = new BuseoDTO();
				buseoDto.setBuseoNo(rs.getInt("buseoNo"));
				buseoDto.setBuseoName(rs.getString("buseoName"));
				buseoDto.setRegiDate(rs.getDate("regiDate"));
				buseoList.add(buseoDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return buseoList;
	}//getSelectAll
	
	public BuseoDTO getSelectOne(BuseoDTO paramDto) {
		BuseoDTO buseoDto = new BuseoDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM buseo WHERE buseoNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBuseoNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				buseoDto.setBuseoNo(rs.getInt("buseoNo"));
				buseoDto.setBuseoName(rs.getString("buseoName"));
				buseoDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return buseoDto;
	}//getSelectOne
	
	public int setInsert(BuseoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO buseo VALUES (seq_buseo.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getBuseoName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BuseoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE buseo SET buseoName = ? WHERE buseoNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getBuseoName());
			pstmt.setInt(2, paramDto.getBuseoNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BuseoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM buseo WHERE buseoNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBuseoNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BuseoDAO
