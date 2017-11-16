package com.synergy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Topic {

	private String topicId;
	private String topicDetails;
	private Byte flag;

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getTopicDetails() {
		return topicDetails;
	}

	public void setTopicDetails(String topicDetails) {
		this.topicDetails = topicDetails;
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

}
