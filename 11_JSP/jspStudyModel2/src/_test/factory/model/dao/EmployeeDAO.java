package _test.factory.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import _common.DB;
import _test.factory.model.dto.EmployeeDTO;

public class EmployeeDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public ArrayList<EmployeeDTO> getSelectAll() {
		ArrayList<EmployeeDTO> employeeList = new ArrayList<>();
		conn = DB.dbConn();
		try {
			String sql = "SELECT e.*, b.buseoName, p.positionName "
					+ "FROM employee e "
					+ "INNER JOIN buseo b ON e.buseoNo = b.buseoNo "
					+ "INNER JOIN position p ON e.positionNo = p.positionNo "
					+ "ORDER BY sabun DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmployeeDTO employeeDto = new EmployeeDTO();
				employeeDto.setSabun(rs.getInt("sabun"));
				employeeDto.setName(rs.getString("name"));
				employeeDto.setPhone(rs.getString("phone"));
				employeeDto.setHireDate(rs.getDate("hireDate"));
				employeeDto.setEmail(rs.getString("email"));
				employeeDto.setSalary(rs.getInt("salary"));
				employeeDto.setBuseoNo(rs.getInt("buseoNo"));
				employeeDto.setPositionNo(rs.getInt("positionNo"));
				employeeDto.setRegiDate(rs.getDate("regiDate"));
				employeeDto.setBuseoName(rs.getString("buseoName"));
				employeeDto.setPositionName(rs.getString("positionName"));
				employeeList.add(employeeDto);
			}//while
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return employeeList;
	}//getSelectAll
	
	public EmployeeDTO getSelectOne(EmployeeDTO paramDto) {
		EmployeeDTO employeeDto = new EmployeeDTO();
		conn = DB.dbConn();
		try {
			String sql = "SELECT e.*, b.buseoName, p.positionName "
					+ "FROM employee e "
					+ "INNER JOIN buseo b ON e.buseoNo = b.buseoNo "
					+ "INNER JOIN position p ON e.positionNo = p.positionNo "
					+ "WHERE sabun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSabun());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employeeDto.setSabun(rs.getInt("sabun"));
				employeeDto.setName(rs.getString("name"));
				employeeDto.setPhone(rs.getString("phone"));
				employeeDto.setHireDate(rs.getDate("hireDate"));
				employeeDto.setEmail(rs.getString("email"));
				employeeDto.setSalary(rs.getInt("salary"));
				employeeDto.setBuseoNo(rs.getInt("buseoNo"));
				employeeDto.setPositionNo(rs.getInt("positionNo"));
				employeeDto.setRegiDate(rs.getDate("regiDate"));
				employeeDto.setBuseoName(rs.getString("buseoName"));
				employeeDto.setPositionName(rs.getString("positionName"));
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return employeeDto;
	}//getSelectOne
	
	public int setInsert(EmployeeDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "INSERT INTO employee VALUES (seq_employee.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getPhone());
			pstmt.setDate(3, paramDto.getHireDate());
			pstmt.setString(4, paramDto.getEmail());
			pstmt.setInt(5, paramDto.getSalary());
			pstmt.setInt(6, paramDto.getBuseoNo());
			pstmt.setInt(7, paramDto.getPositionNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setInsert
	
	public int setUpdate(EmployeeDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "UPDATE employee SET name = ?, phone = ?, hireDate = ?, email = ?, salary = ?, buseoNo = ?, positionNo = ? WHERE sabun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramDto.getName());
			pstmt.setString(2, paramDto.getPhone());
			pstmt.setDate(3, paramDto.getHireDate());
			pstmt.setString(4, paramDto.getEmail());
			pstmt.setInt(5, paramDto.getSalary());
			pstmt.setInt(6, paramDto.getBuseoNo());
			pstmt.setInt(7, paramDto.getPositionNo());
			pstmt.setInt(8, paramDto.getSabun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setUpdate
	
	public int setDelete(EmployeeDTO paramDto) {
		int result = 0;
		conn = DB.dbConn();
		try {
			String sql = "DELETE FROM employee WHERE sabun = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paramDto.getSabun());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.dbConnClose(rs, pstmt, conn);
		}//try-catch-finally
		return result;
	}//setDelete
}//EmployeeDAO
