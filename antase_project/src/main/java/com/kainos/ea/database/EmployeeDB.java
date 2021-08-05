package com.kainos.ea.database;

import com.kainos.ea.entities.Employee;
import com.kainos.ea.entities.SalesEmployee;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeDB {

    private static Connection c;
    private static Connection getConnection() {
        String user;
        String password;
        String host;
        Connection c;
        try (var f = new FileInputStream("employeesdb.properties")) {
            Properties props = new Properties();
            props.load(f);
            user = props.getProperty("user");
            password = props.getProperty("password");
            host = props.getProperty("host");
            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain user, " +
                                "password, and host properties.");
            c = DriverManager.getConnection("jdbc:mysql://" + host +
                    "/group_anatase", user, password);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Employee> getEmployees() {

        if (c == null) {
            c = getConnection();
        }
        List<Employee> emps = new ArrayList<>();
        try {
            Statement s = c.createStatement();
            ResultSet rows = s.executeQuery(
                    """
                            SELECT * from Employee;
                            """);
            while (rows.next()) {
                emps.add(new Employee(
                        rows.getShort("employee_id"),
                        rows.getString("f_name"),
                        rows.getString("l_name"),
                        rows.getInt("salary")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emps;
    }

    public void addSalesEmployee(SalesEmployee salesEmp) {
        if(c == null) {
            c = getConnection();
        }
        List<Employee> sales_emp = new ArrayList<>();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(
                    """
                        INSERT INTO Employee ('f_name', 'l_name', 'ni_number', 'employee_address', 
                        'salary', 'bank_detail', 'is_Manager', 'active', 'employee_type')
                        )
                        VALUES (%d, %s, %s, %d, %s, %d, %s, %d, %d, %s)
                        """);
            while (rs.next()) {
                sales_emp.add(new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("ni_number"),
                        rs.getString ("employee_address"),
                        rs.getFloat("salary"),
                        rs.getString("bank_detail"),
                        rs.getShort("is_Manager"),
                        rs.getShort("active"),
                        rs.getString("employee_type")
                ));
            }
        } catch (SQLException e) {
                System.out.println("There was a problem entering data into db: " + e.getMessage());
        }
    }


    public void addEmployee(Employee emp){
        if (c == null) {
            c = getConnection();
        }
        try {
            Statement s = c.createStatement();
            s.executeUpdate(String.format("insert into Employee (f_name, l_name, " +
                            "ni_number, employee_address, salary, " +
                            "bank_detail, is_manager, employee_type) " +
                    "values(" +
                            "'%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s')",
                    emp.getF_name(),
                    emp.getL_name(),
                    emp.getNi_number(),
                    emp.getEmployee_address(),
                    emp.getSalary(),
                    emp.getBank_detail(),
                    emp.isIs_Manager(),
                    emp.getEmployee_type()));
            System.out.println("Employee added");
        } catch (SQLException e){
            System.out.println("There was a problem during inserting data into db: " + e.getMessage());
        }
    }

}
