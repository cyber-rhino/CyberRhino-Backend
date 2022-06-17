package com.chyberrhino.domain.enums;

public enum PaymentStatus {

	REQUESTED(1, "Requested"), 
	PAID(2, "Paid"), 
	CANCELED(3, "Canceled");

	private int cod;
	private String description;

	private PaymentStatus(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDesciption() {
		return description;
	}

	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (PaymentStatus x : PaymentStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid ID: " + cod);

	}

}
