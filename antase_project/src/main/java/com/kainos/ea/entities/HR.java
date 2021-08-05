package com.kainos.ea.entities;

import com.kainos.ea.database.EmployeeDB;

import java.util.List;

public class HR {

    EmployeeDB db = new EmployeeDB();

    public List<Employee> getEmployees(){
        return EmployeeDB.getEmployees();
    }

    public void addEmployee(Employee emp) {
        db.addEmployee(emp);
    }
}
