package guestBook.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import guestBook.model.dto.GuestBookDTO;

public class GuestBookDAO {
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
	
	public ArrayList<GuestBookDTO> getSelectAll(String searchGubun, String searchData, int startRecord, int lastRecord) {
		String searchValue = "O";
		if (searchGubun.trim().equals("") || searchData.trim().equals("")) { 
			searchValue = "X";
		}//if
		ArrayList<GuestBookDTO> guestBookList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "SELECT * FROM guestBook WHERE 1 = 1";
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("name_content")) {
					// 연산자는 가까운거 혹은 좁은것이 우선시 된다
					basicSql += " AND (name LIKE ? OR content LIKE ?) ";
				} else {
					basicSql += " AND "+ fieldNameChecker(searchGubun) +" LIKE ? ";
				}//if
			}//if
			
			basicSql += "ORDER BY no DESC";
			String rowSql = "SELECT rownum rowNumber, sortResult.* FROM ("+basicSql+") sortResult";
			String sql = "SELECT * FROM ("+rowSql+") WHERE rowNumber BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			if (searchValue.equals("O")) {
				if (searchGubun.equals("name_content")) {
					pstmt.setString(1, '%' + searchData + '%');
					pstmt.setString(2, '%' + searchData + '%');
					pstmt.setInt(3, startRecord);
					pstmt.setInt(4, lastRecord);
				} else {
					pstmt.setString(1, '%' + searchData + '%');
					pstmt.setInt(2, startRecord);
					pstmt.setInt(3, lastRecord);
				}//if
			} else {
				pstmt.setInt(1, startRecord);
				pstmt.setInt(2, lastRecord);
			}//if
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDTO guestBookDto = new GuestBookDTO();
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookDto.setMemberNo(rs.getInt("memberNo"));
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
			String sql = "SELECT * FROM guestBook WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setName(rs.getString("name"));
				guestBookDto.setEmail(rs.getString("email"));
				guestBookDto.setPasswd(rs.getString("passwd"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				guestBookDto.setMemberNo(rs.getInt("memberNo"));
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
			String sql = "INSERT INTO guestBook VALUES (seq_guestBook.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getPasswd());
			pstmt.setString(4, paramDto.getContent());
			pstmt.setInt(5, paramDto.getMemberNo());
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
			String sql = "UPDATE guestBook SET email = ?, content = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getEmail());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setInt(3, paramDto.getNo());
			pstmt.setString(4, paramDto.getPasswd());
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

	public int getTotalRecord(String searchGubun, String searchData) {
		String searchValue = "O";
		if (searchGubun.trim().equals("") || searchData.trim().equals("")) { 
			searchValue = "X";
		}//if
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) recordCounter FROM guestBook";
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("name_content")) {
					// 연산자는 가까운거 혹은 좁은것이 우선시 된다
					sql += " WHERE (name LIKE ? OR content LIKE ?) ";
				} else {
					sql += " WHERE "+ fieldNameChecker(searchGubun) +" LIKE ? ";
				}//if
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("name_content")) {
					pstmt.setString(1, '%'+ searchData +'%');
					pstmt.setString(2, '%'+ searchData +'%');
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
}//GuestBookDAO