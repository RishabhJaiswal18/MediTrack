package com.airtribe.entity;

public final class BillSummary {

	private final int billId;
	private final double amount;
	private final String description;

	public BillSummary(int billId, double amount, String description) {
		this.billId = billId;
		this.amount = amount;
		this.description = description;
	}

	public int getBillId() {
		return billId;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}
}
