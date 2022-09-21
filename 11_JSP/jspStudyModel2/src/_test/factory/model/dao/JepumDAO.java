package _test.factory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.factory.model.dto.JepumDTO;

public class JepumDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<JepumDTO> getSelectAll() {
		ArrayList<JepumDTO> jepumList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM jepum ORDER BY code DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JepumDTO jepumDto = new JepumDTO();
				jepumDto.setCode(rs.getString("code"));
				jepumDto.setName(rs.getString("name"));
				jepumDto.setStandard(rs.getString("standard"));
				jepumDto.setUnit(rs.getString("unit"));
				jepumDto.setBarcode(rs.getString("barcode"));
				jepumDto.setWdate(rs.getDate("wdate"));
				jepumList.add(jepumDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return jepumList;
	}//getSelectAll
	
	public JepumDTO getSelectOne(JepumDTO paramDto) {
		JepumDTO jepumDto = new JepumDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM jepum WHERE code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getCode());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				jepumDto.setCode(rs.getString("code"));
				jepumDto.setName(rs.getString("name"));
				jepumDto.setStandard(rs.getString("standard"));
				jepumDto.setUnit(rs.getString("unit"));
				jepumDto.setBarcode(rs.getString("barcode"));
				jepumDto.setWdate(rs.getDate("wdate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return jepumDto;
	}//getSelectOne
	
	public int setInsert(JepumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO jepum VALUES (?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getCode());
			pstmt.setString(2, paramDto.getName());
			pstmt.setString(3, paramDto.getStandard());
			pstmt.setString(4, paramDto.getUnit());
			pstmt.setString(5, paramDto.getBarcode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(JepumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE jepum SET name = ?, standard = ?, unit = ?, barcode = ? WHERE code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getStandard());
			pstmt.setString(3, paramDto.getUnit());
			pstmt.setString(4, paramDto.getBarcode());
			pstmt.setString(5, paramDto.getCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(JepumDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM jepum WHERE code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//JepumDAO
