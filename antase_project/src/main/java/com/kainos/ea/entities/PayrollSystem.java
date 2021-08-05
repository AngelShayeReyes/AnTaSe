package com.kainos.ea.entities;

public class PayrollSystem {

    private float taxRate = 0.25f;

    public int netPay(Payable payee){
        float grossPay = payee.calcPay();
        float taxToPay = Math.round(grossPay * taxRate);
        return (int) (grossPay - taxToPay);
    }
}
