package com.kainos.ea.entities;

public class SalesEmployee extends Employee {

        private float commissionRate;
        private int salesTotal;

    private int employee_id;

    public SalesEmployee(int employee_id, String f_name, String l_name, String ni_number,
                         String employee_address, float salary, String bank_detail,
                         short is_Manager, short active, String employee_type,
                         float commissionRate, int salesTotal) {
        super(employee_id, f_name, l_name, ni_number, employee_address, salary, bank_detail,
                is_Manager, active, employee_type);
        this.commissionRate = commissionRate;
        this.salesTotal = salesTotal;
    }

    /*public SalesEmployee (float commissionRate, int salesTotal, int employee_id) {
        super(commissionRate, salesTotal, employee_id);
        this.commissionRate = commissionRate;
        this.salesTotal = salesTotal;
    }*/

    public float getCommissionRate() {
            return commissionRate;
        }

        public void setCommissionRate(float commissionRate) {
            this.commissionRate = commissionRate;
        }

        public int getSalesTotal() {
            return salesTotal;
        }

        public void setSalesTotal(int salesTotal) {
            this.salesTotal = salesTotal;
        }

        @Override
        public int getEmployee_id() {
        return employee_id;
    }

    @Override
    public void setEmployee_id(int employee_id) {
        super.setEmployee_id(employee_id);
    }

    /*@Override
    public int calcPay() {
        return super.calcPay() + Math.round(commissionRate * salesTotal);
    }*/

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SalesEmployee that = (SalesEmployee) o;
        return Float.compare(that.commissionRate, commissionRate) == 0 && salesTotal == that.salesTotal;
    }*/

    /*@Override
    public String toString() {
        //String message2 = String.format("Employee %d: %s, £%,.2f. "
        //          + "Monthly gross pay: £%,.2f.",
        //emp2.getNumber(), emp2.getName(), emp2.getSalary()/100.0, emp2.calcPay()/100.0);
        return "SalesEmployee{" +
                "number = " + super.getNumber() +
                ", salary = " + super.getSalary() +
                ", name = '" + super.getName() + '\'' +
                ", commissionRate = " + commissionRate +
                ", salesTotal = " + salesTotal +
                '}';
    }*/

}
