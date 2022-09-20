package _test.haksa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.haksa.model.dto.StudentDTO;

public class StudentDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<StudentDTO> getSelectAll() {
		ArrayList<StudentDTO> studentList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM haksaMember ORDER BY hakbun DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StudentDTO studentDto = new StudentDTO();
				studentDto.setHakbun(rs.getInt("hakbun"));
				studentDto.setName(rs.getString("name"));
				studentDto.setPhone(rs.getString("phone"));
				studentDto.setParentPhone(rs.getString("parentPhone"));
				studentDto.setAddr1(rs.getString("addr1"));
				studentDto.setAddr2(rs.getString("addr2"));
				studentDto.setAddr3(rs.getString("addr3"));
				studentDto.setAddr4(rs.getString("addr4"));
				studentDto.setRegiDate(rs.getDate("regiDate"));
				studentList.add(studentDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return studentList;
	}//getSelectAll
	
	public StudentDTO getSelectOne(StudentDTO paramDto) {
		StudentDTO studentDto = new StudentDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM haksaMember WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getHakbun());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				studentDto.setHakbun(rs.getInt("hakbun"));
				studentDto.setName(rs.getString("name"));
				studentDto.setPhone(rs.getString("phone"));
				studentDto.setParentPhone(rs.getString("parentPhone"));
				studentDto.setAddr1(rs.getString("addr1"));
				studentDto.setAddr2(rs.getString("addr2"));
				studentDto.setAddr3(rs.getString("addr3"));
				studentDto.setAddr4(rs.getString("addr4"));
				studentDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return studentDto;
	}//getSelectOne
	
	public int setInsert(StudentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO haksaMember VALUES (seq_haksaMember.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getPhone());
			pstmt.setString(3, paramDto.getParentPhone());
			pstmt.setString(4, paramDto.getAddr1());
			pstmt.setString(5, paramDto.getAddr2());
			pstmt.setString(6, paramDto.getAddr3());
			pstmt.setString(7, paramDto.getAddr4());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(StudentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE haksaMember SET phone = ?, parentPhone = ?, addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ? WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getPhone());
			pstmt.setString(2, paramDto.getParentPhone());
			pstmt.setString(3, paramDto.getAddr1());
			pstmt.setString(4, paramDto.getAddr2());
			pstmt.setString(5, paramDto.getAddr3());
			pstmt.setString(6, paramDto.getAddr4());
			pstmt.setInt(7, paramDto.getHakbun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(StudentDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM haksaMember WHERE hakbun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getHakbun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//StudentDAO