package com.up.homework.one;

import java.sql.*;
import java.util.*;

public class EmployeeDAO {
	
	static Connection connection = null;
	static ResultSet result = null;
	static PreparedStatement pstmst;
	
	public EmployeeDAO() {
		
	}
	 private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO tbl_employees" + "(first_name, last_name, gender, email, province) VALUES " + " (?, ?, ?, ?, ?);";
	 private static final String SELECT_EMPLOYEE_BY_ID = "SELECT id,first_name,last_name,gender,email,province FROM tbl_employees WHERE id =?";
	 private static final String SELECT_ALL_EMPLOYEES = "SELECT * FROM tbl_employees";
	 private static final String DELETE_EMPLOYEE_SQL = "DELETE FROM tbl_employees WHERE id = ?;";
	 private static final String UPDATE_EMPLOYEE_SQL = "UPDATE tbl_employees SET first_name = ?,last_name= ?,gender =?,email=?,province=? WHERE id = ?;";
     
	 public void addEmployee(Employee employee) throws SQLException {
		 
		 connection = DBConnectionUtil.openConnection();
		 
		 pstmst = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
		 
		     pstmst.setString(1, employee.getFirstName());
		     pstmst.setString(2, employee.getLastName());
		     pstmst.setString(3, employee.getGender());
		     pstmst.setString(4, employee.getEmail());
		     pstmst.setString(5, employee.getProvince());
		     
		     pstmst.executeUpdate();
	 }
	 
	 public List<Employee> listAllEmployee() throws SQLException {
		 
		 List<Employee> listEmployee = new ArrayList<Employee>();
		 
		 connection = DBConnectionUtil.openConnection();
		 pstmst = connection.prepareStatement(SELECT_ALL_EMPLOYEES);
		 result = pstmst.executeQuery();
		 
	       while (result.next()) {
		       int id = result.getInt("id");
		       String firstName = result.getString("first_name");
		       String lastName = result.getString("last_name");
		       String gender = result.getString("gender");
		       String email = result.getString("email");
		       String province = result.getString("province");  
		       
		       Employee employee = new Employee(id, firstName, lastName, gender, email, province);
		       listEmployee.add(employee);
	       	
	       }
	       return listEmployee;
	 }
	 
	 public Employee getEmployee(int id) throws SQLException {
		 Employee employee = null;
		 connection = DBConnectionUtil.openConnection();
		 pstmst = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);
		 pstmst.setInt(1, id);
		 result = pstmst.executeQuery();
		 
		   while (result.next()) {
		       String firstName = result.getString("first_name");
		       String lastName = result.getString("last_name");
		       String gender = result.getString("gender");
		       String email = result.getString("email");
		       String province = result.getString("province");  
		       
		       employee = new Employee(id, firstName, lastName, gender, email, province);	
	       }
		   return employee;
	 }
	 
	 public boolean updateEmployee(Employee employee) throws SQLException {
		 boolean rowUpdated;
		 connection = DBConnectionUtil.openConnection();
		 pstmst = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
		
	        pstmst.setString(1, employee.getFirstName());
	        pstmst.setString(2, employee.getLastName());
	        pstmst.setString(3, employee.getGender());
	        pstmst.setString(4, employee.getEmail());
	        pstmst.setString(5, employee.getProvince());
	        pstmst.setInt(6, employee.getId());
	        
	   rowUpdated = pstmst.executeUpdate() > 0;
	   return rowUpdated;
	 }
	 
	 public boolean deleteEmployee(int id) throws SQLException {
		 boolean rowDeleted;
		 connection = DBConnectionUtil.openConnection();
		 pstmst = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
		 pstmst.setInt(1, id);
		 rowDeleted = pstmst.executeUpdate() > 0;
		 return rowDeleted;
		 
	 }
	 
	@SuppressWarnings("unused")
	private void printSQLException(SQLException ex) {
	    for (Throwable e: ex) {
	        if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
}
