package com.xeno;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {
    private Connection con;
    
    public EmployeeDAO() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/Project?characterEncoding=utf-8", "root", "");
    }

    public void Closeconnecttion() throws SQLException {
        con.close();
    }

    public ArrayList<Employee> getAllEmployees() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM EmployeeTable");
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Employee> emplist = new ArrayList<Employee>();
        while (resultSet.next()) {
            Employee emp = new Employee();
            emp.setid(resultSet.getInt("Employeee_id"));
            emp.setname(resultSet.getString("Employee_name"));
            emp.setyear(resultSet.getInt("Yearofwork"));
            emplist.add(emp);
        }
        return emplist;
    }

    public Employee getOneEmployee(int EmployeeID) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM EmployeeTable WHERE EmployeeID = ?");
        preparedStatement.setInt(1, EmployeeID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if(resultSet.next()){
            Employee emp = new Employee();
            emp.setid(resultSet.getInt("Employeee_id"));
            emp.setname(resultSet.getString("Employee_name"));
            emp.setyear(resultSet.getInt("Yearofwork"));

            return emp;
        }
        else{
            return null;
        }
    }

    public void insetEmp(Employee employee) throws SQLException{
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO EmployeeTable VALUES (null, ?, ?)");
        preparedStatement.setString(1, employee.getname());
        preparedStatement.setInt(2, employee.getyear());
        preparedStatement.executeUpdate();
    }

    public void deleteEmp(int id) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM EmployeeTable WHERE Employeee_id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}
// Hello Again 653450291-6