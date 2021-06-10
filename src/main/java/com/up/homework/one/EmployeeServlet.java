package com.up.homework.one;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


@WebServlet("/")
public class EmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EmployeeDAO employeeDAO;
	
	public void init() {
		employeeDAO = new EmployeeDAO();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		try {
	         switch (action) {
		            case "/new":
		            	showNewForm(request, response);
		                break;
	                case "/insert":
	                    addEmployee(request, response);
	                    break;
	                case "/delete":
	                    deleteEmployee(request, response);
	                    break;
	                case "/edit":
	                    showEditForm(request, response);
	                    break;
	                case "/update":
	                    updateEmployee(request, response);
	                    break;
	                default:
	                    listEmployee(request, response);
	                    break;
	            }
		} catch (SQLException ex) {
            throw new ServletException(ex);
		}
	}
	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String province = request.getParameter("province");
		Employee newEmployee = new Employee(firstName, lastName, gender, email, province);
		employeeDAO.addEmployee(newEmployee);
		response.sendRedirect("list");
				
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		List<Employee> listEmployee = employeeDAO.listAllEmployee();
		request.setAttribute("listEmployee", listEmployee);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
	    dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Employee existingEmployee = employeeDAO.getEmployee(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
		request.setAttribute("employee", existingEmployee);
		dispatcher.forward(request, response);

	}
	
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	Employee employee = null;
    	int id = Integer.parseInt(request.getParameter("id"));
    	String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String province = request.getParameter("province");       
		
		employee = new Employee(id, firstName, lastName, gender, email, province);
		employeeDAO.updateEmployee(employee); 
		response.sendRedirect("list");
   }
    
   private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
    	int id = Integer.parseInt(request.getParameter("id"));
    	employeeDAO.deleteEmployee(id);
    	response.sendRedirect("list");

   }
}
