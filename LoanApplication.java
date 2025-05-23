package com.Encapsulation;

public class LoanApplication {
	private String customerName;
	private double loanAmount;
	private double interestRate;
	private int loanTerm;
	private double outstandingBalance;

	public LoanApplication(String customerName, double loanAmount, double interestRate, int loanTerm, double outstandingBalance) {
		this.customerName = customerName;
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.outstandingBalance = outstandingBalance;
		System.out.println("Loan Application Submitted");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getOutstandingBalance() {
		return outstandingBalance;
	}

	public void setOutstandingBalance(double outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	public void makePayment(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid payment amount");
		} else if (amount > outstandingBalance) {
			System.out.println("Payment exceeds loan balance");
		} else {
			outstandingBalance -= amount;
			System.out.println("Payment successful. Remaining balance: " + outstandingBalance);
		}
	}

	public double calculateEMI() {
		double monthlyRate = interestRate / 12 / 100;
		int totalMonths = loanTerm * 12;
		double emi = (loanAmount * monthlyRate * Math.pow(1 + monthlyRate, totalMonths)) / (Math.pow(1 + monthlyRate, totalMonths) - 1);
		return emi;
	}

	public void displayLoanDetails() {
		System.out.println("Customer Name: " + customerName);
		System.out.println("Loan Amount: " + loanAmount);
		System.out.println("Interest Rate: " + interestRate);
		System.out.println("Loan Term: " + loanTerm);
		System.out.println("Monthly EMI: " + String.format("%.2f", calculateEMI()));
		System.out.println("Outstanding Balance: " + outstandingBalance);
		System.out.println("--------------------------------------------------------------------");
	}

	public static void main(String[] args) {
		LoanApplication loan = new LoanApplication("Rubeena", 500000.00, 4.5, 10, 10000);
		loan.displayLoanDetails();
		loan.setCustomerName("Nurjahan");
		loan.setLoanAmount(25000);
		loan.setInterestRate(6.0);
		loan.setLoanTerm(5);
		loan.setOutstandingBalance(15000);
		loan.makePayment(6000);
		loan.displayLoanDetails();
	}
}