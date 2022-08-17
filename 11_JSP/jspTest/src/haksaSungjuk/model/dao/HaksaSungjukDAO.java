package haksaSungjuk.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import haksaSungjuk.model.dto.HaksaSungjukDTO;

public class HaksaSungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private String tableName_1 = "haksaSungjuk";
	private String tableName_2 = "haksaMember";
	private String tableName_3 = "haksaSihum";
	
	public ArrayList<HaksaSungjukDTO> getSelectAll() {
		ArrayList<HaksaSungjukDTO> sungjukList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT sj.kor, sj.eng, sj.mat, sj.sci, sj.his, sj.tot, sj.avg, sj.grade, mb.name, sh.sihumName, sj.regiDate, sj.sungjukNo, sj.hakbun, sj.sihumNo "
					+ "FROM "+ tableName_1 +" sj, "+ tableName_2 +" mb, "+ tableName_3 +" sh "
					+ "WHERE sj.hakbun = mb.hakbun AND sj.sihumNo = sh.sihumNo "
					+ "ORDER BY sj.regiDate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				HaksaSungjukDTO sungjukDto = new HaksaSungjukDTO();
				sungjukDto.setKor(rs.getInt("kor"));
				sungjukDto.setEng(rs.getInt("eng"));
				sungjukDto.setMat(rs.getInt("mat"));
				sungjukDto.setSci(rs.getInt("sci"));
				sungjukDto.setHis(rs.getInt("his"));
				sungjukDto.setTot(rs.getInt("tot"));
				sungjukDto.setAvg(rs.getDouble("avg"));
				sungjukDto.setGrade(rs.getString("grade"));
				sungjukDto.setName(rs.getString("name"));
				sungjukDto.setSihumName(rs.getString("sihumName"));
				sungjukDto.setRegiDate(rs.getDate("regiDate"));
				sungjukDto.setSungjukNo(rs.getInt("sungjukNo"));
				sungjukDto.setHakbun(rs.getInt("hakbun"));
				sungjukDto.setSihumNo(rs.getInt("sihumNo"));
				sungjukList.add(sungjukDto);
			}//while
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sungjukList;
	}//getSelectAll
	
	public HaksaSungjukDTO getSelectOne(HaksaSungjukDTO paramDto) {
		HaksaSungjukDTO sungjukDto = new HaksaSungjukDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT sj.kor, sj.eng, sj.mat, sj.sci, sj.his, sj.tot, sj.avg, sj.grade, mb.name, sh.sihumName, sj.regiDate, sj.sungjukNo, sj.hakbun, sj.sihumNo "
					+ "FROM "+ tableName_1 +" sj, "+ tableName_2 +" mb, "+ tableName_3 +" sh "
					+ "WHERE sj.hakbun = mb.hakbun AND sj.sihumNo = sh.sihumNo "
					+ "AND sj.sungjukNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSungjukNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				sungjukDto.setKor(rs.getInt("kor"));
				sungjukDto.setEng(rs.getInt("eng"));
				sungjukDto.setMat(rs.getInt("mat"));
				sungjukDto.setSci(rs.getInt("sci"));
				sungjukDto.setHis(rs.getInt("his"));
				sungjukDto.setTot(rs.getInt("tot"));
				sungjukDto.setAvg(rs.getDouble("avg"));
				sungjukDto.setGrade(rs.getString("grade"));
				sungjukDto.setName(rs.getString("name"));
				sungjukDto.setSihumName(rs.getString("sihumName"));
				sungjukDto.setRegiDate(rs.getDate("regiDate"));
				sungjukDto.setSungjukNo(rs.getInt("sungjukNo"));
				sungjukDto.setHakbun(rs.getInt("hakbun"));
				sungjukDto.setSihumNo(rs.getInt("sihumNo"));
			}//if
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return sungjukDto;
	}//getSelectOne
	
	public int setInsert(HaksaSungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO "+ tableName_1 +" VALUES (seq_haksaSungjuk.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
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
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(HaksaSungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE "+ tableName_1
					+ " SET kor = ?, eng = ?, mat = ?, sci = ?, his = ?, tot = ?, avg = ?, grade = ?, hakbun = ?, sihumNo = ?"
					+ " WHERE sungjukNo = ?";
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
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(HaksaSungjukDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM "+ tableName_1 +" WHERE sungjukNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSungjukNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//HaksaSungjukDAO
