package product.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Db;
import product.model.dto.ProductDTO;

public class ProductDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public int setInsert(ProductDTO paramDto) {
		int result = 0;
		conn = Db.getDbConnection();
		try {
			String sql = "INSERT INTO product VALUES (seq_product.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getCate());
			pstmt.setString(2, paramDto.getpName());
			pstmt.setInt(3, paramDto.getPrice());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Db.dbClose(conn, pstmt, rs);
		}//try-catch-finally
		return result;
	}//setInsert
}//DAO
