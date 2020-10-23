package com.rnf.model.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseModel {
	@JsonProperty("message")
	protected String message;
	
	@JsonProperty("content")
	protected Map<String, Object> content = new HashMap<>();
	
	@JsonProperty("success")
	protected boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, Object> getContent() {
		return content;
	}

	public void setContent(Map<String, Object> content) {
		this.content = content;
	}

	@Override
	public String toString()
	{
		return String.format("ResponseModel [message=%s]", this.message);
	}
}
