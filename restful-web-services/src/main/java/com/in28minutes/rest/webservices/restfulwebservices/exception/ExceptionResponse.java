package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

//this is for implementing generic exception handling for all resources
public class ExceptionResponse {
	private Date timesnap;
	private String message;
	private String details;
	public ExceptionResponse(Date timesnap, String message, String details) {
		super();
		this.timesnap = timesnap;
		this.message = message;
		this.details = details;
	}
	public Date getTimesnap() {
		return timesnap;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	
	
}
