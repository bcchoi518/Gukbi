package shopProduct.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import shopProduct.model.dto.ShopProductDTO;

public class ShopProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ShopProductDTO> getSelectAll() {
		ArrayList<ShopProductDTO> shopProductList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM product ORDER BY regiDate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopProductDTO shopProductDto = new ShopProductDTO();
				shopProductDto.setProductCode(rs.getInt("productCode"));
				shopProductDto.setProductName(rs.getString("productName"));
				shopProductDto.setProductPrice(rs.getInt("productPrice"));
				shopProductDto.setVendorCode(rs.getInt("vendorCode"));
				shopProductDto.setAttachInfo(rs.getString("attachInfo"));
				shopProductDto.setRegiDate(rs.getDate("regiDate"));
				shopProductList.add(shopProductDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return shopProductList;
	}//getSelectAll
	
	public ShopProductDTO getSelectOne(ShopProductDTO paramDto) {
		ShopProductDTO shopProductDto = new ShopProductDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM product WHERE productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				shopProductDto.setProductCode(rs.getInt("productCode"));
				shopProductDto.setProductName(rs.getString("productName"));
				shopProductDto.setProductPrice(rs.getInt("productPrice"));
				shopProductDto.setVendorCode(rs.getInt("vendorCode"));
				shopProductDto.setAttachInfo(rs.getString("attachInfo"));
				shopProductDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return shopProductDto;
	}//getSelectOne

	public int setInsert(ShopProductDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO product VALUES (seq_product.NEXTVAL, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProductName());
			pstmt.setInt(2, paramDto.getProductPrice());
			pstmt.setInt(3, paramDto.getVendorCode());
			pstmt.setString(4, paramDto.getAttachInfo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(ShopProductDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE product SET productName = ?, productPrice = ?, vendorCode = ?, attachInfo = ? WHERE productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getProductName());
			pstmt.setInt(2, paramDto.getProductPrice());
			pstmt.setInt(3, paramDto.getVendorCode());
			pstmt.setString(4, paramDto.getAttachInfo());
			pstmt.setInt(5, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(ShopProductDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM product WHERE productCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getProductCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//ShopProductDAO
