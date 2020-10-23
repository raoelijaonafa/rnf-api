package com.rnf.controller.util;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonModel {
	
	@JsonProperty("data")
	private HashMap<String, Object> data = new HashMap<String, Object>();
	
	@JsonProperty("message")
	private String message = "OK";

	@JsonProperty("status")
	private String status = "OK";

	public HashMap<String, Object> getData() {
		return data;
	}

	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}