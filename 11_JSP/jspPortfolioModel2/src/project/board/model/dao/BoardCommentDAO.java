package project.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.board.model.dto.BoardCommentDTO;
import project.common.DB;

public class BoardCommentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardCommentDTO> getSelectAll() {
		ArrayList<BoardCommentDTO> boardCommentList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM boardComment ORDER BY commentNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardCommentDTO boardCommentDto = new BoardCommentDTO();
				boardCommentDto.setCommentNo(rs.getInt("commentNo"));
				boardCommentDto.setBoardNo(rs.getInt("boardNo"));
				boardCommentDto.setWriter(rs.getString("writer"));
				boardCommentDto.setContent(rs.getString("content"));
				boardCommentDto.setPasswd(rs.getString("passwd"));
				boardCommentDto.setMemberNo(rs.getInt("memberNo"));
				boardCommentDto.setIp(rs.getString("ip"));
				boardCommentDto.setRegiDate(rs.getDate("regiDate"));
				boardCommentList.add(boardCommentDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardCommentList;
	}//getSelectAll
	
	public BoardCommentDTO getSelectOne(BoardCommentDTO paramDto) {
		BoardCommentDTO boardCommentDto = new BoardCommentDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM boardComment WHERE commentNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getCommentNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardCommentDto.setCommentNo(rs.getInt("commentNo"));
				boardCommentDto.setBoardNo(rs.getInt("boardNo"));
				boardCommentDto.setWriter(rs.getString("writer"));
				boardCommentDto.setContent(rs.getString("content"));
				boardCommentDto.setPasswd(rs.getString("passwd"));
				boardCommentDto.setMemberNo(rs.getInt("memberNo"));
				boardCommentDto.setIp(rs.getString("ip"));
				boardCommentDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardCommentDto;
	}//getSelectOne
	
	public int setInsert(BoardCommentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO boardComment VALUES (seq_boardComment.NEXTVAL, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBoardNo());
			pstmt.setString(2, paramDto.getWriter());
			pstmt.setString(3, paramDto.getContent());
			pstmt.setString(4, paramDto.getPasswd());
			pstmt.setInt(5, paramDto.getMemberNo());
			pstmt.setString(6, paramDto.getIp());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BoardCommentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE boardComment SET writer = ?, content = ? WHERE commentNo = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setInt(3, paramDto.getCommentNo());
			pstmt.setString(4, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(BoardCommentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM boardComment WHERE commentNo = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getCommentNo());
			pstmt.setString(2, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//BoardCommentDAO