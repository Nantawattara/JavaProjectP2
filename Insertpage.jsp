<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ page import="com.xeno.*" %>

<%
    try{
    EmployeeDAO empDAO = new EmployeeDAO();
    
    String empName = request.getParameter("inName");
    int empYear = Integer.parseInt(request.getParameter("inYear"));
    
    Employee emp = new Employee();
    emp.setname(empName);
    emp.setyear(empYear);

    empDAO.insetEmp(emp);
    empDAO.Closeconnecttion();
    
    }catch (Exception e){
        e.printStackTrace();
    }
    response.sendRedirect("index.jsp");
%>