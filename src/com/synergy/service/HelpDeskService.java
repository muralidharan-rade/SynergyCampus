package com.synergy.service;

import java.util.List;

import com.synergy.exception.ServiceException;
import com.synergy.model.HelpdeskRequest;
import com.synergy.model.Module;
import com.synergy.model.Topic;

public interface HelpDeskService {

	void createHelpDeskComplaint(HelpdeskRequest complaint)
			throws ServiceException;

	List<HelpdeskRequest> listUserTickets(String userId)
			throws ServiceException;

	List<Module> getModules() throws ServiceException;

	List<Topic> getTopics() throws ServiceException;

}
