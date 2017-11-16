package com.synergy.util;

public interface SQLQueries {

	public static final String CREATE_REQUEST = "INSERT INTO helpdesk_calls_master (STR_REQUEST_TOPIC, STR_USER_ID, DT_REQUEST_DATE, STR_REQUEST_DETAILS, STR_REQUEST_STATUS, DT_STATUS_CHANGE_DATE, STR_LEVEL, STR_SEVERITY, N_OLD_REQUEST_ID, STR_APPRV_CROSSCALL_TYPE, STR_REQUEST_MODULE, STR_CALL_TYPE) VALUES(:topic, :userId, :date, :details, :status, :statusChange, :level, :severity, :oldRequest, :crossCall, :module, :type)";

	public static final String GET_ALL_TICKETS_OF_USER = "SELECT N_REQUEST_ID as id, STR_REQUEST_TOPIC as complaintTopic, STR_USER_ID as userId, DT_REQUEST_DATE as date, STR_REQUEST_DETAILS as complaintDetails, STR_REQUEST_STATUS as status, DT_STATUS_CHANGE_DATE as statusChange, STR_LEVEL as level, STR_SEVERITY as severity, N_OLD_REQUEST_ID as oldRequestId, STR_APPRV_CROSSCALL_TYPE as crossCallType, STR_REQUEST_MODULE as complaintModule, STR_CALL_TYPE as type FROM helpdesk_calls_master where str_user_id = ? and STR_REQUEST_STATUS <> 'Closed' union select N_REQUEST_ID as id, STR_REQUEST_TOPIC as complaintTopic, STR_USER_ID as userId, DT_REQUEST_DATE as date, STR_REQUEST_DETAILS as complaintDetails, STR_REQUEST_STATUS as status, DT_STATUS_CHANGE_DATE as statusChange, STR_LEVEL as level, STR_SEVERITY as severity, N_OLD_REQUEST_ID as oldRequestId, STR_APPRV_CROSSCALL_TYPE as crossCallType, STR_REQUEST_MODULE as complaintModule, STR_CALL_TYPE as type from helpdesk_calls_closed where str_user_id = ?";

	public static final String GET_MODULES = "SELECT STR_MODULE_ID as moduleId, STR_MODULE_DETAILS as moduleDetails from Resume_Feedback_Modules_Master";

	public static final String GET_TOPICS = "SELECT STR_TOPIC_ID as topicId, STR_TOPIC_DETAILS as topicDetails from Resume_Feedback_topics_Master";
}
