package memberBasic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;

public class MemberBasicDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<MemberBasicDTO> getSelectAll() {
		ArrayList<MemberBasicDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM memberBasic ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberBasicDTO dto = new MemberBasicDTO();
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setJumin(rs.getString("jumin"));
				dto.setJuso1(rs.getString("juso1"));
				dto.setJuso2(rs.getString("juso2"));
				dto.setJuso3(rs.getString("juso3"));
				dto.setJuso4(rs.getString("juso4"));
				dto.setRegiDate(rs.getDate("regiDate"));
				
				list.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectAll
	
	public MemberBasicDTO getSelectOne(MemberBasicDTO paramDto) {
		MemberBasicDTO dto = new MemberBasicDTO();
		try {
			conn = DB.dbConn();
			String sql = "SELECT * FROM memberBasic WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setId(rs.getString("id"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setJumin(rs.getString("jumin"));
				dto.setJuso1(rs.getString("juso1"));
				dto.setJuso2(rs.getString("juso2"));
				dto.setJuso3(rs.getString("juso3"));
				dto.setJuso4(rs.getString("juso4"));
				dto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return dto;
	}//getSelectOne
	
	public int setInsert(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "INSERT INTO memberBasic VALUES (seq_memberBasic.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			pstmt.setString(3, paramDto.getName());
			pstmt.setString(4, paramDto.getPhone());
			pstmt.setString(5, paramDto.getEmail());
			pstmt.setString(6, paramDto.getJumin());
			pstmt.setString(7, paramDto.getJuso1());
			pstmt.setString(8, paramDto.getJuso2());
			pstmt.setString(9, paramDto.getJuso3());
			pstmt.setString(10, paramDto.getJuso4());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "UPDATE memberBasic SET phone = ?, email = ?, jumin = ?, juso1 = ?, juso2 = ?, juso3 = ?, juso4 = ? WHERE id = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPhone());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getJumin());
			pstmt.setString(4, paramDto.getJuso1());
			pstmt.setString(5, paramDto.getJuso2());
			pstmt.setString(6, paramDto.getJuso3());
			pstmt.setString(7, paramDto.getJuso4());
			pstmt.setString(8, paramDto.getId());
			pstmt.setString(9, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(MemberBasicDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "DELETE FROM memberBasic WHERE id = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//MemberBasicDAO
