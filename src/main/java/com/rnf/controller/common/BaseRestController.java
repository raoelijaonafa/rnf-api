package com.rnf.controller.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseRestController {
	public static final String FRONT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String FRONT_DATE_AND_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String FRONT_DATETIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		
		DateFormat df = new SimpleDateFormat(FRONT_DATE_FORMAT);
		objectMapper.setDateFormat(df);
		
		return objectMapper;
	}
	
	public void setPdfResponse(HttpServletResponse response, String outputFile) {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + outputFile);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("x-filename", outputFile);
    }
	
	public Date parseDate(String strDate) {
		Date res = null;
		
		try {
			SimpleDateFormat format = new SimpleDateFormat(FRONT_DATETIME_FORMAT, Locale.FRANCE);
			format.setTimeZone(TimeZone.getTimeZone("UTC"));
			
			res = format.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public String getStringFromBodyRequest(Map<String, Object> body, String key) {
		return body.containsKey(key) ? body.get(key).toString() : "";
	}
	
	public Integer getIntegerFromBodyRequest(Map<String, Object> body, String key) {
		return body.containsKey(key) ? Integer.parseInt(body.get(key).toString()) : null;
	}
	
	public boolean getBooleanFromBodyRequest(Map<String, Object> body, String key) {
		return Boolean.parseBoolean(body.get(key).toString());
	}
	
	/**
	 * https://stackoverflow.com/questions/2201925/converting-iso-8601-compliant-string-to-java-util-date
	 * @param body
	 * @param key
	 * @return
	 */
	public Date getISODateFromBodyRequest(Map<String, Object> body, String key) {
		if(!body.containsKey(key)) return null;
		
		//DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
	    //TemporalAccessor accessor = timeFormatter.parse("2015-10-27T16:22:27.605-07:00");
		//TemporalAccessor accessor = timeFormatter.parse(body.get(key).toString());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);

	    //return Date.from(Instant.from(accessor));
		try {
			return fm.parse(body.get(key).toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public LocalDate getLocaleDateFromBodyRequest(Map<String, Object> body, String key) {
		LocalDate date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FRONT_DATE_FORMAT);
        
		if(!body.containsKey(key)) return null;
		
		date = body.get(key) != null ? LocalDate.parse(body.get(key).toString(), formatter) : null;
		
		return date;
	}
	
	public LocalDateTime getLocaleDateAndTimeFromBodyRequest(Map<String, Object> body, String key) {
		LocalDateTime date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FRONT_DATE_AND_TIME_FORMAT);
		
		if(!body.containsKey(key)) return null;
		
		date = body.get(key) != null ? LocalDateTime.parse(body.get(key).toString(), formatter) : null;
		
		return date;
	}
}
