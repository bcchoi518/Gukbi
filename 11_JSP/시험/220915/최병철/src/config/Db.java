package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Db {
	public static Connection getDbConnection() {
		String dbDriver = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@//localhost:1521/xe";
		String dbId = "sihum";
		String dbPw = "1234";
		Connection conn = null;
		
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		return conn;
	}//getDbConnection
	
	public static void dbClose(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) { rs.close(); }
			if (pstmt != null) { pstmt.close(); }
			if (conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
	}//getDbConnection
	
}//Db
