package sungjuk.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DB;

public class SungjukDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void getSelectAll() {
		try {
			conn = DB.dbConn();
//			---------------------------------------
			String sql = "select * from sungjuk";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				String grade = rs.getString("grade");
				Date regiDate = rs.getDate("regiDate");
				
				String imsi = "";
				imsi += name + ", ";
				imsi += kor + ", ";
				imsi += eng + ", ";
				imsi += mat + ", ";
				imsi += tot + ", ";
				imsi += avg + ", ";
				imsi += grade + ", ";
				imsi += regiDate;
				
				System.out.println(imsi);
			}//end while
//			---------------------------------------
		} catch (Exception e) {
			System.out.println("-- DB 접속 실패 --");
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}
	}//end getSelectAll
	
	public void getSelectOne(SungjukDTO dto) {
		try {
			conn = DB.dbConn();
//			---------------------------------
			String sql = "select * from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int mat = rs.getInt("mat");
				int tot = rs.getInt("tot");
				double avg = rs.getDouble("avg");
				String grade = rs.getString("grade");
				Date regiDate = rs.getDate("regiDate");
				
				String imsi = "";
				imsi += name + ", ";
				imsi += kor + ", ";
				imsi += eng + ", ";
				imsi += mat + ", ";
				imsi += tot + ", ";
				imsi += avg + ", ";
				imsi += grade + ", ";
				imsi += regiDate;
				
				System.out.println(imsi);
			}//end if
//			---------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
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
	
	public int setInsert04(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------------
			String sql = "insert into sungjuk values (seq_sungjuk.nextval, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getKor());
			pstmt.setInt(3, dto.getEng());
			pstmt.setInt(4, dto.getMat());
			pstmt.setInt(5, dto.getTot());
			pstmt.setDouble(6, dto.getAvg());
			pstmt.setString(7, dto.getGrade());
			result = pstmt.executeUpdate();
//			----------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setInsert04
	
	public int setUpdate(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			--------------------------------
			String sql = "update sungjuk set kor = ?, eng = ?, mat = ?, tot = ?, avg = ?, grade = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getTot());
			pstmt.setDouble(5, dto.getAvg());
			pstmt.setString(6, dto.getGrade());
			result = pstmt.executeUpdate();
//			--------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(SungjukDTO dto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------
			String sql = "delete from sungjuk where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getNo());
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
