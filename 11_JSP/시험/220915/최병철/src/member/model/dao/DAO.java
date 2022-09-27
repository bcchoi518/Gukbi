package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.Db;
import member.model.dto.DTO;

public class DAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int setInsert(DTO paramDto) {
		int result = 0;
		conn = Db.getDbConnection();
		try {
			String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getId());
			pstmt.setString(2, paramDto.getPwd());
			pstmt.setString(3, paramDto.getName());
			pstmt.setString(4, paramDto.getPhone());
			pstmt.setString(5, paramDto.getJob());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Db.dbClose(conn, pstmt, rs);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public ArrayList<DTO> getSelectAll() {
		ArrayList<DTO> memberList = new ArrayList<>();
		conn = Db.getDbConnection();
		try {
			String sql = "SELECT * FROM member ORDER BY id ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DTO dto = new DTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setJob(rs.getString("job"));
				memberList.add(dto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Db.dbClose(conn, pstmt, rs);
		}//try-catch-finally
		return memberList;
	}//getSelectAll
}//DAO
