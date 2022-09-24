package project.guestBook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.common.DB;
import project.guestBook.model.dto.GuestBookDTO;

public class GuestBookDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getTotalRecord(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "";
			sql += "SELECT COUNT(*) totalRecord FROM guestBook WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("name_content")) {
				sql += "AND (name LIKE ? OR content LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("name")) {
				sql += "AND name LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("content")) {
				sql += "AND content LIKE ? ";
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			if (paramDto.getSearchGubun().equals("name_content")) {
				pstmt.setString(1, '%'+paramDto.getSearchData()+'%');
				pstmt.setString(2, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("name")) {
				pstmt.setString(1, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("content")) {
				pstmt.setString(1, '%'+paramDto.getSearchData()+'%');
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
	
	public ArrayList<GuestBookDTO> getSelectAll(GuestBookDTO paramDto) {
		ArrayList<GuestBookDTO> guestBookList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "";
			basicSql += "SELECT * FROM guestBook WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("name_content")) {
				basicSql += "AND (name LIKE ? OR content LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("name")) {
				basicSql += "AND name LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("content")) {
				basicSql += "AND content LIKE ? ";
			}//if
			
			basicSql += "ORDER BY no DESC";
			
			String sql = "";
			sql += "SELECT * FROM (SELECT basic.*, rownum rnum FROM (";
			sql += basicSql;
			sql += ") basic) WHERE rnum BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("name_content")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("name")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("content")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			}//if
			
			pstmt.setInt(++k, paramDto.getStartRecord());
			pstmt.setInt(++k, paramDto.getLastRecord());
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDTO guestBookDto = new GuestBookDTO();
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookList.add(guestBookDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return guestBookList;
	}//getSelectAll
	
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto) {
		GuestBookDTO guestBookDto = new GuestBookDTO();
		conn = DB.dbConn();
		try {
			String sql = "";
			sql += "SELECT * FROM (";
			sql += "SELECT g.*, ";
			
			sql += "LAG(no) OVER (ORDER BY no DESC) preNo, ";
			sql += "LAG(dbms_lob.substr(content, 30, 1)) OVER (ORDER BY no DESC) preContent, ";
			sql += "LEAD(no) OVER (ORDER BY no DESC) nxtNo, ";
			sql += "LEAD(dbms_lob.substr(content, 30, 1)) OVER  (ORDER BY no DESC) nxtContent ";
			
			sql += "FROM guestBook g WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("name_content")) {
				sql += "AND (name LIKE ? OR content LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("name")) {
				sql += "AND name LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("content")) {
				sql += "AND content LIKE ? ";
			}//if
			
			sql += "ORDER BY no DESC";
			sql += ") WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("name_content")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("name")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			} else if (paramDto.getSearchGubun().equals("content")) {
				pstmt.setString(++k, '%'+paramDto.getSearchData()+'%');
			}//if
			
			pstmt.setInt(++k, paramDto.getNo());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookDto.setPreNo(rs.getInt("preNo"));
				guestBookDto.setPreContent(rs.getString("preContent"));
				guestBookDto.setNxtNo(rs.getInt("nxtNo"));
				guestBookDto.setNxtContent(rs.getString("nxtContent"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return guestBookDto;
	}//getSelectOne
	
	public int setInsert(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO guestBook VALUES (seq_guestBook.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getPasswd());
			pstmt.setString(4, paramDto.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE guestBook SET name = ?, email = ?, content = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getContent());
			pstmt.setInt(4, paramDto.getNo());
			pstmt.setString(5, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(GuestBookDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM guestBook WHERE no = ? AND passwd = ?";
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
}//GuestBookDAO
