package com.chyberrhino.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.chyberrhino.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SlipPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date payDate;
	
	public SlipPayment() {
		
	}
	public SlipPayment(Integer id, PaymentStatus status, Request request, Date dueDate, Date payDate) {
		super(id, status, request);
		this.dueDate = dueDate;
		this.payDate = payDate;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Date getPayDate() {
		return payDate;
	}
	
	
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
}
