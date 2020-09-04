package com.managedBean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import com.webserviceClient.WebServiceClient;


@Named("calculatorBean")
@SessionScoped
public class CalculatorBean implements Serializable {
	
	private double principle;
	private double interest;
	private int noofyears;
	private double monthlyPayment;
	public double getPrinciple() {
		return principle;
	}
	public void setPrinciple(double principle) {
		this.principle = principle;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getNoofyears() {
		return noofyears;
	}
	public void setNoofyears(int noofyears) {
		this.noofyears = noofyears;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	
	public void calculate() {
		//this.setMonthlyPayment(100000);
		WebServiceClient wc= new WebServiceClient();
		double payment = wc.calculate(principle, interest, noofyears);
		this.setMonthlyPayment(payment);
		
		
	}

}
