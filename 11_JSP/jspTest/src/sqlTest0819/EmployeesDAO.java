package sqlTest0819;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeesDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String dbDriver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbId = "hr";
	String dbPw = "1234";
	
	public EmployeesDTO getSelectOne(EmployeesDTO paramDto) {
		EmployeesDTO employeesDto = new EmployeesDTO();
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			String sql = "SELECT * FROM employees WHERE first_name = ? AND last_name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getFirst_name());
			pstmt.setString(2, paramDto.getLast_name());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employeesDto.setEmployee_id(rs.getInt("employee_id"));
				employeesDto.setFirst_name(rs.getString("first_name"));
				employeesDto.setLast_name(rs.getString("last_name"));
				employeesDto.setEmail(rs.getString("email"));
				employeesDto.setPhone_number(rs.getString("phone_number"));
				employeesDto.setHire_date(rs.getDate("hire_date"));
				employeesDto.setJob_id(rs.getString("job_id"));
				employeesDto.setSalary(rs.getInt("salary"));
				employeesDto.setCommission_pct(rs.getDouble("commission_pct"));
				employeesDto.setManager_id(rs.getInt("manager_id"));
				employeesDto.setDepartment_id(rs.getInt("department_id"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		
		try {
			if ( rs != null) { rs.close(); }
			if ( pstmt != null) { pstmt.close(); }
			if ( conn != null) { conn.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}//try-catch
		return employeesDto;
	}//getSelectOne
}//EmployeesDAO
