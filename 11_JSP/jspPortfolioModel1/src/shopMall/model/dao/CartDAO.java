package shopMall.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import shopMall.model.dto.CartDTO;

public class CartDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<CartDTO> getSelectCartProductGroup() {
		ArrayList<CartDTO> list = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "";
			sql += "SELECT p.productName productName, SUM(c.amount * p.productPrice) buyMoney ";
			sql += "FROM cart c INNER JOIN product p ON c.productCode = p.productCode ";
			sql += "GROUP BY p.productName ";
			sql += "ORDER BY productName ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartDTO cartDto = new CartDTO();
				cartDto.setProductName(rs.getString("productName"));
				cartDto.setBuyMoney(rs.getInt("buyMoney"));
				list.add(cartDto);
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return list;
	}//getSelectCartProductGroup
	
	public ArrayList<CartDTO> getSelectAll() {
		ArrayList<CartDTO> cartList = new ArrayList<>();
		conn = DB.dbConn();
		try {
//			String subQuery1 = "SELECT productName FROM product p WHERE p.productCode = c.productCode";
//			String subQuery2 = "SELECT productPrice FROM product p WHERE p.productCode = c.productCode";
			String subQuery = "SELECT productName || '/' || productPrice || '/' || vendorCode || '/' || attachInfo "
							 + "FROM product p WHERE p.productCode = c.productCode";
			String sql = "SELECT c.*, ("+ subQuery +") productInfo "
					   + "FROM cart c "
					   + "ORDER BY cartNo DESC";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CartDTO cartDto = new CartDTO();
				cartDto.setCartNo(rs.getInt("cartNo"));
				cartDto.setMemberNo(rs.getInt("memberNo"));
				cartDto.setProductCode(rs.getInt("productCode"));
				cartDto.setAmount(rs.getInt("amount"));
				cartDto.setRegiDate(rs.getDate("regiDate"));
//				cartDto.setProductName(rs.getString("productName"));
//				cartDto.setProductPrice(rs.getInt("productPrice"));
				cartDto.setProductInfo(rs.getString("productInfo"));
				cartList.add(cartDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return cartList;
	}//getSelectAll
	
	public CartDTO getSelectOne(CartDTO paramDto) {
		CartDTO cartDto = new CartDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM cart WHERE cartNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getCartNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				cartDto.setCartNo(rs.getInt("cartNo"));
				cartDto.setMemberNo(rs.getInt("memberNo"));
				cartDto.setProductCode(rs.getInt("productCode"));
				cartDto.setAmount(rs.getInt("amount"));
				cartDto.setRegiDate(rs.getDate("regiDate"));
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return cartDto;
	}//getSelectOne
	
	public int setInsert(CartDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO cart VALUES (seq_cart.NEXTVAL, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getMemberNo());
			pstmt.setInt(2, paramDto.getProductCode());
			pstmt.setInt(3, paramDto.getAmount());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(CartDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE cart SET memberNo = ?, productCode = ?, amount = ? WHERE cartNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getMemberNo());
			pstmt.setInt(2, paramDto.getProductCode());
			pstmt.setInt(3, paramDto.getAmount());
			pstmt.setInt(4, paramDto.getCartNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(CartDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM cart WHERE cartNo = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getCartNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
	
	public int setDeleteBatch(String[] array) {
		int result = 0;
		int[] count = new int[array.length];
		conn = DB.dbConn();
		try {
			conn.setAutoCommit(false);
			String sql = "DELETE FROM cart WHERE cartNo = ?";
			pstmt = conn.prepareStatement(sql);
			
			for (int i = 0; i < array.length; i++) {
				pstmt.setInt(1, Integer.parseInt(array[i]));
				pstmt.addBatch();
			}//for
			
			count = pstmt.executeBatch();
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}//try-catch
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (Exception e3) {
				e3.printStackTrace();
			}//try-catch
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		result = count.length;
		return result;
	}//setDeleteBatch
}//CartDAO
