package com.synergy.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.synergy.exception.ServiceException;
import com.synergy.model.HelpdeskRequest;
import com.synergy.model.Module;
import com.synergy.model.Topic;
import com.synergy.util.Constants;
import com.synergy.util.SQLQueries;

@Repository
public class HelpDeskDAOImpl implements HelpDeskDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void createTicket(HelpdeskRequest reqDetails)
			throws ServiceException {

		KeyHolder holder = new GeneratedKeyHolder();

		try {
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			parameters.addValue("topic", reqDetails.getComplaintTopic());
			parameters.addValue("userId", reqDetails.getUserId());
			parameters.addValue("date", new Date(System.currentTimeMillis()));
			parameters.addValue("details", reqDetails.getComplaintDetails());
			parameters.addValue("status", Constants.OPEN);
			parameters.addValue("statusChange", reqDetails.getStatusChange());
			parameters.addValue("level", reqDetails.getLevel());
			parameters.addValue("severity", reqDetails.getSeverity());
			parameters.addValue("oldRequest", reqDetails.getOldRequestId());
			parameters.addValue("crossCall", reqDetails.getCrossCallType());
			parameters.addValue("module", reqDetails.getComplaintModule());
			parameters.addValue("type", reqDetails.getType());

			namedParameterJdbcTemplate.update(SQLQueries.CREATE_REQUEST,
					parameters, holder);
			reqDetails.setId(holder.getKey().longValue());

		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		}
	}

	@Override
	public List<HelpdeskRequest> listUserTickets(String userId)
			throws ServiceException {
		List<HelpdeskRequest> ticketList = null;
		try {
			ticketList = jdbcTemplate.query(SQLQueries.GET_ALL_TICKETS_OF_USER,
					new Object[] { userId, userId },
					new BeanPropertyRowMapper<HelpdeskRequest>(
							HelpdeskRequest.class));
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		}
		System.out.println("DAOImpl :: listUserTickets :: " + ticketList);
		return ticketList;
	}

	@Override
	public List<Module> getModules() throws ServiceException {
		List<Module> moduleList = null;
		try {
			moduleList = jdbcTemplate.query(SQLQueries.GET_MODULES,
					new BeanPropertyRowMapper<Module>(Module.class));
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		}
		return moduleList;
	}

	@Override
	public List<Topic> getTopics() throws ServiceException {
		List<Topic> topicList = null;
		try {
			topicList = jdbcTemplate.query(SQLQueries.GET_TOPICS,
					new BeanPropertyRowMapper<Topic>(Topic.class));
		} catch (DataAccessException ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException(ex);
		}
		return topicList;

	}

}
