package com.Encapsulation;

public class CreditCardAccount {
	private String customerName;
	private double creditLimit;
	private double currentDebt;
	private double interestRate;

	public CreditCardAccount(String customerName, double creditLimit, double interestRate, double currentDebt) {
		this.customerName = customerName;
		this.creditLimit = creditLimit;
		this.interestRate = interestRate;
		this.currentDebt = currentDebt;
		System.out.println("Credit Card Account Created");
		System.out.println("---------------------------------------");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getCurrentDebt() {
		return currentDebt;
	}

	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void swipeCard(double amount) {
		if (amount + currentDebt > creditLimit) {
			System.out.println("Transaction declined: Limit exceeded");
		} else {
			currentDebt += amount;
			System.out.println("Transaction successful. New debt: " + currentDebt);
		}
	}

	public void makePayment(double amount) {
		if (amount > currentDebt) {
			System.out.println("Excess payment not allowed");
		} else {
			currentDebt -= amount;
			System.out.println("Payment successful. Remaining debt: " + currentDebt);
		}
	}

	public void applyInterest() {
		double interest = currentDebt * (interestRate / 100);
		currentDebt += interest;
		System.out.println("Interest applied: " + interest);
		System.out.println("Total debt: " + currentDebt);
	}

	public static void main(String[] args) {
		CreditCardAccount card = new CreditCardAccount("Alice", 100000, 2.5, 50000);
		card.swipeCard(30000);
		card.swipeCard(80000);
		card.makePayment(5000);
		card.makePayment(50000);
		card.applyInterest();
	}
}