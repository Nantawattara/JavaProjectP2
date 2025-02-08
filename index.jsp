<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8"%>
<%@ page import="com.xeno.*,java.util.ArrayList" %>
    <%
        try {
        EmployeeDAO empDAO = new EmployeeDAO();
        ArrayList<Employee> emplist = empDAO.getAllEmployees();
    %>
<!DOCTYPE html>
    <head>
        <meta charset="UTF-8">
        <title>Employee</title>
    </head>
<body>

<h2>Employee List</h2>
<% for (Employee emp: emplist ) { %>
ID: <%=emp.getid() %>
Name: <%=emp.getname() %>
Year: <%=emp.getyear() %> " "
<a href="Deletepage.jsp?iddel=<%=emp.getid()%>">Delete Employee</a><br>
<% }}catch (Exception e){ %>
<% e.printStackTrace(); } %>
<a href="Insertpage.html">Insert Employee</a>
</body>
</html>