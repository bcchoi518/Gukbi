package _test.haksa.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.haksa.model.dto.SungjukDTO;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<SungjukDTO> getSelectAll() {
		ArrayList<SungjukDTO> sungjukList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT mb.name, sh.sihumName, sj.* "
					+ "FROM haksaSungjuk sj "
					+ "INNER JOIN haksaMember mb ON sj.hakbun = mb.hakbun "
					+ "INNER JOIN haksaSihum sh ON sj.sihumNo = sh.sihumNo "
					+ "ORDER BY sungjukNo DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SungjukDTO sungjukDto = new SungjukDTO();
				sungjukDto.setName(rs.getString("name"));
				sungjukDto.setSihumName(rs.getString("sihumName"));
				sungjukDto.setSungjukNo(rs.getInt("sungjukNo"));
				sungjukDto.setKor(rs.getInt("kor"));
				sungjukDto.setEng(rs.getInt("eng"));
				sungjukDto.setMat(rs.getInt("mat"));
				sungjukDto.setSci(rs.getInt("sci"));
				sungjukDto.setHis(rs.getInt("his"));
				sungjukDto.setTot(rs.getInt("tot"));
				sungjukDto.setAvg(rs.getDouble("avg"));
				sungjukDto.setGrade(rs.getString("grade"));
				sungjukDto.setHakbun(rs.getInt("hakbun"));
				sungjukDto.setSihumNo(rs.getInt("sihumNo"));
				sungjukDto.setRegiDate(rs.getDate("regiDate"));
				sungjukList.add(sungjukDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sungjukList;
	}//getSelectAll
	
	public SungjukDTO getSelectOne(SungjukDTO paramDto) {
		SungjukDTO sungjukDto = new SungjukDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT mb.name, sh.sihumName, sj.* "
					+ "FROM haksaSungjuk sj "
					+ "INNER JOIN haksaMember mb ON sj.hakbun = mb.hakbun "
					+ "INNER JOIN haksaSihum sh ON sj.sihumNo = sh.sihumNo "
					+ "WHERE sungjukNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSungjukNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sungjukDto.setName(rs.getString("name"));
				sungjukDto.setSihumName(rs.getString("sihumName"));
				sungjukDto.setSungjukNo(rs.getInt("sungjukNo"));
				sungjukDto.setKor(rs.getInt("kor"));
				sungjukDto.setEng(rs.getInt("eng"));
				sungjukDto.setMat(rs.getInt("mat"));
				sungjukDto.setSci(rs.getInt("sci"));
				sungjukDto.setHis(rs.getInt("his"));
				sungjukDto.setTot(rs.getInt("tot"));
				sungjukDto.setAvg(rs.getDouble("avg"));
				sungjukDto.setGrade(rs.getString("grade"));
				sungjukDto.setHakbun(rs.getInt("hakbun"));
				sungjukDto.setSihumNo(rs.getInt("sihumNo"));
				sungjukDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sungjukDto;
	}//getSelectOne
	
	public int setInsert(SungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO haksaSungjuk VALUES (seq_haksaSungjuk.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getKor());
			pstmt.setInt(2, paramDto.getEng());
			pstmt.setInt(3, paramDto.getMat());
			pstmt.setInt(4, paramDto.getSci());
			pstmt.setInt(5, paramDto.getHis());
			pstmt.setInt(6, paramDto.getTot());
			pstmt.setDouble(7, paramDto.getAvg());
			pstmt.setString(8, paramDto.getGrade());
			pstmt.setInt(9, paramDto.getHakbun());
			pstmt.setInt(10, paramDto.getSihumNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(SungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE haksaSungjuk "
					+ "SET kor = ?, eng = ?, mat = ?, sci = ?, his = ?, tot = ?, avg = ?, grade = ?, hakbun = ?, sihumNo = ? "
					+ "WHERE sungjukNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getKor());
			pstmt.setInt(2, paramDto.getEng());
			pstmt.setInt(3, paramDto.getMat());
			pstmt.setInt(4, paramDto.getSci());
			pstmt.setInt(5, paramDto.getHis());
			pstmt.setInt(6, paramDto.getTot());
			pstmt.setDouble(7, paramDto.getAvg());
			pstmt.setString(8, paramDto.getGrade());
			pstmt.setInt(9, paramDto.getHakbun());
			pstmt.setInt(10, paramDto.getSihumNo());
			pstmt.setInt(11, paramDto.getSungjukNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(SungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM haksaSungjuk WHERE sungjukNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSungjukNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//SungjukDAO