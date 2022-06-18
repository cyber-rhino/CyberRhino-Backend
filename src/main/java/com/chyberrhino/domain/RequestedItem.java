package com.chyberrhino.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RequestedItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private RequestedItemPK id = new RequestedItemPK();
	
	private Double price;
	
	public RequestedItem() {
		
	}

	public RequestedItem(Double price, Request request, Service service) {
		super();
		this.price = price;
		id.setRequest(request);
		id.setService(service);
	}
	
	@JsonIgnore
	public Request getRequest() {
		return id.getRequest();
	}
	
	public Service getService() {
		return id.getService();
	}
	
	public RequestedItemPK getId() {
		return id;
	}

	public void setId(RequestedItemPK id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestedItem other = (RequestedItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
