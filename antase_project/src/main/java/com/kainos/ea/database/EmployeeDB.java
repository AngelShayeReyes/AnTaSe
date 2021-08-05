package com.kainos.ea.database;

import com.kainos.ea.entities.Employee;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

}