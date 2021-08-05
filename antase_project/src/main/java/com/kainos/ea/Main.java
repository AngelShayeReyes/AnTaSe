package com.kainos.ea;

import com.kainos.ea.entities.Employee;
import com.kainos.ea.entities.HR;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<String> types = Arrays.asList("Technical", "HR", "Sales", "Finance", "BU");
        boolean running = true;
        while (running) {
            System.out.println("1. Do a query");
            System.out.println("2. Add a normal employee");
            System.out.println("9. Quit");
            Scanner input = new Scanner(System.in);
            int x = Integer.parseInt(input.nextLine());
            HR hr = new HR();
            switch (x) {
                case 1:
                    List<Employee> employees = hr.getEmployees();
                    for (com.kainos.ea.entities.Employee emp : employees) {
                        System.out.println(emp);
                    }
                    break;
                case 2:
                    System.out.println(types);
                    System.out.println("First name: ");
                    String f_name = input.nextLine();
                    System.out.println("Last name: ");
                    String l_name = input.nextLine();
                    Pattern pattern = Pattern.compile("^(?!BG)(?!GB)(?!NK)(?!KN)(?!TN)(?!NT)(?!ZZ)" +
                            "(?:[A-CEGHJ-PR-TW-Z][A-CEGHJ-NPR-TW-Z])(?:\\s*\\d\\s*){6}([A-D]|\\s)$");
                    System.out.println("National Insurance Number: ");
                    String ni_number = input.nextLine();
                    Matcher matcher = pattern.matcher(ni_number);
                    if(!matcher.find()){
                        System.out.println("National Insurance Number not valid");
                        break;
                    }
                    System.out.println("Address: ");
                    String address = input.nextLine();
                    System.out.println("Salary: ");
                    int salary = Integer.parseInt(input.nextLine());
                    System.out.println("Bank account number: ");
                    String bank = input.nextLine();
                    System.out.println("Manager: ");
                    System.out.println("No (N)");
                    System.out.println("Yes (Y)");
                    int manager = switch (input.nextLine().toUpperCase()) {
                        case "N" -> 0;
                        case "Y" -> 1;
                        default -> throw new IllegalStateException("You cannot specify values other than 1 or 2");
                    };
                    System.out.println("Employee type: ");
                    String type = input.nextLine();
                    if(!types.contains(type)){
                        System.out.println("Type not supported");
                        break;
                    }
                    Employee employee = new Employee(f_name, l_name, ni_number,
                            address, salary, bank, (short)manager, type);
                    hr.addEmployee(employee);
                    break;
                case 9:
                    running = false;
            }
        }
    }
}
