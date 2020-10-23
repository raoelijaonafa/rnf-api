package com.rnf.misc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ActivityLogState {
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	private String activityValue = "";
	
	public ActivityLogState(Object activityObject) {
		objectMapper.registerModule(new JavaTimeModule());
		
		try {
			this.activityValue = objectMapper.writeValueAsString(activityObject);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public String getActivityValue() {
		return this.activityValue;
	}
}
