package com.abdul.springprojects.boot.rest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.camel.builder.RouteBuilder;

public class EndPointBuilder {

	List<String> targetEndPoint = null;
	LinkedHashMap<String, Object> fromEndPointParam = null;
	List<LinkedHashMap<String, Object>> toEndPointParam = null;
	private EndPointObject endPointObject = new EndPointObject();
	int numOfEndPoints = 0;
	String serviceId = null;
	String fromEndPoint;
	List<String> toEndPoints = new LinkedList<String>();

	public EndPointBuilder(EndPointConfig endPointConfig) {

		    this.serviceId = endPointConfig.getServiceId();
			this.fromEndPointParam = endPointConfig.getFrom().getFirst();
			this.toEndPointParam = endPointConfig.getTo();
			this.numOfEndPoints = endPointConfig.getTo().size();
			this.fromEndPoint = CreateServiceEndPoint(this.fromEndPointParam);
			this.toEndPoints = CreateToEndPoints(this.toEndPointParam);
		    this.endPointObject.setFromEndPoint(CreateServiceEndPoint(this.fromEndPointParam));
		    this.endPointObject.setToEndPoints(CreateToEndPoints(this.toEndPointParam));
		    this.endPointObject.setServiceId(endPointConfig.getServiceId());
		    this.endPointObject.setNumOfEndPoints(endPointConfig.getTo().size());

	}

	 

	public String CreateServiceEndPoint(LinkedHashMap<String, Object> endPointConfig) {

		String endPoint = endPointConfig.get("ServiceEndPoint") + "?" + getEndPointOptions(endPointConfig);

		return endPoint;

	}

	public List<String> CreateToEndPoints(List<LinkedHashMap<String, Object>> endPoints) {

		endPoints.forEach(endPoint -> {
			toEndPoints.add(CreateServiceEndPoint(endPoint));

		});

		return toEndPoints;
	}

	private String getEndPointOptions(LinkedHashMap<String, Object> endPointConfig) {
		//endPointConfig.remove("ServiceEndPoint");
		endPointConfig.forEach((k, v) -> {
			
		
			if(!"ServiceEndPoint".equals(k)) {
				
				fromEndPoint = k + "=" + v;
			}
			 

		});

		return fromEndPoint;
	}



	public EndPointObject getEndPointObject() {
		return endPointObject;
	}



	public void setEndPointObject(EndPointObject endPointObject) {
		this.endPointObject = endPointObject;
	}

}
