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
	
	public String fieldNameChecker(String fieldName) {
		if (fieldName == null) {
			return null;
		}//if
		
		fieldName = fieldName.replace(" ", "").replace(";", "");
		
		return fieldName;
	}//fieldNameChecker
	
	public ArrayList<BoardBasicDTO> getSelectAll(String searchGubun, String searchData, int startRecord, int lastRecord) {
		String searchValue = "O";
		if (searchGubun.trim().equals("") || searchData.trim().equals("")) { 
			searchValue = "X";
		}//if
		ArrayList<BoardBasicDTO> boardBasicList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "";
			basicSql += "SELECT no, subject, writer, regiDate, hit, stepNo, memberNo, ip, parentNo ";
			basicSql += "FROM boardBasic ";
			basicSql += "WHERE 1 = 1 ";
		   
		    if (searchValue.equals("O")) {
		    	if (searchGubun.equals("writer_subject_content")) {
		    		basicSql += "AND (writer LIKE ? OR subject LIKE ? OR content LIKE ?) ";
		    	} else {
		    		basicSql += "AND "+ fieldNameChecker(searchGubun) +" LIKE ?";
		    	}//if
		    }//if
				   
		    basicSql += "ORDER BY refNo DESC, levelNo ASC";
		    String rowSql = "SELECT rownum rowNumber, sortResult.* FROM ("+basicSql+") sortResult";
			String sql = "SELECT * FROM ("+rowSql+") WHERE rowNumber BETWEEN ? AND ?";   
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_subject_content")) {
					pstmt.setString(1, '%'+ searchData +'%');
					pstmt.setString(2, '%'+ searchData +'%');
					pstmt.setString(3, '%'+ searchData +'%');
					pstmt.setInt(4, startRecord);
					pstmt.setInt(5, lastRecord);
				} else {
					pstmt.setString(1, '%'+ searchData +'%');
					pstmt.setInt(2, startRecord);
					pstmt.setInt(3, lastRecord);
				}//if
			} else {
				pstmt.setInt(1, startRecord);
				pstmt.setInt(2, lastRecord);
			}//if
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardBasicDTO boardBasicDto = new BoardBasicDTO();
				boardBasicDto.setNo(rs.getInt("no"));
				boardBasicDto.setSubject(rs.getString("subject"));
				boardBasicDto.setWriter(rs.getString("writer"));
				boardBasicDto.setRegiDate(rs.getDate("regiDate"));
				boardBasicDto.setHit(rs.getInt("hit"));
				boardBasicDto.setStepNo(rs.getInt("stepNo"));
				boardBasicDto.setMemberNo(rs.getInt("memberNo"));
				boardBasicDto.setIp(rs.getString("ip"));
				boardBasicDto.setParentNo(rs.getInt("parentNo"));
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
			String sql = "SELECT * FROM boardBasic WHERE no = ?";
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
				boardBasicDto.setMemberNo(rs.getInt("memberNo"));
				boardBasicDto.setIp(rs.getString("ip"));
				boardBasicDto.setParentNo(rs.getInt("parentNo"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return boardBasicDto;
	}//getSelectOne
	
	public int getTotalRecord(String searchGubun, String searchData) {
		String searchValue = "O";
		if (searchGubun.trim().equals("") || searchData.trim().equals("")) { 
			searchValue = "X";
		}//if
		
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) recordCounter FROM boardBasic ";
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_subject_content")) {
					sql += "WHERE (writer LIKE ? OR subject LIKE ? OR content LIKE ?)";
				} else {
					sql += "WHERE "+ fieldNameChecker(searchGubun) +" LIKE ?";
				}//if
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_subject_content")) {
					pstmt.setString(1, '%'+ searchData +'%');
					pstmt.setString(2, '%'+ searchData +'%');
					pstmt.setString(3, '%'+ searchData +'%');
				} else {
					pstmt.setString(1, '%'+ searchData +'%');
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
			String sql = "INSERT INTO boardBasic VALUES (seq_boardBasic.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?)";
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
			pstmt.setInt(11, paramDto.getMemberNo());
			pstmt.setString(12, paramDto.getIp());
			pstmt.setInt(13, paramDto.getParentNo());
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
			String sql = "UPDATE boardBasic SET writer = ?, subject = ?, content = ?, email = ? WHERE no = ? AND passwd = ?";
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
			String sql = "UPDATE boardBasic SET hit = (hit + 1) WHERE no = ?";
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
			String sql = "DELETE FROM boardBasic WHERE no = ? AND passwd = ?";
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
