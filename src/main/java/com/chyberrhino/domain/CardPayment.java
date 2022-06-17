package com.chyberrhino.domain;

import javax.persistence.Entity;

import com.chyberrhino.domain.enums.PaymentStatus;

@Entity
public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer installments;

	public CardPayment() {
		
	}

	public CardPayment(Integer id, PaymentStatus status, Request request, Integer installments) {
		super(id, status, request);
		this.installments = installments;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	
}
