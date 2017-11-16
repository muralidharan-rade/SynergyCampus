package com.synergy.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class HelpdeskRequest {

	private long id;
	private String complaintTopic;
	private String userId;
	private Date date;
	private String complaintDetails;
	private String status;
	private Date statusChange;
	private String level;
	private String severity;
	private String oldRequestId;
	private String crossCallType;
	private String complaintModule;
	private String type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatusChange() {
		return statusChange;
	}

	public void setStatusChange(Date statusChange) {
		this.statusChange = statusChange;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getOldRequestId() {
		return oldRequestId;
	}

	public void setOldRequestId(String oldRequestId) {
		this.oldRequestId = oldRequestId;
	}

	public String getCrossCallType() {
		return crossCallType;
	}

	public void setCrossCallType(String crossCallType) {
		this.crossCallType = crossCallType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Ticket [id = " + id + "userId = " + userId + "]";
	}

	public String getComplaintTopic() {
		return complaintTopic;
	}

	public void setComplaintTopic(String complaintTopic) {
		this.complaintTopic = complaintTopic;
	}

	public String getComplaintDetails() {
		return complaintDetails;
	}

	public void setComplaintDetails(String complaintDetails) {
		this.complaintDetails = complaintDetails;
	}

	public String getComplaintModule() {
		return complaintModule;
	}

	public void setComplaintModule(String complaintModule) {
		this.complaintModule = complaintModule;
	}

}
