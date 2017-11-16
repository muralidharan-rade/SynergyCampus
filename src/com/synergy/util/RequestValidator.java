package com.synergy.util;

import com.synergy.model.HelpdeskRequest;

public final class RequestValidator {

	public static boolean isCreateRequestValid(HelpdeskRequest request) {
		boolean valid = true;
		if (isEmpty(request.getUserId())
				|| isEmpty(request.getComplaintDetails())
				|| isEmpty(request.getComplaintModule())
				|| isEmpty(request.getComplaintTopic())) {
			return false;
		}
		return valid;
	}

	public static boolean isEmpty(String str) {
		return ((str == null) || str.trim().isEmpty());
	}
}
