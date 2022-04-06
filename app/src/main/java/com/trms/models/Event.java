package com.trms.models;

public class Event {
	
	private long eventTypeId;
	private String eventTypeName;
	public Event(long eventTypeId, String eventTypeName) {

		this.eventTypeId = eventTypeId;
		this.eventTypeName = eventTypeName;
	}
	public Event() {

		this.eventTypeId = 0;
		this.eventTypeName = "";
	}
	public long getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getEventTypeName() {
		return eventTypeName;
	}
	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}
	
	
	
}
