package com.chyberrhino.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RequestedItemPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;
	
	@ManyToOne
	@JoinColumn(name = "request_id")
	private Request request;
		
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		RequestedItemPK other = (RequestedItemPK) obj;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}
	
}
