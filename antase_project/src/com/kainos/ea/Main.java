package com.kainos.ea;

import java.sql.*;
import com.kainos.ea.entities.Employee;

public class Main {

    public static void main(String[] args) {
        Connection c;
        try {
            c = DriverManager.getConnection(
                    "jdbc:mysql://academy2020.cpc8rvmbbd9k.eu-west-2.rds.amazonaws.com",
                    "Sebastian", "tempPwd!");  // Bad practices alert!
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT emp_no AS `number`, "
                            + "CONCAT_WS (' ', first_name, last_name) AS `name`, "
                            + "salary * 100 AS `salary` "
                            + "FROM employees JOIN salaries USING(emp_no) "
                            + "WHERE to_date > NOW() AND salary = 100000");

            while (rs.next()) {
                Employee dbEmp = new Employee(rs.getInt("number"),
                        rs.getString("f_name"), rs.getString("l_name"),
                        rs.getFloat("salary"));
                System.out.println(dbEmp);
            }
        } catch (SQLException e) {
            System.out.println("There was a problem connection to the database: " + e.getMessage());
        }
    }
}
