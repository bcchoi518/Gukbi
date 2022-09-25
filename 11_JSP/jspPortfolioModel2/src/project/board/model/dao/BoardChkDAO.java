package project.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.board.model.dto.BoardChkDTO;
import project.common.DB;

public class BoardChkDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardChkDTO> getSelectAll() {
		ArrayList<BoardChkDTO> boardChkList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM boardChk ORDER BY boardChkNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardChkDTO boardChkDto = new BoardChkDTO();
				boardChkDto.setBoardChkNo(rs.getInt("boardChkNo"));
				boardChkDto.setTbl(rs.getString("tbl"));
				boardChkDto.setTblName(rs.getString("tblName"));
				boardChkDto.setRegiDate(rs.getDate("regiDate"));
				boardChkList.add(boardChkDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardChkList;
	}//getSelectAll
	
	public BoardChkDTO getSelectOne(BoardChkDTO paramDto) {
		BoardChkDTO boardChkDto = new BoardChkDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM boardChk WHERE boardChkNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBoardChkNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardChkDto.setBoardChkNo(rs.getInt("boardChkNo"));
				boardChkDto.setTbl(rs.getString("tbl"));
				boardChkDto.setTblName(rs.getString("tblName"));
				boardChkDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardChkDto;
	}//getSelectOne
	
	public int setInsert(BoardChkDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO boardChk VALUES (seq_boardChk.NEXTVAL, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getTbl());
			pstmt.setString(2, paramDto.getTblName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BoardChkDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE boardChk SET tbl = ?, tblName = ? WHERE boardChkNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getTbl());
			pstmt.setString(2, paramDto.getTblName());
			pstmt.setInt(3, paramDto.getBoardChkNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BoardChkDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM boardChk WHERE boardChkNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBoardChkNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BoardChkDAO