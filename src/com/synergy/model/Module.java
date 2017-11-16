package com.synergy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_DEFAULT)
public class Module {

	private String moduleId;
	private String moduleDetails;
	private Byte flag;

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getModuleDetails() {
		return moduleDetails;
	}

	public void setModuleDetails(String moduleDetails) {
		this.moduleDetails = moduleDetails;
	}

	public Byte getFlag() {
		return flag;
	}

	public void setFlag(Byte flag) {
		this.flag = flag;
	}

}
