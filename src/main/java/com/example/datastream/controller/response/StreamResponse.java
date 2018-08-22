package com.example.datastream.controller.response;

import java.util.Date;
import java.util.List;

import com.example.datastream.model.MyObject;

public class StreamResponse {

	private Date date;
	private List<MyObject> data;

	public StreamResponse(Date date, List<MyObject> data) {
		this.date = date;
		this.data = data;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<MyObject> getData() {
		return data;
	}
	public void setData(List<MyObject> data) {
		this.data = data;
	}
}
