package com.synergy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.dao.HelpDeskDAO;
import com.synergy.exception.ServiceException;
import com.synergy.model.HelpdeskRequest;
import com.synergy.model.Module;
import com.synergy.model.Topic;

@Service("helpdeskService")
@Transactional
public class HelpDeskServiceImpl implements HelpDeskService {

	@Autowired
	private HelpDeskDAO helpdeskDAO;

	@Override
	public void createHelpDeskComplaint(HelpdeskRequest complaint)
			throws ServiceException {
		helpdeskDAO.createTicket(complaint);
	}

	@Override
	public List<HelpdeskRequest> listUserTickets(String userId)
			throws ServiceException {
		System.out.println("HelpDeskServiceImpl :: listUserTickets");
		return helpdeskDAO.listUserTickets(userId);

	}

	@Override
	public List<Module> getModules() throws ServiceException {
		System.out.println("HelpDeskServiceImpl :: getModules");
		return helpdeskDAO.getModules();
	}

	@Override
	public List<Topic> getTopics() throws ServiceException {
		return helpdeskDAO.getTopics();
	}

}
