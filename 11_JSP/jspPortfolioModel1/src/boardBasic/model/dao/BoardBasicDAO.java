package boardBasic.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import boardBasic.model.dto.BoardBasicDTO;
import config.DB;

public class BoardBasicDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String tableName = "boardBasic";
	
	public String tableNameChecker(String tableName) {
		if (tableName == null) {
			return null;
		}//if
		
		tableName = tableName.replace(" ", "").replace(";", "");
		
		return tableName;
	}//tableNameChecker
	
	public ArrayList<BoardBasicDTO> getSelectAll() {
		ArrayList<BoardBasicDTO> boardBasicList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT no, subject, writer, regiDate, hit, stepNo FROM "+ tableNameChecker(tableName) +" ORDER BY refNo DESC, levelNo ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBasicDTO boardBasicDto = new BoardBasicDTO();
				boardBasicDto.setNo(rs.getInt("no"));
				boardBasicDto.setSubject(rs.getString("subject"));
				boardBasicDto.setWriter(rs.getString("writer"));
				boardBasicDto.setRegiDate(rs.getDate("regiDate"));
				boardBasicDto.setHit(rs.getInt("hit"));
				boardBasicDto.setStepNo(rs.getInt("stepNo"));
				boardBasicList.add(boardBasicDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardBasicList;
	}//getSelectAll
	
	public BoardBasicDTO getSelectOne(BoardBasicDTO paramDto) {
		BoardBasicDTO boardBasicDto = new BoardBasicDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName) +" WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardBasicDto.setNo(rs.getInt("no"));
				boardBasicDto.setNum(rs.getInt("num"));
				boardBasicDto.setWriter(rs.getString("writer"));
				boardBasicDto.setSubject(rs.getString("subject"));
				boardBasicDto.setContent(rs.getString("content"));
				boardBasicDto.setEmail(rs.getString("email"));
				boardBasicDto.setPasswd(rs.getString("passwd"));
				boardBasicDto.setRefNo(rs.getInt("refNo"));
				boardBasicDto.setStepNo(rs.getInt("stepNo"));
				boardBasicDto.setLevelNo(rs.getInt("levelNo"));
				boardBasicDto.setHit(rs.getInt("hit"));
				boardBasicDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardBasicDto;
	}//getSelectOne
	
	public int getMaxNum() {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT NVL(max(num),0) max FROM boardbasic";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("max");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getMaxNum

	public int getMaxRefNo() {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT NVL(max(refNo),0) refNo FROM boardbasic";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("refNo");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getMaxRefNo
	
	public int setInsert(BoardBasicDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableNameChecker(tableName) +" VALUES (seq_boardBasic.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNum());
			pstmt.setString(2, paramDto.getWriter());
			pstmt.setString(3, paramDto.getSubject());
			pstmt.setString(4, paramDto.getContent());
			pstmt.setString(5, paramDto.getEmail());
			pstmt.setString(6, paramDto.getPasswd());
			pstmt.setInt(7, paramDto.getRefNo());
			pstmt.setInt(8, paramDto.getStepNo());
			pstmt.setInt(9, paramDto.getLevelNo());
			pstmt.setInt(10, paramDto.getHit());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BoardBasicDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableNameChecker(tableName) +" SET writer = ?, subject = ?, content = ?, email = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getSubject());
			pstmt.setString(3, paramDto.getContent());
			pstmt.setString(4, paramDto.getEmail());
			pstmt.setInt(5, paramDto.getNo());
			pstmt.setString(6, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public void setUpdateHit(BoardBasicDTO paramDto) {
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableNameChecker(tableName) +" SET hit = (hit + 1) WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
	}//setHitUpdate

	public void setUpdateReLevel(BoardBasicDTO paramDto) {
		conn = DB.dbConn();
		try {
			String sql = "UPDATE boardBasic SET levelNo = (levelNo + 1) WHERE refNo = ? AND levelNo > ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getRefNo());
			pstmt.setInt(2, paramDto.getLevelNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
	}//setUpdateReLevel
	
	public int setDelete(BoardBasicDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableNameChecker(tableName) +" WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			pstmt.setString(2, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BoardBasicDAO
