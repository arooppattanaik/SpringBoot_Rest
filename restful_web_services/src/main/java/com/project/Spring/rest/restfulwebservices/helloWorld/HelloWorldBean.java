package com.project.Spring.rest.restfulwebservices.helloWorld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format("HellowWorldBean [message=%s]", message);
	}
	
	

}
