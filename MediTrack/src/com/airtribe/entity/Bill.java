package com.airtribe.entity;

import com.airtribe.constants.Constants;
import com.airtribe.interfaces.Payable;

public class Bill implements Payable {

	protected double baseAmount;

	public Bill(double baseAmount) {
		this.baseAmount = baseAmount;
	}

	@Override
	public double calculateAmount() {
		return applyTax(baseAmount, Constants.TAX_RATE);
	}
}
