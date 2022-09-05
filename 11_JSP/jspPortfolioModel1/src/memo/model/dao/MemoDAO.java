package memo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import memo.model.dto.MemoDTO;

public class MemoDAO {
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
	
	public ArrayList<MemoDTO> getSelectAll(String searchGubun, String searchData, int startRecord, int lastRecord) {
		String searchValue = "O";
		if (searchGubun.trim().equals("") || searchData.trim().equals("")) { 
			searchValue = "X";
		}//if
		ArrayList<MemoDTO> memoList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "SELECT * FROM memo WHERE 1 = 1";
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_content")) {
					basicSql += " AND (writer LIKE ? OR content LIKE ?) ";
				} else {
					basicSql += " AND "+ fieldNameChecker(searchGubun) +" LIKE ? ";
				}//if
			}//if
			
			basicSql += "ORDER BY no DESC";
			String rowSql = "SELECT rownum rowNumber, sortResult.* FROM ("+ basicSql +") sortResult";
			String sql = "SELECT * FROM ("+ rowSql +") WHERE rowNumber BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_content")) {
					pstmt.setString(1, '%'+searchData+'%');
					pstmt.setString(2, '%'+searchData+'%');
					pstmt.setInt(3, startRecord);
					pstmt.setInt(4, lastRecord);
				} else {
					pstmt.setString(1, '%'+searchData+'%');
					pstmt.setInt(2, startRecord);
					pstmt.setInt(3, lastRecord);
				}//if
			} else {
				pstmt.setInt(1, startRecord);
				pstmt.setInt(2, lastRecord);
			}//if
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemoDTO memoDto = new MemoDTO();
				memoDto.setNo(rs.getInt("no"));
				memoDto.setWriter(rs.getString("writer"));
				memoDto.setContent(rs.getString("content"));
				memoDto.setRegiDate(rs.getDate("regiDate"));
				memoList.add(memoDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memoList;
	}//getSelectAll
	
	public MemoDTO getSelectOne(MemoDTO paramDto) {
		MemoDTO memoDto = new MemoDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM memo WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memoDto.setNo(rs.getInt("no"));
				memoDto.setWriter(rs.getString("writer"));
				memoDto.setContent(rs.getString("content"));
				memoDto.setRegiDate(rs.getDate("regiDate"));
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memoDto;
	}//getSelectOne
	
	public int setInsert(MemoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO memo VALUES (seq_memo.NEXTVAL, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getContent());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(MemoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE memo SET writer = ?, content = ? WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setInt(3, paramDto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(MemoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM memo WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
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
			String sql = "SELECT COUNT(*) recordCounter FROM memo ";
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_content")) {
					sql += " WHERE (writer LIKE ? OR content LIKE ?) ";
				} else {
					sql += " WHERE "+ fieldNameChecker(searchGubun) +" LIKE ? ";
				}//if
			}//if
			
			sql += "ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			
			if (searchValue.equals("O")) {
				if (searchGubun.equals("writer_content")) {
					pstmt.setString(1, '%'+searchData+'%');
					pstmt.setString(2, '%'+searchData+'%');
				} else {
					pstmt.setString(1, '%'+searchData+'%');
				}//if
			}//if
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("recordCounter");
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//getTotalRecord
}//MemoDAO
