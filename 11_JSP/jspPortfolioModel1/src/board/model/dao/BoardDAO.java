package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.dto.BoardDTO;
import config.DB;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<BoardDTO> getSelectAll() {
		ArrayList<BoardDTO> boardList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * "
					   + "FROM board "
					   + "ORDER BY refNo DESC, levelNo ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDTO boardDto = new BoardDTO();
				boardDto.setNo(rs.getInt("no"));
				boardDto.setNum(rs.getInt("num"));
				boardDto.setTbl(rs.getString("tbl"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setPasswd(rs.getString("passwd"));
				boardDto.setRefNo(rs.getInt("refNo"));
				boardDto.setStepNo(rs.getInt("stepNo"));
				boardDto.setLevelNo(rs.getInt("levelNo"));
				boardDto.setParentNo(rs.getInt("parentNo"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setIp(rs.getString("ip"));
				boardDto.setMemberNo(rs.getInt("memberNo"));
				boardDto.setNoticeNo(rs.getInt("noticeNo"));
				boardDto.setSecretGubun(rs.getString("secretGubun"));
				boardDto.setRegiDate(rs.getDate("regiDate"));
				boardDto.setAttachInfo(rs.getString("attachInfo"));
				boardList.add(boardDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardList;
	}//getSelectAll
	
	public BoardDTO getSelectOne(BoardDTO paramDto) {
		BoardDTO boardDto = new BoardDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM board WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardDto.setNo(rs.getInt("no"));
				boardDto.setNum(rs.getInt("num"));
				boardDto.setTbl(rs.getString("tbl"));
				boardDto.setWriter(rs.getString("writer"));
				boardDto.setSubject(rs.getString("subject"));
				boardDto.setContent(rs.getString("content"));
				boardDto.setEmail(rs.getString("email"));
				boardDto.setPasswd(rs.getString("passwd"));
				boardDto.setRefNo(rs.getInt("refNo"));
				boardDto.setStepNo(rs.getInt("stepNo"));
				boardDto.setLevelNo(rs.getInt("levelNo"));
				boardDto.setParentNo(rs.getInt("parentNo"));
				boardDto.setHit(rs.getInt("hit"));
				boardDto.setIp(rs.getString("ip"));
				boardDto.setMemberNo(rs.getInt("memberNo"));
				boardDto.setNoticeNo(rs.getInt("noticeNo"));
				boardDto.setSecretGubun(rs.getString("secretGubun"));
				boardDto.setRegiDate(rs.getDate("regiDate"));
				boardDto.setAttachInfo(rs.getString("attachInfo"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardDto;
	}//getSelectOne
	
	public int getMaxNum() {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT NVL(max(num),0) max FROM board";
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
			String sql = "SELECT NVL(max(refNo),0) refNo FROM board";
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
	
	public int setInsert(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO board "
					   + "VALUES (seq_board.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? SYSDATE, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNum());
			pstmt.setString(2, paramDto.getTbl());
			pstmt.setString(3, paramDto.getWriter());
			pstmt.setString(4, paramDto.getSubject());
			pstmt.setString(5, paramDto.getContent());
			pstmt.setString(6, paramDto.getEmail());
			pstmt.setString(7, paramDto.getPasswd());
			pstmt.setInt(8, paramDto.getRefNo());
			pstmt.setInt(9, paramDto.getStepNo());
			pstmt.setInt(10, paramDto.getLevelNo());
			pstmt.setInt(11, paramDto.getParentNo());
			pstmt.setInt(12, paramDto.getHit());
			pstmt.setString(13, paramDto.getIp());
			pstmt.setInt(14, paramDto.getMemberNo());
			pstmt.setInt(15, paramDto.getNoticeNo());
			pstmt.setString(16, paramDto.getSecretGubun());
			pstmt.setString(17, paramDto.getAttachInfo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE board "
					   + "SET subject = ?, content = ?, email = ?, noticeNo = ?, secretGubun = ?, AttachInfo = ? "
					   + "WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setString(3, paramDto.getEmail());
			pstmt.setInt(4, paramDto.getNoticeNo());
			pstmt.setString(5, paramDto.getSecretGubun());
			pstmt.setString(6, paramDto.getAttachInfo());
			pstmt.setInt(7, paramDto.getNo());
			pstmt.setString(8, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public void setUpdateHit(BoardDTO paramDto) {
		conn = DB.dbConn();
		try {
			String sql = "UPDATE board SET hit = (hit + 1) WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
	}//setHitUpdate

	public void setUpdateReLevel(BoardDTO paramDto) {
		conn = DB.dbConn();
		try {
			String sql = "UPDATE board SET levelNo = (levelNo + 1) WHERE refNo = ? AND levelNo > ?";
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
	
	public int setDelete(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM board WHERE no = ? AND passwd = ?";
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
}//BoardDAO
