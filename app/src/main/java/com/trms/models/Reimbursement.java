package com.trms.models;

import java.util.Date;

public class Reimbursement {
	
	private long requestId;
	private long submitterId;
	private long eventTypeId;
	private long statusId;
	private Date eventDate;
	private long cost;
	private String description;
	private String location;
	private Date submittedAt;
	private String status;
	private String event;
	
	public Reimbursement(long requestId, long submitterId, long eventTypeId, long statusId, Date eventDate, long cost,
			String description, String location, Date submittedAt,String status,String event) {
		this.requestId = requestId;
		this.submitterId = submitterId;
		this.eventTypeId = eventTypeId;
		this.statusId = statusId;
		this.eventDate = eventDate;
		this.cost = cost;
		this.description = description;
		this.location = location;
		this.submittedAt = submittedAt;
		this.status = status;
		this.event= event;
	}
	
	public Reimbursement() {
		this.requestId = 0;
		this.submitterId = 0;
		this.eventTypeId = 0;
		this.statusId = 0;
		this.eventDate = new Date();
		this.cost = 0;
		this.description = "";
		this.location = "";
		this.submittedAt = new Date();
		this.status = "";
		this.event = " ";
	}

	public long getRequestId() {
		return requestId;
	}

	public void setRequestId(long requestId) {
		this.requestId = requestId;
	}

	public long getSubmitterId() {
		return submitterId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public void setSubmitterId(long submitterId) {
		this.submitterId = submitterId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getEventTypeId() {
		return eventTypeId;
	}

	public void setEventTypeId(long eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
	}
	
	
	
	
	
	
 
}
