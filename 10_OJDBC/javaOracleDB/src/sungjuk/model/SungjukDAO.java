package sungjuk.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int dataCheck(int no) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------------
			String sql = "select count(no) as count from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}//end if
//			----------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end dataCheck
	
	public ArrayList<SungjukDTO> getSelectAll() {
		ArrayList<SungjukDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
//			---------------------------------------
			String sql = "select * from sungjuk order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				SungjukDTO dto = new SungjukDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegiDate(rs.getDate("regiDate"));
				
				list.add(dto);
			}//end while
//			---------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return list;
	}//end getSelectAll
	
	public SungjukDTO getSelectOne(SungjukDTO paramDto) {
		SungjukDTO dto = new SungjukDTO();
		try {
			conn = DB.dbConn();
//			---------------------------------
			String sql = "select * from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setGrade(rs.getString("grade"));
				dto.setRegiDate(rs.getDate("regiDate"));
			}//end if
//			---------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return dto;
	}//end getSelectOne
	
	public void setInsert01(String name, int kor, int eng, int mat, int tot, double avg, String grade) {
		System.out.println("name: "+ name);
		System.out.println("kor: "+ kor);
		System.out.println("eng: "+ eng);
		System.out.println("mat: "+ mat);
		System.out.println("tot: "+ tot);
		System.out.println("avg: "+ avg);
		System.out.println("grade: "+ grade);
	}//end setInsert01
	
	public void setInsert02(String str) {
		String[] imsiArray = str.split("[|]");
		System.out.println("name: "+ imsiArray[0]);
		System.out.println("kor: "+ imsiArray[1]);
		System.out.println("eng: "+ imsiArray[2]);
		System.out.println("mat: "+ imsiArray[3]);
		System.out.println("tot: "+ imsiArray[4]);
		System.out.println("avg: "+ imsiArray[5]);
		System.out.println("grade: "+ imsiArray[6]);
	}//end setInsert02
	
	public void setInsert03(String[] sungjukArray) {
		System.out.println("name: "+ sungjukArray[0]);
		System.out.println("kor: "+ sungjukArray[1]);
		System.out.println("eng: "+ sungjukArray[2]);
		System.out.println("mat: "+ sungjukArray[3]);
		System.out.println("tot: "+ sungjukArray[4]);
		System.out.println("avg: "+ sungjukArray[5]);
		System.out.println("grade: "+ sungjukArray[6]);
	}//end setInsert03
	
	public int setInsert04(SungjukDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------------
			String sql = "insert into sungjuk values (seq_sungjuk.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setInt(2, paramDto.getKor());
			pstmt.setInt(3, paramDto.getEng());
			pstmt.setInt(4, paramDto.getMat());
			pstmt.setInt(5, paramDto.getTot());
			pstmt.setDouble(6, paramDto.getAvg());
			pstmt.setString(7, paramDto.getGrade());
			result = pstmt.executeUpdate();
//			----------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setInsert04
	
	public int setUpdate(SungjukDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			--------------------------------
			String sql = "update sungjuk set kor = ?, eng = ?, mat = ?, tot = ?, avg = ?, grade = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getKor());
			pstmt.setInt(2, paramDto.getEng());
			pstmt.setInt(3, paramDto.getMat());
			pstmt.setInt(4, paramDto.getTot());
			pstmt.setDouble(5, paramDto.getAvg());
			pstmt.setString(6, paramDto.getGrade());
			pstmt.setInt(7, paramDto.getNo());
			result = pstmt.executeUpdate();
//			--------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(SungjukDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------
			String sql = "delete from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			result = pstmt.executeUpdate();
//			----------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setDelete
}//end SungjukDAO
