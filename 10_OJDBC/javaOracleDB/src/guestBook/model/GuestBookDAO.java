package guestBook.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class GuestBookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ArrayList<GuestBookDTO> getSelectAll() {
		ArrayList<GuestBookDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
			String sql = "select no, writer, subject, regiDate from guestBook order by no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				GuestBookDTO guestBookDto = new GuestBookDTO();
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setWriter(rs.getString("writer"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
				list.add(guestBookDto);
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return list;
	}//end getSelectAll
	
	public int dataCheck(GuestBookDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------------
			String sql = "select count(no) as count from guestBook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}//end if
			if (result == 0) {
				System.out.println("─── Info ─────────────────────────────────────────────────────────────────────────");
				System.out.println("데이터가 없습니다.");
				System.out.println("──────────────────────────────────────────────────────────────────────────────────");
			}//end if
//			----------------------------------------
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end dataCheck
	
	public GuestBookDTO getSelectOne(GuestBookDTO paramDto) {
		GuestBookDTO guestBookDto = new GuestBookDTO();
		try {
			conn = DB.dbConn();
			String sql = "select * from guestBook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				guestBookDto.setNo(rs.getInt("no"));
				guestBookDto.setWriter(rs.getString("writer"));
				guestBookDto.setSubject(rs.getString("subject"));
				guestBookDto.setContent(rs.getString("content"));
				guestBookDto.setRegiDate(rs.getDate("regiDate"));
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return guestBookDto;
	}//end getSelectOne
	
	public int setInsert(GuestBookDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "insert into guestBook values (seq_guestBook.nextval, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getWriter());
			pstmt.setString(2, paramDto.getSubject());
			pstmt.setString(3, paramDto.getContent());
			pstmt.setString(4, paramDto.getPasswd());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setInsert
	
	public boolean checkPasswd(GuestBookDTO paramDto) {
		boolean pwChecker = false;
		try {
			conn = DB.dbConn();
			String sql = "select passwd from guestBook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (paramDto.getPasswd().equals(rs.getString("passwd"))) {
					pwChecker = true;
				} else {
					System.out.println("─── Error ────────────────────────────────────────────────────────────────────────");
					System.out.println("입력된 정보가 잘못되었습니다.");
					System.out.println("──────────────────────────────────────────────────────────────────────────────────");
				}//end if
			}//end if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return pwChecker;
	}//end checkPasswd
	
	public int setUpdate(GuestBookDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "update guestBook set subject = ?, content = ? where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getSubject());
			pstmt.setString(2, paramDto.getContent());
			pstmt.setInt(3, paramDto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(GuestBookDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "delete from guestBook where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setDelete
}//end GuestBookDAO
