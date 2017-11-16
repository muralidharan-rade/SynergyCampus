package com.synergy.dao;

import java.util.List;

import com.synergy.exception.ServiceException;
import com.synergy.model.HelpdeskRequest;
import com.synergy.model.Module;
import com.synergy.model.Topic;

public interface HelpDeskDAO {

	void createTicket(HelpdeskRequest requestDetails) throws ServiceException;

	List<HelpdeskRequest> listUserTickets(String userId)
			throws ServiceException;

	List<Module> getModules() throws ServiceException;

	List<Topic> getTopics() throws ServiceException;

}
