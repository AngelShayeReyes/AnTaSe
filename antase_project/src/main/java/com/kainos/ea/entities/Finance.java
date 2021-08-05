package com.kainos.ea.entities;

import com.kainos.ea.database.EmployeeDB;

import java.util.List;
import java.util.Scanner;

public class Finance {

    public static void main(String[] args){
        boolean running = true;
        while(running){
            System.out.println("\n1. Do a query");
            System.out.println("2. Quit");
            System.out.println("3. Employee with gross pay for the current pay period");
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();

            switch (x) {
                case 1:
                    List<Employee> employees = EmployeeDB.getEmployees();
                    for(com.kainos.ea.entities.Employee emp : employees){
                        System.out.println(emp);
                    }
                    break;
                case 2:
                    running = false;
                case 3:
                    List<Employee> employeeGrossPay = EmployeeDB.getEmployees();
                    for(com.kainos.ea.entities.Employee emp : employeeGrossPay){
                        System.out.println(emp.calcPay());
                    }
                    break;

            }
        }
    }
}
