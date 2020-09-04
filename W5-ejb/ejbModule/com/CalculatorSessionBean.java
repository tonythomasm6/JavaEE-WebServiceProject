package com;

import javax.ejb.Stateless;

@Stateless
public class CalculatorSessionBean implements CalculatorInterface{

	 public CalculatorSessionBean() {
	        // TODO Auto-generated constructor stub
	    }
	    
	    public double calculate(double principle, int noofyears, double interestRate) {
	    	double monthlyPayment = 0.0;
	    	 int numberOfPayments = noofyears * 12;
	    	 monthlyPayment = principle * (interestRate * (Math.pow((1 + interestRate), numberOfPayments))) / ((Math.pow((1 + interestRate),
	    	numberOfPayments)) - 1);

	    	 return monthlyPayment;
	    	}
}
