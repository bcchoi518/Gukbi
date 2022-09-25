package project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
	public static Connection dbConn() {
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
		String dbId = "jspPortfolioModel2";
		String dbPw = "1234";
		
		Connection conn = null;
		
		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("-- Oracle Driver Error --");
		}//try-catch
		
		try {
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println("-- Error 01 --");
		}//try-catch
		
		return conn;
	}//dbConn
	
	public static void dbConnClose (ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}//if
 		} catch (Exception e) {
//			e.printStackTrace();
 			System.out.println("-- Error 02 --");
		}//try-catch
		
		try {
			if (pstmt != null) {
				pstmt.close();
			}//if
 		} catch (Exception e) {
//			e.printStackTrace();
 			System.out.println("-- Error 03 --");
		}//try-catch
		
		try {
			if (conn != null) {
				conn.close();
			}//if
 		} catch (Exception e) {
//			e.printStackTrace();
 			System.out.println("-- Error 04 --");
		}//try-catch
	}//dbConnClose
	
	public static String getCheckfieldName(String fieldName) {
		if (fieldName == null) {
			return null;
		}//if
		
		fieldName = fieldName.replace(" ", "").replace(";", "");
		
		return fieldName;
	}//getCheckfieldName
}//DB
