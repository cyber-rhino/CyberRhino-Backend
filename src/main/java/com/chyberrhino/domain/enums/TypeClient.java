package com.chyberrhino.domain.enums;

import java.util.Iterator;

public enum TypeClient {
	PHYSICALPERSON(1, "Physical Person"), LEGALPERSON(2, "Legal Person");

	private int cod;
	private String description;

	private TypeClient(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	public String getDesciption() {
		return description;
	}

	public static TypeClient toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TypeClient x : TypeClient.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Invalid ID: "+cod);
		
	}

}
