package project.memo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import project.common.DB;
import project.memo.model.dto.MemoDTO;

public class MemoDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int getTotalRecord(MemoDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "SELECT COUNT(*) totalRecord FROM memo WHERE 1=1 ";
			
			if (paramDto.getSearchGubun().equals("writer_content")) {
				sql += "AND (writer LIKE ? OR content LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("writer")) {
				sql += "AND writer LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("content")) {
				sql += "AND content LIKE ? ";
			}//if
			
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("writer_content")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("writer")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("content")) {
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
	
	public ArrayList<MemoDTO> getSelectAll(MemoDTO paramDto) {
		ArrayList<MemoDTO> memoList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String basicSql = "";
			basicSql += "SELECT * FROM memo WHERE 1=1 ";

			if (paramDto.getSearchGubun().equals("writer_content")) {
				basicSql += "AND (writer LIKE ? OR content LIKE ?) ";
			} else if (paramDto.getSearchGubun().equals("writer")) {
				basicSql += "AND writer LIKE ? ";
			} else if (paramDto.getSearchGubun().equals("content")) {
				basicSql += "AND content LIKE ? ";
			}//if
			
			basicSql += "ORDER BY no DESC";
			
			String subQuery = "SELECT rownum rnum, basic.* FROM ("+ basicSql +") basic";
			String sql = "SELECT * FROM ("+ subQuery +") WHERE rnum BETWEEN ? AND ?";
			
			pstmt = conn.prepareStatement(sql);
			
			int k = 0;
			if (paramDto.getSearchGubun().equals("writer_content")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("writer")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			} else if (paramDto.getSearchGubun().equals("content")) {
				pstmt.setString(++k, '%'+ paramDto.getSearchData() +'%');
			}//if
			
			pstmt.setInt(++k, paramDto.getStartRecord());
			pstmt.setInt(++k, paramDto.getLastRecord());
			
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
			}//if
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
}//MemoDAO
