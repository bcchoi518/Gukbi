package board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import board.model.dto.BoardCommentDTO;
import board.model.dto.BoardDTO;
import config.DB;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public String fieldNameChecker(String fieldName) {
		if (fieldName == null) {
			return null;
		}//if
		
		fieldName = fieldName.replace(" ", "").replace(";", "");
		
		return fieldName;
	}//fieldNameChecker
	
	public ArrayList<BoardDTO> getSelectAll(BoardDTO paramDto) {
		String searchValue = "O";
		if (paramDto.getSearchGubun() == null || paramDto.getSearchGubun().trim().equals("")) { paramDto.setSearchGubun(""); }
		if (paramDto.getSearchData() == null || paramDto.getSearchData().trim().equals("")) { paramDto.setSearchData(""); }
		if (paramDto.getSearchGubun().trim().equals("") || paramDto.getSearchData().trim().equals("")) { 
			searchValue = "X";
			paramDto.setSearchGubun("");
			paramDto.setSearchData("");
		}//if
		
		ArrayList<BoardDTO> boardList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "SELECT * FROM board WHERE 1=1 ";
			
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					basicSql += "AND (writer LIKE ? OR subject LIKE ? OR content LIKE ?) ";
				} else {
					basicSql += "AND "+ fieldNameChecker(paramDto.getSearchGubun()) +" LIKE ? ";
				}//if
			}//if

			basicSql += "ORDER BY noticeNo DESC, refNo DESC, levelNo ASC";
			String rowSql = "SELECT rownum rowNumber, sortResult.* FROM ("+basicSql+") sortResult";
			String sql = "SELECT * FROM ("+rowSql+") WHERE rowNumber BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);

			int k = 0;
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				} else {
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				}//if
			}//if
			pstmt.setInt(++k, paramDto.getStartRecord());
			pstmt.setInt(++k, paramDto.getLastRecord());

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
		String searchValue = "O";
		if (paramDto.getSearchGubun() == null || paramDto.getSearchGubun().trim().equals("")) { paramDto.setSearchGubun(""); }
		if (paramDto.getSearchData() == null || paramDto.getSearchData().trim().equals("")) { paramDto.setSearchData(""); }
		if (paramDto.getSearchGubun().trim().equals("") || paramDto.getSearchData().trim().equals("")) { 
			searchValue = "X";
			paramDto.setSearchGubun("");
			paramDto.setSearchData("");
		}//if
		BoardDTO boardDto = new BoardDTO();
		conn = DB.dbConn();
		try {
			String subQuery = "SELECT b.*, ";
			subQuery += "LAG(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preNo, ";
			subQuery += "LAG(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preSubject, ";
			subQuery += "LEAD(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtNo, ";
			subQuery += "LEAD(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtSubject ";
			subQuery += "FROM board b ";
			subQuery += "WHERE 1 = 1 ";
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					subQuery += "AND (writer LIKE ? OR subject LIKE ? OR content LIKE ?) ";
				} else {
					subQuery += "AND "+ fieldNameChecker(paramDto.getSearchGubun()) +" LIKE ? ";
				}//if
			}//if
			subQuery += "ORDER BY noticeNo DESC, refNo DESC, levelNo ASC";
			
			String sql = "SELECT * FROM ("+ subQuery +") WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				} else {
					pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				}//if
			}//if
			pstmt.setInt(++k, paramDto.getNo());
			
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
				boardDto.setPreNo(rs.getInt("preNo"));
				boardDto.setPreSubject(rs.getString("preSubject"));
				boardDto.setNxtNo(rs.getInt("nxtNo"));
				boardDto.setNxtSubject(rs.getString("nxtSubject"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardDto;
	}//getSelectOne
	
	public int getCheckReply(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) count FROM board WHERE parentNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getCheckReply
	
	public int getTotalRecord(BoardDTO paramDto) {
		String searchValue = "O";
		if (paramDto.getSearchGubun() == null || paramDto.getSearchGubun().trim().equals("")) { paramDto.setSearchGubun(""); }
		if (paramDto.getSearchData() == null || paramDto.getSearchData().trim().equals("")) { paramDto.setSearchData(""); }
		if (paramDto.getSearchGubun().trim().equals("") || paramDto.getSearchData().trim().equals("")) { 
			searchValue = "X";
			paramDto.setSearchGubun("");
			paramDto.setSearchData("");
		}//if
		
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) recordCounter FROM board ";
			
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					sql += "WHERE (writer LIKE ? OR subject LIKE ? OR content LIKE ?)";
				} else {
					sql += "WHERE "+ fieldNameChecker(paramDto.getSearchGubun()) +" LIKE ?";
				}//if
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (paramDto.getSearchGubun().equals("writer_subject_content")) {
					pstmt.setString(1, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(2, '%'+ paramDto.getSearchData() +'%');
					pstmt.setString(3, '%'+ paramDto.getSearchData() +'%');
				} else {
					pstmt.setString(1, '%'+ paramDto.getSearchData() +'%');
				}//if
			}//if
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("recordCounter");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getTotalRecord
	
	public int getMaxValue(String gubun) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT NVL(MAX("+ fieldNameChecker(gubun) +"),0) maxValue FROM board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("maxValue");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getMaxNumRefNo

	public int setInsert(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO board "
					   + "VALUES (seq_board.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
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
	
	public ArrayList<BoardCommentDTO> getCommentSelectAll(BoardCommentDTO paramDto) {
		ArrayList<BoardCommentDTO> commentList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM boardComment WHERE boardNo = ? ORDER BY commentNo DESC";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getBoardNo());
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
				commentList.add(boardCommentDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return commentList;
	}//getCommentSelectAll
	
	public int setCommentInsert(BoardCommentDTO paramDto) {
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
	}//setCommentInsert
	
	public int setCommentUpdate(BoardCommentDTO paramDto) {
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
	}//setCommentUpdate
	
	public int setCommentDelete(BoardCommentDTO paramDto) {
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
	}//setCommentDelete
}//BoardDAO
