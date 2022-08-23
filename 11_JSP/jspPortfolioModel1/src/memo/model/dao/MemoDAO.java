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
	String tableName = "memo";
	
	public String tableNameChecker(String tableName) {
		if (tableName == null) {
			return null;
		}//if
		
		tableName = tableName.replace(" ", "").replace(";", "");
		
		return tableName;
	}//tableNameChecker
	
	public ArrayList<MemoDTO> getSelectAll(String searchGubun, String searchData) {
		ArrayList<MemoDTO> memoList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName) +" WHERE 1 = 1";
			
			if (searchGubun.equals("writer")) {
				sql += " AND writer LIKE ? ";
			} else if (searchGubun.equals("content")) {
				sql += " AND content LIKE ? ";
			} else if (searchGubun.equals("writer_content")) {
				sql += " AND (writer LIKE ? OR content LIKE ?) ";
			}//if
			
			sql += "ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			
			if (searchGubun.equals("writer")) {
				pstmt.setString(1, '%'+searchData+'%');
			} else if (searchGubun.equals("content")) {
				pstmt.setString(1, '%'+searchData+'%');
			} else if (searchGubun.equals("writer_content")) {
				pstmt.setString(1, '%'+searchData+'%');
				pstmt.setString(2, '%'+searchData+'%');
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
			String sql = "SELECT * FROM "+ tableNameChecker(tableName) +" WHERE no = ?";
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
			String sql = "INSERT INTO "+ tableNameChecker(tableName) +" VALUES (seq_memo.NEXTVAL, ?, ?, SYSDATE)";
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
			String sql = "UPDATE "+ tableNameChecker(tableName) +" SET writer = ?, content = ? WHERE no = ?";
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
			String sql = "DELETE FROM "+ tableNameChecker(tableName) +" WHERE no = ?";
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
}//MemoDAO
