package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import member.model.dto.MemberDTO;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String tableName_1 = "member";
	
	public String tableNameChecker(String tableName) {
		if (tableName == null) {
			return null;
		}//if
		
		tableName = tableName.replace(" ", "").replace(";", "");
		
		return tableName;
	}//tableNameChecker
	
	public ArrayList<MemberDTO> getSelectAll(String searchGubun, String searchData) {
		ArrayList<MemberDTO> memberList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName_1) +" WHERE 1 = 1";
			
			if (searchGubun.equals("id")) {
				sql += " AND id LIKE ? ";
			} else if (searchGubun.equals("name")) {
				sql += " AND name LIKE ? ";
			} else if (searchGubun.equals("phone")) {
				sql += " AND phone LIKE ? ";
			} else if (searchGubun.equals("jumin")) {
				sql += " AND jumin LIKE ? ";
			} else if (searchGubun.equals("id_name_phone_jumin")) {
				sql += " AND (id LIKE ? OR name LIKE ? OR phone LIKE ? OR jumin LIKE ?) ";
			}//if
			
			sql += "ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
			
			if (searchGubun.equals("id")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("name")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("phone")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("jumin")) {
				pstmt.setString(1, '%' + searchData + '%');
			} else if (searchGubun.equals("id_name_phone_jumin")) {
				pstmt.setString(1, '%' + searchData + '%');
				pstmt.setString(2, '%' + searchData + '%');
				pstmt.setString(3, '%' + searchData + '%');
				pstmt.setString(4, '%' + searchData + '%');
			}//if
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO memberDto = new MemberDTO();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setJumin(rs.getString("jumin"));
				memberDto.setJuso1(rs.getString("juso1"));
				memberDto.setJuso2(rs.getString("juso2"));
				memberDto.setJuso3(rs.getString("juso3"));
				memberDto.setJuso4(rs.getString("juso4"));
				memberDto.setGrade(rs.getString("grade"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
				memberDto.setAttachInfo(rs.getString("attachInfo"));
				memberList.add(memberDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberList;
	}//getSelectAll
	
	public MemberDTO getSelectOne(MemberDTO paramDto) {
		MemberDTO memberDto = new MemberDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableNameChecker(tableName_1) +" WHERE no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPasswd(rs.getString("passwd"));
				memberDto.setName(rs.getString("name"));
				memberDto.setPhone(rs.getString("phone"));
				memberDto.setEmail(rs.getString("email"));
				memberDto.setJumin(rs.getString("jumin"));
				memberDto.setJuso1(rs.getString("juso1"));
				memberDto.setJuso2(rs.getString("juso2"));
				memberDto.setJuso3(rs.getString("juso3"));
				memberDto.setJuso4(rs.getString("juso4"));
				memberDto.setGrade(rs.getString("grade"));
				memberDto.setRegiDate(rs.getDate("regiDate"));
				memberDto.setAttachInfo(rs.getString("attachInfo"));
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberDto;
	}//getSelectOne
	
	public MemberDTO getLogin(MemberDTO paramDto) {
		MemberDTO memberDto = new MemberDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT no, name, grade FROM "+ tableNameChecker(tableName_1) +" WHERE id = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPasswd());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setNo(rs.getInt("no"));
				memberDto.setName(rs.getString("name"));
				memberDto.setGrade(rs.getString("grade"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberDto;
	}//getLogin
	
	public int setInsert(MemberDTO paramDto) {
		if (paramDto.getAttachInfo() == null) {
			paramDto.setAttachInfo("-");
		}//if
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableNameChecker(tableName_1) +" VALUES (seq_member.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?)";
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
			pstmt.setString(11, paramDto.getGrade());
			pstmt.setString(12, paramDto.getAttachInfo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableNameChecker(tableName_1) +" SET phone = ?, email = ?, juso1 = ?, juso2 = ?, juso3 = ?, juso4 = ?, grade = ? WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPhone());
			pstmt.setString(2, paramDto.getEmail());
			pstmt.setString(3, paramDto.getJuso1());
			pstmt.setString(4, paramDto.getJuso2());
			pstmt.setString(5, paramDto.getJuso3());
			pstmt.setString(6, paramDto.getJuso4());
			pstmt.setString(7, paramDto.getGrade());
			pstmt.setInt(8, paramDto.getNo());
			pstmt.setString(9, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableNameChecker(tableName_1) +" WHERE no = ? AND passwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			pstmt.setString(2, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//MemberDAO
