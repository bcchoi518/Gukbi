package shopVendor.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.DB;
import shopVendor.model.dto.ShopVendorDTO;

public class ShopVendorDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<ShopVendorDTO> getSelectAll() {
		ArrayList<ShopVendorDTO> shopVendorList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM vendor ORDER BY regiDate DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ShopVendorDTO shopVendorDto = new ShopVendorDTO();
				shopVendorDto.setVendorCode(rs.getInt("vendorCode"));
				shopVendorDto.setVendorName(rs.getString("vendorName"));
				shopVendorDto.setRegiDate(rs.getDate("regiDate"));
				shopVendorList.add(shopVendorDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return shopVendorList;
	}//getSelectAll
	
	public ShopVendorDTO getSelectOne(ShopVendorDTO paramDto) {
		ShopVendorDTO shopVendorDto = new ShopVendorDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT * FROM vendor WHERE vendorCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getVendorCode());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				shopVendorDto.setVendorCode(rs.getInt("vendorCode"));
				shopVendorDto.setVendorName(rs.getString("vendorName"));
				shopVendorDto.setRegiDate(rs.getDate("regiDate"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return shopVendorDto;
	}//getSelectOne

	public int setInsert(ShopVendorDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO vendor VALUES (seq_vendor.NEXTVAL, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getVendorName());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(ShopVendorDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE vendor SET vendorName = ? WHERE vendorCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getVendorName());
			pstmt.setInt(2, paramDto.getVendorCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(ShopVendorDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM vendor WHERE vendorCode = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getVendorCode());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//ShopVendorDAO
