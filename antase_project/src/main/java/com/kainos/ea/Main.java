package com.kainos.ea;

import com.kainos.ea.database.EmployeeDB;
import com.kainos.ea.entities.Employee;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean running = true;
        while(running){
            System.out.println("1. Do a query");
            System.out.println("2. Quit");
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
            }
        }
    }
}
