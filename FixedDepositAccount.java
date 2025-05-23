package com.Encapsulation;

public class FixedDepositAccount {
	private String customerName;
	private double principalAmount;
	private double interestRate;
	private int duration;
	private double maturityAmount;

	public FixedDepositAccount(String customerName, double principalAmount, double interestRate, int duration,
			double maturityAmount) {
		this.customerName = customerName;
		this.principalAmount = principalAmount;
		this.interestRate = interestRate;
		this.duration = duration;
		this.maturityAmount = maturityAmount;
		System.out.println("Fixed Deposit Created Successfully");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
		calculateMaturityAmount();
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
		calculateMaturityAmount();
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
		calculateMaturityAmount();
	}

	public double getMaturityAmount() {
		return maturityAmount;
	}

	public void calculateMaturityAmount() {
		maturityAmount = principalAmount * Math.pow((1 + interestRate / 100), duration);
	}

	public void withdrawBeforeMaturity() {
		if (duration < 1) {
			System.out.println("Cannot withdraw before one year");
		} else {
			double penalty = maturityAmount * 0.02;
			double amountAfterPenalty = maturityAmount - penalty;
			System.out.println("Withdrawal before maturity. Penalty applied: " + penalty);
			System.out.println("Amount after penalty: " + amountAfterPenalty);
			System.out.println("----------------------------------------------");
		}
	}

	public static void main(String[] args) {
		FixedDepositAccount fd = new FixedDepositAccount("John Doe", 100000, 6.5, 3,1000);
		fd.withdrawBeforeMaturity();
		FixedDepositAccount earlyFd = new FixedDepositAccount("Jane Smith", 50000, 5.0, 0,5000);
		earlyFd.withdrawBeforeMaturity();
	}
}
