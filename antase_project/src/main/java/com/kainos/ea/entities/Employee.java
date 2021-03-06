package com.kainos.ea.entities;

public class Employee {
    private int employee_id;
    private String f_name;
    private String l_name;
    private String ni_number;
    private String employee_address;
    private float salary;
    private String bank_detail;
    private short is_Manager;
    private short active;
    private String employee_type;

    public Employee(int employee_id, String f_name, String l_name, String ni_number, String employee_address, float salary,
                    String bank_detail, short is_Manager, short active, String employee_type) {
        this.employee_id = employee_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.ni_number = ni_number;
        this.employee_address = employee_address;
        this.salary = salary;
        this.bank_detail = bank_detail;
        this.is_Manager = is_Manager;
        this.active = active;
        this.employee_type = employee_type;
    }

    //for proof of concept
    public Employee(String f_name, String l_name, String ni_number, String employee_address, float salary,
                    String bank_detail, short is_Manager, String employee_type) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.ni_number = ni_number;
        this.employee_address = employee_address;
        this.salary = salary;
        this.bank_detail = bank_detail;
        this.is_Manager = is_Manager;
        this.employee_type = employee_type;
    }

    public Employee(int employee_id, String f_name, String l_name, float salary) {
        this.employee_id = employee_id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.salary = salary;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getNi_number() {
        return ni_number;
    }

    public void setNi_number(String ni_number) {
        this.ni_number = ni_number;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBank_detail() {
        return bank_detail;
    }

    public void setBank_detail(String bank_detail) {
        this.bank_detail = bank_detail;
    }

    public short isIs_Manager() {
        return is_Manager;
    }

    public void setIs_Manager(short is_Manager) {
        this.is_Manager = is_Manager;
    }

    public short isActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public float calcPay(){ // calculate monthly pay in pence
        return getSalary() / 12;
    }

    @Override
    public String toString(){
        return String.format("""
                    Employee %d:\s
                    \tName = %s,\s
                    \tSalary = ??%,.2f,\s""",
                employee_id, f_name, salary);
    }

}