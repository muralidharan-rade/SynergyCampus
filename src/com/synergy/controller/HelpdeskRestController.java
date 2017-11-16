package com.synergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.synergy.exception.RequestInvalidException;
import com.synergy.exception.ServiceException;
import com.synergy.model.GenericResponse;
import com.synergy.model.HelpdeskCalls;
import com.synergy.model.HelpdeskRequest;
import com.synergy.model.Module;
import com.synergy.model.Modules;
import com.synergy.model.Topic;
import com.synergy.model.Topics;
import com.synergy.service.HelpDeskService;
import com.synergy.util.Constants;
import com.synergy.util.RequestValidator;

@RestController
@RequestMapping("/api")
public class HelpdeskRestController {

	@Autowired
	HelpDeskService helpdeskService;

	@RequestMapping(value = "/helpdesk/complaints", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> createTicket(
			@RequestBody HelpdeskRequest complaint,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Service ticket for user: " + complaint.getUserId());

		if (RequestValidator.isCreateRequestValid(complaint)) {
			helpdeskService.createHelpDeskComplaint(complaint);
		} else {
			throw new RequestInvalidException();
		}

		GenericResponse response = new GenericResponse();
		if (complaint.getId() > 0) {
			response.setMessage(Constants.SUCCESS_MESSAGE);
			response.setComplaintId(complaint.getId());
		}

		return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/helpdesk/{userid}/history", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HelpdeskCalls> listUserTickets(
			@PathVariable("userid") String userId) {
		System.out.println("List tickets for user :: " + userId);
		List<HelpdeskRequest> ticketList = null;
		HelpdeskCalls calls = new HelpdeskCalls();

		if (!RequestValidator.isEmpty(userId)) {
			ticketList = helpdeskService.listUserTickets(userId);
			calls.setCalls(ticketList);
		} else {
			throw new RequestInvalidException();
		}
		return new ResponseEntity<HelpdeskCalls>(calls, HttpStatus.OK);
	}

	@RequestMapping(value = "/helpdesk/getModules", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Modules> getModules() {
		System.out.println("get modules");
		List<Module> moduleList = null;
		Modules modules = new Modules();

		moduleList = helpdeskService.getModules();
		modules.setModules(moduleList);

		return new ResponseEntity<Modules>(modules, HttpStatus.OK);
	}

	@RequestMapping(value = "/helpdesk/getTopic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Topics> getTopics() {
		System.out.println("get modules");
		List<Topic> topicList = null;
		Topics topics = new Topics();

		topicList = helpdeskService.getTopics();
		topics.setTopics(topicList);

		return new ResponseEntity<Topics>(topics, HttpStatus.OK);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<GenericResponse> handleServiceException(Exception ex) {
		GenericResponse resp = new GenericResponse();
		resp.setError(Constants.ERROR_MESSAGE);
		return new ResponseEntity<GenericResponse>(resp,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RequestInvalidException.class)
	public ResponseEntity<GenericResponse> handleRequestInvalidException(
			Exception ex) {
		GenericResponse resp = new GenericResponse();
		resp.setError(Constants.ERROR_MESSAGE_REQUEST_NOT_VALID);
		return new ResponseEntity<GenericResponse>(resp, HttpStatus.BAD_REQUEST);
	}
}
