package product.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DB;

public class ProductDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public int dataCheck(int productCode) {
		int result = 0;
		try {
			conn = DB.dbConn();
//			----------------------------------------
			String sql = "select count(productCode) as count from product where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, productCode);
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
	
	public ArrayList<ProductDTO> getSelectAll() {
		ArrayList<ProductDTO> list = new ArrayList<>();
		try {
			conn = DB.dbConn();
			String sql = "select * from product order by productCode desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO productDto = new ProductDTO();
				productDto.setProductCode(rs.getInt("productCode"));
				productDto.setProductName(rs.getString("productName"));
				productDto.setProductPrice(rs.getInt("productPrice"));
				productDto.setVender(rs.getString("vender"));
				productDto.setRegiDate(rs.getDate("regiDate"));
				
				list.add(productDto);
			}//end while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return list;
	}//end getSelectAll
	
	public ProductDTO getSelectOne(ProductDTO paramDto) {
		ProductDTO dto = new ProductDTO();
		try {
			conn = DB.dbConn();
			String sql = "select * from product where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto.setProductCode(rs.getInt("productCode"));
				dto.setProductName(rs.getString("productName"));
				dto.setProductPrice(rs.getInt("productPrice"));
				dto.setProductContent(rs.getString("productContent"));
				dto.setVender(rs.getString("vender"));
				dto.setRegiDate(rs.getDate("regiDate"));
			}//end if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return dto;
	}//end getSelectOne
	
	public int setInsert(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "insert into product values (seq_product.nextval, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProductName());
			pstmt.setInt(2, paramDto.getProductPrice());
			pstmt.setString(3, paramDto.getProductContent());
			pstmt.setString(4, paramDto.getVender());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setInsert
	
	public int setUpdate(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "update product set productName = ?, productPrice = ?, productContent = ?, vender = ? where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProductName());
			pstmt.setInt(2, paramDto.getProductPrice());
			pstmt.setString(3, paramDto.getProductContent());
			pstmt.setString(4, paramDto.getVender());
			pstmt.setInt(5, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setUpdate
	
	public int setDelete(ProductDTO paramDto) {
		int result = 0;
		try {
			conn = DB.dbConn();
			String sql = "delete from product where productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//end try-catch-finally
		return result;
	}//end setDelete
}//end productDAO
