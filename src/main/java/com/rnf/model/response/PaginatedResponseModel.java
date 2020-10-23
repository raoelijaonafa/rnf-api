package com.rnf.model.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaginatedResponseModel<T> extends ResponseModel {
	@JsonProperty("data")
	protected List<T> data = new ArrayList<>();
	
	@JsonProperty("length")
	protected int length;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
