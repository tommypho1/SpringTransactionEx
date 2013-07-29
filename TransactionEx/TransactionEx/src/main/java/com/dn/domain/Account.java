package com.dn.domain;

public class Account {
	private int accountId;
	private int studentId;
	private double totalMustPay;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public double getTotalMustPay() {
		return totalMustPay;
	}
	public void setTotalMustPay(double totalMustPay) {
		this.totalMustPay = totalMustPay;
	}
	
}
