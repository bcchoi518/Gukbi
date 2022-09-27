package project.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.board.model.dto.BoardDTO;
import project.common.DB;

public class BoardDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getTotalRecord(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) totalRecord FROM board WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				sql += "AND (writer LIKE ? OR subject LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("writer")) {
				sql += "AND writer LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("subject")) {
				sql += "AND subject LIKE ? ";
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("writer")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			}//if
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("totalRecord");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getTotalRecord
	
	public int getMaxValue(String fieldName) {
		String tmp = DB.getCheckfieldName(fieldName);
		if (tmp == null || !tmp.equals(fieldName)) {
			return -1;
		}//if
		
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT NVL(MAX("+ fieldName +"), 0) maxValue FROM board";
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
	}//getMaxValue
	
	public ArrayList<BoardDTO> getSelectAll(BoardDTO paramDto) {
		ArrayList<BoardDTO> boardList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "";
			basicSql += "SELECT * FROM board WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				basicSql += "AND (writer LIKE ? OR subject LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("writer")) {
				basicSql += "AND writer LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("subject")) {
				basicSql += "AND subject LIKE ? ";
			}//if
			
			basicSql += "ORDER BY noticeNo DESC, refNo DESC, levelNo ASC";
			
			String subQuery = "SELECT rownum rnum, basic.* FROM ("+ basicSql +") basic";
			String sql = "SELECT * FROM ("+ subQuery +") WHERE rnum BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("writer")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
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
		BoardDTO boardDto = new BoardDTO();
		conn = DB.dbConn();
		try {
			String subQuery = "";
			subQuery += "SELECT b.*, ";
			subQuery += "LAG(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preNo, ";
			subQuery += "LAG(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) preSubject, ";
			subQuery += "LEAD(no) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtNo, ";
			subQuery += "LEAD(subject) OVER (ORDER BY noticeNo DESC, refNo DESC, levelNo ASC) nxtSubject ";
			subQuery += "FROM board b WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				subQuery += "AND (writer LIKE ? OR subject LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("writer")) {
				subQuery += "AND writer LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("subject")) {
				subQuery += "AND subject LIKE ? ";
			}//if
			
			subQuery += "ORDER BY noticeNo DESC, refNo DESC, levelNo ASC";
			
			String sql = "SELECT * FROM ("+ subQuery +") WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("writer_subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("writer")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("subject")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
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
	
	public int setInsert(BoardDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO board VALUES (seq_board.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
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
			String sql = "UPDATE board SET writer = ?, subject = ?, content = ?, email = ?, noticeNo = ?, secretGubun = ?, attachInfo = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getSubject());
			pstmt.setString(3, paramDto.getContent());
			pstmt.setString(4, paramDto.getEmail());
			pstmt.setInt(5, paramDto.getNoticeNo());
			pstmt.setString(6, paramDto.getSecretGubun());
			pstmt.setString(7, paramDto.getAttachInfo());
			pstmt.setInt(8, paramDto.getNo());
			pstmt.setString(9, paramDto.getPasswd());
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
	}//setUpdateHit
	
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