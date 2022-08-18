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
	
	public ArrayList<MemberDTO> getSelectAll() {
		ArrayList<MemberDTO> memberList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM "+ tableName_1 +" ORDER BY no DESC";
			pstmt = conn.prepareStatement(sql);
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
			String sql = "SELECT * FROM "+ tableName_1 +" WHERE no = ?";
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
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return memberDto;
	}//getSelectOne
	
	public int setInsert(MemberDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" (no, id, passwd, name, phone, email, jumin, juso1, juso2, juso3, juso4, grade, regiDate) VALUES (seq_member.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
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
			String sql = "UPDATE "+ tableName_1 +" SET phone = ?, email = ?, juso1 = ?, juso2 = ?, juso3 = ?, juso4 = ?, grade = ? WHERE no = ? AND passwd = ?";
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
			String sql = "DELETE FROM "+ tableName_1 +" WHERE no = ? AND passwd = ?";
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
