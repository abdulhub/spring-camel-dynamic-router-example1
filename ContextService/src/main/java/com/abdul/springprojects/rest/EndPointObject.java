package com.abdul.springprojects.rest;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndPointObject {
	
	int numOfEndPoints = 0;
	String serviceId = null;
	String fromEndPoint;
	List<String> toEndPoints = new LinkedList<String>();
	
	
	
	public int getNumOfEndPoints() {
		return numOfEndPoints;
	}
	public void setNumOfEndPoints(int numOfEndPoints) {
		this.numOfEndPoints = numOfEndPoints;
	}
	public String getServiceId() {
		return serviceId;
	}
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
	public String getFromEndPoint() {
		return fromEndPoint;
	}
	public void setFromEndPoint(String fromEndPoint) {
		this.fromEndPoint = fromEndPoint;
	}
	public List<String> getToEndPoints() {
		return toEndPoints;
	}
	public void setToEndPoints(List<String> toEndPoints) {
		this.toEndPoints = toEndPoints;
	}

}
