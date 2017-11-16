package com.synergy.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component("restAuthenticationEntryPoint")
public class SynergyAuthenticationEntryPoint implements
		AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		response.setContentType("application/json");
		response.getOutputStream().print("{\"error\":\"Unauthorized.. Please authenticate..\"}");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}
