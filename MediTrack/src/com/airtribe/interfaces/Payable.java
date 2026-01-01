package com.airtribe.interfaces;

public interface Payable {

	double calculateAmount();

	default double applyTax(double amount, double taxRate) {
		return amount + (amount * taxRate);
	}
}
